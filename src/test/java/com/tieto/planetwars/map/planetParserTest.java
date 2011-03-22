package com.tieto.planetwars.map;

import static org.junit.Assert.*;
import org.junit.Test;

import com.tieto.planetwars.map.parser.PlanetParser;
import com.tieto.planetwars.player.impl.Player;
import com.tieto.planetwars.world.Coordinates;
import com.tieto.planetwars.world.Planet;

public class planetParserTest {

	@Test
	public void shouldReturn() {
		String inputData = "P 0 0 1 34 2";
		String[] splittedStringResult = {"P", "0", "0", "1", "34", "2"};
		PlanetParser planetParser = new PlanetParser(inputData);
		assertEquals(splittedStringResult, planetParser.parsingInput(inputData));
		
	}
	
	@Test
	public void shouldReturnCorrectPlanet() {
		String inputData = "P 0 0 1 34 2";
		//String[] splittedStringResult = {"P", "0", "0", "1", "34", "2"};
		PlanetParser planetParser = new PlanetParser(inputData);
		Coordinates coordinates = new Coordinates(0, 0);
		Player owner = new Player();
		owner.setId(0);
		Planet planet = new Planet(0, 2, owner, 34, coordinates);
		assertEquals(planet, planetParser.generatePlanet(planetParser.parsingInput(inputData)));
	}

}
