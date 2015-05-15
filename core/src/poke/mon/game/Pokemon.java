package poke.mon.game;

import poke.mon.constants.Constants;
import poke.mon.handlers.MapHandler;
import poke.mon.life.PlayerRenderer;
import poke.mon.loader.PokemonAbilityLoader;
import poke.mon.loader.PokemonLoader;
import poke.mon.loader.PokemonTypeLoader;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Pokemon extends ApplicationAdapter {
	private MapHandler map;
	private PlayerRenderer player;
	private SpriteBatch batch;
	
	@Override
	public void create() {
		batch = new SpriteBatch();
		map = new MapHandler("test2.tmx");
		player = new PlayerRenderer("red.png");
		player.setMap(map);
		map.addMapObject(player);
		PokemonTypeLoader type = new PokemonTypeLoader();
		PokemonAbilityLoader abilities = new PokemonAbilityLoader();
		PokemonLoader pl = new PokemonLoader();
	}

	@Override
	public void render() {
		float delta = Gdx.graphics.getDeltaTime();
		Gdx.graphics.setTitle(Constants.gameName + " FPS: " + Gdx.graphics.getFramesPerSecond());
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		Gdx.gl.glEnable(GL20.GL_BLEND);
		map.update();
		batch.begin();
		player.draw(batch, delta);
		batch.end();
	}
	
	@Override
	public void dispose() {
		map.dispose();
		player.dispose();
	}
		
	@Override
	public void resize(int width, int height) {
		map.getViewport().update(width, height);
	}
}