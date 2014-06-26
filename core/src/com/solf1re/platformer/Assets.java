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

    public static Texture terrainSprites;
    public static Sprite spriteMud;
    public static Sprite spriteRock;
    public static Sprite spriteGrass;
    public static Sprite spriteGreen;
    public static Sprite mapSprite;

    public static void load(){
        textureBack = new Texture(Gdx.files.internal("mainmenu/background.png"));
        textureBack.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        spriteBack = new Sprite(textureBack);   // assigns the background texture to a Sprite
        spriteBack.flip(false, true);   // flips the background sprite on its Y axis (not on X axis)

        terrainSprites = new Texture(Gdx.files.internal("images/spritesheet_terrain.png"));
        spriteMud = new Sprite(terrainSprites, 0, 0, 16, 16);
        spriteRock = new Sprite(terrainSprites, 0, 16, 16, 16);
        spriteGrass = new Sprite(terrainSprites, 0, 32, 16, 16);
    }
}
