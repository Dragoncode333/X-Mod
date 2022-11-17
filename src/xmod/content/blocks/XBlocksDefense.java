package xmod.content.blocks;
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

import static mindustry.Vars.*;
import static mindustry.type.ItemStack.*;

public class XBlocksDefense {
    public static Block
    //turret
    aller,super;

    public static void load(){
        aller = new Wall("chelour-wall"){{
            requirements(Category.defense, with(Items.copper, 65));
            health = 80;
            size = 2;
            researchCostMultiplier = 0.1f;
            envDisabled |= Env.scorching;
        }};
        
        super = new PayloadMassDriver("super"){{
            requirements(Category.units, with(Items.tungsten, 120, Items.silicon, 120, Items.graphite, 50));
            regionSuffix = "-dark";
            size = 3;
            reload = 130f;
            chargeTime = 90f;
            range = 700f;
            maxPayloadSize = 2.5f;
            fogRadius = 5;
            consumePower(0.5f);
        }};
    }
}
