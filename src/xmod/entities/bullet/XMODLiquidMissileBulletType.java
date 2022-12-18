package xmod.entities.bullet;

import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.entities.bullet.*;

import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import arc.util.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.entities.*;
import mindustry.gen.*;
import mindustry.type.*;
import mindustry.world.*;
import xmod.content.XLiquids;
import xmod.entities.bullet.*;

import static mindustry.Vars.*;

public class XMODLiquidMissileBulletType extends BasicBulletType{
    public Liquid liquid;
    public float puddleSize = 6f;
    public float puddleAmount = 50f;
    // public float puddleRange1 = tilesize * 3f;
    public float puddleRange025 = tilesize * 0.25f;
    public float puddleRange050 = tilesize * 0.50f;
    public float puddleRange075 = tilesize * 0.75f;
    public float puddleRange100 = tilesize * 1f;
    public float puddleRange125 = tilesize * 1.25f;
    public float puddleRange150 = tilesize * 1.50f;
    public float puddleRange175 = tilesize * 1.75f;
    public float puddleRange300 = tilesize * 3f;
    // public float puddleRange15 = tilesize * 1.5f;
    // public float temp = + puddleRange15;
    public float boilTime = 5f;

    public XMODLiquidMissileBulletType(@Nullable Liquid liquid, float speed, float damage, String bulletSprite){
        super(speed, damage, bulletSprite);

        if(liquid != null){
            this.liquid = liquid;
            this.status = liquid.effect;
            hitColor = liquid.color;
            lightColor = liquid.lightColor;
            lightOpacity = liquid.lightColor.a;
        }

        backColor = Pal.missileYellowBack;
        frontColor = Pal.missileYellow;
        homingPower = 0.08f;
        shrinkY = 0f;
        width = 8f;
        height = 8f;
        hitSound = Sounds.explosion;
        trailChance = 0.2f;
        lifetime = 52f;
    }

    public XMODLiquidMissileBulletType(Liquid liquid, float speed, float damage){
        this(liquid, speed, damage, "missile");
    }

    public XMODLiquidMissileBulletType(Liquid liquid){
        this(liquid, 1f, 1f, "missile");
    }

    @Override
    public void update(Bullet b){
        super.update(b);

        if(liquid.willBoil() && b.time >= Mathf.randomSeed(b.id, boilTime)){
            Fx.vaporSmall.at(b.x, b.y, liquid.gasColor);
            b.remove();
            return;
        }

        if(liquid.canExtinguish()){
            Tile tile = world.tileWorld(b.x, b.y);
            if(tile != null && Fires.has(tile.x, tile.y)){
                Fires.extinguish(tile, 100f);
                b.remove();
                hit(b);
            }
        }
    }

    // @Override
    // public void despawned(Bullet b, float x, float y){
    //     super.hit(b, x, y);

    //     createPuddles(b, x, y);
    //     //don't create liquids when the projectile despawns
    //     // if(!liquid.willBoil()){
    //     //     hitEffect.at(b.x, b.y, b.rotation(), liquid.color);
    //     // }
    // }

    @Override
    public void despawned(Bullet b){
        
        Puddles.deposit(Vars.world.tileWorld(b.x, b.y), liquid, puddleAmount);

        Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange025, b.y + puddleRange025), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange025, b.y - puddleRange025), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x - puddleRange025, b.y + puddleRange025), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x - puddleRange025, b.y - puddleRange025), liquid, puddleAmount);
        
        Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange050, b.y + puddleRange050), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange050, b.y - puddleRange050), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x - puddleRange050, b.y + puddleRange050), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x - puddleRange050, b.y - puddleRange050), liquid, puddleAmount);

        Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange075, b.y + puddleRange075), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange075, b.y - puddleRange075), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x - puddleRange075, b.y + puddleRange075), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x - puddleRange075, b.y - puddleRange075), liquid, puddleAmount);

        Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange100, b.y + puddleRange100), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange100, b.y - puddleRange100), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x - puddleRange100, b.y + puddleRange100), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x - puddleRange100, b.y - puddleRange100), liquid, puddleAmount);

        Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange125, b.y + puddleRange125), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange125, b.y - puddleRange125), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x - puddleRange125, b.y + puddleRange125), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x - puddleRange125, b.y - puddleRange125), liquid, puddleAmount);


        
        Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300, b.y + puddleRange300), liquid, puddleAmount);

        Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300 + puddleRange025, b.y + puddleRange300 + puddleRange025), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300 + puddleRange025, b.y + puddleRange300 - puddleRange025), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300 - puddleRange025, b.y + puddleRange300 + puddleRange025), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300 - puddleRange025, b.y + puddleRange300 - puddleRange025), liquid, puddleAmount);

        Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300 + puddleRange050, b.y + puddleRange300 + puddleRange050), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300 + puddleRange050, b.y + puddleRange300 - puddleRange050), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300 - puddleRange050, b.y + puddleRange300 + puddleRange050), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300 - puddleRange050, b.y + puddleRange300 - puddleRange050), liquid, puddleAmount);

        Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300 + puddleRange075, b.y + puddleRange300 + puddleRange075), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300 + puddleRange075, b.y + puddleRange300 - puddleRange075), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300 - puddleRange075, b.y + puddleRange300 + puddleRange075), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300 - puddleRange075, b.y + puddleRange300 - puddleRange075), liquid, puddleAmount);

        Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300 + puddleRange100, b.y + puddleRange300 + puddleRange100), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300 + puddleRange100, b.y + puddleRange300 - puddleRange100), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300 - puddleRange100, b.y + puddleRange300 + puddleRange100), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300 - puddleRange100, b.y + puddleRange300 - puddleRange100), liquid, puddleAmount);

        Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300 + puddleRange125, b.y + puddleRange300 + puddleRange125), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300 + puddleRange125, b.y + puddleRange300 - puddleRange125), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300 - puddleRange125, b.y + puddleRange300 + puddleRange125), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300 - puddleRange125, b.y + puddleRange300 - puddleRange125), liquid, puddleAmount);



        Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300, b.y - puddleRange300), liquid, puddleAmount);

        Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300 + puddleRange025, b.y - puddleRange300 + puddleRange025), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300 + puddleRange025, b.y - puddleRange300 - puddleRange025), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300 - puddleRange025, b.y - puddleRange300 + puddleRange025), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300 - puddleRange025, b.y - puddleRange300 - puddleRange025), liquid, puddleAmount);

        Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300 + puddleRange050, b.y - puddleRange300 + puddleRange050), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300 + puddleRange050, b.y - puddleRange300 - puddleRange050), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300 - puddleRange050, b.y - puddleRange300 + puddleRange050), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300 - puddleRange050, b.y - puddleRange300 - puddleRange050), liquid, puddleAmount);

        Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300 + puddleRange075, b.y - puddleRange300 + puddleRange075), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300 + puddleRange075, b.y - puddleRange300 - puddleRange075), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300 - puddleRange075, b.y - puddleRange300 + puddleRange075), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300 - puddleRange075, b.y - puddleRange300 - puddleRange075), liquid, puddleAmount);

        Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300 + puddleRange100, b.y - puddleRange300 + puddleRange100), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300 + puddleRange100, b.y - puddleRange300 - puddleRange100), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300 - puddleRange100, b.y - puddleRange300 + puddleRange100), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300 - puddleRange100, b.y - puddleRange300 - puddleRange100), liquid, puddleAmount);

        Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300 + puddleRange125, b.y - puddleRange300 + puddleRange125), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300 + puddleRange125, b.y - puddleRange300 - puddleRange125), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300 - puddleRange125, b.y - puddleRange300 + puddleRange125), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300 - puddleRange125, b.y - puddleRange300 - puddleRange125), liquid, puddleAmount);



        Puddles.deposit(Vars.world.tileWorld(b.x - puddleRange300, b.y + puddleRange300), liquid, puddleAmount);

        Puddles.deposit(Vars.world.tileWorld(b.x - puddleRange300 + puddleRange025, b.y + puddleRange300 + puddleRange025), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x - puddleRange300 + puddleRange025, b.y + puddleRange300 - puddleRange025), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x - puddleRange300 - puddleRange025, b.y + puddleRange300 + puddleRange025), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x - puddleRange300 - puddleRange025, b.y + puddleRange300 - puddleRange025), liquid, puddleAmount);

        Puddles.deposit(Vars.world.tileWorld(b.x - puddleRange300 + puddleRange050, b.y + puddleRange300 + puddleRange050), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x - puddleRange300 + puddleRange050, b.y + puddleRange300 - puddleRange050), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x - puddleRange300 - puddleRange050, b.y + puddleRange300 + puddleRange050), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x - puddleRange300 - puddleRange050, b.y + puddleRange300 - puddleRange050), liquid, puddleAmount);

        Puddles.deposit(Vars.world.tileWorld(b.x - puddleRange300 + puddleRange075, b.y + puddleRange300 + puddleRange075), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x - puddleRange300 + puddleRange075, b.y + puddleRange300 - puddleRange075), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x - puddleRange300 - puddleRange075, b.y + puddleRange300 + puddleRange075), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x - puddleRange300 - puddleRange075, b.y + puddleRange300 - puddleRange075), liquid, puddleAmount);

        Puddles.deposit(Vars.world.tileWorld(b.x - puddleRange300 + puddleRange100, b.y + puddleRange300 + puddleRange100), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x - puddleRange300 + puddleRange100, b.y + puddleRange300 - puddleRange100), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x - puddleRange300 - puddleRange100, b.y + puddleRange300 + puddleRange100), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x - puddleRange300 - puddleRange100, b.y + puddleRange300 - puddleRange100), liquid, puddleAmount);

        Puddles.deposit(Vars.world.tileWorld(b.x - puddleRange300 + puddleRange125, b.y + puddleRange300 + puddleRange125), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x - puddleRange300 + puddleRange125, b.y + puddleRange300 - puddleRange125), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x - puddleRange300 - puddleRange125, b.y + puddleRange300 + puddleRange125), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x - puddleRange300 - puddleRange125, b.y + puddleRange300 - puddleRange125), liquid, puddleAmount);



        Puddles.deposit(Vars.world.tileWorld(b.x - puddleRange300, b.y - puddleRange300), liquid, puddleAmount);

        Puddles.deposit(Vars.world.tileWorld(b.x - puddleRange300 + puddleRange025, b.y - puddleRange300 + puddleRange025), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x - puddleRange300 + puddleRange025, b.y - puddleRange300 - puddleRange025), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x - puddleRange300 - puddleRange025, b.y - puddleRange300 + puddleRange025), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x - puddleRange300 - puddleRange025, b.y - puddleRange300 - puddleRange025), liquid, puddleAmount);

        Puddles.deposit(Vars.world.tileWorld(b.x - puddleRange300 + puddleRange050, b.y - puddleRange300 + puddleRange050), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x - puddleRange300 + puddleRange050, b.y - puddleRange300 - puddleRange050), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x - puddleRange300 - puddleRange050, b.y - puddleRange300 + puddleRange050), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x - puddleRange300 - puddleRange050, b.y - puddleRange300 - puddleRange050), liquid, puddleAmount);

        Puddles.deposit(Vars.world.tileWorld(b.x - puddleRange300 + puddleRange075, b.y - puddleRange300 + puddleRange075), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x - puddleRange300 + puddleRange075, b.y - puddleRange300 - puddleRange075), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x - puddleRange300 - puddleRange075, b.y - puddleRange300 + puddleRange075), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x - puddleRange300 - puddleRange075, b.y - puddleRange300 - puddleRange075), liquid, puddleAmount);

        Puddles.deposit(Vars.world.tileWorld(b.x - puddleRange300 + puddleRange100, b.y - puddleRange300 + puddleRange100), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x - puddleRange300 + puddleRange100, b.y - puddleRange300 - puddleRange100), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x - puddleRange300 - puddleRange100, b.y - puddleRange300 + puddleRange100), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x - puddleRange300 - puddleRange100, b.y - puddleRange300 - puddleRange100), liquid, puddleAmount);

        Puddles.deposit(Vars.world.tileWorld(b.x - puddleRange300 + puddleRange125, b.y - puddleRange300 + puddleRange125), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x - puddleRange300 + puddleRange125, b.y - puddleRange300 - puddleRange125), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x - puddleRange300 - puddleRange125, b.y - puddleRange300 + puddleRange125), liquid, puddleAmount);
        Puddles.deposit(Vars.world.tileWorld(b.x - puddleRange300 - puddleRange125, b.y - puddleRange300 - puddleRange125), liquid, puddleAmount);



        
        // Puddles.deposit(Vars.world.tileWorld(b.x + Mathf.random(puddleRange300) + puddleRange15, b.y + Mathf.random(puddleRange300) + puddleRange15), liquid, puddleAmount);
        // Puddles.deposit(Vars.world.tileWorld(b.x + Mathf.random(puddleRange300) + puddleRange15, b.y + Mathf.random(puddleRange300) + puddleRange15), liquid, puddleAmount);
        // Puddles.deposit(Vars.world.tileWorld(b.x + Mathf.random(puddleRange300) + puddleRange15, b.y + Mathf.random(puddleRange300) + puddleRange15), liquid, puddleAmount);
        // Puddles.deposit(Vars.world.tileWorld(b.x + Mathf.random(puddleRange300) + puddleRange15, b.y + Mathf.random(puddleRange300) + puddleRange15), liquid, puddleAmount);
        // Puddles.deposit(Vars.world.tileWorld(b.x + Mathf.random(puddleRange300) + puddleRange15, b.y + Mathf.random(puddleRange300) + puddleRange15), liquid, puddleAmount);
        
        // Puddles.deposit(Vars.world.tileWorld(b.x + Mathf.random(puddleRange300) + puddleRange15, b.y - Mathf.random(puddleRange300) - puddleRange15), liquid, puddleAmount);
        // Puddles.deposit(Vars.world.tileWorld(b.x + Mathf.random(puddleRange300) + puddleRange15, b.y - Mathf.random(puddleRange300) - puddleRange15), liquid, puddleAmount);
        // Puddles.deposit(Vars.world.tileWorld(b.x + Mathf.random(puddleRange300) + puddleRange15, b.y - Mathf.random(puddleRange300) - puddleRange15), liquid, puddleAmount);
        // Puddles.deposit(Vars.world.tileWorld(b.x + Mathf.random(puddleRange300) + puddleRange15, b.y - Mathf.random(puddleRange300) - puddleRange15), liquid, puddleAmount);
        // Puddles.deposit(Vars.world.tileWorld(b.x + Mathf.random(puddleRange300) + puddleRange15, b.y - Mathf.random(puddleRange300) - puddleRange15), liquid, puddleAmount);
        
        // Puddles.deposit(Vars.world.tileWorld(b.x - Mathf.random(puddleRange300) - puddleRange15, b.y + Mathf.random(puddleRange300) + puddleRange15), liquid, puddleAmount);
        // Puddles.deposit(Vars.world.tileWorld(b.x - Mathf.random(puddleRange300) - puddleRange15, b.y + Mathf.random(puddleRange300) + puddleRange15), liquid, puddleAmount);
        // Puddles.deposit(Vars.world.tileWorld(b.x - Mathf.random(puddleRange300) - puddleRange15, b.y + Mathf.random(puddleRange300) + puddleRange15), liquid, puddleAmount);
        // Puddles.deposit(Vars.world.tileWorld(b.x - Mathf.random(puddleRange300) - puddleRange15, b.y + Mathf.random(puddleRange300) + puddleRange15), liquid, puddleAmount);
        // Puddles.deposit(Vars.world.tileWorld(b.x - Mathf.random(puddleRange300) - puddleRange15, b.y + Mathf.random(puddleRange300) + puddleRange15), liquid, puddleAmount);
        
        // Puddles.deposit(Vars.world.tileWorld(b.x - Mathf.random(puddleRange300) - puddleRange15, b.y - Mathf.random(puddleRange300) - puddleRange15), liquid, puddleAmount);
        // Puddles.deposit(Vars.world.tileWorld(b.x - Mathf.random(puddleRange300) - puddleRange15, b.y - Mathf.random(puddleRange300) - puddleRange15), liquid, puddleAmount);
        // Puddles.deposit(Vars.world.tileWorld(b.x - Mathf.random(puddleRange300) - puddleRange15, b.y - Mathf.random(puddleRange300) - puddleRange15), liquid, puddleAmount);
        // Puddles.deposit(Vars.world.tileWorld(b.x - Mathf.random(puddleRange300) - puddleRange15, b.y - Mathf.random(puddleRange300) - puddleRange15), liquid, puddleAmount);
        // Puddles.deposit(Vars.world.tileWorld(b.x - Mathf.random(puddleRange300) - puddleRange15, b.y - Mathf.random(puddleRange300) - puddleRange15), liquid, puddleAmount);


        // Puddles.deposit(Vars.world.tileWorld(b.x, b.y), liquid, puddleAmount);
        // Puddles.deposit(Vars.world.tileWorld(b.x, b.y), liquid, puddleAmount);

        // Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange1, b.y + puddleRange1), liquid, puddleAmount);
        // Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange1, b.y + puddleRange1), liquid, puddleAmount);

        // Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange2, b.y + puddleRange2), liquid, puddleAmount);
        // Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange2, b.y + puddleRange2), liquid, puddleAmount);

        // Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange2, b.y + puddleRange2), liquid, puddleAmount);
        // Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange2, b.y + puddleRange2), liquid, puddleAmount);





        // Puddles.deposit(Vars.world.tileWorld(b.x + Mathf.random(puddleRange - tilesize * 1f), b.y + Mathf.random(puddleRange - tilesize * 1f)), liquid, puddleAmount);
        // Puddles.deposit(Vars.world.tileWorld(b.x + Mathf.random(puddleRange - tilesize * 1f), b.y + Mathf.random(puddleRange - tilesize * 1f)), liquid, puddleAmount);
        
        // Puddles.deposit(Vars.world.tileWorld(b.x + Mathf.random(puddleRange - tilesize * 2f), b.y + Mathf.random(puddleRange - tilesize * 2f)), liquid, puddleAmount);
        // Puddles.deposit(Vars.world.tileWorld(b.x + Mathf.random(puddleRange - tilesize * 2f), b.y + Mathf.random(puddleRange - tilesize * 2f)), liquid, puddleAmount);
        
        // Puddles.deposit(Vars.world.tileWorld(b.x + Mathf.random(puddleRange - tilesize * 3f), b.y + Mathf.random(puddleRange - tilesize * 3f)), liquid, puddleAmount);
        // Puddles.deposit(Vars.world.tileWorld(b.x + Mathf.random(puddleRange - tilesize * 3f), b.y + Mathf.random(puddleRange - tilesize * 3f)), liquid, puddleAmount);

        // Puddles.deposit(Vars.world.tileWorld(b.x + Mathf.random(puddleRange - tilesize * 4f), b.y + Mathf.random(puddleRange - tilesize * 4f)), liquid, puddleAmount);
        // Puddles.deposit(Vars.world.tileWorld(b.x + Mathf.random(puddleRange - tilesize * 4f), b.y + Mathf.random(puddleRange - tilesize * 4f)), liquid, puddleAmount);

        // Puddles.deposit(Vars.world.tileWorld(b.x + Mathf.random(puddleRange - tilesize * 5f), b.y + Mathf.random(puddleRange - tilesize * 5f)), liquid, puddleAmount);
        // Puddles.deposit(Vars.world.tileWorld(b.x + Mathf.random(puddleRange - tilesize * 5f), b.y + Mathf.random(puddleRange - tilesize * 5f)), liquid, puddleAmount);

        // Tile tile = world.tileWorld(b.x + Mathf.range(puddleRange), b.y + Mathf.range(puddleRange));
        // Puddles.deposit(tile, liquid, puddleAmount);
        //don't create liquids when the projectile despawns
        // if(!liquid.willBoil()){
        //     hitEffect.at(b.x, b.y, b.rotation(), liquid.color);
        // }
    }

    @Override
    public void hit(Bullet b, float hitx, float hity){
        despawnEffect.at(hitx, hity, liquid.color);
        Puddles.deposit(world.tileWorld(hitx, hity), liquid, puddleAmount);

        if(liquid.temperature <= 0.5f && liquid.flammability < 0.3f){
            float intensity = 400f * puddleSize/6f;
            Fires.extinguish(world.tileWorld(hitx, hity), intensity);
            for(Point2 p : Geometry.d4){
                Fires.extinguish(world.tileWorld(hitx + p.x * tilesize, hity + p.y * tilesize), intensity);
            }
        }
    }
}

// @Override
//     public void despawned(Bullet b){

//         for (int i=0; i<4;i++) {
//             Puddles.deposit(Vars.world.tileWorld(b.x, b.y), liquid, puddleAmount);
//             Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange025, b.y + puddleRange025), liquid, puddleAmount);
//             Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange050, b.y + puddleRange050), liquid, puddleAmount);
//             Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange075, b.y + puddleRange075), liquid, puddleAmount);
//             Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange100, b.y + puddleRange100), liquid, puddleAmount);
//             Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange125, b.y + puddleRange125), liquid, puddleAmount);


//         }
        
//         for (int i=0; i<4;i++) {
//             Puddles.deposit(Vars.world.tileWorld(b.x, b.y), liquid, puddleAmount);
//         }
//         Puddles.deposit(Vars.world.tileWorld(b.x, b.y), liquid, puddleAmount);
//         Puddles.deposit(Vars.world.tileWorld(b.x, b.y), liquid, puddleAmount);
//         Puddles.deposit(Vars.world.tileWorld(b.x, b.y), liquid, puddleAmount);


//         for (int i=0; i<4;i++) {
//             Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange025, b.y + puddleRange025), liquid, puddleAmount);
//         }
//         Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange025, b.y - puddleRange025), liquid, puddleAmount);
//         Puddles.deposit(Vars.world.tileWorld(b.x - puddleRange025, b.y + puddleRange025), liquid, puddleAmount);
//         Puddles.deposit(Vars.world.tileWorld(b.x - puddleRange025, b.y - puddleRange025), liquid, puddleAmount);


//         for (int i=0; i<4;i++) {
//             Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange050, b.y + puddleRange050), liquid, puddleAmount);
//         }
//         Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange050, b.y - puddleRange050), liquid, puddleAmount);
//         Puddles.deposit(Vars.world.tileWorld(b.x - puddleRange050, b.y + puddleRange050), liquid, puddleAmount);
//         Puddles.deposit(Vars.world.tileWorld(b.x - puddleRange050, b.y - puddleRange050), liquid, puddleAmount);


//         for (int i=0; i<4;i++) {
//             Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange075, b.y + puddleRange075), liquid, puddleAmount);
//         }
//         Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange075, b.y - puddleRange075), liquid, puddleAmount);
//         Puddles.deposit(Vars.world.tileWorld(b.x - puddleRange075, b.y + puddleRange075), liquid, puddleAmount);
//         Puddles.deposit(Vars.world.tileWorld(b.x - puddleRange075, b.y - puddleRange075), liquid, puddleAmount);


//         for (int i=0; i<4;i++) {
//             Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange100, b.y + puddleRange100), liquid, puddleAmount);
//         }
//         Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange100, b.y - puddleRange100), liquid, puddleAmount);
//         Puddles.deposit(Vars.world.tileWorld(b.x - puddleRange100, b.y + puddleRange100), liquid, puddleAmount);
//         Puddles.deposit(Vars.world.tileWorld(b.x - puddleRange100, b.y - puddleRange100), liquid, puddleAmount);


//         for (int i=0; i<4;i++) {
//             Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange125, b.y + puddleRange125), liquid, puddleAmount);
//         }
//         Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange125, b.y - puddleRange125), liquid, puddleAmount);
//         Puddles.deposit(Vars.world.tileWorld(b.x - puddleRange125, b.y + puddleRange125), liquid, puddleAmount);
//         Puddles.deposit(Vars.world.tileWorld(b.x - puddleRange125, b.y - puddleRange125), liquid, puddleAmount);


        
//         Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300, b.y + puddleRange300), liquid, puddleAmount);
//         Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300, b.y + puddleRange300), liquid, puddleAmount);
//         Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300, b.y + puddleRange300), liquid, puddleAmount);
//         Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300, b.y + puddleRange300), liquid, puddleAmount);

//         Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300 + puddleRange025, b.y + puddleRange300 + puddleRange025), liquid, puddleAmount);
//         Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300 + puddleRange025, b.y + puddleRange300 - puddleRange025), liquid, puddleAmount);
//         Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300 - puddleRange025, b.y + puddleRange300 + puddleRange025), liquid, puddleAmount);
//         Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300 - puddleRange025, b.y + puddleRange300 - puddleRange025), liquid, puddleAmount);

//         Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300 + puddleRange050, b.y + puddleRange300 + puddleRange050), liquid, puddleAmount);
//         Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300 + puddleRange050, b.y + puddleRange300 - puddleRange050), liquid, puddleAmount);
//         Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300 - puddleRange050, b.y + puddleRange300 + puddleRange050), liquid, puddleAmount);
//         Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300 - puddleRange050, b.y + puddleRange300 - puddleRange050), liquid, puddleAmount);

//         Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300 + puddleRange075, b.y + puddleRange300 + puddleRange075), liquid, puddleAmount);
//         Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300 + puddleRange075, b.y + puddleRange300 - puddleRange075), liquid, puddleAmount);
//         Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300 - puddleRange075, b.y + puddleRange300 + puddleRange075), liquid, puddleAmount);
//         Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300 - puddleRange075, b.y + puddleRange300 - puddleRange075), liquid, puddleAmount);

//         Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300 + puddleRange100, b.y + puddleRange300 + puddleRange100), liquid, puddleAmount);
//         Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300 + puddleRange100, b.y + puddleRange300 - puddleRange100), liquid, puddleAmount);
//         Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300 - puddleRange100, b.y + puddleRange300 + puddleRange100), liquid, puddleAmount);
//         Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300 - puddleRange100, b.y + puddleRange300 - puddleRange100), liquid, puddleAmount);

//         Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300 + puddleRange125, b.y + puddleRange300 + puddleRange125), liquid, puddleAmount);
//         Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300 + puddleRange125, b.y + puddleRange300 - puddleRange125), liquid, puddleAmount);
//         Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300 - puddleRange125, b.y + puddleRange300 + puddleRange125), liquid, puddleAmount);
//         Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange300 - puddleRange125, b.y + puddleRange300 - puddleRange125), liquid, puddleAmount);



        
//         // Puddles.deposit(Vars.world.tileWorld(b.x + Mathf.random(puddleRange300) + puddleRange15, b.y + Mathf.random(puddleRange300) + puddleRange15), liquid, puddleAmount);
//         // Puddles.deposit(Vars.world.tileWorld(b.x + Mathf.random(puddleRange300) + puddleRange15, b.y + Mathf.random(puddleRange300) + puddleRange15), liquid, puddleAmount);
//         // Puddles.deposit(Vars.world.tileWorld(b.x + Mathf.random(puddleRange300) + puddleRange15, b.y + Mathf.random(puddleRange300) + puddleRange15), liquid, puddleAmount);
//         // Puddles.deposit(Vars.world.tileWorld(b.x + Mathf.random(puddleRange300) + puddleRange15, b.y + Mathf.random(puddleRange300) + puddleRange15), liquid, puddleAmount);
//         // Puddles.deposit(Vars.world.tileWorld(b.x + Mathf.random(puddleRange300) + puddleRange15, b.y + Mathf.random(puddleRange300) + puddleRange15), liquid, puddleAmount);
        
//         // Puddles.deposit(Vars.world.tileWorld(b.x + Mathf.random(puddleRange300) + puddleRange15, b.y - Mathf.random(puddleRange300) - puddleRange15), liquid, puddleAmount);
//         // Puddles.deposit(Vars.world.tileWorld(b.x + Mathf.random(puddleRange300) + puddleRange15, b.y - Mathf.random(puddleRange300) - puddleRange15), liquid, puddleAmount);
//         // Puddles.deposit(Vars.world.tileWorld(b.x + Mathf.random(puddleRange300) + puddleRange15, b.y - Mathf.random(puddleRange300) - puddleRange15), liquid, puddleAmount);
//         // Puddles.deposit(Vars.world.tileWorld(b.x + Mathf.random(puddleRange300) + puddleRange15, b.y - Mathf.random(puddleRange300) - puddleRange15), liquid, puddleAmount);
//         // Puddles.deposit(Vars.world.tileWorld(b.x + Mathf.random(puddleRange300) + puddleRange15, b.y - Mathf.random(puddleRange300) - puddleRange15), liquid, puddleAmount);
        
//         // Puddles.deposit(Vars.world.tileWorld(b.x - Mathf.random(puddleRange300) - puddleRange15, b.y + Mathf.random(puddleRange300) + puddleRange15), liquid, puddleAmount);
//         // Puddles.deposit(Vars.world.tileWorld(b.x - Mathf.random(puddleRange300) - puddleRange15, b.y + Mathf.random(puddleRange300) + puddleRange15), liquid, puddleAmount);
//         // Puddles.deposit(Vars.world.tileWorld(b.x - Mathf.random(puddleRange300) - puddleRange15, b.y + Mathf.random(puddleRange300) + puddleRange15), liquid, puddleAmount);
//         // Puddles.deposit(Vars.world.tileWorld(b.x - Mathf.random(puddleRange300) - puddleRange15, b.y + Mathf.random(puddleRange300) + puddleRange15), liquid, puddleAmount);
//         // Puddles.deposit(Vars.world.tileWorld(b.x - Mathf.random(puddleRange300) - puddleRange15, b.y + Mathf.random(puddleRange300) + puddleRange15), liquid, puddleAmount);
        
//         // Puddles.deposit(Vars.world.tileWorld(b.x - Mathf.random(puddleRange300) - puddleRange15, b.y - Mathf.random(puddleRange300) - puddleRange15), liquid, puddleAmount);
//         // Puddles.deposit(Vars.world.tileWorld(b.x - Mathf.random(puddleRange300) - puddleRange15, b.y - Mathf.random(puddleRange300) - puddleRange15), liquid, puddleAmount);
//         // Puddles.deposit(Vars.world.tileWorld(b.x - Mathf.random(puddleRange300) - puddleRange15, b.y - Mathf.random(puddleRange300) - puddleRange15), liquid, puddleAmount);
//         // Puddles.deposit(Vars.world.tileWorld(b.x - Mathf.random(puddleRange300) - puddleRange15, b.y - Mathf.random(puddleRange300) - puddleRange15), liquid, puddleAmount);
//         // Puddles.deposit(Vars.world.tileWorld(b.x - Mathf.random(puddleRange300) - puddleRange15, b.y - Mathf.random(puddleRange300) - puddleRange15), liquid, puddleAmount);


//         // Puddles.deposit(Vars.world.tileWorld(b.x, b.y), liquid, puddleAmount);
//         // Puddles.deposit(Vars.world.tileWorld(b.x, b.y), liquid, puddleAmount);

//         // Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange1, b.y + puddleRange1), liquid, puddleAmount);
//         // Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange1, b.y + puddleRange1), liquid, puddleAmount);

//         // Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange2, b.y + puddleRange2), liquid, puddleAmount);
//         // Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange2, b.y + puddleRange2), liquid, puddleAmount);

//         // Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange2, b.y + puddleRange2), liquid, puddleAmount);
//         // Puddles.deposit(Vars.world.tileWorld(b.x + puddleRange2, b.y + puddleRange2), liquid, puddleAmount);





//         // Puddles.deposit(Vars.world.tileWorld(b.x + Mathf.random(puddleRange - tilesize * 1f), b.y + Mathf.random(puddleRange - tilesize * 1f)), liquid, puddleAmount);
//         // Puddles.deposit(Vars.world.tileWorld(b.x + Mathf.random(puddleRange - tilesize * 1f), b.y + Mathf.random(puddleRange - tilesize * 1f)), liquid, puddleAmount);
        
//         // Puddles.deposit(Vars.world.tileWorld(b.x + Mathf.random(puddleRange - tilesize * 2f), b.y + Mathf.random(puddleRange - tilesize * 2f)), liquid, puddleAmount);
//         // Puddles.deposit(Vars.world.tileWorld(b.x + Mathf.random(puddleRange - tilesize * 2f), b.y + Mathf.random(puddleRange - tilesize * 2f)), liquid, puddleAmount);
        
//         // Puddles.deposit(Vars.world.tileWorld(b.x + Mathf.random(puddleRange - tilesize * 3f), b.y + Mathf.random(puddleRange - tilesize * 3f)), liquid, puddleAmount);
//         // Puddles.deposit(Vars.world.tileWorld(b.x + Mathf.random(puddleRange - tilesize * 3f), b.y + Mathf.random(puddleRange - tilesize * 3f)), liquid, puddleAmount);

//         // Puddles.deposit(Vars.world.tileWorld(b.x + Mathf.random(puddleRange - tilesize * 4f), b.y + Mathf.random(puddleRange - tilesize * 4f)), liquid, puddleAmount);
//         // Puddles.deposit(Vars.world.tileWorld(b.x + Mathf.random(puddleRange - tilesize * 4f), b.y + Mathf.random(puddleRange - tilesize * 4f)), liquid, puddleAmount);

//         // Puddles.deposit(Vars.world.tileWorld(b.x + Mathf.random(puddleRange - tilesize * 5f), b.y + Mathf.random(puddleRange - tilesize * 5f)), liquid, puddleAmount);
//         // Puddles.deposit(Vars.world.tileWorld(b.x + Mathf.random(puddleRange - tilesize * 5f), b.y + Mathf.random(puddleRange - tilesize * 5f)), liquid, puddleAmount);

//         // Tile tile = world.tileWorld(b.x + Mathf.range(puddleRange), b.y + Mathf.range(puddleRange));
//         // Puddles.deposit(tile, liquid, puddleAmount);
//         //don't create liquids when the projectile despawns
//         // if(!liquid.willBoil()){
//         //     hitEffect.at(b.x, b.y, b.rotation(), liquid.color);
//         // }
//     }