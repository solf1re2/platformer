package com.solf1re.platformer.levels;

import com.solf1re.platformer.screens.GameScreen;
import com.solf1re.platformer.screens.LevelScreen;

/**
 * Created by James on 05/07/2014.
 */
public class LevelMap
{

    private LevelScreen levelScreen;

    private int currentLevel = 0;

    public static final int TILESIZE = 32;
    private int numberXTiles = 1080/TILESIZE;
    private int numberYTiles = 1920/TILESIZE;

    private int mapSizeX = GameScreen.numberXTiles;
    private int mapSizeY = GameScreen.numberYTiles;

    private  Tile[][] map;

    public LevelMap(LevelScreen screen) {
        levelScreen = screen;
        map = new Tile[mapSizeX][mapSizeY];
        initMapTiles();
    }

    public LevelMap(LevelScreen screen, int level) {
        currentLevel = level;
        levelScreen = screen;
        map = new Tile[mapSizeX][mapSizeY];
        initMapTiles();
    }

    private void initMapTiles(){
        for (int i = 0; i < numberXTiles; i++) {
            for (int j = 0; j < numberYTiles; j++) {
                new Tile(i, j);
            }
        }
    }

    public Tile getTile(int x, int y) {
        return map[x][y];
    }
}
