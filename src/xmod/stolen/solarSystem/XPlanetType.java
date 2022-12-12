package xmod.stolen.solarSystem;

import mindustry.type.Planet;
import mindustry.world.meta.StatUnit;
import xmod.stolen.world.meta.XStat;
import xmod.stolen.world.meta.XStatUnit;

public class XPlanetType extends Planet {
    public float averageSurfaceTemperature = 0;
    public float rad = 0;
    public float orbitRad = 0;
    public XPlanetType(String name, Planet parent, float radius, int sectorSize) {
        super(name, parent, radius, sectorSize);
    }
    @Override
    public void setStats(){
        stats.add(XStat.averageSurfaceTemperature, averageSurfaceTemperature, XStatUnit.kelvins);
        stats.add(XStat.rad, rad, XStatUnit.kilometers);
        if(!(orbitRad == 0)){
            stats.add(XStat.orbitRad, orbitRad, XStatUnit.kilometers);
        }
    }
}