package com.mygdx.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

public class mainMenu implements Screen {

    private static final int exitwidth = 200;
    private static final int exitheight = 100;
    private static final int playwidth = 200;
    private static final int playheight = 100;
    private static final int exity = 100;
    private static final int settingsy = 225;
    private static final int playy = 350;
    private static final int x = TrebuchetGame.WIDTH / 2 - exitwidth / 2;
    private static final int y = TrebuchetGame.HEIGHT;

    public static boolean animasjon = true;
    public static int tid = 100;

    TrebuchetGame game;

    Texture head;
    Texture playButtonActive;
    Texture playButtonInactive;
    Texture exitButtonActive;
    Texture exitButtonInactive;
    Texture mainplayer;
    Texture settings;
    Texture settingsActive;

    public mainMenu (TrebuchetGame game){
        this.game = game;
        head = new Texture("head.png");
        mainplayer = new Texture("playerRollRight.png");
        playButtonActive = new Texture("playButtonActive.png");
        playButtonInactive = new Texture("playButtonInactive.png");
        exitButtonActive = new Texture("exitButtonActive.png");
        exitButtonInactive = new Texture("exitButtonInactive.png");
        settings = new Texture("settings.png");
        settingsActive = new Texture("settingsActive.png");

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.3f, 0.2f, 0.1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();

        game.batch.draw(head,400,500,800,200);
        if (tid == 100) {
            if (animasjon == true) {
                mainplayer = new Texture("playerRollRight.png");
                animasjon = false;
            } else {
                mainplayer = new Texture("playerRollRight1.png");
                animasjon = true;
            }
            tid = 0;
        }
        tid += 1;
        game.batch.draw(mainplayer,180,200,200,200);

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

        if(Gdx.input.getX() > x && Gdx.input.getX() < x + playwidth && Gdx.input.getY() > y - settingsy - playheight && Gdx.input.getY() < y - settingsy) {
            game.batch.draw(settingsActive, x, settingsy, playwidth, playheight);
            if (Gdx.input.isTouched()){
                this.dispose();
                game.setScreen(new Setting(game));
            }
        }else {
            game.batch.draw(settings, x, settingsy, playwidth, playheight);
        }

        if(Gdx.input.getX() > x && Gdx.input.getX() < x + exitwidth && Gdx.input.getY() > y - exity - exitheight && Gdx.input.getY() < y - exity) {
            game.batch.draw(exitButtonActive, x, exity, exitwidth, exitheight);
            if (Gdx.input.isTouched()){
                Gdx.app.exit();
            }
        }else {
            game.batch.draw(exitButtonInactive, x, exity, exitwidth, exitheight);
        }



        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {

    }
}
