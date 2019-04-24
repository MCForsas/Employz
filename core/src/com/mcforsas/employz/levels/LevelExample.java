package com.mcforsas.employz.levels;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mcforsas.employz.GameLauncher;
import com.mcforsas.employz.engine.core.Engine;
import com.mcforsas.employz.engine.core.Level;
import com.mcforsas.employz.gameObjects.GameObjectExample;

/**
 * @author MCForsas @since 3/16/2019
 * Example level to use
 */
public class LevelExample extends Level {

    @Override
    public void start() {
        setDepth(100);

        addGameObject(new GameObjectExample(0, 1,this));

        sprite = new Sprite(Engine.getAssetHandler().getTexture("sprExample"));
        sprite.setPosition(0,0);
        sprite.setBounds(0,0,getWidth(), getHeigth());

        //Engine.getRenderHandler().setMaxDimensions(getWidth(), getHeigth());
        super.start();
    }

    /**
     * Move around with wasd and goto next level with n.
     */
    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        if(Engine.getInputHandler().isKeyDown(Input.Keys.N)){
            Engine.getLevelHandler().nextLevel();
        }

        if(Engine.getInputHandler().isKeyDown(Input.Keys.P)){
            Engine.getLevelHandler().previousLevel();
        }
    }


    @Override
    public void render(SpriteBatch spriteBatch, float deltaTime) {
        super.render(spriteBatch, deltaTime);
    }



    @Override
    public void dispose() {
        save(GameLauncher.getFileHandler(), GameLauncher.getGameData());
        super.dispose();
    }
}
