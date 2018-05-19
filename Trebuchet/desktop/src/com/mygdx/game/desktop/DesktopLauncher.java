package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.TrebuchetGame;


public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.vSyncEnabled = false;
		config.foregroundFPS = 144; //pcmasterrace
		config.width = TrebuchetGame.WIDTH;
		config.height = TrebuchetGame.HEIGHT;
		config.resizable = true;
		new LwjglApplication(new TrebuchetGame(), config);

	}
}
