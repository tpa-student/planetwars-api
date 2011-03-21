package com.tieto.planetwars.map;

import java.util.HashMap;

import junit.framework.Assert;

import org.junit.Test;

import com.tieto.planetwars.map.parser.CommandParser;
import com.tieto.planetwars.player.Command;
import com.tieto.planetwars.player.Player;
import com.tieto.planetwars.world.Coordinates;
import com.tieto.planetwars.world.Planet;

public class CommandParserTest {
	
	@Test
	public void if_new_command_object_was_created() {
		
		CommandParser com1 = new CommandParser();
		Assert.assertNotNull(com1);
	}
	
	
	@Test
	public void check_if_object_is_proper_for_proper_command() {
		
		String test = "1    2 3";
		Player owner = new PlayerDummy();
		Coordinates coordinates = new Coordinates(1.0, 1.0);
		Planet sourcePlanet = new Planet(1, 1, owner, 1, coordinates);;
		Planet destinationPlanet = new Planet(2, 1, owner, 1, coordinates);
		
	
		HashMap<Integer, Planet> planets = new HashMap<Integer, Planet>();
		planets.put(1, sourcePlanet);
		planets.put(2, destinationPlanet);
		
		int numShips = 3;
		
		Command testcommand = new Command(sourcePlanet, destinationPlanet, numShips );
	
		CommandParser com1 = new CommandParser(planets);
		Command tmp = com1.parse(test);
		
		Assert.assertEquals(testcommand.getNumShips(), tmp.getNumShips());
		Assert.assertEquals(testcommand.getSourcePlanet(), tmp.getSourcePlanet());
		Assert.assertEquals(testcommand.getDestinationPlanet(), tmp.getDestinationPlanet());
	}
	
	@Test
	public void sourceplanet_equals_destinationplanet() {
		
		String test = "1 1 3";
		Player owner = new PlayerDummy();
		Coordinates coordinates = new Coordinates(1.0, 1.0);
		Planet sourcePlanet = new Planet(1, 1, owner, 1, coordinates);;
		Planet destinationPlanet = new Planet(2, 1, owner, 1, coordinates);
		
		
		HashMap<Integer, Planet> planets = new HashMap<Integer, Planet>();
		planets.put(1, sourcePlanet);
		planets.put(2, destinationPlanet);
	
		
		CommandParser com1 = new CommandParser(planets);
		
		try{
			com1.parse(test);
			Assert.fail();
		} catch (RuntimeException e) {
			Assert.assertEquals("source planet same as destination planet", e.getMessage());
		}
		
	}
}
