/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.entities.enemies;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import java.util.Random;

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
    
    
    public static EnemyEntity createRandom(Vector2 pos){
        int index = 4;
        Random rng = new Random();
        switch(rng.nextInt(index)){
            case 0:
                return new Enemy_Test(pos);
            default:
                return new Enemy_Test(pos);
        }
    }
    
}
