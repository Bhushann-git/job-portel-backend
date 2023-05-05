<<<<<<< HEAD:java-capstone-project-backend-master/capstone-project/src/main/java/com/anu/capstone/service/JobPostingServiceImpl.java
package com.anu.capstone.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.anu.capstone.domain.JobPosting;
import com.anu.capstone.dto.JobpostingDto;
import com.anu.capstone.exception.JobNotFoundException;
import com.anu.capstone.repository.JobPostRepository;
import com.anu.capstone.util.JobPostMapper;

import lombok.AllArgsConstructor;
@Transactional
@AllArgsConstructor
@Service
public class JobPostingServiceImpl implements JobPostingService {
    public JobPostRepository repository;
    public JobPostMapper mapper;

    @Override
    public Integer createNewJob(JobpostingDto jobpostingDto) {
        repository.save(mapper.toDomain(jobpostingDto));
        return 1;
    }
    @Override
    public List<JobpostingDto> all() {
         return repository.findAll()
                .stream()
                // .map( invoice -> mapper.toDto(invoice) )
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
    @Override
    public Integer deleteJobPost(Long id) throws JobNotFoundException {
        repository.deleteById(id);
        return 1;
    }
    @Override
    public Integer updateJobPost(JobpostingDto jobpostingDto) {
        repository.save(mapper.toDomain(jobpostingDto));
        return 1;
    }
    @Override
    public JobpostingDto fetchJobDetails(Long id) {
        Optional<JobPosting> op = repository.findById(id);
        return mapper.toDto(op.orElseThrow(() -> new JobNotFoundException("Job " + id + " Not Found")));
    }
    }
    
=======
package com.anu.capstone.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.anu.capstone.domain.JobPosting;
import com.anu.capstone.dto.JobPostingDto;
import com.anu.capstone.exception.JobNotFoundException;
import com.anu.capstone.repository.JobPostRepository;
import com.anu.capstone.util.JobPostMapper;

import lombok.AllArgsConstructor;
@Transactional
@AllArgsConstructor
@Service
public class JobPostingServiceImpl implements JobPostingService {
    public JobPostRepository repository;
    public JobPostMapper mapper;

    @Override
    public Integer createNewJob(JobPostingDto jobpostingDto) {
        repository.save(mapper.toDomain(jobpostingDto));
        return 1;
    }
    @Override
    public List<JobPostingDto> all() {
         return repository.findAll()
                .stream()
                // .map( invoice -> mapper.toDto(invoice) )
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
    @Override
    public Integer deleteJobPost(Long id) throws JobNotFoundException {
        repository.deleteById(id);
        return 1;
    }
    @Override
    public Integer updateJobPost(JobPostingDto jobpostingDto) {
        repository.save(mapper.toDomain(jobpostingDto));
        return 1;
    }
    @Override
    public JobPostingDto fetchJobDetails(Long id) {
        Optional<JobPosting> op = repository.findById(id);
        return mapper.toDto(op.orElseThrow(() -> new JobNotFoundException("Job " + id + " Not Found")));
    }
    }
    
>>>>>>> c46f9ae530aba0842b977efc0267c916e36d8bfa:capstone-project/src/main/java/com/anu/capstone/service/JobPostingServiceImpl.java
