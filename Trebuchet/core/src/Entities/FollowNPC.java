package Entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Dying;
import world.gamemap;

public class FollowNPC extends Entity {

    private static final int SPEED = 40;

    public static Texture image;

    public FollowNPC(float x, float y, gamemap map){
        super(x, y, EntityType.FollowNPC, map);
        image = new Texture("FollowNPCLeft.png");
    }

    @Override
    public void update(float deltaTime, float gravity){
        super.update(deltaTime, gravity);

        if (Player.getx > (pos.x-100) && Player.getx < (pos.x)) {
            image = new Texture("FollowNPCLeft.png");
            moveX(-SPEED * deltaTime);
        }
        if (Player.getx > (pos.x) && Player.getx < (pos.x+64)) {
            image = new Texture("FollowNPCRight.png");
            moveX(SPEED * deltaTime);
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        if(gamemap.burn == true){}else {
            batch.draw(image, pos.x, pos.y, getWidth(), getHeight());
        }
        for (float i = 0; i < Player.getPlayerWidth; i++){
            if (Player.getx + i > pos.x && Player.getx + i < pos.x + getWidth() && Player.gety + i > pos.y && Player.gety + i < pos.y + getHeight()){
                Dying.got_hit();
            }
        }
    }
}