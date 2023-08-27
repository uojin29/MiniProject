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

    public Students create(StudentsRequest request){
        Students students = Students.builder()
                .studentId(request.getStudentId())
                .name(request.getName())
                .department(request.getDepartment())
                .campName(request.getCampName())
                .build();
        studentsRepository.save(students);
        return students;
    }
    public Students findById(Long id){
        Students students = studentsRepository.findById(id).get();
        return students;
    }

    public List<Students> findAllByCampName(String campName){
        List<Students> students = studentsRepository.findAllByCampName(campName);
        return students;
    }

    public List<Students> findAll(){
        return studentsRepository.findAll();
    }

    public Students update(Long id, StudentsRequest request){
        Students students = studentsRepository.findById(id).get();
        students.update(request);
        studentsRepository.save(students);
        return students;
    }

    public void delete(Long id){
        studentsRepository.deleteById(id);
    }
}
