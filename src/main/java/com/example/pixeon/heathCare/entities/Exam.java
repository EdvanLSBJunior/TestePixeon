package com.example.pixeon.heathCare.entities;

import javax.persistence.*;

@Entity
@Table(name = "tb_exam")
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String patientName;
    private Integer patientAge;
    private String patientGender;
    private String physicianName;
    private String physicianCRM;
    private String procedureName;

    @ManyToOne
    @JoinColumn(name = "institution_id")
    private HealthCareInstitution healthCareInstitution;

    public Exam() {

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

    public HealthCareInstitution getHealthCareInstitution() {
        return healthCareInstitution;
    }

    public void setHealthCareInstitution(HealthCareInstitution healthCareInstitution) {
        this.healthCareInstitution = healthCareInstitution;
    }
}
