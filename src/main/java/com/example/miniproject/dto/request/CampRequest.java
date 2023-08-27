package com.example.miniproject.dto.request;

import lombok.Data;

@Data
public class CampRequest {
    private String campName;
    private String fee;
    private String profName;
    private String startDate;
    private String finishDate;
}
