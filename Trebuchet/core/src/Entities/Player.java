package Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import world.gamemap;

public class Player extends Entity {

    private static final int SPEED = 90; //normal = 80
    private static final int JUMP_VELOCITY = 5; //normal = 5
    int roll = 0;
    public static int map1;

    public static Texture image;

    public Player (float x, float y, gamemap map) {
        super(x, y, EntityType.PLAYER, map);
        image = new Texture("playerRollRight.png");
    }

    @Override
    public void update(float deltaTime, float gravity) {
        if (Gdx.input.isKeyPressed(Keys.UP) && grounded) {
            this.velocityY += JUMP_VELOCITY * getWeight();
        }
        else if (Gdx.input.isKeyPressed(Keys.UP) && !grounded && this.velocityY > 0) {
            this.velocityY += JUMP_VELOCITY * getWeight() * deltaTime;
        }
        super.update(deltaTime, gravity);

        if (Gdx.input.isKeyPressed(Keys.LEFT)) {
            moveX(-SPEED * deltaTime);

            if (roll > 10){
                image = new Texture("playerRollLeft.png");
            }else {
                image = new Texture("playerRollLeft1.png");
            }
            roll += 1;
            if (roll == 20){roll = 0;}
        }

        if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
            moveX(SPEED * deltaTime);

            if (roll > 10){
                image = new Texture("playerRollRight.png");
            }else {
                image = new Texture("playerRollRight1.png");
            }
            roll += 1;
            if (roll == 20){roll = 0;}
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(image, pos.x, pos.y, getWidth(), getHeight());
        if(pos.x > 1600 - 40){
            if (map1 == 2){
                map1 = 3;
            }else if(map1 == 4){
                map1 = 5;

            }
            else{map1 = 1;}

        }

    }



}
