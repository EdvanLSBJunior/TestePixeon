package com.example.pixeon.heathCare.controllers;

import com.example.pixeon.heathCare.entities.Exam;

import com.example.pixeon.heathCare.exceptions.ResourceNotFound;
import com.example.pixeon.heathCare.repositories.ExamRepository;
import com.example.pixeon.heathCare.services.ExamService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/exam")
public class ExamController {

    @Autowired
    ExamRepository repository;

    @Autowired
    ExamService service;

    @GetMapping
    public Page<Exam> findAll(Pageable pageable) {
        Page<Exam> result = repository.findAll(pageable);
        return result;
    }

//    @GetMapping(value = "/{id}")
//    public Optional<Exam> findById(@PathVariable Long id) {
//        Optional<Exam> exam = repository.findById(id);
//        return exam;
//    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getExamById(@PathVariable("id") Long id) {
        Optional<Exam> exam = repository.findById(id);
        if (exam == null)
            throw new ResourceNotFound("O exame não foi encontrado!");
        return new ResponseEntity<>(exam, HttpStatus.OK);
    }

    @PostMapping
    public Exam create(@RequestBody Exam exam) {
        Exam result = repository.save(exam);
        return result;
    }

    @DeleteMapping(value = "/delete")
    public Exam delete(@RequestParam Long id) {
        repository.deleteById(id);
        return null;
    }
}
