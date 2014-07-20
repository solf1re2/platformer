package com.solf1re.platformer.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.solf1re.platformer.Assets;
import com.solf1re.platformer.PlatformGame;
import com.solf1re.platformer.levels.TileMap;
import com.solf1re.platformer.manager.LevelManager;

import java.util.logging.Level;

/**
 * Created by James on 29/06/2014.
 */
public class LevelScreen extends GameScreen{

    private BitmapFont font = new BitmapFont();
    private TiledMap levelMap;
    private LevelManager levelManager;

    int level = 1;

    private OrthogonalTiledMapRenderer renderer;

    public LevelScreen(PlatformGame game) {
        super(game);
        levelManager = new LevelManager();
    }

    public LevelScreen(PlatformGame game, int level) {
        super(game);
        levelManager = new LevelManager();
        setLevel(level);  //  loads the specified levelMap in the LevelManager
        getLevel();  //  returns the set levelMap
    }





    @Override
    public void render(float delta) {
        super.render(delta);
        renderSpriteBatches();

        renderer.setView(camera);
        renderer.render();
    }

    // TODO make menuScreen spriteBatch here, using Assets
    private void renderSpriteBatches() {
        batch.begin();
        batch.draw(Assets.textureLevelBackground, 0, 0);
        drawMap();
//        batch.draw(Assets.spriteBack, 0, 0);
        font.draw(batch, "fps: " + Gdx.graphics.getFramesPerSecond(), 10, 20);
        batch.end();
    }

    private void drawMap() {
        for (int i = 0; i < xResolution; i+=tileSize) {
            for (int j = 0; j < yResolution; j+=tileSize) {
//                if (levelMap.getTile(i,j).getType() == 0) {
                    batch.draw(Assets.spriteGrass, i, j);
//                }
            }
        }
    }

    public void setLevel(int level) {
        LevelManager.loadMap(level);
    }

    private void getLevel() {
        levelMap = LevelManager.getLevelMap();
    }

    @Override
    public void show() {
        super.show();
        levelManager = new LevelManager();
        setLevel(level);  //  loads the specified levelMap in the LevelManager
        getLevel();  //  returns the set levelMap
        renderer = new OrthogonalTiledMapRenderer(levelMap);

    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        camera.update();
    }

    @Override
    public void hide() {
        super.hide();
    }

    @Override
    public void pause() {
        super.pause();
    }

    @Override
    public void resume() {
        super.resume();
    }

}
