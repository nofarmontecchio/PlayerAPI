package com.rest.resource;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.rest.classes.Player;
import com.rest.dao.DAO;


/**
 * This resource is used to give functions (by GET, POST).
 * Root resource (exposed at "playerAPI" path)
 * @author Nofar Montecchio
 * 
 */
@Path("playerAPI") 
public class PlayerAPIResource {

   private final HashMap<Long,Player> PLAYERS;


	/**
	 * Default Player constructor.
	 */ 
   public PlayerAPIResource() {
	
    	this.PLAYERS = new HashMap<Long, Player>();
    }
   
    
   /**
	 * This method is used to add player.
	 * @param player Player to store.
	 *
	 */
	@POST
	@Path("/addPlayer")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addPlayer(Player player) {

		return DAO.addPlayer(player);
	
	}

	/**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return collection that will be returned as APPLICATION_JSON response.
     */

	@GET
	@Path("/getPlayers")
	@Produces(MediaType.APPLICATION_JSON)
	public Object getAllPlayers (@QueryParam("sort") String sort) {
		if (sort==null) {
			return Response.status(Status.BAD_REQUEST).entity("sort is null.").build();
		}
		switch(sort) {
		case "id":
			return  DAO.getAllById();
		
		case "name":
			return  DAO.getAllByName();
			
		default:
			return Response.status(Status.BAD_REQUEST).entity("you MUST enter either id or name").build();
		}
	
	}

	
}
	
	

