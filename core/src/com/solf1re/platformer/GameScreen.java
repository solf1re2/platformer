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

        batch.end();
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
