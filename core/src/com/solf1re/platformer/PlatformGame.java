package com.solf1re.platformer;


import com.badlogic.gdx.Game;
import com.solf1re.platformer.Screens.LevelScreen;
import com.solf1re.platformer.Screens.MainMenuScreen;
import com.solf1re.platformer.Screens.SettingsScreen;

public class PlatformGame extends Game{

//    public GameScreen gameScreen;
    public MainMenuScreen menuScreen;
    public LevelScreen levelScreen;
    public SettingsScreen settingsScreen;

    @Override
    public void create() {
        Assets.load();
        menuScreen = new MainMenuScreen(this);
        levelScreen = new LevelScreen(this);
        settingsScreen = new SettingsScreen(this);

        setScreen(menuScreen);
    }
}
