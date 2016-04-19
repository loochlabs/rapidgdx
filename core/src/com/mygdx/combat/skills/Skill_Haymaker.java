/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.combat.skills;

import static com.mygdx.combat.skills.Skill.SkillType.HEAVY;
import static com.mygdx.combat.skills.Skill.SkillType.LIGHT;
import com.mygdx.entities.ImageSprite;
import com.mygdx.game.MainGame;
import static com.mygdx.game.MainGame.RATIO;
import com.mygdx.gui.descriptions.DescriptionWindow;
import com.mygdx.managers.ResourceManager;
import com.mygdx.utilities.SoundObject_Sfx;

/**
 *
 * @author looch
 */
public class Skill_Haymaker extends HeavySkill{

    //private final float FORCE;
    
    public Skill_Haymaker(){
        name = "Haymaker";
        //type = HEAVY;
        //COST = 40.0f;
        damageMod = 1.55f;
        FORCE = 1400.0f;
        
        comboChain = new SkillType[] { HEAVY, LIGHT, HEAVY };
        
        desc = "More KNOCKBACK";
        descWindow = new DescriptionWindow(name, desc, comboChain);
        skillIcon = MainGame.am.get(ResourceManager.SKILL_ONETWO);
        
        
        impactTemplates.add(new ImageSprite("impact1", false));
        impactTemplates.get(0).sprite.setScale(1.4f*RATIO);
        impactTemplates.add(new ImageSprite("impact2", false));
        impactTemplates.get(1).sprite.setScale(1.4f*RATIO);
        
        
        skillSprite = new ImageSprite("heavy-att-red",false);
        skillSprite.sprite.setScale(0.5f*RATIO);
        
        impactSound = new SoundObject_Sfx(ResourceManager.SFX_IMPACT_2);
    }
    
    /*
    
    @Override 
    public void comboChainEffect(Skill prevSkill){
        
        float projDamage = GameScreen.player.getCurrentDamage() * GameScreen.player.getLightMod();
        float projSpeed = 3f;
        
        //if(prevSkill.getType() != type && prevSkill.getAttribute() == attribute){
            EnvironmentManager.currentEnv.spawnEntity(
                new PlayerProjectile_Haymaker(
                        new Vector2(
                                GameScreen.player.getBody().getPosition().x * PPM, 
                                GameScreen.player.getBody().getPosition().y * PPM),
                        30f*RATIO, 30f*RATIO,
                        new Vector2(1,1).scl(projSpeed),
                        projDamage));
            EnvironmentManager.currentEnv.spawnEntity(
                new PlayerProjectile_Haymaker(
                        new Vector2(
                                GameScreen.player.getBody().getPosition().x * PPM, 
                                GameScreen.player.getBody().getPosition().y * PPM),
                        30f*RATIO, 30f*RATIO,
                        new Vector2(1,-1).scl(projSpeed),
                        projDamage));
            EnvironmentManager.currentEnv.spawnEntity(
                new PlayerProjectile_Haymaker(
                        new Vector2(
                                GameScreen.player.getBody().getPosition().x * PPM, 
                                GameScreen.player.getBody().getPosition().y * PPM),
                        30f*RATIO, 30f*RATIO,
                        new Vector2(-1,1).scl(projSpeed),
                        projDamage));
            EnvironmentManager.currentEnv.spawnEntity(
                new PlayerProjectile_Haymaker(
                        new Vector2(
                                GameScreen.player.getBody().getPosition().x * PPM, 
                                GameScreen.player.getBody().getPosition().y * PPM),
                        30f*RATIO, 30f*RATIO,
                        new Vector2(-1,-1).scl(projSpeed),
                        projDamage));
        //}
    }
    
    @Override
    public void removeComboChainEffect(){
        comboChainCheck = false;
    }
    
    private class PlayerProjectile_Haymaker extends PlayerProjectile{
        
        public PlayerProjectile_Haymaker(Vector2 pos, float width, float height, Vector2 dir, float dmg) {
            super(pos, width, height, dir, dmg);
            
            texture = MainGame.am.get(ResourceManager.SKILL_ONETWO);
        }
        
    }
    
    */
}
