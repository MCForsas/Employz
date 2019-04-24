package com.mcforsas.employz.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mcforsas.employz.GameLauncher;

public class DesktopLauncher {
	public static void main (String[] arg) {
		GameLauncher gameLauncher = new GameLauncher();
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.foregroundFPS = gameLauncher.getFPS();
		config.width = gameLauncher.getResolutionH();
		config.height = gameLauncher.getResolutionV();
		config.title = "Employz";
		new LwjglApplication(gameLauncher, config);
	}
}
