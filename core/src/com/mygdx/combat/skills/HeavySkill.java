/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.combat.skills;

import com.badlogic.gdx.math.Vector2;
import static com.mygdx.combat.skills.Skill.SkillType.HEAVY;
import com.mygdx.entities.Entity;
import com.mygdx.entities.ImageSprite;
import com.mygdx.entities.esprites.PermSprite;
import static com.mygdx.game.MainGame.RATIO;
import com.mygdx.screen.GameScreen;
import static com.mygdx.utilities.UtilityVars.PPM;

/**
 *
 * @author looch
 */
public abstract class HeavySkill extends Skill{

    public HeavySkill(){
        type = HEAVY;
        COST = 40.0f;
        
        prepTime = 0;
        attTime = 0.85f;
        recovTime = 0.2f;
        
        FORCE = 250.0f;
        
        skillSprite = new ImageSprite("poe-attack-heavy",false);
        skillSprite.sprite.setScale(0.35f*RATIO);
    }
    
    @Override
    public void effect(boolean isCombo, Skill prevSkill){
        reset();
        
        boolean playSound = false;
        
        //screen shake
        screenShake();
        
        
        for(Entity ent: GameScreen.player.getAttTargets()){
            
            //damage enemy
            damageEnemy(ent, isCombo, prevSkill);
            
            
            //force
            knockbackEnemy(ent);
            
            
            
            //impact sprites
            addImpactSprite(ent);
            
            
            playSound = true;
            
        }
        
        addBuff();
        
        if(playSound) impactSound.play(false);
        
        attackForce();
        
        //permanance sprite
        addPermSprite();
    }
    
    public void attackForce(){
        if (GameScreen.player.isUserMoving()) {
            Vector2 dir = GameScreen.player.getCurrentDirection().cpy();
            dir.scl(FORCE * 0.8f);
            GameScreen.player.getBody().applyForce(dir, GameScreen.player.getBody().getPosition(), true);
        }
    }
    
    public void screenShake() {
        if(!GameScreen.player.getAttTargets().isEmpty())
            GameScreen.camera.shake(6, 0.55f);
    }

    public void damageEnemy(Entity e, boolean combo, Skill prevSkill) {
        if (combo) {
            
            comboEffect(prevSkill);
            
            e.damage(
                    GameScreen.player.getCurrentDamage() * GameScreen.player.getHeavyMod() * damageMod * comboBonus,
                    true);
        } else {
            e.damage(GameScreen.player.getCurrentDamage() * GameScreen.player.getHeavyMod() * damageMod);
        }
    }
    
    public void comboEffect(Skill prevSkill){}

    public void knockbackEnemy(Entity e) {
        Vector2 dv = e.getBody().getPosition().sub(GameScreen.player.getBody().getPosition()).cpy().nor();
        e.getBody().applyForce(dv.scl(FORCE), e.getBody().getPosition(), true);
    }

    public void addImpactSprite(Entity e) {
        ImageSprite isprite = new ImageSprite(impactTemplates.get(rng.nextInt(impactTemplates.size)));

        //flip sprite
        if (GameScreen.player.getBody().getPosition().x < e.getBody().getPosition().x) {
            isprite.setXFlip(true);
        }

        GameScreen.player.addImpactSprite(e.getBody().getPosition().x * PPM - isprite.sprite.getWidth() / 2,
                e.getBody().getPosition().y * PPM - isprite.sprite.getHeight() / 2,
                isprite);
    }

    public void addBuff() {}

    public void addPermSprite() {
        PermSprite p = new PermSprite("perm2",
                new Vector2(
                        GameScreen.player.getBody().getPosition().x * PPM,
                        GameScreen.player.getBody().getPosition().y * PPM));
        p.start();
    }
}
