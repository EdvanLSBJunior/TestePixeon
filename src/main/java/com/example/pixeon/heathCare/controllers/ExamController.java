package com.example.pixeon.heathCare.controllers;

import com.example.pixeon.heathCare.dto.ExamPostDto;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(value = "/exam")
public class ExamController {

    @Autowired
    ExamRepository repository;

    @Autowired
    ExamService service;

    @GetMapping
    public Page<Exam> findAll (Pageable pageable) {
        return repository.findAll(pageable);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getExamById (@PathVariable("id") Long id) {
        Optional<Exam> optExam = repository.findById(id);
        if (optExam.isEmpty())
            throw new ResourceNotFound("O exame não foi encontrado!");
        return new ResponseEntity<>(optExam, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> create(@Valid @RequestBody ExamPostDto examPostDto) {
        var newExam = service.createExam(examPostDto);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(newExam.getId()).toUri();
        return ResponseEntity.created(location).body(newExam.getId());
    }

    @DeleteMapping(value = "/delete")
    public Exam delete(@RequestParam Long id) {
        repository.deleteById(id);
        return null;
    }
}
