package com.sinchan.hibernateproject.batch.runner;

import com.sinchan.hibernateproject.constants.StringConstants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JobRunner {

    private static final Logger logger = LoggerFactory.getLogger(JobRunner.class);


    private JobLauncher simpleJobLauncher;
    private Job demoJobOne;

    @Autowired
    public JobRunner(Job demoJobOne, JobLauncher jobLauncher) {
        this.simpleJobLauncher = jobLauncher;
        this.demoJobOne = demoJobOne;
    }


    @Async
    public void runBatchJob() throws JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
        JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();
        jobParametersBuilder.addString(StringConstants.FILE_NAME_CONTEXT_KEY, "employees.csv");
        jobParametersBuilder.addDate("date", new Date(), true);
        runJob(demoJobOne, jobParametersBuilder.toJobParameters());
    }


    public void runJob(Job demoJobOne, JobParameters parameters) throws JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
        try {
            JobExecution jobExecution = simpleJobLauncher.run(demoJobOne, parameters);
        } catch (JobExecutionAlreadyRunningException e) {
            logger.info("Job with fileName={} is already running.");
        } 
    }


}
