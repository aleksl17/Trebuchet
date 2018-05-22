package Entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Dying;
import world.gamemap;

public class ShootNPC extends Entity {

    public static Texture image;

    public ShootNPC(float x, float y, gamemap map){
        super(x, y, EntityType.ShootNPC, map);
        image = new Texture("entities/cannonLeft.png");
    }

    @Override
    public void update(float deltaTime, float gravity){
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(image, pos.x, pos.y, getWidth(), getHeight());
        for (float i = 0; i < Player.getPlayerWidth; i++){
            if (Player.getx + i > pos.x && Player.getx + i < pos.x + getWidth() && Player.gety + i > pos.y && Player.gety + i < pos.y + getHeight()){
                Dying.got_hit();
            }
        }
    }
}