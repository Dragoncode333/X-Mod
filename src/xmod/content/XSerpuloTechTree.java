package xmod.content;

import arc.struct.*;
import mindustry.game.Objectives.*;
import mindustry.content.*;

import static mindustry.content.Blocks.*;
import static mindustry.content.SectorPresets.*;
import static mindustry.content.SectorPresets.craters;
import static mindustry.content.TechTree.*;
import static mindustry.content.UnitTypes.*;

public class XSerpuloTechTree{

    public static void load(){

        Planets.serpulo.techTree = nodeRoot("serpulo", coreShard, () -> {

            node(duo, () -> {
                node(copperWall, () -> {
                    node(copperWallLarge, () -> {
                        node(titaniumWall, () -> {
                            node(titaniumWallLarge);

                            node(door, () -> {
                                node(doorLarge);
                            });
                            node(plastaniumWall, () -> {
                                node(plastaniumWallLarge, () -> {

                                });
                            });
                            node(thoriumWall, () -> {
                                node(thoriumWallLarge);
                                node(surgeWall, () -> {
                                    node(surgeWallLarge);
                                    node(phaseWall, () -> {
                                        node(phaseWallLarge);
                                    });
                                });
                            });
                        });
                    });
                });

                node(scatter, () -> {
                    node(hail, Seq.with(new SectorComplete(craters)), () -> {
                        node(salvo, () -> {
                            node(swarmer, () -> {
                                node(cyclone, () -> {
                                    node(spectre, Seq.with(new SectorComplete(nuclearComplex)), () -> {

                                    });
                                });
                            });

                            node(ripple, () -> {
                                node(fuse, () -> {

                                });
                            });
                        });
                    });
                });

                node(scorch, () -> {
                    node(arc, () -> {
                        node(wave, () -> {
                            node(parallax, () -> {
                                node(segment, () -> {

                                });
                            });

                            node(tsunami, () -> {

                            });
                        });

                        node(lancer, () -> {
                            node(meltdown, () -> {
                                node(foreshadow, () -> {

                                });
                            });

                            node(shockMine, () -> {

                            });
                        });
                    });
                });
            });
        });
    }
}