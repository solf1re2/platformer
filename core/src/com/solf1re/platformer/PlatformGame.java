package com.solf1re.platformer;


import com.badlogic.gdx.Game;
import com.solf1re.platformer.manager.LevelManager;
import com.solf1re.platformer.screens.LevelScreen;
import com.solf1re.platformer.screens.MainMenuScreen;
import com.solf1re.platformer.screens.SettingsScreen;

public class PlatformGame extends Game{

//    public GameScreen gameScreen;
    public MainMenuScreen mainMenuScreen;
    public LevelScreen levelScreen;
    public SettingsScreen settingsScreen;

    @Override
    public void create() {
        Assets.load();
        mainMenuScreen = new MainMenuScreen(this);
        //TODO add a level select screen
        settingsScreen = new SettingsScreen(this);
        levelScreen = new LevelScreen(this);
        LevelManager.initLevelManager();

        setScreen(mainMenuScreen);
    }
}
