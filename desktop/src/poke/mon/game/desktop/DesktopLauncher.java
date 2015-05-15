package poke.mon.game.desktop;

import poke.mon.constants.Constants;
import poke.mon.game.Pokemon;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.fullscreen = Constants.fullscreen;
		config.resizable = Constants.resizable;
		config.width = Constants.width;
		config.height = Constants.height;
		new LwjglApplication(new Pokemon(), config);
	}
}