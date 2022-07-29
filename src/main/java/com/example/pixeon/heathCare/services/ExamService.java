package com.example.pixeon.heathCare.services;

import com.example.pixeon.heathCare.entities.Exam;
import com.example.pixeon.heathCare.repositories.ExamRepository;
import com.example.pixeon.heathCare.services.exceptions.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;


@Service
public class ExamService {

    @Autowired
    ExamRepository examRepository;


    public List<Exam> findAll() {
        return examRepository.findAll();
    }

    public Exam findById(Long id) {
        Optional<Exam> exam = examRepository.findById(id);
        return exam.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Exam createExam(Exam exam) {
        return examRepository.save(exam);
    }

    public Exam update(Long id, Exam examDto) {
        try {
            Exam exam = examRepository.getReferenceById(id);
            updateExam(exam, examDto);
            return examRepository.save(exam);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateExam(Exam exam, Exam obj) {
        exam.setPatientName(obj.getPatientName());
        exam.setPatientAge(obj.getPatientAge());
        exam.setPatientGender(obj.getPatientGender());
        exam.setPhysicianName(obj.getPhysicianName());
        exam.setPhysicianCRM(obj.getPhysicianCRM());
        exam.setProcedureName(obj.getProcedureName());
    }

    public void delete(Long id) {
        try {
            examRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }
    }
}
