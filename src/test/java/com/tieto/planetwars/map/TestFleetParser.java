package com.tieto.planetwars.map;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.tieto.planetwars.map.parser.FleetParser;
import com.tieto.planetwars.player.Command;
import com.tieto.planetwars.player.Player;
import com.tieto.planetwars.world.Coordinates;
import com.tieto.planetwars.world.Fleet;
import com.tieto.planetwars.world.Planet;
import com.tieto.planetwars.world.WarsMap;
public class TestFleetParser {

	@Test
	public void forCorrectFleet() {

		String validFleet1 = "F 1 15 0 1 12 2";
		String validFleet2 = "F 2 28 1 2  8 4";
		FleetParser parser = new FleetParser();
		
		Player owner = new Player() {
			
			@Override
			public String getName() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int getId() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public List<Command> doTurn(WarsMap gameMap) {
				// TODO Auto-generated method stub
				return null;
			}
		};
		
		List<Player> players = new ArrayList<Player>();
		List<Planet> planets = new ArrayList<Planet>();
		
		players.add(owner);

		
		Planet source = new Planet(0, 0, owner, 34, new Coordinates(0,0));
		Planet destination = new Planet(1, 1, owner, 35, new Coordinates(1,1));
		
		planets.add(source);
		planets.add(destination);
		
		assertEquals(new Fleet(owner, 15, source, destination, 12, 2),
				parser.parse(validFleet1, planets, players ));
	}

}
