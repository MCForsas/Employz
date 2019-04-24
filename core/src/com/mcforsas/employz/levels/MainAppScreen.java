package com.mcforsas.employz.levels;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mcforsas.employz.GameLauncher;
import com.mcforsas.employz.engine.core.Utils;
import com.mcforsas.employz.gameObjects.Button;
import com.mcforsas.employz.gameObjects.ButtonTypes;

/**
 * Created by mcforsas on 19.4.24
 * Main screen
 */
public class MainAppScreen extends AppScreen {

    @Override
    public void start() {
        addGameObject(new Button(ButtonTypes.mainMenuEmployee, this));
        addGameObject(new Button(ButtonTypes.mainMenuEmployer, this));
        this.sprite = new Sprite(GameLauncher.getAssetHandler().getTexture("sprExample"));
        this.sprite.setBounds(0,0, width, heigth);
        super.start();
        setDepth(100);
    }

    @Override
    public void onClick(ButtonTypes buttonType) {
        switch (buttonType){
            case mainMenuEmployee:
                Utils.warn("employee");
                break;
            case mainMenuEmployer:
                Utils.warn("employer");
                break;
        }
    }
}
