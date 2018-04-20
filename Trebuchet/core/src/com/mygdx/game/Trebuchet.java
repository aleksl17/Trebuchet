package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import world.CustomGameMapData;
import world.TileType;
import world.TiledGameMap;
import world.gamemap;


public class Trebuchet extends ApplicationAdapter {
	OrthographicCamera cam;
	SpriteBatch batch;


	gamemap gameMap;
	
	@Override
	public void create () {
		batch = new SpriteBatch();

		gameMap = new TiledGameMap();
		cam = new OrthographicCamera();
		cam.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		cam.update();

		gameMap = new CustomGameMapData();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		if(Gdx.input.isTouched()){
			cam.translate(-Gdx.input.getDeltaX(),Gdx.input.getDeltaY());
			cam.update();
		}


		gameMap.render(cam);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
