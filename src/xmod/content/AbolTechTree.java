package xmod.content;

import arc.struct.*;
import mindustry.content.Planets;
import mindustry.game.Objectives.*;
import xmod.content.*;

import static mindustry.content.Blocks.*;
import static mindustry.content.Items.*;
import static mindustry.content.Liquids.*;
import static mindustry.content.UnitTypes.*;
import static mindustry.content.SectorPresets.*;
import static mindustry.content.SectorPresets.craters;
import static mindustry.content.TechTree.*;
import static xmod.content.XBlocks.*;
import static xmod.content.XItems.*;
import static xmod.content.XLiquids.*;
import static xmod.content.XUnits.*;

public class AbolTechTree{

    public static void load(){
        XPlanets.abol.techTree = nodeRoot("@planet.xmod-abol.name", coreShard, () -> {

            node(duo, () -> {

                node(trio, () -> {
                    node(doubleGatling, () -> {
                        node(rocketLauncher, () -> {
                        });
                    });
                });
            });
        });
    }
}