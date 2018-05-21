package com.mygdx.game;

import javax.swing.*;

public class Dead {
    private static boolean isDead;

    public Dead(){
          isDead = false;

    }

    public static void setDead(boolean dead) {
        isDead = dead;
        //System.out.print("rørte lava\n");
    }


    public boolean isIDead() {
        return isDead;
    }
}
