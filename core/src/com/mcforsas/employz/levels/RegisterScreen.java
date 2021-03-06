package com.mcforsas.employz.levels;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mcforsas.employz.GameLauncher;
import com.mcforsas.employz.engine.core.Engine;
import com.mcforsas.employz.engine.handlers.LevelHandler;
import com.mcforsas.employz.gameObjects.ButtonTypes;
import com.mcforsas.employz.gameObjects.InputField;

/**
 * Created by mcforsas on 19.4.26
 * Replace this text by description, of what this code is for
 */
public class RegisterScreen extends AppScreen {

    public void start() {
        InputField inputField = new InputField(ButtonTypes.mainMenuLogin, this);
        addGameObject(inputField);
        this.sprite = new Sprite(Engine.getAssetHandler().getTexture("sprExample"));
        this.sprite.setBounds(
                0,
                0,
                width * (1 + Engine.getRenderHandler().getMaxAspectDeviation()),
                heigth * (1 + Engine.getRenderHandler().getMaxAspectDeviation())
        );

        this.sprite.setOriginCenter();
        this.sprite.setOriginBasedPosition(width/2,heigth/2);
        super.start();
        this.setDepth(100);
        inputField.getSprite().setBounds(10,10,70,30);
    }

    @Override
    public void onClick(ButtonTypes buttonType) {
    }
}
