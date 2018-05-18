package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import static Entities.Player.map1;

public class TrebuchetGame extends Game {

    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;

    public SpriteBatch batch;

    @Override
    public void create() {
        batch = new SpriteBatch();
        this.setScreen(new mainMenu(this));

    }

    @Override
    public void render() {
        if (map1 == 5){
            this.setScreen(new mainMenu(this));
        }
        super.render();
    }

}
