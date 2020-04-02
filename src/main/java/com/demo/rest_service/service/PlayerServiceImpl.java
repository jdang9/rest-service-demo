package com.demo.rest_service.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;
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

		return response;
	}

	@Override
	public Player getPlayerId(Long id) {
		return players.get(id);
	}

	@Override
	public void createPlayer(String name, String position, String nationality, String agent, HttpHeaders headers) {
		long id = ++currId;
		Player newPlayer = new Player();
		newPlayer.setId(id);
		newPlayer.setName(name);
		newPlayer.setPosition(position);
		newPlayer.setNationality(nationality);
		players.put(id, newPlayer);
		
		System.out.println("-----Agent-----");
		System.out.println(agent); //this is to verify header being passed and print in console
		
		System.out.println("-----Headers-----");
		//this is to print out all header props in console
		MultivaluedMap<String, String> allHeaders = headers.getRequestHeaders();
		Set<String> headerKeys = allHeaders.keySet();
		
		for (String key : headerKeys) {
			System.out.println(headers.getHeaderString(key));
		}
		
		System.out.println("-----Cookies-----");
		//this is to print out cookies on console
		Map<String, Cookie> cookies = headers.getCookies();
		Set<String> cookieKeys = cookies.keySet();
		
		for (String key : cookieKeys) {
			System.out.println(cookies.get(key).getValue());
		}
	}

	@Override
	public Response updatePlayer(Player player) {
		Player currentPlayer = players.get(player.getId());
		if (currentPlayer != null)
		{
			players.put(currentPlayer.getId(), player);
			
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

	@Override
	public List<Player> getPlayersByNationality(String nation) {
		List<Player> response = new ArrayList<Player>();
		Iterator<Player> results = players.values().iterator();
		
		while (results.hasNext()) {
			Player player = results.next();
			if (player.getNationality().equals(nation)) {
				response.add(player);
			}
		}
		
		return response;
	}

}
