package com.solf1re.platformer.levels;

/**
 * Created by James on 05/07/2014.
 */
public class Tile {

    private int locationX;
    private int locationY;
    boolean solid;
    private int type;

    /**
     * Deafualt : location only constructor
     * @param x x coordinates
     * @param y y coordinates
     */
    public Tile(int x, int y) {
        locationX = x;
        locationY = y;
        solid = false;
        type = 0;  //doesn't do anything yet
    }

    /**
     *
     * @param x
     * @param y
     * @param solid
     */
    public Tile(int x, int y, boolean solid) {
        locationX = x;
        locationY = y;
        this.solid = solid;
        type = 0;  //doesn't do anything yet
    }

    public int getType() {
        return type;
    }
}
