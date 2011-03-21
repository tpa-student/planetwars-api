package com.tieto.planetwars.map.parser;

import com.tieto.planetwars.player.Player;
import com.tieto.planetwars.world.Coordinates;
import com.tieto.planetwars.world.Planet;

public class PlanetParser {

	// TODO
	//  w konstruktorze przyjmowac
	//   player1
	//   player 2
	//   planetid
	
	public Planet parse(String input) {
		input = input.trim();
		validateHashNotPresent(input);
		validatePromptLetter(input);

		input = dropPromptLetter(input);
		String[] parts = extractParts(input);

		float coordX = Float.parseFloat(parts[0]);
		float coordY = Float.parseFloat(parts[1]);
		int ownerId = Integer.parseInt(parts[2]);
		int ships = Integer.parseInt(parts[3]);
		int growth = Integer.parseInt(parts[4]);

		validateOwnerId(ownerId);
		validateShipsNumber(ships);
		validateGrowthSpeed(growth);

		int planetId = 1;
		Player owner = getOwnerById(ownerId);
		Coordinates planetCoords = new Coordinates(coordX, coordY);
		Planet planet = new Planet(planetId, growth, owner, ships, planetCoords);
		return planet;
	}

	private String dropPromptLetter(String input) {
		return input.substring(1).trim();
	}

	private String[] extractParts(String input) {
		String[] parts = input.split(" +");
		validateNumberOfParts(parts);
		return parts;
	}

	private void validateNumberOfParts(String[] parts) {
		if (parts.length < 5) {
			throw new NotEnoughArgumentsException();
		}

		if (parts.length > 5) {
			throw new TooManyArgumentsException();
		}
	}

	private void validateHashNotPresent(String input) {
		if (input.contains("#")) {
			throw new YouShouldNotUseHashException();
		}
	}

	private void validatePromptLetter(String input) {
		if (!input.startsWith("P")) {
			throw new NotPStarterException();
		}
	}

	private void validateOwnerId(int ownerId) {
		if (!(ownerId >= 0 && ownerId < 3)) {
			throw new InvalidOwnerIdException();
		}
	}

	private void validateGrowthSpeed(int growth) {
		if (growth < 0) {
			throw new IncorrectGrowthException();
		}
	}

	private void validateShipsNumber(int ships) {
		if (ships < 0) {
			throw new IncorrectNumberOfShipsException();
		}
	}

	private Player getOwnerById(int ownerId) {
		// TODO Auto-generated method stub
		return null;
	}
}
