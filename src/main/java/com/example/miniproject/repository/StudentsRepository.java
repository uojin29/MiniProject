package com.example.miniproject.repository;

import com.example.miniproject.domain.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentsRepository extends JpaRepository<Students, Long> {
    List<Students> findAllByCampName(String campName);
//    Students deleteByCampName(String campName);
}
