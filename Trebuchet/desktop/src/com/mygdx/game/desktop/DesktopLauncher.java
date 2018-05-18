package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.TrebuchetGame;


public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.foregroundFPS = 144; //pcmasterrace
		config.width = TrebuchetGame.WIDTH;
		config.height = TrebuchetGame.HEIGHT;
		config.resizable = false;
		new LwjglApplication(new TrebuchetGame(), config);

	}
}
