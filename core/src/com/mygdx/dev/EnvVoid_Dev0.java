/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.dev;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.combat.skills.Skill_Haymaker;
import com.mygdx.demo.demo2.EnvVoid_D2_1;
import com.mygdx.entities.DynamicEntities.DogEntities.MurphyEntity;
import com.mygdx.entities.DynamicEntities.DogEntities.StellaEntity;
import com.mygdx.entities.StaticEntities.SkillPad;
import com.mygdx.entities.StaticEntities.SkillPad_Primary;
import com.mygdx.entities.StaticEntities.breakable.Cyst_Blue;
import com.mygdx.entities.esprites.EntitySprite;
import com.mygdx.environments.EnvSub.pads.EndPad;
import com.mygdx.environments.EnvVoid.EnvVoid;
import com.mygdx.environments.EnvironmentManager;
import static com.mygdx.game.MainGame.RATIO;
import static com.mygdx.utilities.UtilityVars.PPM;

/**
 *
 * @author saynt
 */
public class EnvVoid_Dev0 extends EnvVoid{
    
    protected EndPad pad;
    protected int cyst_count = 4;
    
    public EnvVoid_Dev0(){
        super(-999, 2000f*RATIO, 2000f*RATIO, 1, "B");
        
        startPos = new Vector2(width*0.5f/PPM, height*0.5f/PPM);
        this.setPlayerToStart();
        
        introDescription = "Dev Hell";
        cyst_count = 2;
    }
    
    @Override
    public void init(){
        super.init();
        
        spawnPad();
    }
    
    public void spawnPad(){
    }
    
    
    @Override
    public void generateMisc(){
        super.generateMisc();
        
        //***************************************
        //      SPAWN CYSTS
        //************************************

        for (int i = 0; i < cyst_count; i++) {

            spawnEntity( new Cyst_Blue( new Vector2(createSpawnLocation())));

        }
        //***************************************************
        
        //bg sprites
        spawnEntity(new EntitySprite(new Vector2(0, grid.getHeight()*0.9f),
                        470f,200f,
                        "decom", 
                        true, false, false, false, 
                        1.0f * RATIO,
                        false, false));
        
        
        spawnEntity(new SkillPad_Primary(new Vector2(900f, 1200f)));
        spawnEntity(new SkillPad(new Vector2(1100f, 1200f), new Skill_Haymaker()));
    }
    
    
    
    @Override
    public void generateEndPad(){
        
    }
    
    @Override
    public void generateDogs(){
        //stella & murphy
        
        
        StellaEntity stella = 
                new StellaEntity(
                        new Vector2(150f*RATIO, 150f*RATIO));
        
        spawnEntity(stella);
        
        MurphyEntity murph = 
                new MurphyEntity(
                        new Vector2(150f*RATIO, 150f*RATIO));
        
        spawnEntity(murph);
        
    }
    
    
    @Override
    public void generateTears(){
        
        spawnEntity(new Tear_R_Dev0(new Vector2(1000f*RATIO,800f*RATIO), this.id));
        spawnEntity(new Tear_R_Dev0(new Vector2(800f*RATIO,800f*RATIO), this.id));
        spawnEntity(new Tear_R_Dev0(new Vector2(550f*RATIO,800f*RATIO), this.id));
        spawnEntity(new Tear_R_Dev0(new Vector2(300f*RATIO,800f*RATIO), this.id));
    }
    
    
    
    @Override
    public String toString(){
        return "DEMO2 EnvVoid 0";
    }
    
    private class EndPad_D2_0 extends EndPad {

        public EndPad_D2_0(Vector2 pos, int scount, int idwarp) {
            super(pos, scount, idwarp);
            
        }

        @Override
        public void complete(){
            super.complete();
            
            EnvironmentManager.add(new EnvVoid_D2_1(idwarp));
        }
    }
}