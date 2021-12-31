package com.vandu.Service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vandu.Entity.Employee;

public interface IEmployeeMgmtService {
public Iterable<Employee> getAllEmployee();
public String insertEmployee(Employee emp);
public Employee getEmployeeById(int empno);
public String updateEmployeeByID(Employee emp);
public String removeEmployeeById(int empno);
public Page<Employee> showPageData(Pageable pageable);
}
