package xmod.content;

import arc.graphics.*;
import mindustry.type.*;
import mindustry.content.*;

public class XLiquids {
    public static Liquid 

    coolantLiquid;

    public static void load(){

        coolantLiquid = new Liquid("coolant-liquid", Color.valueOf("8fe9ff")){{
            heatCapacity = 5f;
            temperature = 0.15f;
            viscosity = 0f;
            flammability = 0f;
            boilPoint = 3f;
            capPuddles = true;
            moveThroughBlocks = true;
            incinerable = true;
            blockReactive = true;
        }};
    };
}
