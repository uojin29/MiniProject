package com.example.miniproject.dto.request;

import lombok.Data;

@Data
public class StudentsRequest {
    private int studentId;
    private String name;
    private String department;
    private String campName;
}
