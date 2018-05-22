package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

import static Entities.Player.map1;
import static com.mygdx.game.mainMenu.animasjon;
import static com.mygdx.game.mainMenu.tid;

public class Setting implements Screen {
    TrebuchetGame game;
    Texture head;
    Texture mainplayer;
    Texture graphic;
    Texture High;
    Texture HighActive;
    Texture Low;
    Texture LowActive;
    Texture Mainmenu;
    Texture MainmenuActive;

    private static final int x = TrebuchetGame.WIDTH / 2 - 200 / 2;
    private static final int y = TrebuchetGame.HEIGHT;
    private static final int graphicy = 350;
    private static final int graphicwidth = 300;
    private static final int buttonheight = 100;
    private static final int HighLowx = x + 400;
    private static final int HighLowwidth = 200;
    public static boolean graphicisHigh = true;

    public Setting(TrebuchetGame game) {
        this.game = game;
        head = new Texture("head.png");
        mainplayer = new Texture("playerRollRight.png");
        graphic = new Texture("Graphics.png");
        High = new Texture("High.png");
        HighActive = new Texture("HighActive.png");
        Low = new Texture("Low.png");
        LowActive = new Texture("LowActive.png");
        Mainmenu = new Texture("Mainmenu.png");
        MainmenuActive = new Texture("MainmenuActive.png");

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
            if (animasjon) {
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
        game.batch.draw(graphic, x, graphicy, graphicwidth, buttonheight);
        if(Gdx.input.getX() > 1250 && Gdx.input.getX() < 1250 + 300 && Gdx.input.getY() > 800 - 100 - 100 && Gdx.input.getY() < 800 - 100) {
            game.batch.draw(MainmenuActive,1250,100,300,100);
            if (Gdx.input.isTouched()){
                game.setScreen(new mainMenu(game));
            }
        }else {
            game.batch.draw(Mainmenu,1250,100,300,100);
        }
        if(Gdx.input.getX() > HighLowx && Gdx.input.getX() < HighLowx + HighLowwidth && Gdx.input.getY() > y - graphicy - buttonheight && Gdx.input.getY() < y - graphicy) {
            if (graphicisHigh){
                game.batch.draw(HighActive, HighLowx, graphicy, HighLowwidth, buttonheight);
            }else {
                game.batch.draw(LowActive, HighLowx, graphicy, HighLowwidth, buttonheight);
            }
            if (Gdx.input.isTouched()){
                this.dispose();
                if(graphicisHigh) {
                    graphicisHigh = false;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    graphicisHigh = true;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }else {
            if(graphicisHigh){
                game.batch.draw(High, HighLowx, graphicy, HighLowwidth, buttonheight);
            }else{
                game.batch.draw(Low, HighLowx, graphicy, HighLowwidth, buttonheight);
            }

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
