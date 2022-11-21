package xmod.content;

import arc.graphics.*;
import mindustry.type.*;

public class XLiquids{
    public static Liquid
    aller;
    

    public static void load(){
        aller = new Liquid("aller", Color.valueOf("596ab8")){{
            heatCapacity = 0.4f;
            effect = StatusEffects.wet;
            boilPoint = 0.5f;
            gasColor = Color.grays(0.9f);
            alwaysUnlocked = true;
        }};
      
    }
}
