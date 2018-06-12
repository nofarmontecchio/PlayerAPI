package com.rest.classes;
import java.util.Comparator;

import javax.annotation.Nullable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class is used to define Player Object.
 * @author Nofar Montecchio
 *
 */
public class Player {

	
	private int id;
	private String name;

	/**
	 * Empty constructor.
	 */
	public Player() {
		super();
	}

	/**
	 * Player constructor initializing Player object.
	 * @param id ID of Player.
	 * @param name Name of Player
	 */
	public Player(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	/**
	 * Getters And Setters
	 */
	@JsonProperty
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@JsonProperty
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Comparator for sorting the list by player name
	 * @return sorted list by player name in ascending order
	 */
    public static Comparator<Player> PlayerNameComparator = new Comparator<Player>() {

	  public int compare(Player p1, Player p2) {
		  
	   //set both strings as UPPERCASE
	   String playerName1 = p1.getName().toUpperCase();
	   String playerName2 = p2.getName().toUpperCase();

	   //ascending order
	   return playerName1.compareTo(playerName2);

	   //descending order
	   //return playerName2.compareTo(playerName1);
      }
    };
 
}
