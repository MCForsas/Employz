package com.mcforsas.employz.gameObjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mcforsas.employz.GameLauncher;
import com.mcforsas.employz.engine.core.TextInputListener;
import com.mcforsas.employz.engine.core.Utils;
import com.mcforsas.employz.levels.AppScreen;
import com.mcforsas.employz.levels.BusinessProfileScreen;

/**
 * Created by mcforsas on 19.4.24
 * Input field handles text input.
 */
public class InputField extends Button implements TextInputListener {
    private String input = "";
    private TextHandler textHandler;
    private boolean isClickedOn = false;

    public InputField(ButtonTypes type, AppScreen screen) {
        super(type, screen);
    }

    @Override
    public void touchDown(float x, float y) {
        if (Utils.isOnSprite(this.sprite, x, y) && !isClickedOn) {
            //TODO: Make not hard coded
            GameLauncher.getInputHandler().getTextInput(this, "Email", "", "username@mail.com");
            isClickedOn = true;
        }
    }

    @Override
    public void input(String input) {
        this.input = input;
        GameLauncher.getFileHandler().putPreferences("email",input);
        GameLauncher.getLevelHandler().gotoLevel(new BusinessProfileScreen());
    }

    @Override
    public void canceled() {
        //Debug:
        Utils.warn("canceled");
        isClickedOn = false;
    }

    @Override
    public void render(SpriteBatch spriteBatch, float deltaTime) {
        super.render(spriteBatch, deltaTime);
    }


}
