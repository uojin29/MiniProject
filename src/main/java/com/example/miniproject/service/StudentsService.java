package com.example.miniproject.service;

import com.example.miniproject.domain.Students;
import com.example.miniproject.dto.request.StudentsRequest;
import com.example.miniproject.repository.StudentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class StudentsService {
    private final StudentsRepository studentsRepository;

    public Students create(Students students){
        studentsRepository.save(students);
        return students;
    }
//    public Students findById(Long id){
//        Students students = studentsRepository.findById(id).get();
//        return students;
//    }

    public Students findByCampName(String campName){
        Students students = studentsRepository.findByCampName(campName);
        return students;
    }

    public List<Students> findAll(){
        return studentsRepository.findAll();
    }

    public Students update(String campName, StudentsRequest request){
        Students students = studentsRepository.findByCampName(campName);
        students.update(request);
        studentsRepository.save(students);
        return students;
    }

    public void delete(String campName){
        studentsRepository.deleteByCampName(campName);
    }
}
