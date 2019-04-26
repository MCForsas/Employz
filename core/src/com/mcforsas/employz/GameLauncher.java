package com.mcforsas.employz;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.mcforsas.employz.engine.core.Engine;
import com.mcforsas.employz.engine.core.Utils;
import com.mcforsas.employz.engine.handlers.CameraHandler;
import com.mcforsas.employz.engine.handlers.FileHandler;
import com.mcforsas.employz.levels.MainAppScreen;

/**
 * Created by mcforsas on 19.4.21
 * Game object. All the config and constants should be set here
 */
public class GameLauncher extends Engine {
    private float maxAspectDeviation = .5f;
    //Config here
    public GameLauncher() {
        FPS = 120;
        WORLD_WIDTH = 90;
        WORLD_HEIGHT = 160;
        RESOLUTION_H = 1080/4;
        RESOLUTION_V = 1920/4;
    }

    @Override
    public void create() {
        super.create();

        OrthographicCamera cameraHandler = new CameraHandler(.1f,50f);
        renderHandler.setup(
                cameraHandler,
                new ExtendViewport(WORLD_WIDTH, WORLD_HEIGHT, cameraHandler),
                maxAspectDeviation
        );

        fileHandler = new FileHandler("save.sav",false);
        gameData = fileHandler.load();

    }

    protected void startGame() {
        levelHandler.addLevel(new MainAppScreen());
        super.startGame();
    }

    @Override
    protected void loadAssets() {
        assetHandler.addToQueue(Texture.class, "sprBadlogic", "badlogic.jpg");
        assetHandler.addToQueue(Texture.class, "sprExample", "example.jpg");
        assetHandler.addToQueue(BitmapFont.class, "fntUbuntuMono", "ubuntuMono.fnt");
        assetHandler.addToQueue(Music.class, "musExample","example.ogg");
        assetHandler.addToQueue(Sound.class, "sndExample","test.wav");
        super.loadAssets();
    }
}
