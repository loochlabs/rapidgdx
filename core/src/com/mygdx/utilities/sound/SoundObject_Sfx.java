/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.utilities.sound;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.MainGame;

/**
 *
 * @author looch
 */
public class SoundObject_Sfx {
    
    public Sound sound;
    public long id;
    public float vol;
    
    private Vector2 pos;
    
    public SoundObject_Sfx(String str){
        sound = MainGame.am.get(str);
    }
    
    
    public void setVolume(float vol) { 
        this.vol = vol; 
        if(!SoundManager.muted){
            if(vol < 0){
                this.sound.setVolume(id,0);
            }else{
                this.sound.setVolume(id, vol);
            }
        }else{
            this.sound.setVolume(id, 0);
        }
    }
    
    
    public void play(boolean loop){
        id = SoundManager.addSfxSound(this, loop);
        this.setVolume(SoundManager.SFX_VOL);
    }
    
    
    public void stop(){
        sound.setVolume(id, 0f);
        sound.stop();
        SoundManager.removeSfxSound(this);
    }
    
    public void mute(){
        if(SoundManager.muted){
            sound.setVolume(id, 0);
        }else{
            sound.setVolume(id, vol);
        }
    }
    
    //Used for proximity volume
    public void update(Vector2 pos){
        if(pos == null) return;
        
        this.pos = pos;
        
        /*
        float dv = v.dst(pos);
        vol = 1 - dv/prox < 0 ? 0 : SoundManager.SFX_VOL * (1 - dv/prox);
        this.setVolume(vol);
        
        
        System.out.println("@SoundObject_Sfx id " + id + " vol: " + vol + " pos: " + pos.x + "," +pos.y);
*/
    }
    
}
