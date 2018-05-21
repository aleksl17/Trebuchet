package Entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Dead;
import world.gamemap;

public class NPC extends Entity {

    private static final int SPEED = 30;
    int move = 0;

    public static Texture image;

    public NPC(float x, float y, gamemap map){
        super(x, y, EntityType.NPC, map);
        image = new Texture("EnemyCatapultRight.png");
    }

    @Override
    public void update(float deltaTime, float gravity){
        super.update(deltaTime, gravity);


       if (move < 100) {
           image = new Texture("EnemyCatapultLeft.png");
           moveX(-SPEED * deltaTime);
       }
       else {
           image = new Texture("EnemyCatapultRight.png");
           moveX(SPEED * deltaTime);
       }
       move += 1;
       if (move == 200){move = 0;}

    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(image, pos.x, pos.y, getWidth(), getHeight());
        for (float i = 0;i<26;i++){
            if (Player.getx + i > pos.x && Player.getx + i < pos.x + getWidth() && Player.gety + i > pos.y && Player.gety + i < pos.y + getHeight()){
            Dead.setDead(true);
            }
        }
    }
}