/**
 *Copyright © Virtusa 2015
 */
package com.dell.ngp.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dell.ngp.mapper.EmployeeMapper;
import com.dell.ngp.model.Employee;
/**
 * @author MGunarathna
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class EmployeeService {

     /**Holds mybatis sqlsession.*/
     @Autowired
     private SqlSession sqlSession;

     /**
      * Retrieve all employees with the details from database.
      * @return return list of employees. 
      * */
     public List<Employee> getEmployee(){
     EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
         return employeeMapper.getAllemployee();
     }

     /**
      * Insert new employee details into the database.
      * @param employee for new employee details to be inserted into the database.
      * @return inserted employee details with generated id.
      * */
     public Employee saveEmployee(Employee employee){
         EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
         employeeMapper.saveEmployee(employee);
         return employee;
     }

     /**
      * Update employee with modified details.
      * @param employee for modified employee detail.
      * @return status of the update action.
      * */
     public int updateEmployee(Employee employee){
         EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
         return employeeMapper.updateEmployee(employee);
     }

     /**
      * Delete employee with given id.
      * @param id for employee id.
      * @return status of the delete action.
      * */
     public int deleteEmployee(int id){
         EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
         return employeeMapper.deleteEmployee(id);
     }

}