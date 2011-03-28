package com.tieto.planetwars.map.parser;

import com.tieto.planetwars.player.Player;
import com.tieto.planetwars.world.Coordinates;
import com.tieto.planetwars.world.Fleet;
import com.tieto.planetwars.world.Planet;
import com.tieto.planetwars.world.WarsMap;

public class FleetParser {

	private WarsMap warsMap;

	public FleetParser(WarsMap warsMap) {
		this.warsMap = warsMap;
	}
	
	public Fleet parse(String fleetString)
			throws NotEnoughArgumentsInFleetParserString, TooManyArgumentsInFleetParserString {
		int indexOfHash = fleetString.indexOf('#');
		fleetString = fleetString.substring(0, indexOfHash != - 1 ?  indexOfHash : fleetString.length());
		
		String[] fleetStringSplit = fleetString.split("\\s+");
		int fleetStringSplitLength = fleetStringSplit.length;
		
		if (fleetStringSplitLength < 7 ) {
			throw new NotEnoughArgumentsInFleetParserString();
		}
		if (fleetStringSplitLength > 7 ) {
			throw new TooManyArgumentsInFleetParserString();
		}
		
		int owner = Integer.parseInt(fleetStringSplit[1]);
		int ships = Integer.parseInt(fleetStringSplit[2]);
		int source = Integer.parseInt(fleetStringSplit[3]);
		int destinaton = Integer.parseInt(fleetStringSplit[4]);
		int totalTurns = Integer.parseInt(fleetStringSplit[5]);
		int remainingTurns = Integer.parseInt(fleetStringSplit[6]);
			
		return new Fleet(getPlayerById(owner), ships, getPlanetById(source), getPlanetById(destinaton), totalTurns, remainingTurns);
	}

	private Player getPlayerById(int owner) {
		return null;
	}

	private Planet getPlanetById(int planetId) {
		for (Planet planet : warsMap.getPlanets()) {
			if (planet.getId() == planetId) {
				return planet;
			}
		}
		return null;
	}
}
