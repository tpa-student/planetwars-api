package com.tieto.planetwars.map.parser;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import org.apache.commons.lang.WordUtils;

import com.tieto.planetwars.map.parser.DescribePlanetParser.MyPlayer;
import com.tieto.planetwars.player.Command;
import com.tieto.planetwars.player.Player;
import com.tieto.planetwars.world.Coordinates;
import com.tieto.planetwars.world.Planet;
import com.tieto.planetwars.world.WarsMap;

public class PlanetParser {

	static int firstUnusedPlanetId = 0;

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
			if (player instanceof MyPlayer)
				return ((MyPlayer) player).getId() == id;
			else
				return false;

		}
	};

	public Planet parse(String line) {
		if(line.equals("") || line.startsWith("#"))
			throw new SyntaxException("Comment!");
		
		Scanner scanner = new Scanner(line);
		if (scanner.hasNext() && scanner.next().equals("P")) {
			try {
				float x = scanner.nextFloat();
				if (x < 0)
					throw new SyntaxException();

				float y = scanner.nextFloat();
				if (y < 0)
					throw new SyntaxException();

				int owner = scanner.nextInt();
				if (owner < 0 || owner > 2)
					throw new SyntaxException();

				int ships = scanner.nextInt();
				if (ships < 0)
					throw new SyntaxException();

				int growthRate = scanner.nextInt();
				if (growthRate < 0)
					throw new SyntaxException();

				return new Planet(firstUnusedPlanetId++, growthRate,
						new MyPlayer(owner), ships, new Coordinates(x, y));

			} catch (NoSuchElementException ex) {
				throw new SyntaxException();
			}
		} else
			throw new SyntaxException("Bad line. Line does not start with P.");
	}

}
