package com.baskar.dropwizard.resource;


import com.baskar.dropwizard.Service.DepartmentService;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/department")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DepartmentResources {

    private DepartmentService departmentService;


    public DepartmentResources(final DepartmentService departmentService)
    {
        this.departmentService=departmentService;
    }
    @GET
    public Response getDepartment()
    {

        return Response.ok().entity(this.departmentService.getDepartment()).build();
    }
}
