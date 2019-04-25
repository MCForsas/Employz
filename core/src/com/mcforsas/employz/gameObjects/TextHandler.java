package com.mcforsas.employz.gameObjects;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;
import com.mcforsas.employz.engine.core.GameObject;
import com.mcforsas.employz.engine.core.Utils;

/**
 * Created by mcforsas on 19.4.26
 * Handles text displayment
 */
public class TextHandler extends GameObject {
    private BitmapFont font;
    private float width, height;
    private String text;
    private String drawnText = "";
    private final String delimiter = "***";
    private final float fontSize = 50f;

    public TextHandler(BitmapFont font, float x, float y, float width, float height, String text) {
        this.font = font;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;
        recalculateTextSize();
    }

    @Override
    public void render(SpriteBatch spriteBatch, float deltaTime) {
        font.draw(spriteBatch, drawnText, x,y);
    }


    private void recalculateTextSize(){
        font.getData().setScale(height/fontSize);
        drawnText = text;

        int maxTextWd = (int) Math.floor(width/height);
        Utils.warn(String.valueOf(maxTextWd));

        maxTextWd = (int) Utils.clamp(maxTextWd, 0, drawnText.length());
        drawnText = drawnText.substring(0,maxTextWd);
        drawnText += delimiter;
    }

    //region <Getters and setters>
    public BitmapFont getFont() {
        return font;
    }

    public void setFont(BitmapFont font) {
        this.font = font;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
        recalculateTextSize();
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
        recalculateTextSize();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void setX(float x) {
        super.setX(x);
        recalculateTextSize();
    }

    @Override
    public void setY(float y) {
        super.setY(y);
        recalculateTextSize();
    }
    //endregion
}
