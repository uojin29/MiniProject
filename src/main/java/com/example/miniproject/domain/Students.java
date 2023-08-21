package com.example.miniproject.domain;

import com.example.miniproject.dto.request.StudentsRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "studentId")
    private int studentId;
    private String name;
    private String department;
    @Column(name = "campName")
    private String campName;
    @Column(name = "startDate")
    private String startDate;
    @Column(name = "finishDate")
    private String finishDate;

    public void update(StudentsRequest request) {
        this.name = request.getName();
        this.department = request.getDepartment();
        this.campName = request.getCampName();
        this.startDate = request.getStartDate();
        this.finishDate = request.getFinishDate();
    }
}
