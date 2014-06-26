package com.solf1re.platformer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by james on 26/06/2014.
 */
public class Assets {

    public static Texture textureBack;
    public static Sprite spriteBack;

    public static void load(){
        textureBack = new Texture(Gdx.files.internal("mainmenu/background.png"));
        textureBack.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        spriteBack = new Sprite(textureBack);
        spriteBack.flip(false, true);
    }
}
