package com.mcforsas.employz.gameObjects;

import com.mcforsas.employz.engine.core.GameObject;
import com.mcforsas.employz.engine.core.Utils;

/**
 * Created by mcforsas on 19.4.24
 * Contains UiElements, displays them in a grid.
 */
public class ElementContainer extends GameObject{
    private int rows, columns;
    private float horizontalPadding = 0;
    private float verticalPadding = 0;
    private float elementWidth;
    private float elementHeight;
    private float width, heigth; //Container dimensions



    private Button[][] elements;

    public ElementContainer(
            int rows,
            int columns,
            float horizontalPadding,
            float verticalPadding,
            float width,
            float height,
            boolean useFixedDimensions,
            float fixedWidth,
            float fixedHeight,
            Aligment aligment) {
        this.x = 0;
        this.y = 0;

        this.rows = rows;
        this.columns = columns;
        this.horizontalPadding = horizontalPadding;
        this.verticalPadding = verticalPadding;
        this.width = width;
        this.heigth = height;

        if(useFixedDimensions){
            this.elementWidth = fixedWidth;
            this.elementHeight = fixedHeight;
            if(aligment == Aligment.Top){
                this.y = height - (elementHeight + verticalPadding) * (columns + 1) - verticalPadding;
            }
            if(aligment == Aligment.Bottom){
                //this.y += verticalPadding;
            }
        }else {
            this.elementWidth = (width - ((columns + 1) * horizontalPadding)) / columns; //Calculate element dimensions
            this.elementHeight = (height - ((rows + 1) * verticalPadding)) / rows;
        }

        elements = new Button[rows][columns];
    }

    public void addElement(Button element, int row, int column){
        try {
            if(!Utils.isInRange(row, 0, rows) || !Utils.isInRange(column, 0, columns)){
                throw new Exception("element added outside the container");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        elements[row][column] = element;
    }

    public void update(float deltaTime){
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                if(elements[i][j].getSprite() != null){
                    elements[i][j].getSprite().setBounds(
                            x + (horizontalPadding * (j + 1) + (j * elementWidth)),
                            y + (verticalPadding * (i+1) + (i * elementHeight)),
                            elementWidth,
                            elementHeight);
                }
            }
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
