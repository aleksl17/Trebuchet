package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

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
    Texture Difficulty;
    Texture Easy;
    Texture EasyActive;
    Texture Medium;
    Texture MediumActive;
    Texture Hard;
    Texture HardActive;

    private static final int x = TrebuchetGame.WIDTH / 2 - 200 / 2;
    private static final int y = TrebuchetGame.HEIGHT;
    private static final int graphicy = 350;
    private static final int graphicwidth = 300;
    private static final int buttonheight = 100;
    private static final int HighLowx = x + 400;
    private static final int HighLowwidth = 200;
    private static final int emhwidth = 300;
    private static final int emhy = 225;
    public static boolean graphicisHigh = true;
    public static int vansklighetsgrad = 1;

    public Setting(TrebuchetGame game) {
        this.game = game;
        head = new Texture("ui/head.png");
        mainplayer = new Texture("entities/playerRollRight.png");
        graphic = new Texture("ui/Graphics.png");
        High = new Texture("ui/High.png");
        HighActive = new Texture("ui/HighActive.png");
        Low = new Texture("ui/Low.png");
        LowActive = new Texture("ui/LowActive.png");
        Mainmenu = new Texture("ui/Mainmenu.png");
        MainmenuActive = new Texture("ui/MainmenuActive.png");
        Difficulty = new Texture("ui/Difficulty.png");
        Easy = new Texture("ui/Easy.png");
        EasyActive = new Texture("ui/EasyActive.png");
        Medium = new Texture("ui/Medium.png");
        MediumActive = new Texture("ui/MediumActive.png");
        Hard = new Texture("ui/Hard.png");
        HardActive = new Texture("ui/HardActive.png");

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
                mainplayer = new Texture("entities/playerRollRight.png");
                animasjon = false;
            } else {
                mainplayer = new Texture("entities/playerRollRight1.png");
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
        game.batch.draw(Difficulty, x, emhy, graphicwidth, buttonheight);
        if(Gdx.input.getX() > HighLowx && Gdx.input.getX() < HighLowx + emhwidth && Gdx.input.getY() > y - emhy - buttonheight && Gdx.input.getY() < y - emhy) {
            if (vansklighetsgrad == 1){
                game.batch.draw(EasyActive, HighLowx, emhy, emhwidth, buttonheight);
            }else if(vansklighetsgrad == 2){
                game.batch.draw(MediumActive, HighLowx, emhy, emhwidth, buttonheight);
            }else if(vansklighetsgrad == 3){
                game.batch.draw(HardActive, HighLowx, emhy, emhwidth, buttonheight);
            }
            if (Gdx.input.isTouched()){
                this.dispose();
                if(vansklighetsgrad == 1) {
                    vansklighetsgrad = 2;
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else if (vansklighetsgrad == 2){
                    vansklighetsgrad = 3;
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                else if (vansklighetsgrad == 3){
                    vansklighetsgrad = 1;
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }else {
            if(vansklighetsgrad == 1){
                game.batch.draw(Easy, HighLowx, emhy, emhwidth, buttonheight);
            }else if(vansklighetsgrad == 2){
                game.batch.draw(Medium, HighLowx, emhy, emhwidth, buttonheight);
            }else if(vansklighetsgrad == 3){
                game.batch.draw(Hard, HighLowx, emhy, emhwidth, buttonheight);
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
