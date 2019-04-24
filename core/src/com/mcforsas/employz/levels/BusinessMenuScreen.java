package com.mcforsas.employz.levels;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mcforsas.employz.GameLauncher;
import com.mcforsas.employz.engine.core.Engine;
import com.mcforsas.employz.engine.core.Utils;
import com.mcforsas.employz.gameObjects.Button;
import com.mcforsas.employz.gameObjects.ButtonTypes;
import com.mcforsas.employz.gameObjects.ElementContainer;

/**
 * Created by mcforsas on 19.4.24
 * Replace this text by description, of what this code is for
 */
public class BusinessMenuScreen extends AppScreen {
    private ElementContainer elementContainer;

    @Override
    public void start() {
        this.sprite = new Sprite(GameLauncher.getAssetHandler().getTexture("sprBadlogic"));
        this.sprite.setBounds(
                0,
                0,
                width * (1 + Engine.getRenderHandler().getMaxAspectDeviation()),
                heigth * (1 + Engine.getRenderHandler().getMaxAspectDeviation())
        );

        this.sprite.setOriginCenter();
        this.sprite.setOriginBasedPosition(width/2,heigth/2);

        super.start();

        Button buttonHasABusiness = new Button(ButtonTypes.businessMenuHasABusiness, this);
        Button buttonCreateABusiness = new Button(ButtonTypes.businessMenuCreate, this);
        Button buttonPartnership = new Button(ButtonTypes.businessMenuPartnership, this);

        elementContainer = new ElementContainer(3,1,10,10, width, heigth);
        elementContainer.addElement(buttonHasABusiness,0,0);
        elementContainer.addElement(buttonCreateABusiness,1,0);
        elementContainer.addElement(buttonPartnership,2,0);

        addGameObject(elementContainer);

        addGameObject(buttonCreateABusiness);
        addGameObject(buttonHasABusiness);
        addGameObject(buttonPartnership);

        setDepth(100);

    }

    @Override
    public void onClick(ButtonTypes buttonType) {

    }
}
