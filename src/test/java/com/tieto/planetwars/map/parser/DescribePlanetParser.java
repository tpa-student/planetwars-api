package com.tieto.planetwars.map.parser;

import static org.junit.Assert.*;

import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Test;

import com.tieto.planetwars.player.Command;
import com.tieto.planetwars.player.Player;
import com.tieto.planetwars.world.Coordinates;
import com.tieto.planetwars.world.Planet;
import com.tieto.planetwars.world.WarsMap;

public class DescribePlanetParser {

	class MyPlayer implements Player {
		private int id;

		public MyPlayer(int id) {
			this.id = id;
		}

		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getId() {
			// TODO Auto-generated method stub
			return this.id;
		}

		@Override
		public List<Command> doTurn(WarsMap gameMap) {
			// TODO Auto-generated method stub
			return null;
		}

		public boolean equals(Object player) {
			if (player instanceof Player)
				return ((Player)player).getId() == id;
			else 
				return false;
			
		}
	};

	@Test
	public void correct_line_containing_planet() {
		//Given
		String correctLine = "P 1.0 2.0 0 0 1";
		PlanetParser planetParser = new PlanetParser();
		Player player=new MyPlayer(0); 
		Planet correctPlanet = new Planet(0, 1, player, 0, new Coordinates(1.0, 2.0));
		
		//when
		Planet created = planetParser.parse(correctLine);
		
		// then
		assertThat(created.getCoordinates().getX(), Matchers.is(correctPlanet.getCoordinates().getX()));
		assertThat(created.getCoordinates().getY(), Matchers.is(correctPlanet.getCoordinates().getY()));
		assertThat(created.getGrowthRate(), Matchers.is(correctPlanet.getGrowthRate()));
		assertThat(created.getOwner(), Matchers.is(player));
		assertThat(created.getNumberOfShips(), Matchers.is(correctPlanet.getNumberOfShips()));
	}
	
	@Test
	public void given_fleet_instead_of_planet() throws SyntaxException {
		//given
		String line = "F 1 15 0 1 12 2 #commenthere";
		
		//when
		try {
			new PlanetParser().parse(line);
			fail();
		} catch (SyntaxException e) {
			assertThat(e.getMessage(), Matchers.containsString("Bad line. Line does not start with P."));
		}
	}
}
