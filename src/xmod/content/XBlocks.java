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
import xmod.classes.*;
import mindustry.content.*;

import static mindustry.Vars.*;
import static mindustry.type.ItemStack.*;

public class XBlocks {
    public static Block
    //turret
    aller, simple, doubleGatling, rocketCrafter, rocketLauncher, turret, missile, hugeMissile, missileConstructor;

    public static void load(){

        aller = new Wall("chelour-wall"){{
            requirements(Category.defense, with(Items.copper, 65));
            health = 80;
            size = 3;
            researchCostMultiplier = 0.1f;
            envDisabled |= Env.scorching;
        }};

        missile = new Floor("missile"){{
            requirements(Category.units, with(Items.copper, 65));
            size = 3;
        }};

        hugeMissile = new Floor("hugeMissile"){{
            requirements(Category.units, with(Items.copper, 65));
            size = 3;
            inEditor = false;
            placeableOn = false;
            placeablePlayer = false;
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
            envDisabled |= Env.scorching;

            limitRange();
        }};

        doubleGatling = new ItemTurret("double-gatling"){{
            requirements(Category.turret, with(Items.copper, 120, Items.titanium, 100, Items.graphite, 60, Items.silicon, 50));
            
            drawer = new DrawTurret("powerful-");
            ammo(
                XItems.tenmm, new BasicBulletType(13f, 100f, "xmod-gauge1-bullet"){{
                    frontColor = Color.valueOf("42fff8");
                    backColor = Color.valueOf("42fff8");
                    hitSize = 17.5f;
                    width = 17.5f;
                    height = 17.5f;
                    lifetime = 300f;
                    shootEffect = Fx.shootBig;
                    ammoMultiplier = 2;
                    trailChance = 1f;
                    trailColor = Color.valueOf("8cfffb");
                    trailParam = 5;
                    trailLength = 2;
                    trailWidth = 3.5f;
                    trailEffect = Fx.none;
                    hitEffect = despawnEffect = new MultiEffect(
                        Fx.hitBulletBig,
                        new WaveEffect(){{
                        sizeFrom = 0f;
                        sizeTo = 9f;
                        strokeFrom = 5f;
                        strokeTo = 0f;
                        lifetime = 7.5f;
                        colorFrom = Color.white;
                        colorTo = Pal.lightOrange;
                    }}
                    );
                }},
                XItems.tenmmE, new BasicBulletType(13f, 65f, "xmod-gauge1-bullet"){{
                    frontColor = Color.valueOf("42fff8");
                    backColor = Color.valueOf("42fff8");
                    hitSize = 17.5f;
                    width = 17.5f;
                    height = 17.5f;
                    lifetime = 300f;
                    shootEffect = Fx.shootBig;
                    ammoMultiplier = 2;
                    trailChance = 1f;
                    trailColor = Color.valueOf("8cfffb");
                    trailParam = 5;
                    trailLength = 2;
                    trailWidth = 3.5f;
                    trailEffect = Fx.none;
                    splashDamage = 155f;
                    splashDamageRadius = 25f;
                    hitEffect = despawnEffect = new MultiEffect(
                    Fx.hitBulletBig,
                    new WaveEffect(){{
                        sizeFrom = 0f;
                        sizeTo = 25f;
                        strokeFrom = 8.5f;
                        strokeTo = 0f;
                        lifetime = 15f;
                        colorFrom = Color.valueOf("A9D8FFFF");
                        colorTo = Color.valueOf("66B1FFFF");
                    }}
                   );
                }}
            );
            reload = 5.5f;
            recoil = 13f;
            recoilTime = 145f;
            maxAmmo = 40;
            buildCostMultiplier = 0.35f;
            health = 2150;
            rotateSpeed = 4.25f;
            shootY = 5f;
            coolantMultiplier = 0.5f;
            range = 300f;
            inaccuracy = 5.5f;
            heatColor = Pal.turretHeat;
            shoot = new ShootAlternate(){{
                spread = 21;
                shots = 2;
            }};
            shake = 3f;
            size = 5;
            shootCone = 24f;
            shootSound = Sounds.shootBig;
            coolant = consumeLiquid(XLiquids.coolantLiquid, 1f);

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

            cooldownTime = 60;
            minWarmup = 0.99f;
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
        
        turret = new PayloadAmmoTurret("turret"){{
            requirements(Category.turret, with(Items.copper, 150, Items.silicon, 200, Items.lead, 40, Items.titanium, 400));
            size = 7;
            outlineColor = Pal.darkOutline;
            shootWarmupSpeed = 0.04f;
            shootY = 0;
            minWarmup = 0.99f;
            coolant = consume(new ConsumeLiquid(Liquids.water, 15f / 60f));
            coolantMultiplier = 6f;
            shake = 2f;
            rotateSpeed = 2.5f;
            reload = 45f;
            recoil = 2f;
            envEnabled |= Env.scorching;

            ammo(
                    XBlocks.missile, new BasicBulletType(11f, 500){{
                        lifetime = 30f;
                        range = 330f;
                        width = 12f;
                        hitSize = 7f;
                        height = 20f;
                        smokeEffect = Fx.shootBigSmoke;
                        ammoMultiplier = 1;
                        pierceCap = 7;
                        pierce = true;
                        pierceBuilding = true;
                        hitColor = backColor = trailColor = Color.valueOf("#89769a");
                        frontColor = Color.white;
                        trailWidth = 2.1f;
                        trailLength = 10;
                        hitEffect = despawnEffect = Fx.hitBulletColor;
                        buildingDamageMultiplier = 0.3f;
                    }},
                    XBlocks.hugeMissile, new BasicBulletType(13f, 750){{
                        lifetime = 35f;
                        range = 455;
                        width = 12f;
                        hitSize = 7f;
                        height = 20f;
                        smokeEffect = Fx.shootBigSmoke;
                        ammoMultiplier = 1;
                        pierceCap = 7;
                        pierce = true;
                        pierceBuilding = true;
                        hitColor = backColor = trailColor = Pal.accent;
                        frontColor = Color.white;
                        trailWidth = 2.1f;
                        trailLength = 10;
                        hitEffect = despawnEffect = Fx.hitBulletColor;
                        buildingDamageMultiplier = 0.3f;
                        fragBullets = 4;
                        fragBullet = new LightningBulletType(){{
                            damage = 30;
                            collidesAir = false;
                            ammoMultiplier = 1f;
                            lightningColor = Pal.accent;
                            lightningLength = 6;
                            lightningLengthRand = 3;
                        }};
                    }}
            );

            drawer = new DrawTurret("reinforced-"){{
                parts.addAll(
                        new RegionPart("-body"){{
                            layerOffset = 0f;
                            outlineLayerOffset = -0.3f;
                            heatProgress = PartProgress.warmup;
                            heatColor = Pal.berylShot.cpy().a(0.25f);
                        }},

                        new RegionPart("-wing"){{
                            progress = heatProgress = PartProgress.warmup.curve(Interp.slowFast).curve(Interp.bounce);
                            heatColor = Pal.berylShot.cpy().a(0.40f);
                            layerOffset = -0.1f;
                            moveX = 10f * 0.25f;
                            moveY = -10f * 0.25f;
                            turretShading = true;
                            mirror = true;
                            outlineLayerOffset = -0.2f;
                        }},
                        new RegionPart("-barrel"){{
                            layerOffset = -0.2f;
                            progress = PartProgress.warmup.curve(Interp.circleIn).curve(Interp.bounce);
                            moveX = 20f * 0.25f;
                            moveY = 20f * 0.25f;
                            turretShading = true;
                            mirror = true;
                            outlineLayerOffset = -0.1f;
                            heatColor = Pal.turretHeat.cpy();
                            heatLayerOffset = -0.2f;
                            moves.add(new PartMove(PartProgress.recoil.sustain(1f, 0.1f, 0.1f), 0f, -4f, 0f));
                        }}
                );
            }};
        }};

        missileConstructor = new Constructor("missile-constructor"){{
            requirements(Category.units, with(Items.silicon, 100, Items.titanium, 150, Items.copper, 80));
            regionSuffix = "-dark";
            hasPower = true;
            buildSpeed = 0.6f;
            consumePower(2f);
            size = 4;
            //TODO expand this list
            filter = Seq.with(XBlocks.missile, XBlocks.hugeMissile);
        }};
    }
}