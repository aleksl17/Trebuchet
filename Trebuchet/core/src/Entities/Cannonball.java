package Entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Dead;
import world.gamemap;

public class Cannonball extends Entity {

    private static final int SPEED = 180;

    public static Texture image;

    public Cannonball(float x, float y, gamemap map){
        super(x, y, EntityType.Cannonball, map);
        image = new Texture("Cannonball.png");
    }

    @Override
    public void update(float deltaTime, float gravity){
        super.update(deltaTime, gravity);

        this.velocityY = 0;
        moveX(-SPEED * deltaTime);

        /*
        if (ShootNPC.facing == 0) {
            moveX(-SPEED * deltaTime);
        }
        if (ShootNPC.facing == 1) {
            moveX(SPEED * deltaTime);
        }
        */
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(image, pos.x, pos.y, getWidth(), getHeight());
        for (float i = 0;i<31;i++){
            if (Player.getx + i > pos.x && Player.getx + i < pos.x+4 && Player.gety + i > pos.y && Player.gety + i < pos.y+4){
                Dead.setDead(true);
            }
        }
    }
}