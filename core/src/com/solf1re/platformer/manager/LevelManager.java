package com.solf1re.platformer.manager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.solf1re.platformer.levels.TileMap;

import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;

import java.util.HashMap;

/**
 * Created by James on 20/07/2014.
 */
public class LevelManager {

    public static int currentLevel;
    private static TiledMap map = null;
    static TmxMapLoader loader = new TmxMapLoader();


    public static HashMap<Integer, String> levelMaps = new HashMap<Integer, String>();

    public static void loadMap(int level) {
        map = loader.load(levelMaps.get(level));
    }

    public static TiledMap getLevelMap() {
        return map;
    }

//    public static HashMap<Integer, FileHandle> levelMaps = new HashMap<Integer, FileHandle>();

    public static void initLevelManager() {

        levelMaps.put(1, "maps/levelone.tmx");
        levelMaps.put(2, "maps/leveltwo.tmx");
    }


}
