package Entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Dead;
import world.gamemap;

public class ShootNPC extends Entity {

    //private static final int SPEED = 1;
    //public int facing = 0; //0 = left, 1 = right

    public static Texture image;

    public ShootNPC(float x, float y, gamemap map){
        super(x, y, EntityType.ShootNPC, map);
        image = new Texture("CannonLeft.png");
        //facing = 0;
    }

    @Override
    public void update(float deltaTime, float gravity){
        super.update(deltaTime, gravity);

        /*
        if (Player.getx > (pos.x-128) && Player.getx < (pos.x)) {
            image = new Texture("CannonLeft.png");
            //facing = 0;
            moveX(-SPEED * deltaTime);
        }
        if (Player.getx > (pos.x) && Player.getx < (pos.x+128)) {
            image = new Texture("CannonRight.png");
            facing = 1;
            moveX(SPEED * deltaTime);
        }
        */
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(image, pos.x, pos.y, getWidth(), getHeight());
        for (float i = 0; i < Player.getPlayerWidth; i++){
            if (Player.getx + i > pos.x && Player.getx + i < pos.x + getWidth() && Player.gety + i > pos.y && Player.gety + i < pos.y + getHeight()){
                Dead.setDead(true);
            }
        }
    }
}