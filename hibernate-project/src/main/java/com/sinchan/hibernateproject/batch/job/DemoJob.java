package com.sinchan.hibernateproject.batch.job;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.sinchan.hibernateproject.batch.mapper.EmployeeDbMapper;
import com.sinchan.hibernateproject.batch.mapper.EmployeeFileRowMapper;
import com.sinchan.hibernateproject.batch.processor.EmployeeProcessor;
import com.sinchan.hibernateproject.entity.Employee;
import com.sinchan.hibernateproject.entity.EmployeeMapped;

@Configuration
public class DemoJob {
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	@Autowired
	private DataSource datasource;
	@Autowired
	private EmployeeProcessor employeeProcessor;
	
	@Autowired
	private EmployeeDbMapper employeeDbMapper;

	public DemoJob(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory,
			EmployeeProcessor employeeProcessor, DataSource dataSource,EmployeeDbMapper employeeDbMapper) {
		this.jobBuilderFactory = jobBuilderFactory;
		this.stepBuilderFactory = stepBuilderFactory;
		this.employeeProcessor = employeeProcessor;
		this.datasource = datasource;
		this.employeeDbMapper = employeeDbMapper;
	}

	@Bean
	public Job demoJobOne() throws Exception {
		System.out.println("DOING JOB #########");
		return jobBuilderFactory.get("demoJob1").start(dempStepOne()).build();

	}

	public Step dempStepOne() throws Exception {

		return this.stepBuilderFactory.get("stepOne")
				/*
				 * pass the io type, o/p type
				 */
				.<Employee, EmployeeMapped>chunk(5).reader(jdbcEmployeeReader()).processor(employeeProcessor)
				.writer(employeeDBWriterDefault()).build();

	}

	@Bean
	@StepScope
	Resource inputFileResource(@Value("#{jobParameters[fileName]}") final String fileName) throws Exception {
		return new ClassPathResource(fileName);
	}

	@Bean
	public JdbcBatchItemWriter<EmployeeMapped> employeeDBWriterDefault() {
		JdbcBatchItemWriter<EmployeeMapped> itemWriter = new JdbcBatchItemWriter<EmployeeMapped>();
		itemWriter.setDataSource(datasource);
		itemWriter.setSql(
				"insert into employee (employee_id, first_name, last_name, email, age) values (:employeeId, :firstName, :lastName, :email, :age)");
		itemWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<EmployeeMapped>());
		return itemWriter;
	}

	@Bean
	public FlatFileItemReader<Employee> employeeReader() throws Exception {
		FlatFileItemReader<Employee> reader = new FlatFileItemReader<>();
		reader.setResource(inputFileResource(null));
		reader.setLineMapper(new DefaultLineMapper<Employee>() {
			{
				setLineTokenizer(new DelimitedLineTokenizer() {
					{
						setNames("employeeId", "firstName", "lastName", "email", "age");
						setDelimiter(",");
					}
				});
				setFieldSetMapper(new EmployeeFileRowMapper());
			}
		});

		return reader;
	}
	
	public JdbcCursorItemReader<Employee> jdbcEmployeeReader(){
		JdbcCursorItemReader<Employee> jdbcReaderObj = new JdbcCursorItemReader<>();
		jdbcReaderObj.setDataSource(datasource);
		jdbcReaderObj.setSql("Select * from employee");
		jdbcReaderObj.setRowMapper(employeeDbMapper);
		return jdbcReaderObj;
		
	}

	private Tasklet firstTask() {
		return new Tasklet() {
			@Override
			public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
				// TODO Auto-generated method stub
				System.out.println("First Task is completed");
				return RepeatStatus.FINISHED;
			}
		};
	}

}
