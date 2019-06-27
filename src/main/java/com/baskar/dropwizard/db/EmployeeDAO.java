package com.baskar.dropwizard.db;


import com.baskar.dropwizard.db.utils.EmployeeMapper;
import model.Employee;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(EmployeeMapper.class)
public interface EmployeeDAO {

    @SqlQuery("select * from  `employee` ")
    public List<Employee> getEmployee();
}
