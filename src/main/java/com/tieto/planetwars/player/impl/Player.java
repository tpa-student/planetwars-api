package com.tieto.planetwars.player.impl;

import java.util.List;

import com.tieto.planetwars.player.Command;
import com.tieto.planetwars.world.WarsMap;


public class Player implements com.tieto.planetwars.player.Player {

	private int id;
	
	public Player() {
	}
	
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Command> doTurn(WarsMap gameMap) {
		// TODO Auto-generated method stub
		return null;
	}

}
