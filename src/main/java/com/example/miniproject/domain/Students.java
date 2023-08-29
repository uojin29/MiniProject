package com.example.miniproject.domain;

import com.example.miniproject.dto.request.StudentsRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @CreationTimestamp
    @Column(name = "regDate")
    private LocalDateTime regDate;

    public void update(StudentsRequest request) {
        this.name = request.getName();
        this.department = request.getDepartment();
        this.studentId = request.getStudentId();
    }

    @OneToMany(mappedBy = "students")
    private List<CampStudents> campStudents = new ArrayList<>();
}
