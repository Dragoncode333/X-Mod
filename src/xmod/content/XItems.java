package xmod.content;

import arc.graphics.*;
import arc.struct.*;
import mindustry.type.*;
import mindustry.*;

import static mindustry.content.Items.*;

public class XItems {
    public static Item
    iron, flydradium, tenmm, tenmmE, emptyRocket, flydradiumRocket;

    public static final Seq<Item> 
    abolItems = new Seq<>(), abolOnlyItems = new Seq<>(),
    holyarItems = new Seq<>(), holyarOnlyItems = new Seq<>(),
    planet4546BItems = new Seq<>();

    public static void load(){

        iron = new Item("iron", Color.valueOf("c5c5c5")){{
            hardness = 1;
        }};

        flydradium = new Item("flydradium", Color.valueOf("c5c5c5")){{
            hardness = 5;
            radioactivity = 3;
            charge = 8;
            frames = 2;
            frameTime = 1;
            transitionFrames = 100;
        }};

        tenmm = new Item("10mm", Color.valueOf("ffad00")){{
            radioactivity = 0f;
        }};

        tenmmE = new Item("10mmEXPL", Color.valueOf("ff6000")){{
            radioactivity = 0f;
        }};

        emptyRocket = new Item("empty-rocket", Color.valueOf("f9a3c7")){{
            radioactivity = 0f;
        }};

        flydradiumRocket = new Item("flydradium-rocket", Color.valueOf("d99d73")){{
            hardness = 1;
            cost = 0.7f;
        }};

        abolItems.addAll(
        iron, flydradium,
        //Serpulo's items
        scrap, copper, lead, graphite, coal, titanium, thorium, silicon, plastanium,
        phaseFabric, surgeAlloy, sporePod, sand, blastCompound, pyratite, metaglass
        );

        holyarItems.addAll(
        iron,
        //Serpulo's items
        scrap, copper, lead, graphite, coal, titanium, thorium, silicon, plastanium,
        phaseFabric, surgeAlloy, sporePod, sand, blastCompound, pyratite, metaglass
        );

        planet4546BItems.addAll(
        iron, flydradium,
        //Serpulo's items
        scrap, copper, lead, graphite, coal, titanium, thorium, silicon, plastanium,
        phaseFabric, surgeAlloy, sporePod, sand, blastCompound, pyratite, metaglass
        );

        abolOnlyItems.addAll(abolItems).removeAll(holyarItems);
        holyarOnlyItems.addAll(holyarItems).removeAll(abolItems);
    }
}