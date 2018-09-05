package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@Slf4j
public class FirstController {

    List<String> studentList = new ArrayList<>(Arrays.asList("Bill", "Jhon", "Jim", "Mike", "Konnor"));


    @GetMapping("/student")
    public List<String> getAll() {
        log.info("Print all students-----------------------------");
        return studentList;
    }

    @PostMapping("/getById/{id}")
    public String getStudentById(@PathVariable int id) {
        String name = null;
        for (int i = 0; i < studentList.size(); i++) {
            if (i == id) {
                name = studentList.get(i);
                log.info("Name student with id {}=" + name + "----------------------", id);
            }
        }
        return name;
    }

    @PostMapping("/deleteById/{id}")
    public List<String> delStudentById(@PathVariable int id) {
        for (int i = 0; i < studentList.size(); i++) {
            if (i == id) {
                studentList.remove(id);
                log.info("Delete student with id {}--------------------------", id);
            }
        }
        return studentList;
    }

    @PostMapping("/delete/{name}")
    public List<String> delStudentByName(@PathVariable String name) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).equals(name)) {
                studentList.remove(i);
                log.info("Delete student with name {}--------------------------", name);
            }
        }
        return studentList;
    }

    @PostMapping("/student/add/{name}")
    public List<String> addStudent(@PathVariable String name) {
        log.info("Add new student with name {}------------------", name);
        studentList.add(name);
        return studentList;
    }
}
