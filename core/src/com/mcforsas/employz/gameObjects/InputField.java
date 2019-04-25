package com.mcforsas.employz.gameObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mcforsas.employz.engine.core.Utils;
import com.mcforsas.employz.levels.AppScreen;

/**
 * Created by mcforsas on 19.4.24
 * Input field handles text input.
 */
public class InputField extends Button{

    private static boolean isKeyboardOnScreen = false;

    public InputField(ButtonTypes type, AppScreen screen) {
        super(type, screen);
    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void touchDown(float x, float y) {
        super.touchDown(x, y);
    }

    @Override
    public void touchUp(float x, float y) {
        super.touchUp(x, y);
        if(Utils.isOnSprite(sprite,x,y)){
            isKeyboardOnScreen = Utils.flipBoolean(isKeyboardOnScreen);
            Gdx.input.setOnscreenKeyboardVisible(isKeyboardOnScreen);
        }
    }

    @Override
    public void render(SpriteBatch spriteBatch, float deltaTime) {
        super.render(spriteBatch, deltaTime);
    }
}
