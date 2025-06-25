package com.example.jobportal.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String jobTitle;
    private String companyName;
    private String location;
    private String jobType;
    private Integer salaryMin;
    private Integer salaryMax;
    
    @Column(length = 1000)
    private String description;

    @Column(length = 1000)
    private String requirements;

    @Column(length = 1000)
    private String responsibilities;

    private LocalDate deadline;

    // === Getters & Setters ===
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getJobTitle() { return jobTitle; }
    public void setJobTitle(String jobTitle) { this.jobTitle = jobTitle; }

    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getJobType() { return jobType; }
    public void setJobType(String jobType) { this.jobType = jobType; }

    public Integer getSalaryMin() { return salaryMin; }
    public void setSalaryMin(Integer salaryMin) { this.salaryMin = salaryMin; }

    public Integer getSalaryMax() { return salaryMax; }
    public void setSalaryMax(Integer salaryMax) { this.salaryMax = salaryMax; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getRequirements() { return requirements; }
    public void setRequirements(String requirements) { this.requirements = requirements; }

    public String getResponsibilities() { return responsibilities; }
    public void setResponsibilities(String responsibilities) { this.responsibilities = responsibilities; }

    public LocalDate getDeadline() { return deadline; }
    public void setDeadline(LocalDate deadline) { this.deadline = deadline; }
}
