package com.mcforsas.employz.levels;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mcforsas.employz.GameLauncher;
import com.mcforsas.employz.engine.core.Engine;
import com.mcforsas.employz.engine.core.Utils;
import com.mcforsas.employz.gameObjects.Button;
import com.mcforsas.employz.gameObjects.ButtonTypes;
import com.mcforsas.employz.gameObjects.ElementContainer;

/**
 * Created by mcforsas on 19.4.26
 * Replace this text by description, of what this code is for
 */
public class JobSearchScreen extends AppScreen {
    private ElementContainer elementContainer;
    private Texture[] jobApplications = new Texture[5];
    private float jobPhotoWidth = 80;
    private float jobPhotoHeigth = 100;
    private Sprite jobPhoto;
    private int selectedJob = 0;


    public JobSearchScreen() {
        jobPhoto = new Sprite(GameLauncher.getAssetHandler().getTexture("sprExample"));

        jobApplications[0] = GameLauncher.getAssetHandler().getTexture("sprExample");
        jobApplications[1] = GameLauncher.getAssetHandler().getTexture("sprExample");
        jobApplications[2] = GameLauncher.getAssetHandler().getTexture("sprExample");
        jobApplications[3] = GameLauncher.getAssetHandler().getTexture("sprExample");
        jobApplications[4] = GameLauncher.getAssetHandler().getTexture("sprExample");
        //jobApplications[5] = GameLauncher.getAssetHandler().getTexture("sprExample");

        Button buttonAccept = new Button(ButtonTypes.jobMenuAccept, this);
        Button buttonDecline = new Button(ButtonTypes.jobMenuDecline, this);


        elementContainer = new ElementContainer(1,2,10,10, width, heigth, true, 30, 12.857f, ElementContainer.Aligment.Bottom);
        elementContainer.addElement(buttonAccept,0,0);
        elementContainer.addElement(buttonDecline,0,1);

        sprite = new Sprite(GameLauncher.getAssetHandler().getTexture("sprBadlogic"));
        this.sprite.setBounds(
                0,
                0,
                width * (1 + Engine.getRenderHandler().getMaxAspectDeviation()),
                heigth * (1 + Engine.getRenderHandler().getMaxAspectDeviation())
        );

        this.sprite.setOriginCenter();
        this.sprite.setOriginBasedPosition(width/2,heigth/2);

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
        if(buttonType == ButtonTypes.jobMenuAccept){
            GameLauncher.getLevelHandler().gotoLevel(new ContactScreen());
        }
        if(buttonType == ButtonTypes.jobMenuDecline){
            shiftJobs();
        }
    }

    @Override
    public void render(SpriteBatch spriteBatch, float deltaTime) {
        super.render(spriteBatch, deltaTime);
        jobPhoto.draw(spriteBatch);
    }

    private void shiftJobs(){
        selectedJob++;
        if(selectedJob >= jobApplications.length){
            selectedJob = 0;
        }

        selectedJob = (int) Utils.clamp(selectedJob,0,jobApplications.length);
        jobPhoto.setTexture(jobApplications[selectedJob]);
    }
}
