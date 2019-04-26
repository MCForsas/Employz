package com.mcforsas.employz.levels;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mcforsas.employz.GameLauncher;
import com.mcforsas.employz.gameObjects.Button;
import com.mcforsas.employz.gameObjects.ButtonTypes;
import com.mcforsas.employz.gameObjects.ElementContainer;
import java.util.Vector;

/**
 * Created by mcforsas on 19.4.26
 * Replace this text by description, of what this code is for
 */
public class JobSearchScreen extends AppScreen {
    private ElementContainer elementContainer;
    private Vector<Texture> jobApplications = new Vector<Texture>();
    private float jobPhotoWidth = 80;
    private float jobPhotoHeigth = 100;
    private Sprite jobPhoto;


    public JobSearchScreen() {
        jobPhoto = new Sprite(GameLauncher.getAssetHandler().getTexture("sprExample"));

        Button buttonAccept = new Button(ButtonTypes.jobMenuAccept, this);
        Button buttonDecline = new Button(ButtonTypes.jobMenuDecline, this);
        elementContainer = new ElementContainer(1,2,10,10, width, heigth, true, 30, 12.857f, ElementContainer.Aligment.Bottom);
        elementContainer.addElement(buttonAccept,0,0);
        elementContainer.addElement(buttonDecline,0,1);

        sprite = new Sprite(GameLauncher.getAssetHandler().getTexture("sprBadlogic"));

        jobPhoto.setSize(jobPhotoWidth, jobPhotoHeigth);
        jobPhoto.setOriginCenter();
        jobPhoto.setOriginBasedPosition(width/2,heigth/2);

        addGameObject(buttonAccept);
        addGameObject(buttonDecline);
        addGameObject(elementContainer);
        setDepth(100);
    }

    @Override
    public void onClick(ButtonTypes buttonType) {
    }

    @Override
    public void render(SpriteBatch spriteBatch, float deltaTime) {
        super.render(spriteBatch, deltaTime);
        jobPhoto.draw(spriteBatch);
    }
}
