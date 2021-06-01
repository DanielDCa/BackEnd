package edu.upc.dsa.services;

import edu.upc.dsa.JuegoImpl;
import edu.upc.dsa.JuegoInterfaz;
import edu.upc.dsa.Min2Impl;
import edu.upc.dsa.Min2nterfaz;
import edu.upc.dsa.models.Badges;
import edu.upc.dsa.models.User;
import edu.upc.dsa.models.Usuario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.LinkedList;
import java.util.List;

@Api(value = "/min2", description = "Endpoint to Track Service")
@Path("/min2")
public class Min2Service {
    private Min2nterfaz m2;
    List<String> medallas;

    public Min2Service() {
        this.m2 = Min2Impl.getInstance();
        if(m2.sizeUser()==0){
            medallas = new LinkedList<>();
            medallas.add("meteor");
            medallas.add("sun");
            this.m2.Registro("TheKiller99","http://localhost:8080/img/avatar.png","Antonio","Miranda",medallas);
            /*this.jm.Registro("victor@upc.edu","Victory_777","Victor","Gutierrez","dadacaefsa");
            this.jm.Registro("toni@upc.edu","ToniMontana","Toni","Montana","dadacaefsa");*/
        }
    }
    //Obtener un usuario
    @GET
    @ApiOperation(value = "get a User", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = User.class),
            @ApiResponse(code = 404, message = "User not found")
    })
    @Path("/user/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser1(@PathParam("userId") String userId) {
       User u = this.m2.get1User(userId);
        if (u == null) return Response.status(404).build();
        else  return Response.status(201).entity(u).build();
        //Track t = this.tm.getTrack(id);

    }
    /*@GET
    @ApiOperation(value = "get badgets", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Badges.class),
            @ApiResponse(code = 404, message = "User not found")
    })
    @Path("/badges")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("userId") String userId) {
       /*Usuario u = this.jm.getUsuario(apodo);
        if (u == null) return Response.status(404).build();
        else  return Response.status(201).entity(u).build();
        //Track t = this.tm.getTrack(id);

    }*/



}
