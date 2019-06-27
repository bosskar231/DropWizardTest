package com.baskar.dropwizard.db.utils;

import com.mysql.cj.api.mysqla.result.Resultset;
import model.Employee;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class EmployeeMapper implements ResultSetMapper<Employee> {


    public Employee map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {



        Employee employee=new Employee(
                resultSet.getInt("id"),
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
