package com.baskar.dropwizard.db.dao;

import com.baskar.dropwizard.db.mapper.DepartmentMapper;
import com.baskar.dropwizard.model.Department;
import com.baskar.dropwizard.model.Employee;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;


@RegisterMapper(DepartmentMapper.class)
public interface DepartmentDAO {


    @SqlQuery("select * from `department`")
    public List<Department> getDepartment();

}
