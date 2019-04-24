package com.mcforsas.employz.engine.core;

import com.mcforsas.employz.engine.handlers.FileHandler;

/**
 * Created by MCForsas on 3/16/2019
 * Game object. Can be used with game logic and so on.
 */
public abstract class GameObject extends Renderable{
    protected Level level;
    protected boolean isPaused = false;

    public void update(float deltaTime){
        super.update();
    }

    /**
     * Called on game save. Object should save all of it's details for later use;
     * @param fileHandler
     * @param gameData
     */
    public void save(FileHandler fileHandler, GameData gameData){

    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public boolean isPaused() {
        return isPaused;
    }

    public void setPaused(boolean paused) {
        isPaused = paused;
    }
}
