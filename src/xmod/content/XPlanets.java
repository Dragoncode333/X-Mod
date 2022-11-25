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
import xmod.solarSystem.*;
import xmod.graphics.*;

public class XPlanets{
    public static Planet sun2, sun3, testPlanet, holyar, abol, amsha, omaloon;

    public static void load(){

        sun3 = new Planet("sun3", null, 23f){{
            bloom = true;
            accessible = false;

            orbitRadius = 6.25f;

            meshLoader = () -> new SunMesh(
                this, 4,
                5, 0.3, 1.7, 1.2, 1,
                1.15f,
                Color.valueOf("008a81"),
                Color.valueOf("009f94"),
                Color.valueOf("00b7aa"),
                Color.valueOf("00ffec"),
                Color.valueOf("57fff3"),
                Color.valueOf("91fff7")
            );
        }};

        sun2 = new Planet("sun2", XPlanets.sun3, 7.25f){{
            bloom = true;
            accessible = false;

            orbitTime = 60 * 30;
            orbitRadius = 45f;

            meshLoader = () -> new SunMesh(
                this, 4,
                5, 0.3, 1.7, 1.2, 1,
                1.15f,
                Color.valueOf("009926"),
                Color.valueOf("00b62d"),
                Color.valueOf("00c531"),
                Color.valueOf("00ff40"),
                Color.valueOf("56ff80"),
                Color.valueOf("91ffad")
            );
        }};

        testPlanet = new Planet("test-planet", XPlanets.sun3, 1.35f, 4){{
            generator = new Planete3Generatore();
            meshLoader = () -> new HexMesh(this, 6);
            cloudMeshLoader = () -> new MultiMesh(
                new HexSkyMesh(this, 11, 0.15f, 0.13f, 5, Color.valueOf("68eb9f").a(0.75f), 2, 0.45f, 0.9f, 0.38f),
                new HexSkyMesh(this, 1, 0.6f, 0.16f, 5, Color.valueOf("91e9b6").a(0.75f), 2, 0.45f, 1f, 0.41f)
            );

            orbitRadius = 112f;

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

        holyar = new Planet("holyar", Planets.sun, 1.35f, 4){{
            generator = new Planete3Generatore();
            meshLoader = () -> new HexMesh(this, 6);
            cloudMeshLoader = () -> new MultiMesh(
                new HexSkyMesh(this, 11, 0.15f, 0.13f, 5, new Color().set(Pal.spore).mul(0.9f).a(0.75f), 2, 0.45f, 0.9f, 0.38f),
                new HexSkyMesh(this, 1, 0.6f, 0.16f, 5, Color.white.cpy().lerp(Pal.spore, 0.55f).a(0.75f), 2, 0.45f, 1f, 0.41f)
            );

            orbitRadius = 28.5f;

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

        abol = new Planet("abol", XPlanets.holyar, 0.45f, 2){{
            generator = new Planete3Generatore();
            meshLoader = () -> new HexMesh(this, 6);
            cloudMeshLoader = () -> new MultiMesh(
                new HexSkyMesh(this, 11, 0.15f, 0.13f, 5, new Color().set(Pal.spore).mul(0.9f).a(0.75f), 2, 0.45f, 0.9f, 0.38f),
                new HexSkyMesh(this, 1, 0.6f, 0.16f, 5, Color.white.cpy().lerp(Pal.spore, 0.55f).a(0.75f), 2, 0.45f, 1f, 0.41f)
            );

            orbitRadius = 5f;

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

        // amsha = new XPlanetType("amsha", null, 4f, 0) {{
        //     averageSurfaceTemperature = 2300;
        //     rad = 50;
        //     bloom = true;
        //     accessible = false;
        //     hasAtmosphere = true;
        //     meshLoader = () -> new SunMesh(
        //             this, 4, 5, 0.3f, 1.0f, 1.2f, 1, 1.3f,
        //             Color.valueOf("#8B4513"),
        //             Color.valueOf("#A0522D"),
        //             Color.valueOf("c2311e"),
        //             Color.valueOf("ff6730"),
        //             Color.valueOf("bf342f"),
        //             Color.valueOf("8e261d")
        //     );
        // }};

        // omaloon = new XPlanetType("omaloon", amsha, 1f, 3) {{
        //     averageSurfaceTemperature = 193.15f;
        //     rad = 0.15f;
        //     orbitRad = 446;
        //     // generator = new OmaLoonPlanetGenerator();
        //     generator = new SerpuloPlanetGenerator();
        //     hasAtmosphere = true;
        //     meshLoader = () -> new MultiMesh(
        //             new HexMesh(this, 6)
        //     );
        //     allowSectorInvasion = false;
        //     atmosphereColor = XPal.XDarkBlue;
        //     atmosphereRadIn = 0.02f;
        //     atmosphereRadOut = 0.3f;
        //     landCloudColor = XPal.XDarkBlue.cpy().a(0.5f);
        //     orbitRadius = 60f;
        //     startSector = 12;
        //     accessible = true;
        //     alwaysUnlocked = true;
        //     bloom = false;
        //     orbitTime = Mathf.pow(orbitRadius, 1.5f) * 960;
        //     ruleSetter = r -> {
        //       r.waveTeam = Team.green;
        //       r.attributes.set(Attribute.heat, -0.2f);
        //       r.showSpawns = true;
        //       r.coreCapture = true;
        //       r.coreIncinerates = false;
        //     };
        // }};

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