package com.solf1re.platformer.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.solf1re.platformer.Assets;
import com.solf1re.platformer.PlatformGame;
import com.solf1re.platformer.entities.Player;
import com.solf1re.platformer.manager.LevelManager;

import java.util.logging.Level;

/**
 * Created by James on 29/06/2014.
 */
public class LevelScreen extends GameScreen{

    private BitmapFont font = new BitmapFont();
    private TiledMap levelMap;
    private LevelManager levelManager;

    //Start of Hud Stuff
    public Stage stage;
    Table table;
    Skin skin;
    public Label fps;
    //End of Hud Stuff
    private Hud hud;

    int level = 1;

    private OrthogonalTiledMapRenderer renderer;

    public LevelScreen(PlatformGame game) {
        super(game);
        levelManager = new LevelManager();
        hudSetup(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
//        hud = new Hud(this, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
//        uiViewport = hud.getViewport();
    }

//    public LevelScreen(PlatformGame game, int level) {
//        super(game);
//        levelManager = new LevelManager();
//        setLevel(level);  //  loads the specified levelMap in the LevelManager
//        getLevel();  //  returns the set levelMap
//    }





    @Override
    public void render(float delta) {
        super.render(delta);
        camera.update();
        fps.setText(getFPSString());
//        renderSpriteBatches();

        // render the background and the player
        renderer.getSpriteBatch().begin();
        renderer.getSpriteBatch().draw(Assets.spriteLevelBackground, 0, 0);
        player.draw(renderer.getSpriteBatch());
        renderer.getSpriteBatch().end();

        // render the Map
        renderer.setView(camera);
        renderer.render();

        // render the HUD
        renderHud();
    }

    private void renderSpriteBatches() {
        batch.begin();
        batch.draw(Assets.spriteLevelBackground, 0, 0);;
        batch.end();
    }
    private void renderHud() {
        batch.begin();
        stage.draw();
//        Table.drawDebug(stage);
        batch.end();
    }

    //TODO change this to the background image? OR add tiles to the tilemap for background
    private void drawMap() {
        for (int i = 0; i < xResolution+1; i+=tileSize) {
            for (int j = 0; j < yResolution+10; j+=tileSize) {
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


    private Player player;
    @Override
    public void show() {
        super.show();
        levelManager = new LevelManager();
        setLevel(level);  //  loads the specified levelMap in the LevelManager
        getLevel();  //  returns the set levelMap
        renderer = new OrthogonalTiledMapRenderer(levelMap);
        player = new Player(new Sprite(new Texture("images/player.png")), (TiledMapTileLayer)levelMap.getLayers().get(0));
        player.setPosition(18 * player.getCollisionLayer().getTileWidth(),21 * player.getCollisionLayer().getTileHeight());
    }

    @Override
    public void dispose() {
        super.dispose();
        stage.dispose();
        renderer.dispose();
        player.getTexture().dispose();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        stage.getViewport().update(width, height, true);
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

    public void hudSetup(int width, int height) {
        skin = new Skin(Gdx.files.internal("data/uiskin.json"));

        stage = new Stage(new ScreenViewport());

        fps = new Label(getFPSString(), skin);

        table = new Table();

        table.debug();
        stage.addActor(table);
        table.setFillParent(true);
        table.add(fps).expand().top().right();
    }

    public void update() {

        stage.draw();  //GUI stuff
//        Table.drawDebug(stage);  //debug lines for UI

    }
}
