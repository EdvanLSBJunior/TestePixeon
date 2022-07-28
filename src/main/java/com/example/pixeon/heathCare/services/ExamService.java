package com.example.pixeon.heathCare.services;

import com.example.pixeon.heathCare.entities.Exam;
import com.example.pixeon.heathCare.repositories.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamService {

    @Autowired
    ExamRepository repository;

}
