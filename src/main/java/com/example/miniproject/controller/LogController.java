//package com.example.miniproject.controller;
//
//import com.example.miniproject.domain.Log;
//import com.example.miniproject.service.LogService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequiredArgsConstructor
//@CrossOrigin
//public class LogController {
//
//    private final LogService logService;
//
//    public LogController(LogService logService) {
//        this.logService = logService;
//    }
//
//    @PostMapping("/download-logs")
//    public void saveDownloadLog(@RequestBody Log log) {
//        logService.saveDownloadLog(downloadLog.getName(), downloadLog.getCampName());
//    }
//}
