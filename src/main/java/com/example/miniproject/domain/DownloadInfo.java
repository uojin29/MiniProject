package com.example.miniproject.domain;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DownloadInfo {
    private String currentTime;
    private String name;
    private String campName;
    private String studentId;
}
