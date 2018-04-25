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
    float deltaX, deltaY;

    @Override
    public void create() {
        batch = new SpriteBatch();

        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();

        cam = new OrthographicCamera();
        cam.setToOrtho(false, w, h);
        cam.update();

        gameMap = new CustomGameMapData();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        cam.update();
        gameMap.update(Gdx.graphics.getDeltaTime());
        gameMap.render(cam, batch);
    }

    @Override
    public void dispose() {
        batch.dispose();
        gameMap.dispose();
    }
}
