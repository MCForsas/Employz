package com.mcforsas.employz.engine.core;

/**
 * Created by mcforsas on 19.4.26
 * Replace this text by description, of what this code is for
 */
public interface TextInputListener {
    /**
     * Invoked on when key is typed on keyboard
     * @param input
     */
    void input(String input);

    /**
     * Invoked on when user cancels the input
     */
    void canceled();
}
