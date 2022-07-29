package com.example.pixeon.heathCare.controllers;

import com.example.pixeon.heathCare.entities.Exam;
import com.example.pixeon.heathCare.repositories.ExamRepository;
import com.example.pixeon.heathCare.services.ExamService;
import com.example.pixeon.heathCare.services.InstitutionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping(value = "/exam")
public class ExamController {

    @Autowired
    ExamRepository repository;

    @Autowired
    ExamService service;

    @Autowired
    InstitutionService institutionService;

    @GetMapping
    public ResponseEntity<List<Exam>> findAll() {
        List<Exam> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Exam> getExamById(@PathVariable Long id, Exam exam) {
        exam = service.findById(id);
        return ResponseEntity.ok().body(exam);
    }

    @PostMapping
    public ResponseEntity<Exam> insertExam(@RequestBody Exam exam) {
        service.createExam(exam);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(exam.getId()).toUri();
        return ResponseEntity.created(location).body(exam);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Exam> updateExam(@PathVariable Long id, @RequestBody Exam exam) {
        exam = service.update(id, exam);
        return ResponseEntity.ok().body(exam);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteExam(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
