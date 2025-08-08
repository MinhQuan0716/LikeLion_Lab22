package com.likelion.controller;

import com.likelion.dto.StudentDTO;
import com.likelion.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/students")
@AllArgsConstructor
public class StudentController {
    private StudentService studentService;
    @GetMapping
    public ResponseEntity<List<StudentDTO>> findAll(){
        return ResponseEntity.ok(studentService.findAllStudents());
    }
    @PostMapping
    public void createStudent(@RequestBody StudentDTO studentDTO){
         studentService.createStudent(studentDTO);
    }
    @PutMapping("/{id}")
    public void updateStudent(@PathVariable Integer id, @RequestBody StudentDTO studentDTO){
        studentService.updateStudent(id,studentDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Integer id){
        studentService.deleteStudent(id);
    }
    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> findStudentById(@PathVariable Integer id){
        return ResponseEntity.ok(studentService.findStudentById(id));
    }
}
