package edu.upc.dsa.services;


import edu.upc.dsa.*;
import edu.upc.dsa.models.Arma;
import edu.upc.dsa.models.Casillas_mapa;
import edu.upc.dsa.models.Compra_arma;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api(value = "/casillas", description = "Endpoint to Track Service")
@Path("/casillas")
public class CasillasService {

    private JuegoInterfaz jm;
    private ICasillasDAO casillasDao;

    public CasillasService() {
       // this.jm = JuegoImpl.getInstance();
        /*if(jm.sizeUser()==0){
            this.jm.Registro("carlo@upc.edu","TheKiller99","Antonio","Miranda","dadacaefsa");
            this.jm.Registro("victor@upc.edu","Victory_777","Victor","Gutierrez","dadacaefsa");
            this.jm.Registro("toni@upc.edu","ToniMontana","Toni","Montana","dadacaefsa");
        }*/
        casillasDao = CasillasDAOImpl.getInstance();
    }

    //Lista de casillas por nivel
    @GET
    @ApiOperation(value = "get casillas by level", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Casillas_mapa.class),
            @ApiResponse(code = 404, message = "User not found")
    })
    @Path("/{level}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCasillasBylevel(@PathParam("level") String level) {
        //List<Compra_arma> armasCom = armaDao.getArmasCompradas(correo);
        List<Casillas_mapa> casiMap = casillasDao.getCasillasLevel(Integer.parseInt(level));
        if (level == null) return Response.status(404).build();
        else{
            GenericEntity<List<Casillas_mapa>> entity = new GenericEntity<List<Casillas_mapa>>(casiMap) {};
            return Response.status(201).entity(entity).build();
        }
    }
    //Actualizar un usuario
    /*@GET
    @ApiOperation(value = "get all Track", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Track.class, responseContainer="List"),
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTracks() {

        List<Track> tracks = this.tm.findAll();

        GenericEntity<List<Track>> entity = new GenericEntity<List<Track>>(tracks) {};
        return Response.status(201).entity(entity).build()  ;

    }

    @GET
    @ApiOperation(value = "get a Track", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Track.class),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTrack(@PathParam("id") String id) {
        Track t = this.tm.getTrack(id);
        if (t == null) return Response.status(404).build();
        else  return Response.status(201).entity(t).build();
    }

    @DELETE
    @ApiOperation(value = "delete a Track", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/{id}")
    public Response deleteTrack(@PathParam("id") String id) {
        Track t = this.tm.getTrack(id);
        if (t == null) return Response.status(404).build();
        else this.tm.deleteTrack(id);
        return Response.status(201).build();
    }

    @PUT
    @ApiOperation(value = "update a Track", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/")
    public Response updateTrack(Track track) {

        Track t = this.tm.updateTrack(track);

        if (t == null) return Response.status(404).build();

        return Response.status(201).build();
    }



    @POST
    @ApiOperation(value = "create a new Track", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=Track.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newTrack(Track track) {

        if (track.getSinger()==null || track.getTitle()==null)  return Response.status(500).entity(track).build();
        this.tm.addTrack(track);
        return Response.status(201).entity(track).build();
    }*/

}