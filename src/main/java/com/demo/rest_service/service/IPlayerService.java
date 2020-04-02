package com.demo.rest_service.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.demo.rest_service.model.Player;

@Consumes("application/xml,application/json,application/x-www-form-urlencoded")
@Produces("application/xml,application/json")
@Path("/playerservice")
public interface IPlayerService {

	@Path("/players")
	@GET
	List<Player> getAllPlayers();
	
	@Path("/players/{id}")
	@GET
	Player getPlayerId(@PathParam(value = "id") Long id);
	
	@Path("/playersByNationality")
	@GET
	List<Player> getPlayersByNationality(@QueryParam("nation") String nation);
	
	@Path("/players")
	@POST
	void createPlayer(@FormParam("name") String name, @FormParam("position") String position, 
			@FormParam("nationality") String nationality, @HeaderParam("agent") String agent,
			@Context HttpHeaders headers);
	
	@Path("/players")
	@PUT
	Response updatePlayer(Player player);
	
	@Path("/players/{id}")
	@DELETE
	Response deletePlayer(@PathParam(value = "id") Long id);
}
