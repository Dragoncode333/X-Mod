package xmod.stolen.solarSystem.Planet;

import mindustry.world.meta.Attribute;

public class XAttributes {
    public static Attribute windPower;

    public static void load() {
        windPower = Attribute.add("windPower");
    }
}