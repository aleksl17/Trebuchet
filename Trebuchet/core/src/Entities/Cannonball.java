package Entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Dying;
import world.gamemap;

public class Cannonball extends Entity {

    private static final int SPEED = 180;

    public static Texture image;

    public Cannonball(float x, float y, gamemap map){
        super(x, y, EntityType.Cannonball, map);
        image = new Texture("entities/cannonball.png");
    }

    @Override
    public void update(float deltaTime, float gravity){
        super.update(deltaTime, gravity);

        this.velocityY -=  deltaTime;
        moveX(-SPEED * deltaTime);

    }

    @Override
    public void render(SpriteBatch batch) {
        if (pos.x > 5) {
            batch.draw(image, pos.x, pos.y, getWidth(), getHeight());
        }

        for (float i = 0; i < Player.getPlayerWidth; i++){
            if (Player.getx + i > pos.x && Player.getx + i < pos.x + getWidth() && Player.gety + i > pos.y && Player.gety + i < pos.y + getHeight()){
                Dying.got_hit();
            }
        }
    }
}