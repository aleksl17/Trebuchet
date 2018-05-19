package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import world.TiledGameMap;
import world.gamemap;

import static Entities.Player.map1;


public class Trebuchet implements Screen {
    OrthographicCamera cam;
    SpriteBatch batch;
    TrebuchetGame game;
    gamemap gameMap;
    private BitmapFont font;


    float w = Gdx.graphics.getWidth();
    float h = Gdx.graphics.getHeight();
    long startTime = System.currentTimeMillis();

    public Trebuchet(TrebuchetGame game) {
        this.game = game;
    }

    @Override
    public void show() {
batch = new SpriteBatch();



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

        if(map1 == 1){
            gameMap = new TiledGameMap();
            map1 = 2;
        }
        if(map1 == 3){
            gameMap = new TiledGameMap();
            map1 = 4;
        }

        cam.update();
        gameMap.update(Gdx.graphics.getDeltaTime());
        gameMap.render(cam, batch);
        batch.begin();
        font = new BitmapFont();
        font.setColor(Color.BLACK);
        font.draw(batch, "Fps: " + (float)Gdx.graphics.getFramesPerSecond(), 10, h-10);
        font.draw(batch,"Time: " + ((System.currentTimeMillis() - startTime) / 1000),100,h-10);
        batch.end();
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
