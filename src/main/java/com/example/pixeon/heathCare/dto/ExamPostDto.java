package com.example.pixeon.heathCare.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ExamPostDto {

    private Long id;

    @NotBlank
    private String patientName;

    @NotNull
    private Integer patientAge;

    @NotBlank
    private String patientGender;

    @NotBlank
    private String physicianName;

    @NotBlank
    private String physicianCRM;

    @NotBlank
    private String procedureName;

    public ExamPostDto(String patientName, Integer patientAge, String patientGender, String physicianName, String physicianCRM, String procedureName) {
        this.patientName = patientName;
        this.patientAge = patientAge;
        this.patientGender = patientGender;
        this.physicianName = physicianName;
        this.physicianCRM = physicianCRM;
        this.procedureName = procedureName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Integer getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(Integer patientAge) {
        this.patientAge = patientAge;
    }

    public String getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(String patientGender) {
        this.patientGender = patientGender;
    }

    public String getPhysicianName() {
        return physicianName;
    }

    public void setPhysicianName(String physicianName) {
        this.physicianName = physicianName;
    }

    public String getPhysicianCRM() {
        return physicianCRM;
    }

    public void setPhysicianCRM(String physicianCRM) {
        this.physicianCRM = physicianCRM;
    }

    public String getProcedureName() {
        return procedureName;
    }

    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }

}


