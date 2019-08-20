package com.example.demo.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;

@Repository
public class EmployeeDAO {

	private static final Map<String, Employee> empMap = new HashMap<String, Employee>();
	
	static {
		initEmp();
	}
	
	private static void initEmp() {
		Employee emp1 = new Employee("E01", "Smith", "Clerk", "999-999-9999","smith@demo.com");
		Employee emp2 = new Employee("E02", "Allen", "Salesman", "888-888-8888", "allen@demo.com");
		Employee emp3 = new Employee("E03", "Jones", "Manager", "777-777-7777", "jones@demo.com");
		
		empMap.put(emp1.getEmpNo(), emp1);
		empMap.put(emp2.getEmpNo(), emp2);
		empMap.put(emp3.getEmpNo(), emp3);
	}
	
	public Employee getEmployee(String empNo) {
		return empMap.get(empNo);
	}
	
	public List<Employee> getEmployees(){
		Collection< Employee> empCol = empMap.values();
		List<Employee> empList = new ArrayList<Employee>(empCol);
		return empList;
	}
}
