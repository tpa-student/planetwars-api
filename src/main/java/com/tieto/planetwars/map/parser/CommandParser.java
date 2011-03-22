package com.tieto.planetwars.map.parser;

import java.util.List;

import com.tieto.planetwars.player.Command;
import com.tieto.planetwars.world.Planet;

public class CommandParser {
	private Planet sourcePlanet;
	private Planet destinationPlanet;
	private int numShips;
	private Command parsedCommand = null;
	private List<Planet> planets;

	public CommandParser(List<Planet> planets) {
		this.planets = planets;
	}

	public Command parseCommand(String command) {
		if(planets == null) 
			return null;
		
		if (command.isEmpty())
			return null;
		
		String[] tokens = command.split(" ");
		if (tokens.length != 3) 
			return null;
		
		sourcePlanet = planets.get(Integer.parseInt(tokens[0]));
		destinationPlanet = planets.get(Integer.parseInt(tokens[1]));
		numShips = Integer.parseInt(tokens[2]);
		parsedCommand = new Command(sourcePlanet, destinationPlanet, numShips);
		return parsedCommand;
	}
}
