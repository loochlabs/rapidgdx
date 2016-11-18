/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.environments.EnvDefault;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mygdx.entities.enemies.EnemyManager;
import com.mygdx.entities.StaticEntities.BlankWall;
import com.mygdx.environments.Environment;
import com.mygdx.game.MainGame;
import static com.mygdx.game.MainGame.RATIO;
import com.mygdx.utilities.ResourceManager;
import static com.mygdx.utilities.UtilityVars.PPM;

/**
 *
 * @author looch
 */
public class EnvDefault extends Environment{
    
    private final Array<Vector2> spawns = new Array<Vector2>();
    
    public EnvDefault(int id, int linkid) {
        super(id);
        
        this.linkid = linkid;
        fg = MainGame.am.get(ResourceManager.DEFAULT_SQCOLOR);
        beginFC.setTime(0);
        
        /*
        Initial room settings
        */
        
        width = 5000*RATIO;
        height = 5000*RATIO;
        fgx = 0;
        fgy = 0;
        fgw = width;
        fgh = height;
        startPos = new Vector2(width*0.5f/PPM,height*0.2f/PPM);
        this.setPlayerToStart();
        
        
    }
    
    @Override
    public void init(){
        super.init();
        
        /*****************************************************
         *      INITIAL WALLS / ENVIRONMENT BOUNDARIES
         **************************************************/
        
        
        float border = 25f;
        
        spawnEntity(new BlankWall(new Vector2( (fgx) + width/2, height*0.1f),       width/2,  border));//south
        spawnEntity(new BlankWall(new Vector2( (fgx) + width/2, height*0.95f),  width/2,  border));//north
        spawnEntity(new BlankWall(new Vector2( (fgx) + width*0.92f, height/2),  border, height/2));//east
        spawnEntity(new BlankWall(new Vector2( (fgx) + width*0.08f, height/2),   border, height/2));//west
        
    }
    
}
