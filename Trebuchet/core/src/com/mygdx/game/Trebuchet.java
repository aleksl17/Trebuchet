package com.mygdx.game;

import Entities.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import world.TiledGameMap;
import world.gamemap;


public class Trebuchet implements Screen {
    OrthographicCamera cam;
    SpriteBatch batch;
    TrebuchetGame game;
    gamemap gameMap;


    public Trebuchet(TrebuchetGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();


        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();

        cam = new OrthographicCamera();
        cam.setToOrtho(false, w, h);
        gameMap = new TiledGameMap();


        cam.update();


    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        cam.update();
        gameMap.update(Gdx.graphics.getDeltaTime());
        gameMap.render(cam, batch);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        batch.dispose();
        gameMap.dispose();
    }
}
