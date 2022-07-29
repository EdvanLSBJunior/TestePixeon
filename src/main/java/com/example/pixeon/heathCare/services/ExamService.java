package com.example.pixeon.heathCare.services;

import com.example.pixeon.heathCare.entities.Exam;
import com.example.pixeon.heathCare.repositories.ExamRepository;
import com.example.pixeon.heathCare.services.exceptions.ResourceNotFoudException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;


@Service
public class ExamService {

    @Autowired
    ExamRepository repository;

    public List<Exam> findAll() {
        return repository.findAll();
    }

    public Exam findById(Long id) {
        Optional<Exam> exam = repository.findById(id);
        return exam.orElseThrow(() -> new ResourceNotFoudException(id));

    }

    public Exam createExam(Exam exam) {
        return repository.save(exam);
    }

    public Exam update(Long id, Exam examDto) {
        try {
            Exam exam = repository.getReferenceById(id);
            updateExam(exam, examDto);
            return repository.save(exam);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoudException(id);
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
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoudException(id);
        }
    }
}
