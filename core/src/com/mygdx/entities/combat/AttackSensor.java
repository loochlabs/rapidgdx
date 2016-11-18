/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.entities.combat;

import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.mygdx.entities.DynamicEntities.SteerableEntity;
import static com.mygdx.utilities.UtilityVars.BIT_ATT;
import static com.mygdx.utilities.UtilityVars.BIT_EN;
import static com.mygdx.utilities.UtilityVars.BIT_TEAR;

/**
 *
 * @author looch
 */
public abstract class AttackSensor extends FixtureDef{
    
    
    protected SteerableEntity parent;
    protected String data;
    
    public String getData() {return data;}
    
    
    public AttackSensor(SteerableEntity parent){
        
        this.parent = parent;
        this.filter.categoryBits = BIT_ATT;
        this.filter.maskBits = BIT_EN | BIT_TEAR;
        this.isSensor = true;
        
    }
    
    
}
