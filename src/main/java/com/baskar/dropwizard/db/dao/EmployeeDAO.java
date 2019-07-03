package com.baskar.dropwizard.db.dao;


import com.baskar.dropwizard.db.mapper.EmployeeMapper;
import com.baskar.dropwizard.model.Employee;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(EmployeeMapper.class)
public interface EmployeeDAO {

    @SqlQuery("select * from  `employee` ")
    public List<Employee> getEmployee();


    @SqlQuery("select * from `employee` where empid= :empid")
    public Employee getEmploye(@Bind("empid")final int empid);

    @SqlUpdate("INSERT INTO `employee` (`empid`,`name`,`age`,`place`,`dob`,`phone`,`deptid`) VALUES (:eid , :name, :age, :place, :dob, :phone, :deptid );")
    public void insert(@BindBean  Employee employee);

    @SqlUpdate("update employee set name = coalesce(:name ,name) where empid= :eid")
    void editEmploye(@BindBean Employee employee);

    @SqlUpdate("delete from employee where empid= :id")
    int deleteEmployee(@Bind("id")final int id);
//    @SqlUpdate("create table baskarTest(id int);")
//    public void create();
}

