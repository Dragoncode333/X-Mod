package xmod.entities.bullet;

import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.util.*;
import mindustry.content.*;
import mindustry.entities.*;
import mindustry.entities.bullet.*;
import mindustry.gen.*;
import mindustry.graphics.*;

import arc.math.geom.*;
import mindustry.world.*;
import mindustry.type.*;
import static mindustry.Vars.*;

public class LiquidMissileBulletTypeTry extends BasicBulletType{
    public Liquid liquid;
    public float puddleSize = 6f;
    public float orbSize = 3f;
    public float boilTime = 5f;
    
    public LiquidMissileBulletTypeTry(@Nullable Liquid liquid, float speed, float damage, String bulletSprite){
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

    // public LiquidMissileBulletType(Liquid liquid, float speed, float damage){
    //     this(null,speed, damage, "missile");
    // }

    // public LiquidMissileBulletType(){
    //     this(null, 1f, 1f, "missile");
    // }

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

    @Override
    public void hit(Bullet b, float hitx, float hity){
        hitEffect.at(hitx, hity, liquid.color);
        Puddles.deposit(world.tileWorld(hitx, hity), liquid, puddleSize);

        if(liquid.temperature <= 0.5f && liquid.flammability < 0.3f){
            float intensity = 400f * puddleSize/6f;
            Fires.extinguish(world.tileWorld(hitx, hity), intensity);
            for(Point2 p : Geometry.d4){
                Fires.extinguish(world.tileWorld(hitx + p.x * tilesize, hity + p.y * tilesize), intensity);
            }
        }
    }
}