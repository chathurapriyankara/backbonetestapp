/**
 *Copyright © Virtusa 2015
 */
package com.dell.ngp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.dell.ngp.model.Employee;
/**
 * @author MGunarathna
 */
public interface EmployeeMapper {

    /**
     * Retrieve List of all employees.
     * @return Employee List.
     * */
    @Select("SELECT * FROM EMPLOYEE")
    List<Employee> getAllemployee();

    /**
     * Save employee into the database.
     * @param employee for new employee details.
     * @return status of the insert action will return.
     * */
    @Insert("INSERT INTO employee (name,address,city,school,description,picture,email) VALUES "
             + "(#{name},#{address},#{city},#{school},#{description},#{picture},#{email})")
    @Options(useGeneratedKeys=true, keyProperty="id")
    int saveEmployee(Employee employee);


    /**
     * Update employee into the database.
     * @param employee for updated employee details.
     * @return status of the update action will return.
     * */
    @Update("UPDATE employee SET id = #{id},name = #{name},address = #{address},city = #{city }"
            + ",school = #{school },description = #{description },picture = #{picture},email = #{email} WHERE id = #{id}")
    int updateEmployee(Employee employee);

    /**
     * delete employee into the database.
     * @param id for employee id.
     * @return status of the delete action will return.
     * */
    @Delete("DELETE FROM employee WHERE id = #{id}")
    int deleteEmployee(int id);

}