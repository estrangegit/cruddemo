package com.luv2code.springboot.cruddemo.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.luv2code.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

  private EntityManager entityManager;

  @Autowired
  public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
    this.entityManager = theEntityManager;
  }

  @Override
  public List<Employee> findAll() {

    // create a Query
    Query theQuery = entityManager.createQuery("from Employee");

    // execute the query and get a result list
    List<Employee> employees = theQuery.getResultList();

    // return the results
    return employees;
  }

  @Override
  public Employee findById(int theId) {

    // get employee
    Employee theEmployee = entityManager.find(Employee.class, theId);

    // return employee
    return theEmployee;
  }

  @Override
  public void save(Employee theEmployee) {
    // save or update the employee
    Employee dbEmployee = entityManager.merge(theEmployee);

    // update with the id from the db... so we can get generated id for save/insert
    theEmployee.setId(dbEmployee.getId());
  }

  @Override
  public void deleteById(int theId) {
    // delete object with the given primary key
    Query theQuery = entityManager.createQuery("delete from Employee where id=:employeeId");
    theQuery.setParameter("employeeId", theId);
    theQuery.executeUpdate();
  }

}
