package com.example.miniproject.controller;

import com.example.miniproject.domain.Students;
import com.example.miniproject.dto.request.StudentsRequest;
import com.example.miniproject.service.StudentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class StudentsController {
    private final StudentsService studentsService;

    @PostMapping("/student")
    public void students(@RequestBody StudentsRequest request){
        studentsService.create(request);
    }
//    @PostMapping("/camp/{id}")
//    public Students findById(@RequestParam Int id){
//        Students students = studentsService.findById(id);
//        return students;
//    }
    @GetMapping("/student/{id}")
    public Students findById(@PathVariable Long id){
        Students students = studentsService.findById(id);
        return students;
    }
    @PostMapping("/student/{campName}")
    public List<Students> findByName(@PathVariable String campName){
        List<Students> students = studentsService.findAllByCampName(campName);
        return students;
    }
    @PostMapping("/student/list")
    public ResponseEntity<List<Students>> findAll(){
        return ResponseEntity.ok(studentsService.findAll());
    }

//    @PatchMapping("/student/{campName}")
//    public ResponseEntity<Students> update(@PathVariable String campName, @RequestBody StudentsRequest request){
//        return ResponseEntity.ok(studentsService.update(campName, request));
//    }
    @PatchMapping("/student/{id}")
    public ResponseEntity<Students> update(@PathVariable Long id, @RequestBody StudentsRequest request){
        return ResponseEntity.ok(studentsService.update(id, request));
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id){
        studentsService.delete(id);
        return ResponseEntity.ok(id);
    }
//    @DeleteMapping("/camp/{campName}")
//    public ResponseEntity<String> delete(@PathVariable String campName){
//        studentsService.delete(campName);
//        return ResponseEntity.ok(campName);
//    }
}


