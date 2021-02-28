package com.example.demo;

import javax.persistence.*;
import java.util.List;

public class EmployeeService {

    private static EntityManager entityManager;

    public EmployeeService() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("EmployeeService");
        entityManager = factory.createEntityManager();
    }

    public Employee createEmployee(int id, String name, long salary) {
        Employee employee = new Employee(id);
        employee.setName(name);
        employee.setSalary(salary);
        entityManager.persist(employee);
        return employee;
    }

    public Employee findEmployee(int id) {
        return entityManager.find(Employee.class, id);
    }

    public void removeEmployee(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        if(employee != null) {
            entityManager.remove(employee);
        }
    }

    public Employee raiseEmployeeSalary(int id, long raise) {
        Employee employee = entityManager.find(Employee.class, id);
        employee.setSalary(employee.getSalary() + raise);
        return employee;
    }

    public Employee createEmployeeInTransaction(int id, String name, long salary) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
            Employee employee = createEmployee(id, name, salary);
        entityTransaction.commit();
        return employee;
    }

    public List<Employee> findAllEmployees() {
        TypedQuery<Employee> query = entityManager.createQuery("SELECT e FROM Employee e", Employee.class);
        return query.getResultList();
    }


    public static void main(String[] args) {
        EmployeeService demo = new EmployeeService();
        // Logic
    }
}
