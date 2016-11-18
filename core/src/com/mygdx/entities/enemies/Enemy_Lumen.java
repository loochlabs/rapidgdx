/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.entities.enemies;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.MainGame;
import com.mygdx.utilities.ResourceManager;

/**
 *
 * @author saynt
 */
public class Enemy_Lumen extends Enemy_TestMon{
    
    public Enemy_Lumen(Vector2 pos) {
        super(pos);
        
        idleTexture = MainGame.am.get(ResourceManager.ENEMY_LUMEN_IDLE);
        deadTexture = MainGame.am.get(ResourceManager.ENEMY_LUMEN_DEAD);
        texture = idleTexture;
    }
    
}
