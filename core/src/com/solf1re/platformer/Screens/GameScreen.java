package com.solf1re.platformer.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.solf1re.platformer.Assets;
import com.solf1re.platformer.PlatformGame;

import java.util.Random;

/**
 * Created by James on 25/06/2014.
 * Main game screen, draws on assets class for sprite loading.
 */
public abstract class GameScreen implements Screen {

    PlatformGame game;

    OrthographicCamera camera;
    SpriteBatch batch;
    private BitmapFont font = new BitmapFont();
    Random random = new Random();
    public static int tileSize = 16;
    public static int xResolution = 1920;
    public static int yResolution = 1080;
    public static int numberXTiles = xResolution/16;
    public static int numberYTiles = yResolution/16;

    final int spriteheight = 16;


    public GameScreen(PlatformGame game){
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false,1920,1080); // flips the Y axis

        batch = new SpriteBatch();


    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.95f, 0.95f, 0.95f, 0.95f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();

        batch.setProjectionMatrix(camera.combined);

        if (Gdx.input.isKeyPressed(Input.Keys.E))
            game.setScreen(game.levelScreen);
        if (Gdx.input.isKeyPressed(Input.Keys.O))
            game.setScreen(game.settingsScreen);
        if (Gdx.input.isKeyPressed(Input.Keys.R))
            game.setScreen(game.mainMenuScreen);


    }

    /**
     * make sprite batch for render method.
     */
    private void renderSpriteBatches() {
        batch.begin();

        batch.draw(Assets.spriteBack, 0, 0);
//        drawFloor();
        font.draw(batch, "fps: " + Gdx.graphics.getFramesPerSecond(), 10, 20);
        batch.end();
    }

    //TODO move method of making floor - to one time run
    /**
     * Method to generate the floor.
     * Bad location - continuously drawing etc
     */
    private void drawFloor(){
        int floorDepth = 128;
        for(int i = 0; i < 1920; i += spriteheight) {
            batch.draw(Assets.spriteGrass, i, floorDepth);
            for(int j = 0; j < floorDepth; j += spriteheight) {
                switch (random.nextInt(2)){
                    case 0 : batch.draw(Assets.spriteRock, i, j);
                        break;
                    case 1 : batch.draw(Assets.spriteMud, i, j);
                        break;
                    default : batch.draw(Assets.spriteRock, i, j);
                        break;
                }
            }
        }
    }

    @Override
    public void show() {

    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    public String getFPSString() {
        return "fps: " + Gdx.graphics.getFramesPerSecond();

    }
}
