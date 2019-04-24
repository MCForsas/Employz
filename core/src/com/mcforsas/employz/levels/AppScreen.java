package com.mcforsas.employz.levels;

import com.mcforsas.employz.engine.core.GameObject;
import com.mcforsas.employz.engine.core.Level;
import com.mcforsas.employz.gameObjects.ButtonTypes;

/**
 * Created by mcforsas on 19.4.24
 * Replace this text by description, of what this code is for
 */
public abstract class AppScreen extends Level {
    public abstract void onClick(ButtonTypes buttonType);
}
