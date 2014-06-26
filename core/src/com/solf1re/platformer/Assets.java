package com.solf1re.platformer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by james on 26/06/2014.
 * Texture loading static class.
 */
public class Assets {

    public static Texture textureBack;
    public static Sprite spriteBack;

    public static Texture terrainSheet;
    public static Sprite spriteOne;
    public static Sprite spriteTwo;
    public static Sprite spriteThree;
    public static Sprite spriteFour;
    public static Sprite mapSprite;

    private static final int ss = 16;

    public static void load(){
        textureBack = new Texture(Gdx.files.internal("mainmenu/background.png"));
        textureBack.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        spriteBack = new Sprite(textureBack);   // assigns the background texture to a Sprite
        spriteBack.flip(false, true);   // flips the background sprite on its Y axis (not on X axis)

        terrainSheet = new Texture(Gdx.files.internal("terrain/oryx_16bit.png"));
        spriteOne = new Sprite(terrainSheet, 0, 0, 16, 16);
        spriteTwo = new Sprite(terrainSheet, ss*0, ss*8, 16, 16);
        spriteThree = new Sprite(terrainSheet, ss*0, ss*7, 16, 16);
        spriteFour = new Sprite(terrainSheet, ss*0, ss*14, 16, 16);


    }
}
