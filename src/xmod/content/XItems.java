package xmod.content;

import arc.graphics.*;
import arc.struct.*;
import mindustry.type.*;

public class XItems {
    public static Item

    iron, tenmm, emptyRocket, flydradiumRocket;

    public static void load(){

        iron = new Item("iron", Color.valueOf("c5c5c5")){{
            hardness = 1;
        }};

        tenmm = new Item("10mm", Color.valueOf("ffad00")){{
            radioactivity = 0f;
        }};

        emptyRocket = new Item("empty-rocket", Color.valueOf("f9a3c7")){{
            radioactivity = 0f;
        }};

        flydradiumRocket = new Item("flydradium-rocket", Color.valueOf("d99d73")){{
            hardness = 1;
            cost = 0.7f;
        }};
    }
}