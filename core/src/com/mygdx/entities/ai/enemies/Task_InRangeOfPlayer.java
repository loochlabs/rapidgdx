/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.entities.ai.enemies;

import com.badlogic.gdx.ai.btree.LeafTask;
import com.badlogic.gdx.ai.btree.Task;
import com.mygdx.entities.DynamicEntities.enemies.EnemyEntity;

/**
 *
 * @author looch
 */
public class Task_InRangeOfPlayer extends LeafTask<EnemyEntity>{

    @Override
    public void run(EnemyEntity en) {
        if(en.inRangeOfPlayer()){
            en.removeWanderPos();
            this.success();
        }else{
            this.fail();
        }
    }

    @Override
    protected Task<EnemyEntity> copyTo(Task<EnemyEntity> task) {
        Task_InRangeOfPlayer moveTo = (Task_InRangeOfPlayer)task;
        return moveTo;
    }
    
}
