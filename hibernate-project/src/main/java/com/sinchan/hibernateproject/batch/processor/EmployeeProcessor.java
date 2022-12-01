package com.sinchan.hibernateproject.batch.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.sinchan.hibernateproject.entity.Employee;
import com.sinchan.hibernateproject.entity.EmployeeMapped;
@Component
public class EmployeeProcessor implements ItemProcessor<Employee, EmployeeMapped>{

	@Override
	public EmployeeMapped process(Employee employeeDTO) throws Exception {
		EmployeeMapped employee =  new EmployeeMapped();
		employee.setEmployeeId(employeeDTO.getEmployeeId());
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setAge(employeeDTO.getAge());
        System.out.println("inside processor " + employee.toString());
        return employee;
	}
	

}
