package edu.upc.dsa.services;

import edu.upc.dsa.UsersManager;
import edu.upc.dsa.UsersManagerImpl;
import edu.upc.dsa.models.Track;
import edu.upc.dsa.models.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Root resource (exposed at "myresource" path)
 */
@Api(value = "/user", description = "Endpoint to User Service")
@Path("user")
public class UserService {
    private UsersManager um;

    public UserService() {
        this.um = UsersManagerImpl.getInstance();
        if (um.size()==0) {
            this.um.addNewByName("Claudia", "Biblioteca");
            this.um.addNewByName("Gilbert", "Cafeteria");
            this.um.addNewByName("Claudia", "Cafeteria");
        }


    }

    @GET
    @ApiOperation(value = "get all Users", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = User.class, responseContainer="List"),
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {

        List<User> users = this.um.findAll();

        GenericEntity<List<User>> entity = new GenericEntity<List<User>>(users) {};
        return Response.status(201).entity(entity).build()  ;

    }
}
