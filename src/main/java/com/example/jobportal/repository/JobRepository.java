package com.example.jobportal.repository;

import com.example.jobportal.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {

    @Query("SELECT j FROM Job j WHERE " +
           "(:keyword IS NULL OR LOWER(j.jobTitle) LIKE LOWER(CONCAT('%', :keyword, '%'))) AND " +
           "(:location IS NULL OR LOWER(j.location) = LOWER(:location)) AND " +
           "(:jobType IS NULL OR LOWER(j.jobType) = LOWER(:jobType))")
    List<Job> findByFilters(
        @Param("keyword") String keyword,
        @Param("location") String location,
        @Param("jobType") String jobType
    );
}
