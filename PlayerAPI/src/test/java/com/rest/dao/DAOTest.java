package com.rest.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

import com.rest.classes.Player;

/**
 * This class testing the methods of DAO Class by JUnit
 * @author Nofar Montecchio
 *
 */
public class DAOTest {
	 
	
	@Test
	public void testGetCount() {

		assertEquals(7, DAO.getCount());
	        
	}
	 
    @Test
    public void testGetAllByName() {
        assertEquals("iniesta", DAO.getAllByName().get(0).getName());
        
    }

    @Test
    public void testGetAllById() {
        assertEquals(1, DAO.getAllById().stream().findFirst().get().getId());
        
    }
    
    
    @Test
    public void testAddPlayer() {
       
        Player player = new Player(8,"griezmann");
        DAO.addPlayer(player);
    	
        Collection<Player> collectionlist= DAO.getAllById();
        List<Player> arraylist = new ArrayList<Player>();
        for(Player p : collectionlist){
            arraylist.add(p);
        }
        
        assertEquals(8, arraylist.size());
        assertEquals(8, arraylist.get(7).getId());
     
    }

}
