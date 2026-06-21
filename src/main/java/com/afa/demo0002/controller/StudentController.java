package com.afa.demo0002.controller;

import com.afa.demo0002.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    private List<Student> students = new ArrayList<>(List.of(
            new Student(1, "ramish", 54),
            new Student(2, "reza", 65)
    ));



    @GetMapping("students")
    public List<Student> getStudents(){
        return students;
    }

    @PostMapping("students")
    public Student createStudent(@RequestBody Student student){
        students.add(student);
        return student;
    }

}
