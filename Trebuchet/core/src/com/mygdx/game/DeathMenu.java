package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import java.io.*;

import static Entities.Player.map1;

public class DeathMenu implements Screen {

    private static final int exitwidth = 200;
    private static final int exitheight = 100;
    private static final int playwidth = 200;
    private static final int playheight = 100;
    private static final int exity = 100;
    private static final int playy = 250;
    private static final int x = TrebuchetGame.WIDTH / 2 - exitwidth / 2;
    private static final int y = TrebuchetGame.HEIGHT;

    TrebuchetGame game;
    Texture you_died;
    Texture Mainmenu;
    Texture MainmenuActive;
    Texture exitButtonActive;
    Texture exitButtonInactive;
    Texture playButtonActive;
    Texture playButtonInactive;


    private BitmapFont font;

    public DeathMenu(TrebuchetGame game){
        this.game = game;
        you_died = new Texture("ui/you_died.png");
        Mainmenu = new Texture("ui/mainmenu.png");
        MainmenuActive = new Texture("ui/mainmenuActive.png");
        exitButtonActive = new Texture("ui/exitButtonActive.png");
        exitButtonInactive = new Texture("ui/exitButtonInactive.png");
        playButtonActive = new Texture("ui/playButtonActive.png");
        playButtonInactive = new Texture("ui/playButtonInactive.png");
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.4f, 0.1f, 0.1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        game.batch.draw(you_died,500,500,600,200);

        font = new BitmapFont();
        font.setColor(Color.BLACK);
        font.getData().setScale(2);

        game.dispose();

        if(Gdx.input.getX() > x && Gdx.input.getX() < x + playwidth && Gdx.input.getY() > y - playy - playheight && Gdx.input.getY() < y - playy) {
            game.batch.draw(playButtonActive, x, playy, playwidth, playheight);
            if (Gdx.input.isTouched()){
                this.dispose();
                game.setScreen(new Trebuchet(game));
            }
        }else {
            game.batch.draw(playButtonInactive, x, playy, playwidth, playheight);
        }

        if(Gdx.input.getX() > 1250 && Gdx.input.getX() < 1250 + 300 && Gdx.input.getY() > 800 - 100 - 100 && Gdx.input.getY() < 800 - 100) {
            game.batch.draw(MainmenuActive,1250,100,300,100);
            if (Gdx.input.isTouched()){
                map1 = 7;
            }
        }else {
            game.batch.draw(Mainmenu,1250,100,300,100);
        }

        game.batch.end();

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

    }
}
