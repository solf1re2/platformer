package com.solf1re.platformer.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import javafx.scene.Camera;

/**
 * Created by James on 20/07/2014.
 */
public class Hud extends Stage {

    LevelScreen levelScreen;
    public Stage stage;
    Table table;
    Skin skin;
    public Label fps;
    private ScreenViewport hudViewPort = new ScreenViewport();


    SpriteBatch hudSpriteBatch = new SpriteBatch();

    public Hud(LevelScreen levelScreen, int width, int height) {
        this.levelScreen = levelScreen;
        hudSetup(width, height);
    }
    public void hudSetup(int width, int height) {
        skin = new Skin(Gdx.files.internal("data/uiskin.json"));
        fps = new Label(levelScreen.getFPSString(), skin);
        stage = this;
        this.setViewport(hudViewPort);

        table = new Table();
//        table.setPosition(0, 0);

        table.debug();

        stage.addActor(table);

        table.setFillParent(true);

        table.add(fps);
    }

    public void update(SpriteBatch batch) {

        stage.draw();  //GUI stuff
        Table.drawDebug(stage);  //debug lines for UI
//        font.draw(spriteBatch, getFPSString(), 0, 20);

    }

    public void resize(int width, int height){

    }
}
