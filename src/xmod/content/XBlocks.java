package xmod.content;
import arc.graphics.*;
import arc.math.*;
import arc.struct.*;
import mindustry.*;
import mindustry.entities.*;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.entities.part.DrawPart.*;
import mindustry.entities.part.*;
import mindustry.entities.pattern.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.type.unit.*;
import mindustry.world.*;
import mindustry.world.blocks.*;
import mindustry.world.blocks.campaign.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.heat.*;
import mindustry.world.blocks.legacy.*;
import mindustry.world.blocks.liquid.*;
import mindustry.world.blocks.logic.*;
import mindustry.world.blocks.payloads.*;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.sandbox.*;
import mindustry.world.blocks.storage.*;
import mindustry.world.blocks.units.*;
import mindustry.world.consumers.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;
import mindustry.content.*;
import xmod.content.XItems;
import xmod.content.XLiquids;

import static mindustry.Vars.*;
import static mindustry.type.ItemStack.*;

public class XBlocks {
    public static Block
    //turret
    aller, simple, rocketCrafter, rocketLauncher;

    public static void load(){

        aller = new Wall("chelour-wall"){{
            requirements(Category.defense, with(Items.copper, 65));
            health = 80;
            size = 3;
            researchCostMultiplier = 0.1f;
            envDisabled |= Env.scorching;
        }};

        simple = new ItemTurret("simple"){{
            requirements(Category.turret, with(Items.copper, 35));
            ammo(
                Items.copper,  new BasicBulletType(2.5f, 9){{
                    width = 7f;
                    height = 9f;
                    lifetime = 60f;
                    ammoMultiplier = 2;
                    shootEffect = Fx.massiveExplosion;
                }},
                Items.graphite, new BasicBulletType(3.5f, 18){{
                    width = 9f;
                    height = 12f;
                    reloadMultiplier = 0.6f;
                    ammoMultiplier = 4;
                    lifetime = 60f;
                    shootEffect = Fx.scatheExplosion;
                }},
                Items.silicon, new BasicBulletType(3f, 12){{
                    width = 7f;
                    height = 9f;
                    homingPower = 0.1f;
                    reloadMultiplier = 1.5f;
                    ammoMultiplier = 5;
                    lifetime = 60f;
                    shootEffect = Fx.scatheLight;
                }}
            );

            shoot = new ShootAlternate(3.5f);

            shootY = 3f;
            reload = 20f;
            range = 110;
            shootCone = 15f;
            ammoUseEffect = Fx.casing1;
            health = 250;
            inaccuracy = 2f;
            rotateSpeed = 10f;
            coolant = consumeCoolant(0.1f);
            researchCostMultiplier = 0.05f;

            limitRange();
        }};

        rocketCrafter = new GenericCrafter("rocket-crafter"){{
            requirements(Category.crafting, with(Items.titanium, 100, Items.silicon, 25, Items.lead, 100, Items.graphite, 50));

            craftEffect = Fx.generatespark;
            outputItem = new ItemStack(XItems.emptyRocket, 1);
            craftTime = 30f;
            itemCapacity = 475;
            size = 3;
            hasItems = true;
            hasLiquids = true;
            hasPower = true;

            consumePower(60f / 300f);
            consumeItems(with(XItems.iron, 475, Items.titanium, 300));
            consumeLiquid(Liquids.water, 60f / 25);
        }};

        rocketLauncher = new ItemTurret("rocket-launcher"){{
            requirements(Category.turret, with(Items.silicon, 450, Items.graphite, 400, Items.copper, 500, Items.lead, 300));

            ammo(
            XItems.emptyRocket, new BasicBulletType(0f, 1){{
                shootEffect = Fx.shootBig;
                smokeEffect = XFx.mediumShootSmokeMissile;
                ammoMultiplier = 1f;

                spawnUnit = new MissileUnitType("manger-missile"){{
                    speed = 6.5f;
                    maxRange = 6f;
                    lifetime = 60f * 5.5f;
                    outlineColor = Pal.darkOutline;
                    engineColor = trailColor = Pal.redLight;
                    engineLayer = Layer.effect;
                    engineSize = 2.25f;
                    engineOffset = 10f;
                    rotateSpeed = 0.05f;
                    trailLength = 18;
                    missileAccelTime = 20f;
                    lowAltitude = true;
                    loopSound = Sounds.missileTrail;
                    loopSoundVolume = 0.6f;
                    deathSound = Sounds.largeExplosion;
                    targetAir = false;

                    fogRadius = 4.75f;

                    health = 210;

                    weapons.add(new Weapon(){{
                        shootCone = 360f;
                        mirror = false;
                        reload = 1f;
                        deathExplosionEffect = Fx.massiveExplosion;
                        shootOnDeath = true;
                        shake = 11f;
                        bullet = new ExplosionBulletType(21f, 50f){{
                            hitColor = Pal.redLight;
                            shootEffect = new MultiEffect(XFx.mediumMassiveExplosion, XFx.mediumScatheExplosion, XFx.mediumScatheLight, new WaveEffect(){{
                                lifetime = 10f;
                                strokeFrom = 4f;
                                sizeTo = 97.5f;
                            }});

                            collidesAir = false;
                            buildingDamageMultiplier = 0.3f;

                            ammoMultiplier = 1f;
                        }};
                    }});

                    abilities.add(new MoveEffectAbility(){{
                        effect = XFx.mediumMissileTrailSmoke;
                        rotation = 180f;
                        y = -9f;
                        color = Color.grays(0.6f).lerp(Pal.redLight, 0.5f).a(0.4f);
                        interval = 7f;
                    }});
                }};
            }}
            );

            drawer = new DrawTurret("powerful-"){{

            }};

            shoot = new ShootAlternate(){{
                shots = 7;
                barrels = 4;
                spread = 9f;
                shotDelay = 11f;
            }};
            recoil = 8f;
            recoilTime = 45f;

            fogRadiusMultiuplier = 0.75f;
            coolantMultiplier = 6f;
            shootSound = Sounds.missileLaunch;

            // minWarmup = 0.94f;
            // shootWarmupSpeed = 0.03f;
            targetAir = false;

            shake = 6f;
            ammoPerShot = 7;
            maxAmmo = 7;
            shootY = 0;
            outlineColor = Pal.darkOutline;
            size = 6;
            envEnabled |= Env.scorching;
            reload = 200;
            range = 1350;
            shootCone = 1f;
            health = 3000;
            rotateSpeed = 0.75f;

            coolant = consume(new ConsumeLiquid(XLiquids.coolantLiquid, 60f / 30f));
            limitRange();
        }};
    }
}
