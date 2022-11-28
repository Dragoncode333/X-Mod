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
import mindustry.type.Weather.*;
import mindustry.content.*;
import mindustry.world.*;
import mindustry.world.meta.*;
import xmod.content.*;
import xmod.graphics.*;
import xmod.stolen.solarSystem.*;
import xmod.stolen.solarSystem.Planet.*;

public class XPlanets{
    public static Planet lumina, sun1, sun2, testPlanet, testPlanet1, holyar, abol, amsha, omaloon, gravillo;

    //Max 5 for sectorSize

    public static void load(){

//System1
        sun1 = new Planet("sun1", null, 23f){{
            bloom = true;
            accessible = false;

            meshLoader = () -> new SunMesh(
                this, 4,
                5, 0.3, 1.7, 1.2, 1,
                1.15f,
                Color.valueOf("08958b"),
                Color.valueOf("0aa096"),
                Color.valueOf("08c7b9"),
                Color.valueOf("00ffec"),
                Color.valueOf("6bfff4"),
                Color.valueOf("91fff7")
            );
        }};

        sun2 = new Planet("sun2", XPlanets.sun1, 7.25f){{
            bloom = true;
            accessible = false;

            orbitTime = 60 * 30;
            orbitRadius = 45f;

            meshLoader = () -> new SunMesh(
                this, 4,
                5, 0.3, 1.7, 1.2, 1,
                1.15f,
                Color.valueOf("15ab4c"),
                Color.valueOf("0dbd4e"),
                Color.valueOf("00cd4c"),
                Color.valueOf("00ff5e"),
                Color.valueOf("6bffa2"),
                Color.valueOf("86ffb3")
            );
        }};


//Planets of System1
        testPlanet = new Planet("test-planet", XPlanets.sun1, 1f, 4){{
            generator = new XPlanetGenerator();
            meshLoader = () -> new HexMesh(this, 6);
            cloudMeshLoader = () -> new MultiMesh(
                new HexSkyMesh(this, 11, 0.75f, 0.23f, 5, Color.valueOf("5672d7").a(0.75f), 2, 0.45f, 0.9f, 0.36f),
                new HexSkyMesh(this, 1, 1f, 0.28f, 5, Color.valueOf("778ee5").a(0.75f), 2, 0.45f, 1f, 0.38f)
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
            iconColor = Color.valueOf("e7e437");
            atmosphereColor = Color.valueOf("a8a528");
            atmosphereRadIn = 0.02f;
            atmosphereRadOut = 0.3f;
            startSector = 15;
            alwaysUnlocked = true;
            landCloudColor = Pal.spore.cpy().a(0.5f);
            hiddenItems.addAll(Items.erekirItems).removeAll(Items.serpuloItems);
        }};

        testPlanet1 = new Planet("test-planet1", XPlanets.sun1, 1f, 3){{
            generator = new XPlanetGenerator();
            meshLoader = () -> new HexMesh(this, 6);
            cloudMeshLoader = () -> new MultiMesh(
                new HexSkyMesh(this, 11, 0.15f, 0.23f, 5, Color.valueOf("5672d7").a(0.75f), 2, 0.45f, 0.9f, 0.38f),
                new HexSkyMesh(this, 1, 0.6f, 0.28f, 5, Color.valueOf("778ee5").a(0.75f), 2, 0.45f, 1f, 0.41f)
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
            atmosphereColor = Color.valueOf("a8a528");
            atmosphereRadIn = 0.01f;
            atmosphereRadOut = 0.28f;
            startSector = 1;
            alwaysUnlocked = true;
            landCloudColor = Pal.spore.cpy().a(0.5f);
            hiddenItems.addAll(Items.erekirItems).removeAll(Items.serpuloItems);
        }};


//Planets of base System
        holyar = new Planet("holyar", Planets.sun, 1.05f, 4){{
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

        abol = new Planet("abol", XPlanets.holyar, 0.775f, 2){{
            generator = new Planete3Generatore();
            meshLoader = () -> new HexMesh(this, 6);
            cloudMeshLoader = () -> new MultiMesh(
                new HexSkyMesh(this, 11, 0.15f, 0.13f, 5, new Color().set(Pal.spore).mul(0.9f).a(0.75f), 2, 0.45f, 0.9f, 0.38f),
                new HexSkyMesh(this, 1, 0.6f, 0.16f, 5, Color.white.cpy().lerp(Pal.spore, 0.55f).a(0.75f), 2, 0.45f, 1f, 0.41f)
            );

            orbitRadius = 8f;

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

        lumina = new Planet("lumina", Planets.serpulo, 0.8f, 1){{
            accessible = true;
            alwaysUnlocked = true;
            tidalLock = true;
            defaultCore = Blocks.coreShard;
            hasAtmosphere = true;
            bloom = false;
            camRadius = 0.275f;
            atmosphereColor = Color.valueOf("288a5d");
            iconColor = Color.valueOf("288a5d");
            meshLoader = () -> new HexMesh(this, 5);
            startSector = 9;
            generator = new LuminaPlanetGenerator();
            defaultEnv = Env.terrestrial | Env.oxygen;
            orbitRadius = 6.5f;
            allowLaunchLoadout = true;
            cloudMeshLoader = () -> new HexSkyMesh(this, 7, 1.4f, 0.17f, 5, Color.valueOf("b0dcb76d"), 2, 0.5f, 1f, 0.38f);
            ruleSetter = r -> {
                r.loadout = ItemStack.list();
                r.fog = true;
                r.waveTeam = Team.crux;
                r.waves = true;
                r.enemyCoreBuildRadius = 300;
                r.coreCapture = false;
            };
        }};


        
        
        
        




        
        
        // gravillo = new Planet("gravillo", XPlanets.sun3, 3f, 1){{
        //     generator = new STPPlanetGenerator();
        //     hasAtmosphere = true;
        //     meshLoader = () -> new HexMesh(this, 6);
        //     atmosphereColor = Color.valueOf("63353cFF");
        //     atmosphereRadIn = 0.019f;
        //     atmosphereRadOut = 0.29f;
        //     alwaysUnlocked = true;
        //     landCloudColor = Pal.spore.cpy().a(0.5f);
        //     orbitRadius = 100f;
        //     startSector = 20;
        //     alwaysUnlocked = true;
        // }};
        
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