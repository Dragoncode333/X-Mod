package xmod.content;

import arc.graphics.*;
import arc.struct.*;
import mindustry.type.*;

public class XItems{
    public static Item
    flydradiumRocket;
    
  public static void load(){
        flydradiumRocket = new Item("flydradium-rocket", Color.valueOf("d99d73")){{
            hardness = 1;
            cost = 0.7f;
        }};
    
  }
  
}
