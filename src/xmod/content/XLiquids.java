package xmod.content;

import arc.graphics.*;
import mindustry.type.*;
import mindustry.content.*;

public class XLiquids {
    public static Liquid 

    poison, poisonGas, coolantLiquid;

    public static void load(){

        poison = new Liquid("poison", Color.valueOf("ae0fc980")){{
            capPuddles = false;
            temperature = 0.5f;
            viscosity = 0.775f;
            effect = XStatusEffects.eroded;
            coolant = false;
        }};

        poisonGas = new Liquid("poison-gas", Color.valueOf("ae0fc980")){{
            temperature = 0.5f;
            viscosity = 0.775f;
            effect = XStatusEffects.eroded;
            coolant = false;
            gasColor = Color.valueOf("ae0fc980");
            gas = true;
        }};

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
    }
}