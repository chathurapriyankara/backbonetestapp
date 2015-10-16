/**
 *Copyright © Virtusa 2015
 */
package com.dell.ngp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dell.ngp.model.Employee;
import com.dell.ngp.service.EmployeeService;

/**
 * @author MGunarathna
 */

@RestController
@RequestMapping("/employee/api")
public class EmployeeController {
    /**Holds Employee service class.*/
    @Autowired
    private EmployeeService employeeService;

    /**
     * Retrieve all employee details.
     * @return List<Employee> list of employees.
     * */
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody public List<Employee> getAllEmployee(){
         return employeeService.getEmployee();
    }

    /**
     * Save new employee details.
     * @param employee for new employee details.
     * @return saved employee details with generated id.
     * */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Employee saveEmployee(@RequestBody Employee employee){
           return employeeService.saveEmployee(employee);
    }

    /**
     * Update employee with modified information.
     * @param employee for updated details of employee.
     * @return status if the updated action.
     * */
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public int updateEmployee(@RequestBody Employee employee){
         return employeeService.updateEmployee(employee);
    }

    /**
     * Delete employee mapped to the id.
     * @param id for employee id
     * @return status if the delete action.
     * */
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public int deleteEmployee(@PathVariable("id") int id){
         return employeeService.deleteEmployee(id);
    }
}