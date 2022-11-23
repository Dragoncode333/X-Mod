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

public class XPlanets{
    public static Planet sun2;

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