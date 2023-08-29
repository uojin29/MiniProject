package com.example.miniproject.controller;

import com.example.miniproject.domain.DownloadInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@RestController
public class ApiController {
    @PostMapping("/api/saveTime")
    public void saveTime(@RequestBody DownloadInfo downloadInfo) {
        String currentTime = downloadInfo.getCurrentTime();
        String name = downloadInfo.getName();
        String campName = downloadInfo.getCampName();
        String studentId = downloadInfo.getStudentId();

        // 시간과 정보를 파일에 저장
        String filename = "download_log.txt";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
            writer.write("Time: " + currentTime + ", Name: " + name + ", Camp Name: " + campName + ", Student ID: " + studentId + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}