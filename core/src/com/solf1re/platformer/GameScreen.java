package com.solf1re.platformer;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;

/**
 * Created by James on 25/06/2014.
 */
public class GameScreen implements Screen {

    private PlatformGame game;
    OrthographicCamera camera;

    public GameScreen(PlatformGame game){
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(true,1920,1080);
    }

    @Override
    public void render(float delta) {
        camera.update();
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
