package com.baskar.dropwizard;

import api.resource.EmployeeResources;
import api.resource.Service.EmployeeService;
import com.baskar.dropwizard.db.EmployeeDAO;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
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
    }
}
