package com.tieto.planetwars.map;

import java.util.List;

import com.tieto.planetwars.player.Command;
import com.tieto.planetwars.player.Player;
import com.tieto.planetwars.world.WarsMap;

public class PlayerDummy implements Player {

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
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
