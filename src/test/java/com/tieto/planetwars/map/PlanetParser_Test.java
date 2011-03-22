package com.tieto.planetwars.map;

import java.awt.List;
import java.util.regex.Matcher;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

import com.tieto.planetwars.map.parser.PlanetParser;
import com.tieto.planetwars.map.parser.WrongPlanetDefinitionException;
import com.tieto.planetwars.player.Player;
import com.tieto.planetwars.world.Coordinates;
import com.tieto.planetwars.world.Planet;

public class PlanetParser_Test {
	
	private List<Player> ownerList;

	@Test
	public void Creates_planet_from_string() {

		String planetDefinition = "P 11.6135908004 11.6587374197 0 119 0";
		Planet newPlanet;

		Planet shouldBePlanet = new Planet(null, 0, null, 119, new Coordinates(
				11.6135908004, 11.6587374197));

		try {
			
			newPlanet = PlanetParser.parse(planetDefinition);
			// Assert.assertEquals(newPlanet, shouldBePlanet);
			assertThat(newPlanet, is(shouldBePlanet));
		} catch (WrongPlanetDefinitionException wpde) {
		}

	}

	@Test
	public void String_is_not_planet_definition() {
		String wrongPlanetDefinition = "F 1 15 0 1 12 2 ";
		Planet newPlanet;

		try {
			newPlanet = PlanetParser.parse(wrongPlanetDefinition);
			fail();
		} catch (WrongPlanetDefinitionException wpde) {

		}

	}

}
