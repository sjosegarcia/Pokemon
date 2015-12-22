package poke.mon.game;

import poke.mon.constants.Constants;
import poke.mon.handlers.MapHandler;
import poke.mon.loader.PokemonAbilityLoader;
import poke.mon.loader.PokemonLoader;
import poke.mon.loader.PokemonTypeLoader;
import poke.mon.pokemon.Pokemon;
import poke.mon.trainer.PokemonTrainer;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Game extends ApplicationAdapter {
	
	private MapHandler map;
	private SpriteBatch batch;
	private PokemonTrainer trainer;
	
	@Override
	public void create() {
		new PokemonTypeLoader();
		new PokemonAbilityLoader();
		new PokemonLoader();
		batch = new SpriteBatch();
		map = new MapHandler("test2.tmx");
		trainer = new PokemonTrainer("red.png");
		map.addMapObject(trainer);
		Pokemon p = new Pokemon(4, 1);
		System.out.println(p.toString());
	}

	@Override
	public void render() {
		Gdx.graphics.setTitle(Constants.gameName + " FPS: " + Gdx.graphics.getFramesPerSecond());
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		Gdx.gl.glEnable(GL20.GL_BLEND);
		map.update();
		batch.begin();
		trainer.draw(batch, map);
		batch.end();
	}
	
	@Override
	public void dispose() {
		map.dispose();
		trainer.dispose();
	}
		
	@Override
	public void resize(int width, int height) {
		map.getViewport().update(width, height);
	}
}