package com.mcforsas.employz.gameObjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mcforsas.employz.GameLauncher;
import com.mcforsas.employz.engine.core.TextInputListener;
import com.mcforsas.employz.engine.core.Utils;
import com.mcforsas.employz.levels.AppScreen;

/**
 * Created by mcforsas on 19.4.24
 * Input field handles text input.
 */
public class InputField extends Button implements TextInputListener {
    private String input = "";
    private TextHandler textHandler;

    public InputField(ButtonTypes type, AppScreen screen) {
        super(type, screen);
    }
    @Override
    public void touchUp(float x, float y) {
        super.touchUp(x, y);
        if(Utils.isOnSprite(sprite, x,y)){
            GameLauncher.getInputHandler().getTextInput(this, "Hello", "world", "say hi");
        }
    }

    @Override
    public void input(String input) {
        this.input = input;
    }

    @Override
    public void canceled() {
        //Debug:
        Utils.warn("canceled");
    }

    @Override
    public void render(SpriteBatch spriteBatch, float deltaTime) {
        super.render(spriteBatch, deltaTime);
    }
}
