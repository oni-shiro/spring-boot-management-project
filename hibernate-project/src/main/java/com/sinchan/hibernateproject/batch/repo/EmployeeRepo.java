package com.sinchan.hibernateproject.batch.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sinchan.hibernateproject.entity.Employee;
import com.sinchan.hibernateproject.entity.EmployeeMapped;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, String> {
}
