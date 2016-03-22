/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.ai.DogTasks;

import com.badlogic.gdx.ai.btree.LeafTask;
import com.badlogic.gdx.ai.btree.Task;
import com.mygdx.entities.DynamicEntities.DogEntities.DogEntity;

/**
 *
 * @author looch
 */
public class Task_MoveToPlayer extends LeafTask<DogEntity>{

    @Override
    public void run(DogEntity dog) {
        
        //dog.moveTo(GameScreen.player.getBody().getPosition(),dog.getSpeed());
        dog.moveTo(dog.findClosestBody().getPosition(),dog.getSpeed());
        success();
    }

    @Override
    protected Task<DogEntity> copyTo(Task<DogEntity> task) {
        Task_MoveToPlayer moveTo = (Task_MoveToPlayer)task;
        return moveTo;
    }
    
}