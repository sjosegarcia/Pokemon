package poke.mon.life;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import poke.mon.handlers.LifeHandler;

public class MapObjects {
	
	private List<LifeHandler> mapLife;
	
	public MapObjects() {
		mapLife = new ArrayList<LifeHandler>();
	}

	public Collection<LifeHandler> getMapObjects() {
		return Collections.unmodifiableList(mapLife);
	}
	
	public void addMapObject(LifeHandler life) {
		mapLife.add(life);
	}
	
	public void removeLife(LifeHandler life) {
		mapLife.remove(life);
	}
	
	public void removeActorId(int id) {
		mapLife.remove(id);
	}
	
	public LifeHandler getLife(int index) {
		return mapLife.get(index);
	}
	
	public void removeAllMapObjects() {
		mapLife.clear();
	}
	
}