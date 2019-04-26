package com.mcforsas.employz.gameObjects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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
    private boolean isClickedOn = false;

    public Button(ButtonTypes type, AppScreen screen) {
        this.type = type;
        this.screen = screen;
    }

    @Override
    public void start() {
        super.start();
        GameLauncher.getInputHandler().addInputListener(this);
        String textureName = "";
        switch (type) {
            case mainMenuEmployee:
                textureName = "sprBtnMainMenuEmployee";
                break;
            case mainMenuEmployer:
                textureName = "sprBtnMainMenuEmployer";
                break;
            case mainMenuLogin:
                textureName = "sprBtnMainMenuLogin";
                break;
            case businessMenuHasABusiness:
                textureName = "sprBtnBusinessMenuHasABusiness";
                break;
            case businessMenuCreate:
                textureName = "sprBtnBusinessMenuCreate";
                break;
            case businessMenuPartnership:
                textureName = "sprBtnBusinessMenuPartnership";
                break;
            case jobMenuAccept:
                textureName = "sprBtnJobMenuAccept";
                break;
            case jobMenuDecline:
                textureName = "sprBtnJobMenuDecline";
                break;
            default:
                textureName = "sprExample";
        }

        this.sprite = new Sprite(GameLauncher.getAssetHandler().getTexture(textureName));
        if(type == ButtonTypes.gotoMainMenu){
            sprite.setBounds(0,0,level.getWidth(),10);
        }

    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        this.x = sprite.getBoundingRectangle().x;
        this.y = sprite.getBoundingRectangle().y;
    }

    @Override
    public void touchDown(float x, float y) {
        super.touchDown(x, y);
        if(Utils.isOnSprite(sprite, x, y)){
            sprite.setColor(Color.DARK_GRAY);
            isClickedOn = true;
        }
    }

    @Override
    public void touchUp(float x, float y) {
        super.touchUp(x, y);
        sprite.setColor(Color.WHITE);
        if(Utils.isOnSprite(sprite, x, y) && isClickedOn){
            screen.onClick(type);
            Utils.warn("Clicked: " + type.toString());
        }else{
            isClickedOn = false;
        }
    }

    @Override
    public void render(SpriteBatch spriteBatch, float deltaTime) {
        if(type != ButtonTypes.gotoMainMenu)
            super.render(spriteBatch, deltaTime);

        //Utils.warnf("%f,%f,%f,%f",sprite.getX(),sprite.getY(),sprite.getWidth(),sprite.getHeight());
    }
}
