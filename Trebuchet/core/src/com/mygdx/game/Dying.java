package com.mygdx.game;

import static Entities.Player.misteliv;

public class Dying {
    private static boolean isDead;
    private static boolean tuch_lava;

    private static int lives = 3;

    public static boolean mortal;
    private static long end;

    public Dying(){
        isDead = false;
        tuch_lava = false;
        mortal = true;

    }

    public static void setDead(boolean dead) {
        isDead = dead;

        //System.out.print("rørte lava\n");
    }

    public static void setTuch_lava(boolean tuch_lava) {
        Dying.tuch_lava = tuch_lava;
    }

    public static boolean isIDead() {
        return isDead;
    }

    public static boolean isTuch_lava() {
        return tuch_lava;
    }

    public static int getLives() {
        return lives;
    }

    public static void setLives(int lives) {
        Dying.lives = lives;
    }


    public static void got_hit(){
        if (mortal){
            misteliv();
            setLives(getLives() - 1);
            if (getLives() == 0)
                setDead(true);
            mortal = false;
            end = System.currentTimeMillis() + 2 * 1000;
        }
        else if (!mortal){
            if (System.currentTimeMillis() > end){
                mortal = true;
            }
        }
    }
}
