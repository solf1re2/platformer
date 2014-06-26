package com.solf1re.platformer;


import com.badlogic.gdx.Game;

public class PlatformGame extends Game{

    public GameScreen gameScreen;

    @Override
    public void create() {
        gameScreen = new GameScreen(this);

        setScreen(gameScreen);
    }
}
