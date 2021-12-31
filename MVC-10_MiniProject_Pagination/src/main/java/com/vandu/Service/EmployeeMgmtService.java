package com.vandu.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.vandu.Entity.Employee;
import com.vandu.Repository.IEmployeeRepo;

@Service("empService")
public class EmployeeMgmtService implements IEmployeeMgmtService {
	@Autowired
	private IEmployeeRepo repo;

	@Override
	public Iterable<Employee> getAllEmployee() {
		System.out.println("EmployeeMgmtService.getAllEmployee()");
		return repo.findAll(Sort.by("desig").ascending());
	}

	@Override
	public String insertEmployee(Employee emp) {
		return "employee saved with " + repo.save(emp).getEmpno();
	}

	@Override
	public Employee getEmployeeById(int empno) {
		return repo.findById(empno).get();
	}

	@Override
	public String updateEmployeeByID(Employee emp) {
		// TODO Auto-generated method stub
		return repo.save(emp).getEmpno() + " Employee updated";
	}

	@Override
	public String removeEmployeeById(int empno) {
		repo.deleteById(empno);
		return empno + " Employee deleted";
	}

	@Override
	public Page<Employee> showPageData(Pageable pageable) {
		System.out.println("EmployeeMgmtService.showPageData()");
		return repo.findAll(pageable);
	}

}
