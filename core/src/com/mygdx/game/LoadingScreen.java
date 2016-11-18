/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MainGame;
import com.mygdx.game.Screen;
import com.mygdx.game.ScreenManager;

/**
 *
 * @author looch
 */
public class LoadingScreen extends Screen{

    private BitmapFont font = new BitmapFont();
    
    
    @Override
    public void create() {
        font.setColor(Color.WHITE);
        MainGame.rm.primaryLoad();
    }

    @Override
    public void update(float dt) {}

    @Override
    public void render(SpriteBatch sb) {
        
        //load assets through AssetManager
        if(MainGame.am.update()){
            //all assets are loaded -> move on to next screen
            
            ScreenManager.setScreen(new MainMenuScreen());
            MainGame.rm.secondaryLoad();
        }
        
        sb.begin();
        font.draw(sb, "" +MainGame.am.getProgress()+ "", MainGame.WIDTH/2, MainGame.HEIGHT/2);
        sb.end();
        
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void dispose() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }
    
}
