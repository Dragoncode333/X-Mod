package xmod.content;

import arc.struct.Seq;
import mindustry.content.Blocks;
import mindustry.content.Planets;
import mindustry.content.SectorPresets;
import mindustry.content.TechTree.*;
import mindustry.ctype.UnlockableContent;
import mindustry.game.Objectives.*;
import mindustry.content.*;

public class SerpuloTechTree {
    public static void load() {
        newNode(XBlocks.rocketLauncher, Blocks.swarmer, Seq.with(new OnPlanet(Planets.serpulo)));
        newNode(XBlocks.doubleGatling, Blocks.cyclone, Seq.with(new OnPlanet(Planets.serpulo)));
    }

    private static void newNode(UnlockableContent content, UnlockableContent parent, Seq<Objective> objectives) {
        TechNode parentNode = parent.techNode;
        TechNode node = new TechNode(parentNode, content, content.researchRequirements());
        if (objectives != null) node.objectives = objectives;
    }
}