package xmod.content;

import arc.func.*;
import arc.graphics.*;
import arc.math.*;
import arc.math.geom.*;
import arc.struct.*;
import arc.util.*;
import mindustry.game.*;
import mindustry.graphics.*;
import mindustry.graphics.g3d.*;
import mindustry.graphics.g3d.PlanetGrid.*;
import mindustry.maps.planet.*;
import mindustry.type.*;
import mindustry.content.*;
import mindustry.world.*;
import mindustry.world.meta.*;
import xmod.content.*;

public class XPlanets{
    public static Planet sun2, planète3;

    public static void load(){
        sun2 = new Planet("sun2", Planets.sun, 0.8f){{
            bloom = false;
            accessible = false;

            orbitRadius = 6.25f;

            meshLoader = () -> new SunMesh(
                this, 4,
                5, 0.3, 1.7, 1.2, 1,
                1.1f,
                Color.valueOf("008a81"),
                Color.valueOf("009f94"),
                Color.valueOf("00b7aa"),
                Color.valueOf("00ffec"),
                Color.valueOf("57fff3"),
                Color.valueOf("91fff7")
            );
        }};

        planète3 = new Planet("planète3", Planets.sun, 1f, 3){{
            generator = new Planete3Generatore();
            meshLoader = () -> new HexMesh(this, 6);
            cloudMeshLoader = () -> new MultiMesh(
                new HexSkyMesh(this, 11, 0.15f, 0.13f, 5, new Color().set(Pal.spore).mul(0.9f).a(0.75f), 2, 0.45f, 0.9f, 0.38f),
                new HexSkyMesh(this, 1, 0.6f, 0.16f, 5, Color.white.cpy().lerp(Pal.spore, 0.55f).a(0.75f), 2, 0.45f, 1f, 0.41f)
            );

            orbitRadius = 25f;
            
            launchCapacityMultiplier = 0.5f;
            sectorSeed = 2;
            allowWaves = true;
            allowWaveSimulation = true;
            allowSectorInvasion = true;
            allowLaunchSchematics = true;
            enemyCoreSpawnReplace = true;
            allowLaunchLoadout = true;
            //doesn't play well with configs
            prebuildBase = false;
            ruleSetter = r -> {
                r.waveTeam = Team.crux;
                r.placeRangeCheck = false;
                r.showSpawns = false;
            };
            iconColor = Color.valueOf("7d4dff");
            atmosphereColor = Color.valueOf("3c1b8f");
            atmosphereRadIn = 0.02f;
            atmosphereRadOut = 0.3f;
            startSector = 15;
            alwaysUnlocked = true;
            landCloudColor = Pal.spore.cpy().a(0.5f);
            hiddenItems.addAll(Items.erekirItems).removeAll(Items.serpuloItems);
        }};

        // try{
        //     shar = new Planet("shar", Planets.serpulo, 1f, 2) {{
        //         atmosphereColor = Color.gray.cpy();
        //         landCloudColor = Color.clear.cpy();
        //         atmosphereRadOut = 0.5f;
        //         atmosphereRadIn = 0.05f;
        //         tidalLock = true;
        //         hasAtmosphere = true;
        //         generator = new SharMoonGenerator();
        //         meshLoader = () -> new HexMesh(this, 5);
        //         startSector = 15;
        //         bloom = false;
        //     }};
        // }
        // catch(Exception e){
        //     Log.info("Couldn't load BM's planet, posting crash now");
        //     Log.err(e);
        // }

        //routercube = new Planet("routercube", Planets.serpulo, 0, 0.6f){{
        //    meshLoader = () ->
        //}}
    }
}
