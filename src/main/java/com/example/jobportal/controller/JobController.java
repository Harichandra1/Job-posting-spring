package com.example.jobportal.controller;

import com.example.jobportal.model.Job;
import com.example.jobportal.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class JobController {

    @Autowired
    private JobRepository jobRepository;

    @GetMapping("/")
    public String listJobs(
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) String location,
            @RequestParam(required = false) String jobType,
            Model model
    ) {
        System.out.println("Keyword: " + keyword);
        System.out.println("Location: " + location);
        System.out.println("JobType: " + jobType);

        List<Job> jobs;

        boolean isFiltering = (keyword != null && !keyword.isEmpty()) ||
                              (location != null && !location.isEmpty()) ||
                              (jobType != null && !jobType.isEmpty());

        if (isFiltering) {
            jobs = jobRepository.findByFilters(keyword, location, jobType);
        } else {
            jobs = jobRepository.findAll();
        }

        model.addAttribute("jobs", jobs);
        return "job-list";
    }

    @GetMapping("/add-job")
    public String showAddJobForm(Model model) {
        model.addAttribute("job", new Job());
        return "job-form";
    }

    @PostMapping("/add-job")
    public String submitJob(@ModelAttribute Job job) {
        jobRepository.save(job);
        return "redirect:/";
    }
}