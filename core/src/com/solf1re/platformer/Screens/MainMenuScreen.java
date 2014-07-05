package com.solf1re.platformer.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.solf1re.platformer.Assets;
import com.solf1re.platformer.PlatformGame;

/**
 * Created by James on 29/06/2014.
 * MainMenu screen.
 */
public class MainMenuScreen extends GameScreen{

    private BitmapFont font = new BitmapFont();
    private Skin skin;
    private Stage stage; // for UI
    private Table table;
//    TextButton settingsButton;
//    TextButton playButton;


    public MainMenuScreen(PlatformGame game) {
        super(game);
        stageSetup();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        stage.act(delta);

        renderSpriteBatches();

    }

    // TODO make menuScreen spriteBatch here, using Assets
    private void renderSpriteBatches() {
        batch.begin();

        batch.draw(Assets.spriteBack, 0, 0);
//        batch.draw(Assets.spritePlayButt, 650, 700);
//        batch.draw(Assets.spriteSettingsButt, 650, 500);
//        batch.draw(Assets.spriteQuitButt, 650, 300);

        font.draw(batch, "fps: " + Gdx.graphics.getFramesPerSecond(), 10, 20);

        // render stage UI
        stage.draw();
        Table.drawDebug(stage);
        batch.end();
    }

    private void stageSetup() {
        // adding buttons UI
        skin = new Skin(Gdx.files.internal("data/uiskin.json"));

        // TODO need to somehow resize viewport with the Screen, resize method not doing it...
        stage = new Stage(new ScreenViewport());
//        stage.getViewport().
        table = new Table();
        // draws line for debugging table
        table.debug();

        stage.addActor(table);
        table.setFillParent(true);

        // play Button
        final TextButton playButton = new TextButton("Play", skin, "default");
        playButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(game.levelScreen);
            }
        });

        //settings Button
        final TextButton settingsButton = new TextButton("Settings", skin, "default");

        settingsButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(game.settingsScreen);
            }
        });

        table.add(playButton).size(250f, 80f).pad(20f, 0, 20f,0);
        table.row();
        table.add(settingsButton).size(250f, 80f).pad(20f, 0, 20f,0);
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void dispose() {
        super.dispose();
        stage.dispose();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
//        playButton.setPosition(stage.getWidth()/2 -100f, stage.getHeight() / 2 + 100f);
//        settingsButton.setPosition(stage.getWidth()/2 -100f , stage.getHeight() / 2 + 50f);
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
