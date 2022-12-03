package xmod.stolen.solarSystem.Planet;

import arc.graphics.Color;
import arc.util.*;
import mindustry.content.Weathers;
import mindustry.gen.*;
import mindustry.type.*;
import mindustry.type.weather.*;

import xmod.content.*;

public class XWeathers {
    public static Weather wind;

    public static void load() {
        //add wind power attribute to vanilla weathers, such as:
        Weathers.sandstorm.attrs.set(XAttributes.windPower, 0.9f);
        Weathers.sporestorm.attrs.set(XAttributes.windPower, 0.8f);

        wind = new ParticleWeather("wind"){{
            drawParticles = false;
            drawNoise = true;
            noiseColor = Color.valueOf("b0dcb73b");
            useWindVector = true;
            baseSpeed = 3.6f;
            force = 0.2f;
            sound = Sounds.wind;
            soundVol = 0.9f;
            duration = 7f * Time.toMinutes;
            attrs.set(XAttributes.windPower, 1f);
        }};
    }
}