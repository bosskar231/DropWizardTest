package com.baskar.dropwizard;

import com.baskar.dropwizard.Service.DepartmentService;
import com.baskar.dropwizard.db.dao.DepartmentDAO;
import com.baskar.dropwizard.resource.DepartmentResources;
import com.baskar.dropwizard.resource.EmployeeResources;
import com.baskar.dropwizard.Service.EmployeeService;
import com.baskar.dropwizard.db.dao.EmployeeDAO;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

public class EmployeeApplication extends Application<EmployeeConfiguration> {


    public static void main(String[] args) throws Exception {
        new EmployeeApplication().run(args);
    }

//    public void initialize(Bootstrap<Configuration> bootstrap) {
//
//    }

    public void run(EmployeeConfiguration configuration, Environment environment) throws Exception {
        final DBIFactory dbiFactory=new DBIFactory();
        final DBI dbi=dbiFactory.build(environment,configuration.getDataSourceFactory(),"mysql");
         final EmployeeDAO employeeDAO=dbi.onDemand(EmployeeDAO.class);
         final EmployeeService employeeService=new EmployeeService(employeeDAO);

         final EmployeeResources employeeResources=new EmployeeResources(employeeService);
            environment.jersey().register(employeeResources);


            final DepartmentDAO departmentDAO=dbi.onDemand(DepartmentDAO.class);
            final DepartmentService departmentService=new DepartmentService(departmentDAO);

            final DepartmentResources departmentResources=new DepartmentResources(departmentService);
            environment.jersey().register(departmentResources);
    }
}
