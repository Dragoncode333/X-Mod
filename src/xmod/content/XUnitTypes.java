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

public class XUnitTypes{
	public static UnitType
	missile1, missile2, funny;


	public static void load(){

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
	}
}