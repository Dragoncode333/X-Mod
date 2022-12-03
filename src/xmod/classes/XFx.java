package xmod.classes;

import arc.Core;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import arc.struct.*;
import arc.util.*;
import xmod.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.entities.*;
import mindustry.game.Team;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.world.Block;

import java.util.*;

import static arc.graphics.g2d.Draw.*;
import static arc.graphics.g2d.Lines.*;
import static arc.math.Angles.angle;
import static arc.math.Angles.randLenVectors;
import static mindustry.Vars.renderer;
import static mindustry.Vars.tilesize;


public class XFx {

    public static final Rand rand = new Rand();
    public static final Vec2 v = new Vec2();

    public static final Effect

    cannonShoot = new Effect(25f, e -> {
        color(Pal.engine);

        e.scaled(15f, e2 -> {
            stroke(e2.fout() * 4.1f);
            Lines.circle(e2.x, e2.y, 4f + e2.fin() * 23f);
        });

        stroke(e.fout() * 2.5f);

        randLenVectors(e.id, 18, 8f + 30f * e.finpow(), e.rotation, 130f, (x, y) -> {
            lineAngle(e.x + x, e.y + y, Mathf.angle(x, y), e.fin() * 6f + 1f);
        });
    }),

    mediumMissileTrailSmoke = new Effect(95f, 200f, b -> {
        float intensity = 2f;

        color(b.color, 0.45f);
        for(int i = 0; i < 4; i++){
            rand.setSeed(b.id*2 + i);
            float lenScl = rand.random(0.5f, 1f);
            int fi = i;
            b.scaled(b.lifetime * lenScl, e -> {
                randLenVectors(e.id + fi - 1, e.fin(Interp.pow10Out), (int)(2.9f * intensity), 13f * intensity, (x, y, in, out) -> {
                    float fout = e.fout(Interp.pow5Out) * rand.random(0.5f, 1f);
                    float rad = fout * ((2f + intensity) * 1.7f);

                    Fill.circle(e.x + x, e.y + y, rad);
                    Drawf.light(e.x + x, e.y + y, rad * 1.f, b.color, 0.5f);
                });
            });
        }
    }).layer(Layer.bullet - 1f),

    mediumShootSmokeMissile = new Effect(150f, 300f, e -> {
        color(Pal.redLight);
        alpha(0.1f);
        rand.setSeed(e.id);
        for(int i = 0; i < 35; i++){
            v.trns(e.rotation + 180f + rand.range(21f), rand.random(e.finpow() * 90f)).add(rand.range(3f), rand.range(3f));
            e.scaled(e.lifetime * rand.random(0.35f, 1f), b -> {
                Fill.circle(e.x + v.x, e.y + v.y, b.fout() * 7.5f + 0.3f);
            });
        }
    }),

    mediumMassiveExplosion = new Effect(30, e -> {
        color(Pal.missileYellow);

        e.scaled(7, i -> {
            stroke(3f * i.fout());
            Lines.circle(e.x, e.y, 4f + i.fin() * 30f);
        });

        color(Color.gray);

        randLenVectors(e.id, 8, 2f + 30f * e.finpow(), (x, y) -> {
            Fill.circle(e.x + x, e.y + y, e.fout() * 4f + 0.5f);
        });

        color(Pal.missileYellowBack);
        stroke(e.fout());

        randLenVectors(e.id + 1, 6, 1f + 29f * e.finpow(), (x, y) -> {
            lineAngle(e.x + x, e.y + y, Mathf.angle(x, y), 1f + e.fout() * 4f);
        });

        Drawf.light(e.x, e.y, 37.5f, Pal.missileYellowBack, 0.8f * e.fout());
    }),

    mediumScatheExplosion = new Effect(60f, 160f, e -> {
        color(e.color);
        stroke(e.fout() * 5f);
        float circleRad = 6f + e.finpow() * 40f;
        Lines.circle(e.x, e.y, circleRad);

        rand.setSeed(e.id);
        for(int i = 0; i < 16; i++){
            float angle = rand.random(360f);
            float lenRand = rand.random(0.5f, 1f);
            Tmp.v1.trns(angle, circleRad);

            for(int s : Mathf.signs){
                Drawf.tri(e.x + Tmp.v1.x, e.y + Tmp.v1.y, e.foutpow() * 40f, e.fout() * 30f * lenRand + 6f, angle + 90f + s * 90f);
            }
        }
    }),

    mediumScatheLight = new Effect(60f, 160f, e -> {
        float circleRad = 6f + e.finpow() * 40f;

        color(e.color, e.foutpow());
        Fill.circle(e.x, e.y, circleRad);
    }).layer(Layer.bullet + 2f);
}