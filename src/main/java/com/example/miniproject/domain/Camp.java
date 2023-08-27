package com.example.miniproject.domain;

import com.example.miniproject.dto.request.CampRequest;
import com.example.miniproject.dto.request.StudentsRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Camp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String campName;

    private String fee;

    private String profName;

    private String startDate;

    private String finishDate;

    @CreationTimestamp
    private LocalDateTime regDate;

    public void update(CampRequest request) {
        this.campName = request.getCampName();
        this.fee = request.getFee();
        this.profName = request.getProfName();
        this.startDate = request.getStartDate();
        this.finishDate = request.getFinishDate();
    }

    @OneToMany(mappedBy = "camp")
    private List<CampStudents> campStudents = new ArrayList<>();
}
