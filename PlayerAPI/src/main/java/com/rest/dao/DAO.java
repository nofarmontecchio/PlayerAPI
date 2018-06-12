package com.rest.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.rest.classes.Player;


/**
 * This class includes the methods used in resource
 * @author Nofar Montecchio
 *
 */
public class DAO {

	
	private static final Map<Integer,Player> PLAYERS= new TreeMap<>();
	   
	   
	   static {
		   PLAYERS.put(1, new Player(1, "messi"));
		   PLAYERS.put(7, new Player(7, "ronaldo"));
		   PLAYERS.put(3, new Player(3, "neymar"));
		   PLAYERS.put(4, new Player(4, "iniesta"));
		   PLAYERS.put(5, new Player(5, "ronaldo"));
		   PLAYERS.put(2, new Player(2, "pique"));
		   PLAYERS.put(6, new Player(6, "suarez"));
	   }
  

    /**
     * Returns the number of players.
     * @return size of the Map.
     */
    public static int getCount() {
        return PLAYERS.size();
    }

    /**
     * Adds new Player to Map.
	 * @param player - Player that is going to be added to the Map.
     * @return Response - if the player added successfully
     */
    public static Response addPlayer(Player player) {
        
		if (player==null) {
			return Response.status(Status.BAD_REQUEST).entity("player is null. please send again.").build();
		}
		if (PLAYERS.get(player.getId()) == null) {
			if (player.getName() != null){
				PLAYERS.put(player.getId(), player);
				return Response.status(Status.OK).entity("player with id "+player.getId()+" added successfully").build();
			}
			else {
				return Response.status(Status.BAD_REQUEST).entity("player name is null. please send again.").build();
			}
		} 
		else {
			return Response.status(Status.BAD_REQUEST).entity("player's id is already exists. please send again.").build();
		}
		
    }
    
    /**
     * Returns a sorted map of the players by id.
     * @return Collection - sorted map by id.
     */
	 public static Collection<Player> getAllById() {
	    	
		 TreeMap<Integer, Player> sortedPlayersById = new TreeMap<Integer, Player>(PLAYERS);
			
	    	return sortedPlayersById.values();

	    }
    
	 /**
	  * Returns a sorted map of the players by name.
	  * @return Collection - sorted map by name.
	  */
     public static List<Player> getAllByName() {
	   
    	List<Player> sortedPlayersByName = new ArrayList<Player>(PLAYERS.values());
    	Collections.sort(sortedPlayersByName, Player.PlayerNameComparator);
		
    	return sortedPlayersByName;

    }
}
