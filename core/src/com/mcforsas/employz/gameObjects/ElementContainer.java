package com.mcforsas.employz.gameObjects;

import com.mcforsas.employz.engine.core.Utils;

/**
 * Created by mcforsas on 19.4.24
 * Contains UiElements, displays them in a grid
 */
public class ElementContainer{
    private int rows, columns;
    private int padding = 0;

    private UiElement[][] elements;

    public ElementContainer(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    public void addElement(UiElement element, int row, int column){
        elements[row][column] = element;
        try {
            if(!Utils.isInRange(row, 0, rows) || !Utils.isInRange(column, 0, columns)){
                throw new Exception("element added outside the container");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public enum Aligment{
        Left,
        Right,
        Center,
        Top,
        Bottom,
    }
}
