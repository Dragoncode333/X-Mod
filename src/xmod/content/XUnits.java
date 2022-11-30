package xmod.content;

import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import arc.util.*;
import arc.struct.*;
import mindustry.ai.types.*;
import mindustry.content.*;
import mindustry.entities.*;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.entities.pattern.*;
import mindustry.entities.units.*;
import mindustry.gen.*;
import mindustry.type.*;
import mindustry.ctype.*;
import mindustry.type.ammo.*;
import mindustry.world.meta.*;
import arc.func.*;
import arc.struct.ObjectMap.*;
import mindustry.entities.part.*;
import mindustry.type.weapons.*;
import mindustry.world.blocks.payloads.*;

import static mindustry.Vars.*;

// public class XUnitTypes {
//     public static UnitType placeholder,
//     funny;
    
//     // Steal from Unlimited Armament Works which stole from Progressed Material which stole from Endless Rusting which stole from Progressed Materials in the past which stole from BetaMindy
// 	private static final Entry<Class<? extends Entityc>, Prov<? extends Entityc>>[] types = new Entry[]{
// 		// prov(CopterUnitEntity.class, CopterUnitEntity::new),
// 		// prov(TankUnitEntity.class, TankUnitEntity::new),
// 	};

// 	private static final ObjectIntMap<Class<? extends Entityc>> idMap = new ObjectIntMap<>();

// 	/**
// 	 * Internal function to flatmap {@code Class -> Prov} into an {@link Entry}.
// 	 * @author GlennFolker
// 	 */
// 	private static <T extends Entityc> Entry<Class<T>, Prov<T>> prov(Class<T> type, Prov<T> prov) {
// 		Entry<Class<T>, Prov<T>> entry = new Entry<>();
// 		entry.key = type;
// 		entry.value = prov;
// 		return entry;
// 	}

// 	/**
// 	 * Setups all entity IDs and maps them into {@link EntityMapping}.
// 	 * <p>
// 	 * Put this inside load()
// 	 * </p>
// 	 * @author GlennFolker
// 	 */
// 	private static void setupID() {
// 		for (
// 			int i = 0,
// 			j = 0,
// 			len = EntityMapping.idMap.length;
// 			i < len;
// 			i++
// 		) {
// 			if (EntityMapping.idMap[i] == null) {
// 				idMap.put(types[j].key, i);
// 				EntityMapping.idMap[i] = types[j].value;
// 				if (++j >= types.length) break;
// 			}
// 		}
// 	}

// 	// private static void setupPayloadSource() {
// 	// 	registerPayloadSource(HelicopterUnitType.class);
// 	// 	registerPayloadSource(TankUnitType.class);
// 	// }

// 	/**
// 	 * Retrieves the class ID for a certain entity type.
// 	 * @author GlennFolker
// 	 */
// 	public static <T extends Entityc> int classID(Class<T> type) {
// 		return idMap.get(type, -1);
// 	}

// 	public static <T extends UnitType> void registerPayloadSource(@NotNull Class<T> clz) {
// 		var source = (PayloadSource) Blocks.payloadSource;
// 		source.config((Class<UnitType>) clz,
// 			(PayloadSource.PayloadSourceBuild build, UnitType type) -> {
// 				if (source.canProduce(type) && build.unit != type) {
// 					build.unit = type;
// 					build.block = null;
// 					build.payload = null;
// 					build.scl = 0f;
// 				}
// 			});
// 	}

// 	public static void load() {
// 		setupID();
// 		// setupPayloadSource();
// 	}
// }

// public class XUnitTypes{
// 	public static UnitType
// 	missile1, missile2, funny;


// 	public static void load(){

		// missile1 = new UnitType("missile1"){{
        //     hitSize = 12f;
        //     health = 500;
        // }};

		// missile2 = new UnitType("missile2"){{
        //     hitSize = 15f;
        //     health = 500;
        // }};

		// funny = new UnitType("funny"){{
        //     speed = 3f;
        //     hitSize = 8f;
        //     health = 500;
        //     weapons.add(new Weapon("large-weapon"){{
        //         reload = 13f;
        //         x = 4f;
        //         y = 2f;
        //         top = false;
        //         ejectEffect = Fx.casing1;
        //         bullet = new BasicBulletType(2.5f, 9){{
        //             width = 7f;
        //             height = 9f;
        //             lifetime = 60f;
        //         }};
        //     }});
        // }};
// 	}
// }

// public class XUnitTypes implements ContentList{
//     public static int handsID;
//     public static UnitType
//         //crumb,
//         nibble;
//         //byte


//     @Override
//     public void load(){
//         handsID = EntityMapping.register("nibble", HandsUnitEntity::new);
//         nibble = new HandsUnitType("nibble"){{
//             defaultController = BuilderAI::new;
//             isCounted = false;

//             hovering = true;

//             flying = true;
//             mineTier = 0;
//             buildSpeed = 1.2f;
//             drag = 0.05f;
//             speed = 2.9f;
//             rotateSpeed = 9f;
//             accel = 0.1f;
//             itemCapacity = 60;
//             health = 200f;
//             hitSize = 9f;
//             rotateShooting = true;
//             lowAltitude = true;
//             commandLimit = 4;
//         }};
//     }
// }

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.entities.bullet.LaserBoltBulletType;
import mindustry.gen.LegsUnit;
import mindustry.gen.Legsc;
import mindustry.gen.Sounds;
import mindustry.gen.Unitc;
import mindustry.type.UnitType;
import mindustry.type.Weapon;
import mindustry.type.ammo.PowerAmmoType;
import mindustry.type.unit.*;


public class XUnits{
    //core units
    public static UnitType blaze, tanker, missileamoi;
    public static void load(){
        //core units
        blaze = new UnitType("blaze"){{
            constructor = LegsUnit::create;
            outlineColor = Color.valueOf("2b2c34");
            speed = 0.35f;
            hitSize = 8f;
            health = 1000;

            ammoType = new PowerAmmoType(3000);

            weapons.add(new Weapon("blaze-laserboltgun"){{
                top = true;
                shootY = 2f;
                reload = 24f;
                x = 2f;
                y = 1f;
                alternate = true;
                ejectEffect = Fx.none;
                recoil = 2f;
                shootSound = Sounds.lasershoot;

                bullet = new LaserBoltBulletType(5.2f, 30){{
                    lifetime = 20f;
                    healPercent = 5f;
                    collidesTeam = true;
                    backColor = Color.valueOf("ffd37f");
                    frontColor = Color.white;
                }};
            }});
        }};

        tanker = new TankUnitType("tanker"){{
            constructor = TankUnit::create;
            hitSize = 20f;
            treadPullOffset = 3;
            speed = 0.625f;
            rotateSpeed = 2.25f;
            health = 2000;
            armor = 6f;
            itemCapacity = 0;
            researchCostMultiplier = 0f;

            weapons.add(new Weapon("tanker-weapon"){{
                layerOffset = 0.0001f;
                reload = 50f;
                shootY = 4.5f;
                recoil = 1f;
                rotate = true;
                rotateSpeed = 2.2f;
                mirror = false;
                x = 0f;
                y = -0.75f;
                heatColor = Color.valueOf("f9350f");
                cooldownTime = 30f;

                bullet = new BasicBulletType(4f, 100){{
                    sprite = "missile-extra-large";
                    smokeEffect = Fx.shootBigSmoke;
                    shootEffect = Fx.shootBigColor;
                    width = 5f;
                    height = 7f;
                    lifetime = 40f;
                    hitSize = 4f;
                    hitColor = backColor = trailColor = Color.valueOf("feb380");
                    frontColor = Color.white;
                    trailWidth = 1.7f;
                    trailLength = 5;
                    despawnEffect = hitEffect = Fx.hitBulletColor;
                }};
            }});
        }};

        missileamoi = new UnitType("missileamoi"){{
            constructor = LegsUnit::create;
            outlineColor = Color.valueOf("2b2c34");
            speed = 0.3f;
            hitSize = 8f;
            drownTimeMultiplier = 2.5f;
            health = 500;
        }};
    }
}