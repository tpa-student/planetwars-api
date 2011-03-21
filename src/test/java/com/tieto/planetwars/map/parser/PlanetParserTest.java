package com.tieto.planetwars.map.parser;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class PlanetParserTest {
	@Test
	public void shouldThrowNotPStarterException() {
		String input = "G";

		PlanetParser pr = new PlanetParser();
		try {
			pr.parse(input);
			Assert.fail("Not enough arguments");
		} catch (NotPStarterException ex) {

		}
	}

	@Test
	public void shouldThrowNotEnoughAgrumentsException() {
		String input = "P 1 3 1";

		PlanetParser pr = new PlanetParser();
		try {
			pr.parse(input);
			Assert.fail("Not enough arguments");
		} catch (NotEnoughArgumentsException ex) {

		}
	}

	@Test
	public void shouldThrowTooManyAgrumentsException() {
		String input = "P 1 2 1 9 11 13";

		PlanetParser pr = new PlanetParser();
		try {
			pr.parse(input);
			Assert.fail("Too many arguments");
		} catch (TooManyArgumentsException ex) {

		}
	}

	@Test
	public void shouldNotThrowCountExceptionIfFiveArguments() {
		String input = "P 1 3 2 7 9";

		PlanetParser pr = new PlanetParser();
		try {
			pr.parse(input);
		} catch (TooManyArgumentsException ex) {
			Assert.fail("Too many arguments thrown");
		} catch (NotEnoughArgumentsException ex) {
			Assert.fail("Not enough arguments thrown");
		}
	}

	@Test
	public void shouldThrowNumberFormatException1() {
		shouldThrowNmberFormatExceptionForInput("P 1a 2 3 6 4");
	}

	@Test
	public void shouldThrowNumberFormatException2() {
		shouldThrowNmberFormatExceptionForInput("P 1 2a 3 6 4");
	}

	@Test
	public void shouldThrowNumberFormatException3() {
		shouldThrowNmberFormatExceptionForInput("P 1 2 3a 6 4");
	}

	@Test
	public void shouldThrowNumberFormatException4() {
		shouldThrowNmberFormatExceptionForInput("P 1 2 3 6a 4");
	}

	@Test
	public void shouldThrowNumberFormatException5() {
		shouldThrowNmberFormatExceptionForInput("P 1 2 3 6 4a");
	}

	@Test
	public void shouldThrowNumberFormatException6() {
		shouldThrowNmberFormatExceptionForInput("P 1 2 3.5 6 4");
	}

	@Test
	public void shouldThrowNumberFormatException7() {
		shouldThrowNmberFormatExceptionForInput("P 1 2 3 6.3 4");
	}

	@Test
	public void shouldThrowNumberFormatException8() {
		shouldThrowNmberFormatExceptionForInput("P 1 2 3 6 4.3");
	}

	private void shouldThrowNmberFormatExceptionForInput(String input) {
		PlanetParser pr = new PlanetParser();

		try {
			pr.parse(input);
			Assert.fail("number format exception not thrown");
		} catch (NumberFormatException ex) {
		}
	}

	@Test
	public void shouldThrowYouShouldNotUseHashException() {
		String input = "P 1 3 # 7 9";

		PlanetParser pr = new PlanetParser();
		try {
			pr.parse(input);
			Assert.fail("Shall you not use hash, thou you should be doomed");
		} catch (YouShouldNotUseHashException ex) {

		}
	}

	@Test
	public void shouldNotThrowOwnerIDException1() {
		shouldNotThrowInvalidOwnerIDException("P 1 2 0 6 4");
	}

	@Test
	public void shouldNotThrowOwnerIDException2() {
		shouldNotThrowInvalidOwnerIDException("P 1 2 1 6 4");
	}

	@Test
	public void shouldNotThrowOwnerIDException3() {
		shouldNotThrowInvalidOwnerIDException("P 1 2 2 6 4");
	}

	@Test
	public void shouldThrowOwnerIDException4() {
		shouldThrowInvalidOwnerIDException("P 1 2 34 6 4");
	}

	private void shouldThrowInvalidOwnerIDException(String input) {

		PlanetParser pr = new PlanetParser();
		try {
			pr.parse(input);
			Assert.fail("owner id incorrect");
		} catch (InvalidOwnerIdException ex) {

		}
	}

	private void shouldNotThrowInvalidOwnerIDException(String input) {

		PlanetParser pr = new PlanetParser();
		try {
			pr.parse(input);

		} catch (InvalidOwnerIdException ex) {
			Assert.fail("owner id correct");
		}
	}
	
	@Test
	public void shouldThrowIncorrectNumberOfShipsExceptions()  {
		String input = "  P 1 2 1 -1 5";
		PlanetParser pr = new PlanetParser();
		
		try {
			pr.parse(input);
			Assert.fail("Incorrect number of ships shuold be thrown");
		} catch (IncorrectNumberOfShipsException ex ) {
			
		}
	}
	
	@Test
	public void shouldThrowIncorrectGrowthExceptions()  {
		String input = "P 1 2 1 1 -5";
		PlanetParser pr = new PlanetParser();
		
		try {
			pr.parse(input);
			Assert.fail("Incorrect growth shuold be thrown");
		} catch (IncorrectGrowthException ex ) {
			
		}
	}
	
	
}
