package Entities;

@SuppressWarnings("rawtypes")
public enum EntityType {

    PLAYER("player", Player.class, 26, 26, 40),
    NPC("NPC", NPC.class, 26, 16, 20),
    FollowNPC("FollowNPC", FollowNPC.class, 26, 19, 100),
    ShootNPC("ShootNPC", ShootNPC.class, 26, 13, 80);

    private String id;
    private Class loaderClass;
    private int width, height;
    private float weight;

    EntityType(String id, Class loaderClass, int width, int height, float weight) {
        this.id = id;
        this.loaderClass = loaderClass;
        this.width = width;
        this.height = height;
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public float getWeight() {
        return weight;
    }


}