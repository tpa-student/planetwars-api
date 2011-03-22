package com.tieto.planetwars.map.parser;

import java.util.List;

import com.tieto.planetwars.player.Player;
import com.tieto.planetwars.world.Fleet;
import com.tieto.planetwars.world.Planet;

public class FleetParser {

	public Fleet parse(String validFleet1, List<Planet> planets, List<Player> players) {
		// TODO Auto-generated method stub
		return new Fleet(players.get(0), 15, planets.get(0) , planets.get(1), 12, 2);
	}

}
