package edu.upc.dsa.services;


import edu.upc.dsa.*;
import edu.upc.dsa.models.Arma;
import edu.upc.dsa.models.Compra_arma;
import edu.upc.dsa.models.Usuario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.LinkedList;
import java.util.List;

@Api(value = "/store", description = "Endpoint to Track Service")
@Path("/store")
public class TiendaService {

    private JuegoInterfaz jm;
    private IArmaDAO armaDao;

    public TiendaService() {
       // this.jm = JuegoImpl.getInstance();
        /*if(jm.sizeUser()==0){
            this.jm.Registro("carlo@upc.edu","TheKiller99","Antonio","Miranda","dadacaefsa");
            this.jm.Registro("victor@upc.edu","Victory_777","Victor","Gutierrez","dadacaefsa");
            this.jm.Registro("toni@upc.edu","ToniMontana","Toni","Montana","dadacaefsa");
        }*/
        armaDao = ArmaDAOImpl.getInstance();
    }
    //Obtener armas que se mostraran en la tienda
    @GET
    @ApiOperation(value = "get all weapons", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Arma.class),
            @ApiResponse(code = 404, message = "User not found")
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllWeapons() {

        List<Arma> armas = armaDao.getAllArmas();
        if (armas == null) return Response.status(404).build();
        else{
            GenericEntity<List<Arma>> entity = new GenericEntity<List<Arma>>(armas) {};
            return Response.status(201).entity(entity).build();
        }
    }
    //Comprar arma
    @POST
    @ApiOperation(value = "Buy a weapon", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Compra_arma.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response buyWeapon(Compra_arma compraArma) {

        if (compraArma.getCorreo_usuario()==null || compraArma.getNombre_arma()==null || compraArma.getForma_pago()==null )  return Response.status(500).entity(compraArma).build();
        this.armaDao.comprarArma(compraArma.getNombre_arma(),compraArma.getCorreo_usuario(),compraArma.getForma_pago());
        //this.jm.Registro(usuario.getCorreo(), usuario.getApodo(), usuario.getNombre(), usuario.getApellido(), usuario.getPassword());

        return Response.status(201).entity(compraArma).build();
    }

    //Lista de armas compradas
    @GET
    @ApiOperation(value = "get my weapons", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Compra_arma.class),
            @ApiResponse(code = 404, message = "User not found")
    })
    @Path("/{correo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMyWeapons(@PathParam("correo") String correo) {
        List<Compra_arma> armasCom = armaDao.getArmasCompradas(correo);
        if (correo == null) return Response.status(404).build();
        else{
            GenericEntity<List<Compra_arma>> entity = new GenericEntity<List<Compra_arma>>(armasCom) {};
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