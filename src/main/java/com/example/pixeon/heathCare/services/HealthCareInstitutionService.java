package com.example.pixeon.heathCare.services;

import com.example.pixeon.heathCare.entities.HealthCareInstitution;

import com.example.pixeon.heathCare.repositories.HealthCareInstitutionRepository;
import com.example.pixeon.heathCare.services.exceptions.ResourceNotFoudException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;


@Service
public class HealthCareInstitutionService {

    @Autowired
    HealthCareInstitutionRepository repository;

    public List<HealthCareInstitution> findAll() {
        return repository.findAll();
    }

    public HealthCareInstitution findById(Long id) {
        Optional<HealthCareInstitution> institution = repository.findById(id);
        return institution.orElseThrow(() -> new ResourceNotFoudException(id));
    }

    public HealthCareInstitution createInstitution(HealthCareInstitution institution) {
        return repository.save(institution);
    }

    public HealthCareInstitution updateInstitution(Long id, HealthCareInstitution examDto) {
        try {
            HealthCareInstitution institution = repository.getReferenceById(id);
            updateInstitution(institution, examDto);
            return repository.save(institution);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoudException(id);
        }
    }

    private void updateInstitution(HealthCareInstitution institution, HealthCareInstitution obj) {
        institution.setName(obj.getName());
        institution.setCnpj(obj.getCnpj());
        institution.setBudget(obj.getBudget());
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoudException(id);
        }
    }
}