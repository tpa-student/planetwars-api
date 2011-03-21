package com.tieto.planetwars.map.parser;

import java.util.HashMap;
import java.util.Map;

import com.tieto.planetwars.player.Command;
import com.tieto.planetwars.world.Planet;
import com.tieto.planetwars.world.WarsMap;

public class CommandParser {

	private HashMap<Integer, Planet> map;

	public CommandParser() {

	}

	public CommandParser(HashMap<Integer, Planet> planetsMap) {
		this.map = planetsMap;
	}

	public Command parse(String test) {

		String array[] = test.split("\\s+");
		if (array.length != 3)
			throw new RuntimeException();
		int numbers[] = new int[array.length];
		int i = 0;
		for (String p : array) {
			try {
				numbers[i++] = Integer.parseInt(p);
			}
			catch (NumberFormatException ex) {
				throw new RuntimeException();
			}
		}

		Planet sourcePlanet = null;
		Planet destinationPlanet = null;
		
		sourcePlanet = map.get(new Integer(numbers[0]));
		destinationPlanet = map.get(new Integer(numbers[1]));
		
		
		if (sourcePlanet == null || destinationPlanet == null)
			throw new RuntimeException();
		
		if(sourcePlanet.getId() == destinationPlanet.getId()) {
			throw new RuntimeException("source planet same as destination planet");
		}

		Command testcommand = new Command(sourcePlanet, destinationPlanet,
				numbers[2]);
		
		return testcommand;
	}

}
