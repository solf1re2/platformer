package com.solf1re.platformer.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.solf1re.platformer.Assets;
import com.solf1re.platformer.PlatformGame;

/**
 * Created by James on 29/06/2014.
 */
public class SettingsScreen extends GameScreen{

    private BitmapFont font = new BitmapFont();

    public SettingsScreen(PlatformGame game) {
        super(game);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        renderSpriteBatches();
    }

    // TODO make menuScreen spriteBatch here, using Assets
    private void renderSpriteBatches() {
        batch.begin();

        batch.draw(Assets.spriteSettingsBackground, 0, 0);

        font.draw(batch, "fps: " + Gdx.graphics.getFramesPerSecond(), 10, 20);
        batch.end();
    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
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
