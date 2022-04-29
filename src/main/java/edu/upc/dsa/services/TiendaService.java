package edu.upc.dsa.services;

import edu.upc.dsa.TiendaManager;
import edu.upc.dsa.TiendaManagerImpl;
import edu.upc.dsa.TracksManager;
import edu.upc.dsa.TracksManagerImpl;
import edu.upc.dsa.models.Cliente;
import edu.upc.dsa.models.Catalogo;
import edu.upc.dsa.models.Articulo;
import edu.upc.dsa.models.Track;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Api(value = "/tienda", description = "Endpoint to Tienda Service")
@Path("/tienda")
public class TiendaService {
    private TiendaManager tm;

    public TiendaService() {
        this.tm = TiendaManagerImpl.getInstance();
        if (tm.size()==0) {
            this.tm.RegistroUsuario("Claudia", "Garcia Gil", "7 mayo 1999", "claudia@gmail.com", "123");
            this.tm.RegistroUsuario("Pepito", "Garcia Gil", "7 mayo 1999", "pepi@gmail.com", "1727");
            this.tm.RegistroUsuario("Claudia", "Fernandez Gil", "7 mayo 1999", "claudia1@gmail.com", "123");
            this.tm.RegistroUsuario("Jose", "Pascual Gil", "7 mayo 1999", "pepi1@gmail.com", "1727");
            this.tm.RegistroUsuario("Jose", "Alvarez Gil", "7 mayo 1999", "pepi3@gmail.com", "1727");

        }

    }

    @GET
    @ApiOperation(value = "get all Clients", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Cliente.class, responseContainer="List"),
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClientesOrdenadosAlf() {

        List<Cliente> clientes = this.tm.OrdenadosAlfabeticamente();

        GenericEntity<List<Cliente>> entity = new GenericEntity<List<Cliente>>(clientes) {};
        return Response.status(201).entity(entity).build()  ;

    }

    @GET
    @ApiOperation(value = "get a articulos comprados por un cliente", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Articulo.class),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getArticulo(@PathParam("id") String id) {
        Articulo a = this.tm.articulosCompradosPor(id).get(0);
        if (a == null) return Response.status(404).build();
        else  return Response.status(201).entity(a).build();
    }

}
