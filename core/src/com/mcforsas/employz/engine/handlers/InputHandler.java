package com.mcforsas.employz.engine.handlers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector3;
import com.mcforsas.employz.GameLauncher;
import com.mcforsas.employz.engine.core.InputListener;
import com.mcforsas.employz.engine.core.TextInputListener;
import com.mcforsas.employz.engine.core.Utils;

import java.util.Vector;

/**
 * @author MCForsas @since 3/16/2019
 * Handles input. When key is pressed, calls input listeners
 */
public class InputHandler implements InputProcessor, Input.TextInputListener {
    private Vector<InputListener> listeners = new Vector<InputListener>(); //Listeners
    TextInputListener textInputListener = null;

    private final boolean isDebugKeystrokesShown = false;

    private String keyboardString = "";

    //region <Call listeners and overrride methods>
    @Override
    public boolean keyDown(int keycode) {
        for(int i = 0; i < listeners.size(); i++){
            listeners.get(i).keyDown(keycode);
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        for(int i = 0; i < listeners.size(); i++){
            listeners.get(i).keyUp(keycode);
        }

        return true;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        Vector3 worldCoordinates =
                GameLauncher.getRenderHandler().
                        getCamera().
                        unproject(new Vector3(screenX, screenY, 0));
        for(int i = 0; i < listeners.size(); i++){
            listeners.get(i).touchDown(worldCoordinates.x,worldCoordinates.y);
        }
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        Vector3 worldCoordinates =
                GameLauncher.getRenderHandler().
                        getCamera().
                        unproject(new Vector3(screenX, screenY, 0));
        for(int i = 0; i < listeners.size(); i++){
            listeners.get(i).touchUp(worldCoordinates.x, worldCoordinates.y);
        }


        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        for(int i = 0; i < listeners.size(); i++){
            listeners.get(i).mouseMoved(screenX, screenY);
        }
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
    //endregion

    public void addInputListener(InputListener listener){
        listeners.add(listener);
    }

    public void removeInputListener(InputListener listener){
        listeners.remove(listener);
    }

    public boolean isKeyDown(final int keycode){
        return Gdx.input.isKeyPressed(keycode);
    }

    public boolean isButtonDown(final int keycode){return Gdx.input.isButtonPressed(keycode);}

    public String getKeyboardString() {
        return keyboardString;
    }

    public void setKeyboardString(String keyboardString) {
        this.keyboardString = keyboardString;
    }

   //region <Call textInput listeners>

    public void getTextInput(TextInputListener listener, String title, String text, String hint){
        setTextInputListener(listener);
        Gdx.input.getTextInput(this, title, text, hint);
    }

    public void input(String text) {
        textInputListener.input(text);
    }

    @Override
    public void canceled() {
        textInputListener.canceled();
    }

    public TextInputListener getTextInputListener() {
        return textInputListener;
    }

    private void setTextInputListener(TextInputListener textInputListener) {
        this.textInputListener = textInputListener;
    }

    //endregion
}