package com.mcforsas.employz.levels;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mcforsas.employz.GameLauncher;
import com.mcforsas.employz.engine.core.Engine;
import com.mcforsas.employz.gameObjects.Button;
import com.mcforsas.employz.gameObjects.ButtonTypes;

/**
 * Created by mcforsas on 19.4.26
 * Replace this text by description, of what this code is for
 */
public class BusinessProfileScreen extends AppScreen {

    @Override
    public void start() {
        sprite = new Sprite(GameLauncher.getAssetHandler().getTexture("sprBadlogic"));
        this.sprite.setBounds(
                0,
                0,
                width * (1 + Engine.getRenderHandler().getMaxAspectDeviation()),
                heigth * (1 + Engine.getRenderHandler().getMaxAspectDeviation())
        );

        addGameObject(new Button(ButtonTypes.gotoMainMenu, this));

        this.sprite.setOriginCenter();
        this.sprite.setOriginBasedPosition(width/2,heigth/2);
        super.start();
    }

    @Override
    public void onClick(ButtonTypes buttonType) {
        if(buttonType == ButtonTypes.gotoMainMenu){
            GameLauncher.getLevelHandler().gotoLevel(new MainAppScreen());
        }
    }
}
