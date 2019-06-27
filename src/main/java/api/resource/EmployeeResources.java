package api.resource;


import api.resource.Service.EmployeeService;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/employee")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeResources {
    private EmployeeService employeeService;
    public EmployeeResources(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GET
    public Response getEmployee()
    {
        return Response.ok().entity(this.employeeService.getEmployee()).build();
    }



}
