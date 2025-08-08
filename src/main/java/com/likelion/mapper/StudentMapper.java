package com.likelion.mapper;

import com.likelion.dto.StudentDTO;
import com.likelion.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentDTO toDTO(Student student);
    Student toEntity(StudentDTO studentDTO);
    List<StudentDTO> toDTOs(List<Student> students);
    void updateEntity(StudentDTO studentDTO, @MappingTarget Student student);
}
