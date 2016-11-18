/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.entities.pickups;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.entities.Entity;
import com.mygdx.utilities.FrameCounter;
import com.mygdx.utilities.sound.SoundObject_Sfx;
import static com.mygdx.utilities.UtilityVars.BIT_PICKUP;
import static com.mygdx.utilities.UtilityVars.BIT_PLAYER;
import static com.mygdx.utilities.UtilityVars.BIT_WALL;
import static com.mygdx.utilities.UtilityVars.PPM;

/**
 *
 * @author looch
 */
public abstract class Pickup extends Entity{
    
    protected Object name;
    protected String desc;
    protected boolean pickupComplete = false;
    
    protected FixtureDef solidfd;
    protected CircleShape sensorShape = new CircleShape();
    protected boolean canPickup = false;
    protected FrameCounter pickupFC = new FrameCounter(0.7f);
    protected boolean pickupInit = true;
    protected boolean flagSpawnForce = false;
    protected float spawnForceValue = 800f;
    protected Vector2 spawnDirection;
    
    protected final float Y_FLOATING_UP = 15f, Y_FLOATING_DOWN = 0;
    protected final float Y_AMMOUNT = 0.8f;
    protected float yfloat = 0;
    protected boolean floatUp = true;
    
    //sound
    protected SoundObject_Sfx pickupSound;
    
    public Object getName() { return name; }
    public boolean getCanPickup() { return canPickup; }
    
    public Pickup(Vector2 pos, float w, float h){
        super(pos,w,h);
        
        name = "fragment" + id;
        userdata = name;
        bd.position.set(pos.x/PPM,pos.y/PPM);
        bd.type = BodyDef.BodyType.DynamicBody;
        sensorShape.setRadius(width*1.50f/PPM);
        fd.shape = sensorShape;
        fd.filter.categoryBits = BIT_PICKUP;
        fd.filter.maskBits = BIT_PLAYER;
        fd.isSensor = true;
        
        solidfd = new FixtureDef();
        cshape.setRadius(width/PPM);
        solidfd.shape = cshape;
        solidfd.filter.categoryBits = BIT_PICKUP;
        solidfd.filter.maskBits = BIT_WALL | BIT_PICKUP;
    }
    
    //copy of pickup
    public Pickup(Pickup pickup){
        this(pickup.getPos(), pickup.getWidth(), pickup.getHeight());
    }
    

    @Override
    public void init(World world) {
        
        try {

            bd.position.set(pos.x / PPM, pos.y / PPM);//todo: soft code this somewhere else
            body = world.createBody(bd);
            body.createFixture(fd).setUserData(userdata);
            body.setUserData(userdata);
            body.createFixture(solidfd);
            body.setLinearDamping(5.0f);

            pickupFC.start(fm);
            pickupInit = true;

            if (flagSpawnForce) {

                if(spawnDirection == null){
                body.applyForceToCenter(
                        new Vector2(
                                (spawnForceValue * rng.nextFloat() * 0.5f + spawnForceValue) * rngNegSet.random(),
                                (spawnForceValue * rng.nextFloat() * 0.5f + spawnForceValue) * rngNegSet.random()),
                        true);
                }else{
                    body.applyForceToCenter(
                        new Vector2(
                                spawnDirection.x + (spawnForceValue * rng.nextFloat() * 0.5f + spawnForceValue) ,
                                spawnDirection.y + (spawnForceValue * rng.nextFloat() * 0.5f + spawnForceValue)) ,
                        true);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    @Override
    public void update(){
        super.update();
        
        yfloat = floatUp ? yfloat+ Y_AMMOUNT: yfloat - Y_AMMOUNT;
        if(yfloat > Y_FLOATING_UP && floatUp){
            floatUp = false;
        }else if(yfloat < 0 && !floatUp){
            floatUp = true;
        }
        
        if(pickupFC.complete && pickupInit) {
            canPickup = true;
            pickupInit = false;
        }
        
    }
    
    @Override
    public void render(SpriteBatch sb){
        
        if(isprite != null){
            isprite.sprite.setPosition(
                    (pos.x - isprite.sprite.getWidth() / 2),
                    (pos.y - isprite.sprite.getHeight() / 2));
            isprite.sprite.draw(sb);
        }else if(texture != null)
            sb.draw(texture, pos.x-iw/2, pos.y -ih/2 + yfloat, iw, ih);
        
        if(pickupComplete){
            deathAnim();
        }
        
        
    }
    
    @Override
    public void offsetRender(SpriteBatch sb, float x, float y){
        if(isprite != null){
            isprite.drawOffset(sb, 
                    pos.x - isprite.sprite.getWidth()/2 + x,
                    pos.y - isprite.sprite.getHeight()/2 + y);
        }else if(texture != null){
            sb.draw(
                    texture, 
                    pos.x - iw/2 + x,
                    pos.y - ih/2 + y + yfloat,
                    iw,ih);
        }
    }
    
    @Override
    public void alert(String[] str) {
        try {
            if (str[0].equals("begin") && str[1].equals(userdata.toString()) && canPickup) {
                System.out.println("@Pickup death alert ");
                canPickup = false;
                pickupComplete = true;

                //sound
                pickupSound.play(false);
            }
        } catch (IndexOutOfBoundsException ex) {
            ex.printStackTrace();
        }
    }
    
    
    public void deathAnim(){
        
        ih *= 0.7f;
        iw *= 1.3f;
        
        if(ih <= 5.0f){
            dispose();
        }
        
    }
    
    public void spawnForce(){
        flagSpawnForce = true;
    }
    
    public void spawnForce(Vector2 dir, float force){
        spawnForce();
        spawnDirection = dir;
        spawnForceValue = force;
    }
    
    public abstract Pickup cpy();
    
    
    
    
}
