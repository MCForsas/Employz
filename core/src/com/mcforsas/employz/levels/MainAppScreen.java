package com.mcforsas.employz.levels;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mcforsas.employz.GameLauncher;
import com.mcforsas.employz.engine.core.Utils;
import com.mcforsas.employz.gameObjects.Button;
import com.mcforsas.employz.gameObjects.ButtonTypes;
import com.mcforsas.employz.gameObjects.ElementContainer;

/**
 * Created by mcforsas on 19.4.24
 * Main screen
 */
public class MainAppScreen extends AppScreen {

    private ElementContainer elementContainer;

    @Override
    public void start() {
        this.sprite = new Sprite(GameLauncher.getAssetHandler().getTexture("sprExample"));
        this.sprite.setBounds(0,0, width, heigth);
        super.start();

        Button buttonEmployee = new Button(ButtonTypes.mainMenuEmployee, this);
        Button buttonEmployer = new Button(ButtonTypes.mainMenuEmployer, this);

        elementContainer = new ElementContainer(2,2,10,10, width, heigth);
        elementContainer.addElement(buttonEmployee,0,0);
        elementContainer.addElement(buttonEmployer,1,0);

        addGameObject(elementContainer);

        addGameObject(buttonEmployee);
        addGameObject(buttonEmployer);

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
