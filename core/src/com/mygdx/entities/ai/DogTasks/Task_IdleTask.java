/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.entities.ai.DogTasks;

import com.badlogic.gdx.ai.btree.LeafTask;
import com.badlogic.gdx.ai.btree.Task;
import com.mygdx.entities.DynamicEntities.DogEntities.DogEntity;

/**
 *
 * @author looch
 */
public class Task_IdleTask extends LeafTask<DogEntity>{

    @Override
    public void run(DogEntity dog) {
        /*
        if(dog.inIdleRange()){
            dog.idle();
            success();
        }else
            fail();
            */
    }

    @Override
    protected Task<DogEntity> copyTo(Task<DogEntity> task) {
        Task_IdleTask idle = (Task_IdleTask)task;
        return idle;
    }
    
    
}
