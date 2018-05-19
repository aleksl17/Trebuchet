package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import java.io.*;

import static Entities.Player.map1;

public class GameEnd implements Screen {
    TrebuchetGame game;
    Texture Victory;
    Texture Mainmenu;
    Texture MainmenuActive;
    public FileReader fileReader;
    public BufferedReader bufferedReader;
    public FileWriter fileWriter;
    public BufferedWriter bufferedWriter;
    private BitmapFont font;
    private long EndTime;
    private long score = 100;
    private long Highscore;

    public GameEnd(TrebuchetGame game){
        this.game = game;
        Victory = new Texture("Victory.png");
        Mainmenu = new Texture("Mainmenu.png");
        MainmenuActive = new Texture("MainmenuActive.png");
        try {
            fileReader = new FileReader("Highscore.txt");
            bufferedReader = new BufferedReader(fileReader);
            try {
                Highscore = Long.parseLong(bufferedReader.readLine());
            }catch (NumberFormatException ex){
                System.out.println("No Highscore");
                Highscore = 0;
            }
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file");
            Highscore = 0;
        }
        catch(IOException ex) {
            System.out.println("Error reading file '");
            Highscore = 0;
        }
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.1f, 0.4f, 0.1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        game.batch.draw(Victory,500,500,600,200);

        font = new BitmapFont();
        font.setColor(Color.BLACK);
        font.getData().setScale(2);
        if (map1 == 5){
            EndTime = ((System.currentTimeMillis() - Trebuchet.startTime) / 1000);
            score -= EndTime;
            if(Highscore < score){
                Highscore = score;
                try {
                    fileWriter = new FileWriter("Highscore.txt");
                    bufferedWriter = new BufferedWriter(fileWriter);

                    bufferedWriter.write( "" + Highscore);
                    bufferedWriter.close();
                }
                catch(IOException ex) {
                    System.out.println("Error writing to file");
                }
            }
            map1 = 6;
        }
        font.draw(game.batch,"Time: " + EndTime,750,400);
        font.draw(game.batch, "Highscore: " + Highscore,750,350);
        font.draw(game.batch, "Score: " + score,750,300);
        game.dispose();
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
