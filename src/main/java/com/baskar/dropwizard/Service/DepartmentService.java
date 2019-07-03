package com.baskar.dropwizard.Service;

import com.baskar.dropwizard.db.dao.DepartmentDAO;
import com.baskar.dropwizard.model.Department;

import java.util.List;

public class DepartmentService {


    private DepartmentDAO departmentDAO;
   public DepartmentService(final DepartmentDAO departmentDAO)
    {
        this.departmentDAO=departmentDAO;
    }

    public List<Department> getDepartment()
    {
        return this.departmentDAO.getDepartment();
    }
}
