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
    private static final int playy = 250;
    private static final int x = TrebuchetGame.WIDTH / 2 - exitwidth / 2;
    private static final int y = TrebuchetGame.HEIGHT;

    TrebuchetGame game;

    Texture playButtonActive;
    Texture playButtonInactive;
    Texture exitButtonActive;
    Texture exitButtonInactive;

    public mainMenu (TrebuchetGame game){
        this.game = game;
        playButtonActive = new Texture("playButtonActive.png");
        playButtonInactive = new Texture("playButtonInactive.png");
        exitButtonActive = new Texture("exitButtonActive.png");
        exitButtonInactive = new Texture("exitButtonInactive.png");

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.3f, 0.2f, 0.1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();

        if(Gdx.input.getX() > x && Gdx.input.getX() < x + playwidth && Gdx.input.getY() > y - playy - playheight && Gdx.input.getY() < y - playy) {
            game.batch.draw(playButtonActive, x, playy, playwidth, playheight);
            if (Gdx.input.isTouched()){
                this.dispose();
                game.setScreen(new Trebuchet(game));
            }
        }else {
            game.batch.draw(playButtonInactive, x, playy, playwidth, playheight);
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
