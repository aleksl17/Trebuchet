package world;

import Entities.Entity;
import Entities.Player;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


import java.util.ArrayList;

public abstract class gamemap {

    protected ArrayList<Entity> entities;

    public gamemap() {
        entities = new ArrayList<Entity>();
        entities.add(new Player(40, 500, this));
    }

    public void render(OrthographicCamera camera, SpriteBatch batch){
        for (Entity entity : entities){
            entity.render(batch);
        }
    }
    public void update(float delta){
        for(Entity entity : entities){
            entity.update(delta, -9.8f);
        }
    }
    public void dispose(){

    }



    public abstract TileType getTileTypeByCoordinate(int layer, int col, int row);

    public boolean doesRectCollideWithMap(float x, float y, int width, int height){
        if (x < 0 || y < 0 || x + width > getPixelWith() || y + height > getPixelHeight())
            return true;

        for (int row = (int) (y / TileType.TILE_SIZE); row < Math.ceil((y + height) / TileType.TILE_SIZE); row++){
            for (int col = (int) (x / TileType.TILE_SIZE); col < Math.ceil((x + width) / TileType.TILE_SIZE); col++){
                for (int layer = 0; layer < getLayers(); layer++){
                    TileType type = getTileTypeByCoordinate(layer, col, row);
                    if (type != null && type.isCollidable())
                        return true;
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
