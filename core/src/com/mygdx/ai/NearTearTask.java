/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.ai;

import com.badlogic.gdx.ai.btree.LeafTask;
import com.badlogic.gdx.ai.btree.Task;
import com.mygdx.entities.DynamicEntities.DogEntities.DogEntity;
import com.mygdx.environments.tears.TearPortal;

/**
 *
 * @author looch
 */
public class NearTearTask extends LeafTask<DogEntity>{

    @Override
    public void run(DogEntity dog) {
        TearPortal tp = dog.isNearTear();
        if(tp != null){
            success();
        }else
            fail();
    }

    @Override
    protected Task<DogEntity> copyTo(Task<DogEntity> task) {
        NearTearTask near = (NearTearTask)task;
        return near;
    }
    
}