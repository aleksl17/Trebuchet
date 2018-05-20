package Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import world.gamemap;

public class NPC extends Entity {

    private static final int SPEED = 100;
    private static final int JUMP_VELOCITY = 10;

    public static Texture image;

    public NPC(float x, float y, gamemap map){
        super(x, y, EntityType.NPC, map);
        image = new Texture("EnemyCatapultRight.png");
    }

    @Override
    public void update(float deltaTime, float gravity){
        super.update(deltaTime, gravity);


        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            image = new Texture("EnemyCatapultLeft.png");
            moveX(-SPEED * deltaTime);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            image = new Texture("EnemyCatapultRight.png");
            moveX(SPEED * deltaTime);
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(image, pos.x, pos.y, getWidth(), getHeight());
    }
}