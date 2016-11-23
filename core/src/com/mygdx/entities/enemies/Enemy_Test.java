/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.entities.enemies;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.utilities.ResourceManager;
import com.mygdx.utilities.sound.SoundObject_Sfx;

/**
 *
 * @author saynt
 */
public class Enemy_Test extends EnemyEntity{
    
    public SoundObject_Sfx sfx;
    
    public Enemy_Test(Vector2 pos) {
        super(pos, 15f,15f);
        
        sfx = new SoundObject_Sfx(ResourceManager.SFX_TEST);
    }
    
    @Override
    public void update(){
        super.update();
        
    }
    
}
