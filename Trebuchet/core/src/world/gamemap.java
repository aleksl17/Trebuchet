package world;

import Entities.Entity;
import Entities.Player;
import Entities.NPC;
import Entities.FollowNPC;
import Entities.ShootNPC;
import Entities.Cannonball;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Dying;
import com.mygdx.game.Setting;
import java.util.ArrayList;
import static Entities.Player.map1;
import static com.mygdx.game.Dying.lives;

public abstract class gamemap {
    Dying d = new Dying();
    long tid = 1000;
    public static boolean burn = false;
    protected ArrayList<Entity> entities;

    public gamemap() {
        entities = new ArrayList<Entity>();
        entities.add(new Player(1, 340, this));
        if (map1 == 0) {
            lives = 4 - Setting.vanskelighetsgrad;
            entities.add(new NPC(248, 370, this));
            if(Setting.vanskelighetsgrad > 1) {
                entities.add(new NPC(1050, 370, this));
                if (Setting.vanskelighetsgrad > 2)
                    entities.add(new NPC(1334, 500, this));
            }
        }
        if (map1 == 1) {
            entities.add(new FollowNPC(760, 417, this));
            if (Setting.vanskelighetsgrad > 1) {
                entities.add(new NPC(312, 340, this));

                if (Setting.vanskelighetsgrad > 2) {
                    entities.add(new NPC(810, 195, this));
                    entities.add(new NPC(1325, 340, this));
                }
            }
        }
        if (map1 == 3) {
            entities.add(new NPC(248, 370, this));
            entities.add(new ShootNPC(560, 530, this));
            if (Setting.vanskelighetsgrad > 1) {
                entities.add(new NPC(870, 370, this));
                if (Setting.vanskelighetsgrad >2) {
                    entities.add(new NPC(1200, 370, this));
                }
            }
        }
    }

    public void render(OrthographicCamera camera, SpriteBatch batch) {
        if (tid > 100 && map1 > 3) {
            entities.add(new Cannonball(572, 536, this));
            tid = 0;
        }
        for (Entity entity : entities) {
            entity.render(batch);
        }
        tid++;
    }

    public void update(float delta) {
        for(Entity entity : entities) {
            entity.update(delta, -9.8f);
        }
    }

    public void dispose() {}

    public abstract TileType getTileTypeByCoordinate(int layer, int col, int row);

    public boolean doesRectCollideWithMap(float x, float y, int width, int height) {
        if (x < 0 || y < 0 || x + width > getPixelWith() || y + height > getPixelHeight())
            return true;

        for (int row = (int) (y / TileType.TILE_SIZE); row < Math.ceil((y + height) / TileType.TILE_SIZE); row++) {
            for (int col = (int) (x / TileType.TILE_SIZE); col < Math.ceil((x + width) / TileType.TILE_SIZE); col++) {
                for (int layer = 0; layer < getLayers(); layer++) {
                    TileType type = getTileTypeByCoordinate(layer, col, row);
                    if (type != null && type.isCollidable()) {
                        return true;
                    }
                    else if (type != null && type.getId() == 4){
                        if (Player.getx + TileType.TILE_SIZE > x && Player.getx + TileType.TILE_SIZE < x + getWidth() && Player.gety + TileType.TILE_SIZE > y && Player.gety + TileType.TILE_SIZE < y + getHeight()){
                            Dying.setTuch_lava(true);
                        }
                        else{
                            burn = true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public abstract int getWidth();
    public abstract int getHeight();
    public abstract int getLayers();

    public int getPixelWith(){
        return this.getWidth() * TileType.TILE_SIZE;
    }

    public int getPixelHeight(){
        return this.getHeight() * TileType.TILE_SIZE;
    }
}
