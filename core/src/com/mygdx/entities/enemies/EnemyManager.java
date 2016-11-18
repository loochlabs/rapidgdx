/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.entities.enemies;

import com.badlogic.gdx.utils.Array;

/**
 *
 * @author saynt
 */
public class EnemyManager {
    
    public static Array<EnemyEntity> enemies = new Array<EnemyEntity>();
    
    public static void add(EnemyEntity e){
        enemies.add(e);
    }
    
    public static void remove(EnemyEntity e){
        enemies.removeValue(e, false);
    }
    
    /*
    public static Enemy_TestMon createRandom(Vector2 pos){
        int index = 4;
        Random rng = new Random();
        switch(rng.nextInt(index)){
            case 0:
                return new Enemy_Mousine(pos);
            case 1:
                return new Enemy_Creepit(pos);
            case 2:
                return new Enemy_Poe(pos);
            case 3:
                return new Enemy_Lumen(pos);
            default:
                return new Enemy_Mousine(pos);
        }
    }*/
    
}
