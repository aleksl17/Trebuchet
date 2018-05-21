package Entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Dead;
import world.gamemap;

public class ShootNPC extends Entity {

    private static final int SPEED = 10;

    public static Texture image;

    public ShootNPC(float x, float y, gamemap map){
        super(x, y, EntityType.NPC, map);
        image = new Texture("CannonLeft.png");
    }

    @Override
    public void update(float deltaTime, float gravity){
        super.update(deltaTime, gravity);

    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(image, pos.x, pos.y, getWidth(), getHeight());
        for(float i = 0;i<31;i++){
            if (Player.getx + i > pos.x && Player.getx + i < pos.x+26 && Player.gety + i > pos.y && Player.gety + i < pos.y+16){
                Dead.setDead(true);
            }
        }
    }
}