package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.model.Employee;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value="Employee Management System", description="Operations pertaining to employee in Employee Management System")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MainRestController {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	@RequestMapping("/")
	@ResponseBody
	public String welcome() {
		return "Welcome to the RestAPI Demo";
	}
	
	@ApiOperation(value = "View a list of available employees", response = List.class)
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Successfully retrieved list"),
		    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
		    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
		})
	@RequestMapping(value ="/employees")
	@ResponseBody
	public List<Employee> getEmployees() {
		return employeeDAO.getEmployees();
	}
	
	@RequestMapping(value ="/employeesXml", method = RequestMethod.GET, 
			produces = {MediaType.APPLICATION_XML_VALUE } )
	@ResponseBody
	public List<Employee> getEmployeesXml() {
		return employeeDAO.getEmployees();
	}
	
	@RequestMapping(value ="/employeesJson",method = RequestMethod.GET,
			produces = { MediaType.APPLICATION_JSON_VALUE } )
	@ResponseBody
	public List<Employee> getEmployeesJson() {
		return employeeDAO.getEmployees();
	}
	
	@RequestMapping(value="/employee/{empNo}", method= RequestMethod.GET,
			produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public Employee getEmployee(@PathVariable("empNo") String empNo) {
		return employeeDAO.getEmployee(empNo);
	}
}
