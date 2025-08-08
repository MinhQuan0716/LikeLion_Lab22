package com.likelion.service.impl;

import com.likelion.dto.StudentDTO;
import com.likelion.entity.Student;
import com.likelion.mapper.StudentMapper;
import com.likelion.repository.StudentRepository;
import com.likelion.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;
    private StudentMapper studentMapper;
    @Override
    public void createStudent(StudentDTO student) {
        Optional.ofNullable(studentRepository.findStudentByEmail(student.getEmail())).
                ifPresentOrElse(
           existing->{
             throw new IllegalArgumentException("Student already exists");
           },
                        ()->{
               Student newStudent=studentMapper.toEntity(student);
               studentRepository.save(newStudent);
                        }
        );
    }

    @Override
    public void deleteStudent(Integer id) {
        studentRepository.findById(id).ifPresentOrElse(
                existing->{
                    studentRepository.deleteById(id);
                },
                ()->{
                    throw new IllegalArgumentException("Student not found");
                }
        );
    }

    @Override
    public void updateStudent(Integer id, StudentDTO studentDTO) {
        studentRepository.findById(id).ifPresentOrElse(
                existing->{
                   studentMapper.updateEntity(studentDTO,existing);
                   studentRepository.save(existing);
                },
                ()->{
                    throw new IllegalArgumentException("Student not found");
                }
        );
    }

    @Override
    public List<StudentDTO> findAllStudents() {
        return studentRepository.findAll().stream()
                .map(studentMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO findStudentById(Integer id) {
        return studentRepository.findById(id)
                .map(studentMapper::toDTO)
                .orElseThrow(() -> new IllegalArgumentException("Student not found"));
    }
}
