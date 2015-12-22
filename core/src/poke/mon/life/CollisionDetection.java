package poke.mon.life;

import poke.mon.handlers.MapHandler;

import com.badlogic.gdx.Gdx;

public class CollisionDetection {
	
	private MapHandler map;
	private PlayerRenderer player;

	public CollisionDetection(MapHandler map) {
		this.map = map;
	}	
	
	public CollisionDetection(MapHandler map, PlayerRenderer player) {
		this.map = map;
		this.player = player;
	}
	
	public CollisionDetection(PlayerRenderer player) {
	//	this.map = player.getMap();
		this.player = player;
	}
	/*
	public boolean canMove() {
		if (player.getX()-player.getLifeFrame().getRegionWidth() <= map.getBounds().x-(Gdx.graphics.getWidth()/2) || 
				player.getY()-player.getLifeFrame().getRegionHeight() <= map.getBounds().y-(Gdx.graphics.getHeight()/2)) {
			return false;
		}
		
		if (player.getX()+player.getLifeFrame().getRegionWidth() >= map.getBounds().x+(Gdx.graphics.getWidth())) { 
			System.out.println(map.getBounds().x);
			return false;
		}
		
		if (player.getBounds().overlaps(map.getBounds())) {
			return true;
		}
		return false;
	}*/
	
}
