package com.likelion.service;

import com.likelion.dto.StudentDTO;
import com.likelion.entity.Student;

import java.util.List;

public interface StudentService {
    void createStudent(StudentDTO student);
    void deleteStudent(Integer id);
    void updateStudent(Integer id, StudentDTO studentDTO);
    List<StudentDTO> findAllStudents();
    StudentDTO findStudentById(Integer id);
}
