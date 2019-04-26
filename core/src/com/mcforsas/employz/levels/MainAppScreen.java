package com.mcforsas.employz.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mcforsas.employz.GameLauncher;
import com.mcforsas.employz.engine.core.Engine;
import com.mcforsas.employz.engine.core.Utils;
import com.mcforsas.employz.gameObjects.Button;
import com.mcforsas.employz.gameObjects.ButtonTypes;
import com.mcforsas.employz.gameObjects.ElementContainer;
import com.mcforsas.employz.gameObjects.TextHandler;

/**
 * Created by mcforsas on 19.4.24
 * Main screen
 */
public class MainAppScreen extends AppScreen {

    private ElementContainer elementContainer;

    @Override
    public void start() {
        this.sprite = new Sprite(GameLauncher.getAssetHandler().getTexture("sprBackground"));
        this.sprite.setBounds(
                0,
                0,
                width * (1 + Engine.getRenderHandler().getMaxAspectDeviation()),
                heigth * (1 + Engine.getRenderHandler().getMaxAspectDeviation())
        );

        this.sprite.setOriginCenter();
        this.sprite.setOriginBasedPosition(width/2,heigth/2);


        Button buttonEmployee = new Button(ButtonTypes.mainMenuEmployee, this);
        Button buttonEmployer = new Button(ButtonTypes.mainMenuEmployer, this);

        elementContainer = new ElementContainer(2,1,10,10, width, heigth, true, 70,30, ElementContainer.Aligment.Top);
        elementContainer.addElement(buttonEmployee,0,0);
        elementContainer.addElement(buttonEmployer,1,0);

        addGameObject(elementContainer);
        addGameObject(buttonEmployee);
        addGameObject(buttonEmployer);

        super.start();

        setDepth(100);

    }

    @Override
    public void onClick(ButtonTypes buttonType) {
        switch (buttonType){
            case mainMenuEmployee:
                GameLauncher.getLevelHandler().gotoLevel(new JobSearchScreen());
                break;
            case mainMenuEmployer:
                GameLauncher.getLevelHandler().gotoLevel(new BusinessMenuScreen());
                break;
        }
    }
}
