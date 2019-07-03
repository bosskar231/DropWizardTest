package com.baskar.dropwizard.Service;

import com.baskar.dropwizard.db.dao.EmployeeDAO;
import com.baskar.dropwizard.model.Employee;

import java.util.List;

public class EmployeeService {

    private   EmployeeDAO employeeDAO;


    public EmployeeService(final EmployeeDAO employeeDAO) {
        this.employeeDAO=employeeDAO;
    }
    public List<Employee> getEmployee(){
        return this.employeeDAO.getEmployee();
    }
    public Employee getEmploye(final int empid)
    {
        return this.employeeDAO.getEmploye( empid);
    }
    public void insert(Employee employee)
    {
//        try
//        {
            this.employeeDAO.insert(employee);
//        }
//        catch (Exception e)
//        {
//            System.out.println("duplicate erroe");
//        }

    }
    public Employee editEmploye(Employee employee)
    {
        this.employeeDAO.editEmploye(employee);
        return this.employeeDAO.getEmploye(Integer.parseInt(String.valueOf(employee.getEid())));
    }
        public int deleteEmployee(int id)
        {
            return this.employeeDAO.deleteEmployee(id);
        }
//        public void create()
//        {
//            this.employeeDAO.create();
//        }
}
