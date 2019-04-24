package com.mcforsas.employz.gameObjects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mcforsas.employz.GameLauncher;
import com.mcforsas.employz.engine.core.GameObject;
import com.mcforsas.employz.engine.core.Utils;
import com.mcforsas.employz.levels.AppScreen;

/**
 * Created by mcforsas on 19.4.24
 * Button object. Can be tapped on
 */
public class Button extends GameObject {

    ButtonTypes type;
    AppScreen screen;

    public Button(ButtonTypes type, AppScreen screen) {
        this.type = type;
        this.screen = screen;
    }

    @Override
    public void start() {
        super.start();
        GameLauncher.getInputHandler().addInputListener(this);
        this.sprite = new Sprite(GameLauncher.getAssetHandler().getTexture("sprBadlogic"));
        this.sprite.setSize(level.getWidth()/2,level.getHeigth()/8);
        this.sprite.setOriginCenter();
        this.sprite.setOriginBasedPosition(level.getWidth()/2,level.getHeigth()/2);
    }

    @Override
    public void touchDown(float x, float y) {
        super.touchDown(x, y);
        if(Utils.isOnSprite(sprite, x, y)){
            sprite.setTexture(GameLauncher.getAssetHandler().getTexture("sprExample"));
        }
    }

    @Override
    public void touchUp(float x, float y) {
        super.touchUp(x, y);
        sprite.setTexture(GameLauncher.getAssetHandler().getTexture("sprBadlogic"));
        if(Utils.isOnSprite(sprite, x, y)){
            screen.onClick(type);
        }
    }



    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
    }
}
