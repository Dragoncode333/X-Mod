package xmod.content;

import mindustry.type.*;

import static mindustry.content.Planets.*;

public class XSectorPresets{
    public static SectorPreset
    groundZero1, groundZero2, biomassFacility1, biomassFacility2, biomassFacility3, biomassFacility4, biomassFacility5,
    craters, biomassFacility, frozenForest, ruinousShores, windsweptIslands, stainedMountains, tarFields,
    fungalPass, extractionOutpost, saltFlats, overgrowth,
    impact0078, desolateRift, nuclearComplex, planetaryTerminal,
    coastline, navalFortress,

    onset, aegis, lake, intersect, basin, atlas, split, marsh, peaks, ravine, caldera,
    stronghold, crevice, siege, crossroads, karst, origin;

    public static void load(){
        //region serpulo

        // groundZero1 = new SectorPreset("groundZero1", XPlanets.lumina, 15){{
        //     alwaysUnlocked = true;
        //     addStartingItems = true;
        //     captureWave = 10;
        //     difficulty = 1;
        //     overrideLaunchDefaults = true;
        //     noLighting = true;
        //     startWaveTimeMultiplier = 3f;
        // }};

        groundZero2 = new SectorPreset("groundZero2", XPlanets.testPlanet1, 1){{
            alwaysUnlocked = true;
            addStartingItems = true;
            captureWave = 10;
            difficulty = 1;
            overrideLaunchDefaults = true;
            noLighting = true;
            startWaveTimeMultiplier = 3f;
        }};

        craters = new SectorPreset("craters1", XPlanets.testPlanet1, 100){{
            alwaysUnlocked = true;
            addStartingItems = true;
            captureWave = 10;
            difficulty = 3;
            overrideLaunchDefaults = true;
            allowLaunchLoadout = true;
            allowLaunchSchematics = true;
            noLighting = true;
            startWaveTimeMultiplier = 1.5f;
        }};

        biomassFacility1 = new SectorPreset("biomassFacility1", XPlanets.testPlanet1, 35){{
            alwaysUnlocked = true;
            captureWave = 10;
            difficulty = 3;
        }};

        biomassFacility2 = new SectorPreset("biomassFacility2", XPlanets.testPlanet1, 10){{
            alwaysUnlocked = true;
            captureWave = 1;
            difficulty = 3;
        }};

        biomassFacility2 = new SectorPreset("biomassFacility3", XPlanets.testPlanet1, 67){{
            alwaysUnlocked = true;
            captureWave = 1;
            difficulty = 3;
        }};

        biomassFacility2 = new SectorPreset("biomassFacility4", XPlanets.testPlanet1, 52){{
            alwaysUnlocked = true;
            captureWave = 1;
            difficulty = 3;
        }};
        
        biomassFacility4 = new SectorPreset("biomassFacility5", XPlanets.testPlanet1, 92){{
            alwaysUnlocked = true;
            captureWave = 1;
            difficulty = 3;
        }};
    }
}