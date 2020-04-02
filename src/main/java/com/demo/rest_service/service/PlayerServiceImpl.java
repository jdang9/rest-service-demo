package com.demo.rest_service.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.demo.rest_service.model.Player;

@Service
public class PlayerServiceImpl implements IPlayerService {

	Map<Long, Player> players = new HashMap<>();
	long currId = 123;
	
	public PlayerServiceImpl() {
		initialize();
	}
	
	private void initialize() {
		Player player = new Player();
		player.setId(currId);
		player.setName("Ronaldo");
		player.setPosition("FW");
		player.setNationality("Brazil");
		
		players.put(player.getId(), player);
	}
	
	@Override
	public List<Player> getAllPlayers() {
		Collection<Player> results = players.values();
		ArrayList<Player> response = new ArrayList<Player>(results);

		System.out.print("---------------" + response);
		return response;
	}

	@Override
	public Player getPlayer(Long id) {
		return players.get(id);
	}

	@Override
	public Response createPlayer(Player player) {
		player.setId(++currId);
		players.put(player.getId(), player);
		
		return Response.ok(player).build();
	}

	@Override
	public Response updatePlayer(Player player) {
		Player currentPlayer = players.get(player.getId());
		if (currentPlayer != null)
		{
			players.put(currentPlayer.getId(),currentPlayer);
			
			return Response.ok(currentPlayer).build();
		}
		
		return Response.notModified().build();
	}

	@Override
	public Response deletePlayer(Long id) {
		Player currentPlayer = players.get(id);
		if (currentPlayer != null) {
			players.remove(id);
			
			return Response.ok().build();
		}

		return Response.notModified().build();	
		
	}

}
