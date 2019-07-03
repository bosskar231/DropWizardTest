package com.baskar.dropwizard.db.mapper;

import com.baskar.dropwizard.model.Department;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentMapper implements ResultSetMapper<Department> {

    public Department map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        Department department=new Department(

                resultSet.getInt("deptId"),
                resultSet.getString("deptName")
        );
        return department;
    }
}
