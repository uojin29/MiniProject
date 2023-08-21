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
public class StudentsController {
    private final StudentsService studentsService;

    @PostMapping("/camp")
    public Students students(@RequestBody StudentsRequest request){
        Students students = Students.builder()
                .studentId(request.getStudentId())
                .name(request.getName())
                .department(request.getDepartment())
                .campName(request.getCampName())
                .startDate(request.getStartDate())
                .finishDate(request.getFinishDate())
                .build();
        studentsService.create(students);
        return students;
    }
//    @PostMapping("/camp/{id}")
//    public Students findById(@PathVariable Long id){
//        Students students = studentsService.findById(id);
//        return students;
//    }
    @PostMapping("/camp/{campName}")
    public Students findByName(@PathVariable String campName){
        Students students = studentsService.findByCampName(campName);
        return students;
    }
    @PostMapping("/camp/list")
    public ResponseEntity<List<Students>> findAll(){
        return ResponseEntity.ok(studentsService.findAll());
    }

    @PatchMapping("/camp/{campName}")
    public ResponseEntity<Students> update(@PathVariable String campName, @RequestBody StudentsRequest request){
        return ResponseEntity.ok(studentsService.update(campName, request));
    }

    @DeleteMapping("/camp/{campName}")
    public ResponseEntity<String> delete(@PathVariable String campName){
        studentsService.delete(campName);
        return ResponseEntity.ok(campName);
    }
}


