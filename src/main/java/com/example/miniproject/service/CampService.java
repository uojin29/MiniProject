package com.example.miniproject.service;

import com.example.miniproject.domain.Camp;
import com.example.miniproject.domain.Students;
import com.example.miniproject.dto.request.CampRequest;
import com.example.miniproject.dto.request.StudentsRequest;
import com.example.miniproject.repository.CampRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CampService {
    private final CampRepository campRepository;

    public void create(CampRequest request){
        Camp camp = Camp.builder()
                .campName(request.getCampName())
                .profName(request.getProfName())
                .fee(request.getFee())
                .startDate(request.getStartDate())
                .finishDate(request.getFinishDate())
                .build();
        campRepository.save(camp);
    }
    public Camp findById(Long id){
        Camp camp = campRepository.findById(id).get();
        return camp;
    }
    public List<Camp> findAll(){
        return campRepository.findAll();
    }
    public Camp update(Long id, CampRequest request){
        Camp camp = campRepository.findById(id).get();
        camp.update(request);
        campRepository.save(camp);
        return camp;
    }

    public void delete(Long id){
        campRepository.deleteById(id);
    }
}
