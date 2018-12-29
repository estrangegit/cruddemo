package com.luv2code.springboot.cruddemo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

  private EmployeeDAO employeeDAO;

  public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
    this.employeeDAO = employeeDAO;
  }

  @Override
  public List<Employee> findAll() {
    return employeeDAO.findAll();
  }

  @Override
  public Employee findById(int theId) {
    return employeeDAO.findById(theId);
  }

  @Override
  public void save(Employee theEmployee) {
    employeeDAO.save(theEmployee);
  }

  @Override
  public void deleteById(int theId) {
    employeeDAO.deleteById(theId);
  }

}
