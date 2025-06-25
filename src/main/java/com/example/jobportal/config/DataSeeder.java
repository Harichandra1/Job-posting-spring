package com.example.jobportal.config;

import com.example.jobportal.model.Job;
import com.example.jobportal.repository.JobRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner initDatabase(JobRepository jobRepository) {
        return args -> {
            Job job = new Job();
            job.setJobTitle("Java Developer");
            job.setCompanyName("Tech Corp");
            job.setLocation("Bangalore");
            job.setJobType("Full Time");
            job.setSalaryMin(600000);
            job.setSalaryMax(1200000);
            job.setDescription("Work with Spring Boot projects.");
            job.setRequirements("Java, Spring Boot, SQL");
            job.setResponsibilities("Develop REST APIs, fix bugs.");
            job.setDeadline(LocalDate.of(2025, 7, 31));

            jobRepository.save(job);
        };
    }
}
