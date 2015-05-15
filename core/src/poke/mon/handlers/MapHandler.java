package poke.mon.handlers;

import poke.mon.constants.Constants;
import poke.mon.life.MapObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MapHandler implements Handlers {
	
	private TiledMapRenderer renderMap;
	private TiledMap map;
	private String name;
	private MapProperties mapProps;
	private OrthographicCamera camera;
	private Rectangle bounds;
	private MapObjects mapObjects;
	private float x, y;
	private Viewport viewport;
	
	public MapHandler(String name) {
		this.name = name;
		try {
			map = new TmxMapLoader().load(Gdx.files.internal("maps/"+ this.name).toString());
		} catch(Exception e) {
			new ExceptionHandler(this.getClass().getName(), e);
		}
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.update();
		mapProps = map.getProperties();
		viewport = new StretchViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), camera);
		renderMap = new OrthogonalTiledMapRenderer(map);
		mapObjects = new MapObjects();
		bounds = new Rectangle();
	}

	public void update() {
		renderMap.setView(camera);
		renderMap.render();
		x = -camera.position.x;
		y = -camera.position.y;
		bounds.set(x+(viewport.getWorldWidth()/2), y+(viewport.getWorldHeight()/2), getHeight(), getHeight());
	}
	
	public MapProperties getMapPropertiesByName(String name) {
		try {
			return new TmxMapLoader().load(Gdx.files.internal("maps/"+ name).toString()).getProperties();
		} catch(Exception e) {
			new ExceptionHandler(this.getClass().getName(), e);
		}
		return null;
	}

	public MapProperties getMapProperties() {
		return mapProps;
	}
		
	public OrthographicCamera getCamera() {
		return camera;
	}
	
	public TiledMapRenderer getRender() {
		return renderMap;
	}
		
	public void setMapName(String name) {
		this.name = name;
	}
	
	public String getMapName() {
		return name;
	}
	
	public int getWidth() {
		return (Integer) mapProps.get("width")*Constants.pixel;
	}

	public int getHeight() {
		return (Integer) mapProps.get("height")*Constants.pixel;
	}
	
	public int getTileWidth() {
		return (Integer) mapProps.get("width");
	}

	public int getTileHeight() {
		return (Integer) mapProps.get("height");
	}
		
	public void dispose() {
		((OrthogonalTiledMapRenderer) renderMap).dispose();
	//	for (MapObjects mo : mapObjects) {
		//after I make this "life object super class", make sure to add a dispose method, so we can dispose of all the objects with this one piece of code.	
	//	}
	}

	public Rectangle getBounds() {
		return bounds;
	}

	public MapObjects getMapObjects() {
		return mapObjects;
	}

	public void addMapObject(LifeHandler life) {
		life.setMap(this);
		float checkWidth = life.getTexture().getWidth() / (Constants.pixel / 2);
		float offsetX = 0;
		if (checkWidth >= (Constants.pixel / 2)-1) { //TODO this is for now, until I can find a better way.
			offsetX-= checkWidth;
		}
		life.getPosition().set(-x + offsetX, -y);
		life.getBounds().set(x + (viewport.getWorldWidth() / 2) , y + (viewport.getWorldHeight() / 2), life.getLifeFrame().getRegionWidth(), life.getLifeFrame().getRegionHeight());
		mapObjects.addMapObject(life);
	}

	public Viewport getViewport() {
		return viewport;
	}

	public void setViewport(Viewport viewport) {
		this.viewport = viewport;
	}
}