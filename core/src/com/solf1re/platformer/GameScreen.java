package com.solf1re.platformer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by James on 25/06/2014.
 */
public class GameScreen implements Screen {

    PlatformGame game;
    OrthographicCamera camera;
    SpriteBatch batch;

    final int spriteheight = 16;


    public GameScreen(PlatformGame game){
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(true,1920,1080);

        batch = new SpriteBatch();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.95f, 0.95f, 0.95f, 0.95f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();

        batch.setProjectionMatrix(camera.combined);

        batch.begin();

        batch.draw(Assets.spriteBack, 0, 0);
//        batch.draw(Assets.spriteMud, 22, 34);
//        batch.draw(Assets.spriteRock, 256, 256);
//        batch.draw(Assets.spriteGrass, 652, 444);
//        batch.draw(Assets.spriteGreen, 43, 324);
        drawFloor();
        batch.end();
    }

    private void drawFloor(){
        int floorDepth = 1080 - 128;
        for(int i = 0; i < 1920; i += spriteheight) {
            batch.draw(Assets.spriteGrass, i, floorDepth);
            for(int j = spriteheight + floorDepth; j < 1080; j += spriteheight) {
                batch.draw(Assets.spriteRock, i, j);
            }
        }
    }

    @Override
    public void show() {

    }

    @Override
    public void dispose() {

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
}
