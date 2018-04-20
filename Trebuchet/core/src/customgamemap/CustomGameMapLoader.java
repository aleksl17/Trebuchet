package customgamemap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;
import world.TileType;

import java.util.Random;

public class CustomGameMapLoader {

    private static Json json = new Json();
    private static final int SIZE = 100;

    public static CustomGameMap loadMap(String id, String name) {
        Gdx.files.local("maps/").file().mkdirs();
        FileHandle file = Gdx.files.local("maps/" + id + ".map");
        if (file.exists()){
            CustomGameMap data = json.fromJson(CustomGameMap.class, file.readString());
            return data;
        } else {
            CustomGameMap data = generateRandomMap(id, name);
            saveMap(data.id, data.name, data.map);
            return data;
        }
    }

    public static void saveMap(String id, String name, int[][][]map){
        CustomGameMap data = new CustomGameMap();
        data.id = id;
        data.name = name;
        data.map = map;

        Gdx.files.local("maps/").file().mkdirs();
        FileHandle file = Gdx.files.local("maps/" + id + ".map");
        file.writeString(json.prettyPrint(data),false);
    }

    public static CustomGameMap generateRandomMap (String id, String name){
        CustomGameMap mapData = new CustomGameMap();
        mapData.id = id;
        mapData.name = name;
        mapData.map = new int[2][SIZE][SIZE];

        Random random = new Random();

        for (int row = 0;row <SIZE;row++){
            for (int col = 0;col <SIZE;col++){
                mapData.map[0][row][col] = TileType.SKY.getId();

                if(row > SIZE - 3 -1){
                    mapData.map[1][row][col] = TileType.LAVA.getId();
                }else if(row > SIZE - 20){
                    mapData.map[1][row][col] = TileType.STONE.getId();
                }else if(row > SIZE - 25){
                    mapData.map[1][row][col] = TileType.DIRT.getId();
                }else if(row > SIZE - 26){
                    mapData.map[1][row][col] = TileType.GRASS.getId();
                }else{
                    if (random.nextInt(50) == 0)//1av 50 for cloud
                        mapData.map[1][row][col] = TileType.CLOUD.getId();
                }
            }

        }
        return mapData;
    }

}
