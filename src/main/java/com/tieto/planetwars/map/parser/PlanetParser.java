package com.tieto.planetwars.map.parser;

import java.util.List;
import java.util.StringTokenizer;

import org.hamcrest.CoreMatchers;

import com.tieto.planetwars.player.Player;
import com.tieto.planetwars.world.Coordinates;
import com.tieto.planetwars.world.Planet;

public class PlanetParser {

	private List<Player> ownerList;
	
	public PlanetParser(List<Player> _owner){
		  ownerList = _owner;
		
	}
	
	public Planet parse(String planetDefinition) throws WrongPlanetDefinitionException {
		
		String type;
		int numberOfShips;
		int growth;
		int ownerId;
		double x;
		double y;
		
		StringTokenizer strTokenizer = new StringTokenizer(planetDefinition, " ");
		
		type = strTokenizer.nextToken();
		if(type.equals("P")){
			x = Double.parseDouble(strTokenizer.nextToken());
			y = Double.parseDouble(strTokenizer.nextToken());
			ownerId = Integer.parseInt(strTokenizer.nextToken());
			numberOfShips = Integer.parseInt(strTokenizer.nextToken());
			growth = Integer.parseInt(strTokenizer.nextToken());
		}else{
			throw new WrongPlanetDefinitionException();
		}

		Planet planet = new Planet(null, growth, ownerList.get(ownerId), numberOfShips, new Coordinates(x,y));
		
		return planet;
	}


}
