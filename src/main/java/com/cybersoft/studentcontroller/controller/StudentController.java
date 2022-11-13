package com.cybersoft.studentcontroller.controller;

import com.cybersoft.studentcontroller.entity.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private List<Student> listStudent = new ArrayList<>();

    @GetMapping("/")
    public List<Student> getAllStudents() {
        return listStudent;
    }

    @GetMapping("/add")
    public List<Student> addRequestParam(@RequestParam("name") String name, @RequestParam("age") int age) {
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        listStudent.add(student);
        return listStudent;
    }

    @GetMapping("/add/{name}/{age}")
    public List<Student> addPathVariable(@PathVariable("name") String name, @PathVariable("age") int age) {
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        listStudent.add(student);
        return listStudent;
    }

    @PostMapping(value = "add", consumes = "application/json")
    public List<Student> add(@RequestBody Student student) {
        listStudent.add(student);
        return listStudent;
    }
}
