package com.example.pixeon.heathCare.services;

import com.example.pixeon.heathCare.dto.ExamPostDto;
import com.example.pixeon.heathCare.entities.Exam;
import com.example.pixeon.heathCare.repositories.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamService {

    @Autowired
    ExamRepository repository;

    public Exam createExam(ExamPostDto examPostDto) {
    var newExam = convertExamDtoToExam(examPostDto);
    return repository.save(newExam);
    }

    private Exam convertExamDtoToExam(ExamPostDto examPostDto) {

       Exam exam = new Exam();

       exam.setPatientName(examPostDto.getPatientName());
       exam.setPatientAge(examPostDto.getPatientAge());
       exam.setPatientGender(exam.getPatientGender());
       exam.setPhysicianName(examPostDto.getPhysicianName());
       exam.setPhysicianCRM(examPostDto.getPhysicianCRM());
       exam.setProcedureName(examPostDto.getProcedureName());
       return exam;
    }
}
