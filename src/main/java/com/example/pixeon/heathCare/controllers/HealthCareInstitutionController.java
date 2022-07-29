package com.example.pixeon.heathCare.controllers;

import com.example.pixeon.heathCare.entities.HealthCareInstitution;
import com.example.pixeon.heathCare.repositories.HealthCareInstitutionRepository;
import com.example.pixeon.heathCare.services.HealthCareInstitutionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/institution")
public class HealthCareInstitutionController {

    @Autowired
    HealthCareInstitutionRepository repository;

    @Autowired
    HealthCareInstitutionService service;

    @GetMapping
    public ResponseEntity<List<HealthCareInstitution>> findAll() {
        List<HealthCareInstitution> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<HealthCareInstitution> getExamById(@PathVariable Long id, HealthCareInstitution institution) {
        institution = service.findById(id);
        return ResponseEntity.ok().body(institution);
    }

    @PostMapping
    public ResponseEntity<HealthCareInstitution> insertExam(@RequestBody HealthCareInstitution institution) {
        service.createInstitution(institution);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(institution.getId()).toUri();
        return ResponseEntity.created(location).body(institution);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<HealthCareInstitution> updateExam(@PathVariable Long id, @RequestBody HealthCareInstitution institution) {
        institution = service.updateInstitution(id, institution);
        return ResponseEntity.ok().body(institution);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteExam(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
