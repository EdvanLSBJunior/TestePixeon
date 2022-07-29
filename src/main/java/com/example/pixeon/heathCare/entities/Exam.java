package com.example.pixeon.heathCare.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_exam")
public class Exam implements Serializable {

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
    @JoinColumn(name = "institution_id", nullable = false)
    private HealthCareInstitution healthCareInstitution;

    public Exam() {

    }

    public Exam(String patientName, Integer patientAge, String patientGender, String physicianName, String physicianCRM, String procedureName, HealthCareInstitution healthCareInstitution) {
        this.patientName = patientName;
        this.patientAge = patientAge;
        this.patientGender = patientGender;
        this.physicianName = physicianName;
        this.physicianCRM = physicianCRM;
        this.procedureName = procedureName;
        this.healthCareInstitution = healthCareInstitution;
    }

    public Long getId() {
        return id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exam exam = (Exam) o;
        return id.equals(exam.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", patientName='" + patientName + '\'' +
                ", patientAge=" + patientAge +
                ", patientGender='" + patientGender + '\'' +
                ", physicianName='" + physicianName + '\'' +
                ", physicianCRM='" + physicianCRM + '\'' +
                ", procedureName='" + procedureName + '\'' +
                ", healthCareInstitution=" + healthCareInstitution +
                '}';
    }
}
