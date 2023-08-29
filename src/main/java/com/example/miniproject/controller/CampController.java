package com.example.miniproject.controller;

import com.example.miniproject.domain.Camp;
import com.example.miniproject.domain.Students;
import com.example.miniproject.dto.request.CampRequest;
import com.example.miniproject.dto.request.StudentsRequest;
import com.example.miniproject.service.CampService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class CampController {
    private final CampService campService;

    @PostMapping("/camp")
    public void camp(@RequestBody CampRequest request){
        campService.create(request);

    }

    @GetMapping("/camp/{id}")
    public Camp findById(@PathVariable Long id){
        Camp camp = campService.findById(id);
        return camp;
    }

    @PostMapping("/camp/list")
    public ResponseEntity<List<Camp>> findAll(){
        return ResponseEntity.ok(campService.findAll());
    }

    @PatchMapping("/camp/{id}")
    public ResponseEntity<Camp> update(@PathVariable Long id, @RequestBody CampRequest request){
        return ResponseEntity.ok(campService.update(id, request));
    }

    @DeleteMapping("/camp/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id){
        campService.delete(id);
        return ResponseEntity.ok(id);
    }
}
