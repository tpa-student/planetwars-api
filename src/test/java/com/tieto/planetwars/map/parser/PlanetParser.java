package com.tieto.planetwars.map.parser;

import com.tieto.planetwars.player.Player;
import com.tieto.planetwars.world.Coordinates;
import com.tieto.planetwars.world.Planet;

public class PlanetParser {

	public PlanetParser(String inputData) {
	}
	
	public String[] parsingInput(String inputData) {
		String[] splittedData = inputData.split(" ");
		return splittedData;
	}
	
	public Planet generatePlanet(String[] splittedData) {
		Coordinates coordinates;
		if (splittedData[0].compareTo("P") != 0)
			throw new RuntimeException();
		try {
			coordinates = new Coordinates(Double.parseDouble(splittedData[1]), Double.parseDouble(splittedData[2]));
		
		Integer numberOfShips = Integer.parseInt(splittedData[4]);
		Integer growthRate = Integer.parseInt(splittedData[5]);
		
		com.tieto.planetwars.player.impl.Player owner = new com.tieto.planetwars.player.impl.Player();
		owner.setId(Integer.parseInt(splittedData[2]));
		
		
		Planet planet = new Planet(0, growthRate, owner, numberOfShips, coordinates);

		
		return planet;
		
		} catch (NumberFormatException e) {
			//throw new WrongParsingException();
		}
		return null;
	}

}
