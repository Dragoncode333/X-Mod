package xmod.content;

import arc.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.util.*;
import mindustry.content.*;
import mindustry.entities.abilities.*;
import mindustry.entities.units.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.world.meta.*;

import static mindustry.Vars.*;

public class XStatusEffects{
    public static StatusEffect
    eroded;

    public static void load(){

        eroded = new StatusEffect("eroded"){{
            color = Color.valueOf("ae0fc9");
            applyColor = Color.valueOf("ae0fc9");
            permanent = true;
            healthMultiplier = 0.1f;
            speedMultiplier = 0.001f;
            effectChance = 0.5f;
        }};
    }
}