package com.solf1re.platformer.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.solf1re.platformer.PlatformGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "My Platformer";
        config.width = 480;
        config.height = 320;
//        config.resizable = false;


		new LwjglApplication(new PlatformGame(), config);
	}
}
