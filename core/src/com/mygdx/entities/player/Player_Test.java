/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.entities.player;

import com.badlogic.gdx.math.Vector2;

/**
 *
 * @author saynt
 */
public class Player_Test extends PlayerEntity{
    
    private final float SPEED_DEFAULT = 4.5f;
    
    public Player_Test(Vector2 pos, float w, float h) {
        super(pos, w, h);
        
        CURRENT_SPEED = SPEED_DEFAULT;
    }
    
    @Override
    public void action_down(int index) {
        switch (index) {
            case 1:
                break;
            default:
                break;
        }
    }
    
    @Override
    public void action_up(int index) {
        switch (index) {
            case 1:
                break;
            default:
                break;
        }
    }
    
}
