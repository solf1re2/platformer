package com.solf1re.platformer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by james on 26/06/2014.
 * Texture loading static class.
 */
public class Assets {

    //Mainmenu textures and sprites
    public static Texture textureBack;
    public static Sprite spriteBack;
    public static Texture texturePlayButton;
    public static Texture textureQuitButton;
    public static Texture textureSettingsButton;
    public static Sprite spritePlayButt;
    public static Sprite spriteQuitButt;
    public static Sprite spriteSettingsButt;

    //settings textures and sprites
    public static Texture textureSettingsBackground;
    public static Sprite spriteSettingsBackground;

    //level textures and sprites
    public static Texture textureLevelBackground;
    public static Sprite spriteLevelBackground;

    //terrain and level block textures
    public static Texture terrainSprites;
    public static Sprite spriteMud;
    public static Sprite spriteRock;
    public static Sprite spriteGrass;

    public static void load(){
        //mainmenu init
        textureBack = new Texture(Gdx.files.internal("mainmenu/background.png"));
        textureBack.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        texturePlayButton = new Texture(Gdx.files.internal("mainmenu/playButton.png"));
        texturePlayButton.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        textureQuitButton = new Texture(Gdx.files.internal("mainmenu/quitButton.png"));
        textureQuitButton.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        textureSettingsButton = new Texture(Gdx.files.internal("mainmenu/settingsButton.png"));
        textureSettingsButton.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        spriteBack = new Sprite(textureBack);   // assigns the background texture to a Sprite
        spriteBack.flip(false, false);   // flips the background sprite on its Y axis (not on X axis)
        spritePlayButt = new Sprite(texturePlayButton);
        spriteQuitButt = new Sprite(textureQuitButton);
        spriteSettingsButt = new Sprite(textureSettingsButton);

        //settting init
        textureSettingsBackground = new Texture(Gdx.files.internal("settingpage/settings_placeholder.png"));
        textureSettingsBackground.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        //level init
        textureLevelBackground = new Texture(Gdx.files.internal("Level-placeholder.png"));
        textureLevelBackground.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        spriteSettingsBackground = new Sprite(textureSettingsBackground);
        spriteLevelBackground = new Sprite(textureLevelBackground);

        terrainSprites = new Texture(Gdx.files.internal("images/spritesheet_terrain.png"));
        spriteMud = new Sprite(terrainSprites, 0, 0, 16, 16);
        spriteRock = new Sprite(terrainSprites, 0, 16, 16, 16);
        spriteGrass = new Sprite(terrainSprites, 0, 32, 16, 16);
    }


}
