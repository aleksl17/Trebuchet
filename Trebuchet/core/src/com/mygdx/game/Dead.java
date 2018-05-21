package com.mygdx.game;

import javax.swing.*;

public class Dead {
    private static boolean isDead;
    private static boolean tuch_lava;

    public Dead(){
          isDead = false;
          tuch_lava = false;

    }

    public static void setDead(boolean dead) {
        isDead = dead;

        //System.out.print("rørte lava\n");
    }

    public static void setTuch_lava(boolean tuch_lava) {
        Dead.tuch_lava = tuch_lava;
    }

    public boolean isIDead() {
        return isDead;
    }

    public static boolean isTuch_lava() {
        return tuch_lava;
    }
}
