package com.solf1re.platformer.levels;

import com.badlogic.gdx.files.FileHandle;
import com.solf1re.platformer.manager.LevelManager;
import com.solf1re.platformer.screens.GameScreen;
import com.solf1re.platformer.screens.LevelScreen;

/**
 * Created by James on 05/07/2014.
 */
public class TileMap
{

    private LevelScreen levelScreen;

    private int currentLevel = 0;

    public static final int TILESIZE = 32;
    private int numberXTiles = 1080/TILESIZE;
    private int numberYTiles = 1920/TILESIZE;

    private int mapSizeX = GameScreen.numberXTiles;
    private int mapSizeY = GameScreen.numberYTiles;

    private  Tile[][] map;

    public TileMap(LevelScreen screen) {
        levelScreen = screen;
        map = new Tile[mapSizeX][mapSizeY];
        initMapTiles();
    }

    public TileMap(LevelScreen screen, int level) {
        currentLevel = level;
        levelScreen = screen;
        map = new Tile[mapSizeX][mapSizeY];
        initMapTiles();
    }

    /**
     * USE THIS!!
     * @param level  assigns the level which is being made
     * @param mapFile  this is the filehandle for the file(txt?) that holds the maps shape
     */
    public TileMap(int level, FileHandle mapFile) {
        //TODO add some way to read in the mapFile
        currentLevel = level;
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
