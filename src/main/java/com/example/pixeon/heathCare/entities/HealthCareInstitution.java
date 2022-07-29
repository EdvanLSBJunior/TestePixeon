package com.example.pixeon.heathCare.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_institution")
public class HealthCareInstitution implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cnpj;
    private Integer budget;
    private Integer exams_found;

    @OneToMany(mappedBy = "healthCareInstitution")
    private List<Exam> exams;

    public HealthCareInstitution() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public Integer getExams_found() {
        return exams_found;
    }

    public void setExams_found(Integer exams_found) {
        this.exams_found = exams_found;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HealthCareInstitution that = (HealthCareInstitution) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "HealthCareInstitution{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", budget=" + budget +
                ", exams_found=" + exams_found +
                ", exams=" + exams +
                '}';
    }
}