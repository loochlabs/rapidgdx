/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.entities.pickups;

import com.mygdx.entities.pickups.Pickup_Key;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.environments.EnvRoom.Wall_Lock;
import com.mygdx.entities.pickups.Pickup;
import com.mygdx.game.MainGame;
import com.mygdx.gui.descriptions.DescriptionWindow;
import com.mygdx.managers.ResourceManager;

/**
 *
 * @author looch
 */
public class Item_GlyphOne extends Pickup_Key{

    public Item_GlyphOne(Vector2 pos, float w, float h, Wall_Lock lock) {
        super(pos, w, h, lock);
        
        name = "Strange Glyph";
        texture = MainGame.am.get(ResourceManager.GLYPH_ONE);
        desc = "\"This seems to belong somewhere.\"";
        descWindow = new DescriptionWindow(""+name+"", desc, type, true);
        
        
    }
    
    @Override
    public Pickup cpy(){
        return new Item_GlyphOne(pos, width, height, lock);
    }
    
}