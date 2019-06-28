package com.baskar.dropwizard.db.mapper;

import com.baskar.dropwizard.model.Employee;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class EmployeeMapper implements ResultSetMapper<Employee> {


    public Employee map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {



        Employee employee=new Employee(
                resultSet.getInt("empid"),
                resultSet.getString("name"),
                resultSet.getInt("age"),
                resultSet.getString("place"),
                resultSet.getString("dob"),
                resultSet.getString("phone"),
                resultSet.getInt("deptid")
        );
        return employee;
    }
}
