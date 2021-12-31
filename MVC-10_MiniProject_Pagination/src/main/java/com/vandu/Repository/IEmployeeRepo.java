package com.vandu.Repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.vandu.Entity.Employee;

public interface IEmployeeRepo extends PagingAndSortingRepository<Employee, Integer> {

}
