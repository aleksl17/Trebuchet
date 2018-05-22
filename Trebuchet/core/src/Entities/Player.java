package Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Dying;
import world.gamemap;

public class Player extends Entity {

    public Dying d = new Dying();
    private static final int SPEED = 90; //normal = 90
    private static final int JUMP_VELOCITY = 5; //normal = 5
    int roll = 0;
    int flame = 0;
    int timer = 0;
    private static long tid = 3000;
    public static int map1;
    public static float getx;
    public static float gety;
    public static float getPlayerWidth;
    private boolean isRight = true;
    public static Texture image;

    public Player (float x, float y, gamemap map) {
        super(x, y, EntityType.PLAYER, map);
        image = new Texture("entities/playerRollRight.png");
    }

    public static void misteliv(){
        tid = System.currentTimeMillis();
    }

    @Override
    public void update(float deltaTime, float gravity) {

        if (Dying.isTuch_lava()) {
            if (flame > 10) {
                image = new Texture("entities/onflame_1.png");
            }
            else {
                image = new Texture("entities/onfflame2.png");
            }
            flame += 1;
            timer += 1;
            if (flame == 20) {
                flame = 0;
            }
            if (timer == 100) {
                d.setDead(true);
            }
        }
        else {
            if (Gdx.input.isKeyPressed(Keys.UP) && grounded) {
                this.velocityY += JUMP_VELOCITY * getWeight();
            }
            else if (Gdx.input.isKeyPressed(Keys.UP) && !grounded && this.velocityY > 0) {
                this.velocityY += JUMP_VELOCITY * getWeight() * deltaTime;
            }
            super.update(deltaTime, gravity);
            if (Gdx.input.isKeyPressed(Keys.LEFT)) {
                moveX(-SPEED * deltaTime);
                isRight = false;
                if (roll > 10) {
                    image = new Texture("entities/playerRollLeft.png");
                }
                else {
                    image = new Texture("entities/playerRollLeft1.png");
                }
                roll += 1;
                if (roll == 20){roll = 0;}
            }
            if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
                moveX(SPEED * deltaTime);
                isRight = true;

                if (roll > 10) {
                    image = new Texture("entities/playerRollRight.png");
                }
                else {
                    image = new Texture("entities/playerRollRight1.png");
                }
                roll += 1;
                if (roll == 20){roll = 0;}
            }
            if(pos.x > 1600 - 30){
                if (map1 == 2){
                    map1 = 3;
                }
                else if(map1 == 4){
                    map1 = 5;

                }
                else{map1 = 1;}
            }
            getx = pos.x;
            gety = pos.y;
            getPlayerWidth = getWidth();
            if ((System.currentTimeMillis() - tid) < 100 || (System.currentTimeMillis() - tid) > 500 && (System.currentTimeMillis() - tid) < 600 ) {
                image = new Texture("entities/misteliv.png");
            }
            else if(isRight) {
                image = new Texture("entities/playerRollRight.png");
            }
            else if(!isRight) {
                image = new Texture("entities/playerRollLeft.png");
            }
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(image, pos.x, pos.y, getWidth(), getHeight());
    }
}
