/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsREST;

import DAO.AlumnoDAO;
import entidades.Alumno;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Arcke
 */
@Path("alumno")
public class AlumnoResource {
    
    AlumnoDAO DAO = new AlumnoDAO();
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AlumnoResource
     */
    public AlumnoResource() {
    }

    /**
     * Retrieves representation of an instance of wsREST.AlumnoResource
     * @param id
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getJson(@PathParam("id") int id) {
        
        return Response.ok().entity(DAO.consultar(id)).build();
    }

    /**
     * PUT method for updating or creating an instance of AlumnoResource
     * @param content representation for the resource
     */
    @POST
    @Consumes("application/json")
    public Response postJson(Alumno alumno) {
        DAO.insertar(alumno);
        return Response.ok().entity(alumno).build();
    }
    
    @PUT
    @Consumes("application/json")
    @Path("{id}")
    public Response putJson(@PathParam("id") int id, Alumno alumno) {
        alumno.setId(id);
        DAO.actualizar(alumno);
        return Response.ok().entity(alumno).build();
    }
    
    
}
