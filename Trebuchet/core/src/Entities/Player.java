package Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import world.gamemap;

public class Player extends Entity {

    private static final int SPEED = 80;
    private static final int JUMP_VELOCITY = 5;

    Texture image;

    public Player (float x, float y, gamemap map) {
        super(x, y, EntityType.PLAYER, map);
        image = new Texture("player.png");
    }

    @Override
    public void update(float deltaTime, float gravity) {
        if (Gdx.input.isKeyPressed(Keys.UP) && grounded) {
            this.velocityY += JUMP_VELOCITY * getWeight();
        }
        else if (Gdx.input.isKeyPressed(Keys.UP) && !grounded && this.velocityY > 0)
            this.velocityY += JUMP_VELOCITY * getWeight() * deltaTime;

        super.update(deltaTime, gravity);

        if (Gdx.input.isKeyPressed(Keys.LEFT)) {
            moveX(-SPEED * deltaTime);
            image = new Texture("player1.png");
        }

        if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
            moveX(SPEED * deltaTime);
            image = new Texture("player.png");
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(image, pos.x, pos.y, getWidth(), getHeight());
    }

}
