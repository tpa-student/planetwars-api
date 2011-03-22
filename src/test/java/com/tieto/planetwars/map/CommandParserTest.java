package com.tieto.planetwars.map;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Test;

import com.tieto.planetwars.map.parser.CommandParser;
import com.tieto.planetwars.player.Command;
import com.tieto.planetwars.world.Planet;

public class CommandParserTest {
	
	private CommandParser commandPar;
	List<Planet> planets;
	public CommandParserTest() {
		planets = new ArrayList<Planet>();
		planets.add(new Planet(0,2,null,12,null));
		planets.add(new Planet(1,2,null,12,null));
		planets.add(new Planet(2,2,null,12,null));
		commandPar = new CommandParser(planets);
	}
	@Test
	public void empty_line() throws Exception {
	//	CommandParser comPar = new CommandParser(null);
		Command command = commandPar.parseCommand("");
		assertThat(command, Matchers.nullValue());
	}
	
	@Test
	public void number_of_ships_is_correct() throws Exception {
		//CommandParser commandPar = new CommandParser(null);
		Command command = commandPar.parseCommand("1 2 123581321");
		assertThat(command.getNumShips(), Matchers.is(123581321));
	}
	
	@Test
	public void number_of_parameters_is_ok() throws Exception {
	///	CommandParser commandPar = new CommandParser(null);
		Command command = commandPar.parseCommand("1 2 12");
		assertThat(command, Matchers.notNullValue());
	}
	
	@Test
	public void if_planets_are_correctly_parsed() throws Exception {
		
		Command command = commandPar.parseCommand("1 2 12");
		assertThat(command.getSourcePlanet(), Matchers.is(planets.get(1)));
	}
}
