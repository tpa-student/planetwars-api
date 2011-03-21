package com.tieto.planetwars.map;


import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.tieto.planetwars.map.parser.FleetParser;
import com.tieto.planetwars.map.parser.NotEnoughArgumentsInFleetParserString;
import com.tieto.planetwars.map.parser.TooManyArgumentsInFleetParserString;
import com.tieto.planetwars.world.Fleet;
import com.tieto.planetwars.world.WarsMap;

public class DescriptionFleetParser {

	public WarsMap warsMap;
	public FleetParser parser;
	
	@Before
	public void init() {
		warsMap = new WarsMap(null, null);
		parser = new FleetParser(warsMap);
	}
	
	@Test
	public void parser_should_have_method_parse() throws Exception {
		// given
		// then
		assertThat(parser.parse("F 1 15 0 1 12 2"),is(instanceOf(Fleet.class))); 
	}
	
	@Test
	public void parser_should_throw_exception_for_not_enough_arguments() throws Exception  {
		// given
		String fleetStringWithNotEnoughArguments = "F 1 15 0 1 12";
		// when
		try {
			parser.parse(fleetStringWithNotEnoughArguments);
			
			// then
			fail();
		} catch (NotEnoughArgumentsInFleetParserString ex) {
			// then
		}
	}
	
	@Test
	public void parser_should_ignore_comments() throws Exception  {
		// given
		String fleetStringWithComment = "F 1 15 0 1 12 2 #komentarz";
		
		// when
		try {
			parser.parse(fleetStringWithComment);
		} catch (NotEnoughArgumentsInFleetParserString ex) {
			// then
			fail();
		}
	}
	
	
	@Test
	public void parser_should_throw_exception_for_too_many_arguments() throws Exception  {
		// given
		String fleetStringWithTooManyArguments = "F 1 15 0 1 12 2 7";
		// when
		try {
			parser.parse(fleetStringWithTooManyArguments);
			
			// then
			fail();
		} catch (TooManyArgumentsInFleetParserString ex) {
			// then
		}
	}
	
	
	
	@Test
	public void parser_should_return_correct_planet_object() throws NotEnoughArgumentsInFleetParserString, TooManyArgumentsInFleetParserString {
		// given
		String fleetString = "F 1 15 0 1 12 2";
		Fleet fleet;
		
		// when
		fleet = parser.parse(fleetString);
		
		// then
		assertThat(fleet.getOwner().getId(),is(1)); 
	}

}
