package xmod.content;

import mindustry.game.*;
import mindustry.*;

public class XSchematics {
    public static Schematic
            xCore;

    public static void load(){
        xCore = Schematics.readBase64("bXNjaAF4nGNgY2BjZmDJS8xNZWDLrXTOL0pl4E5JLU4uyiwoyczPY2BgYMtJTErNKWZgio5lZOCuyM1P0U0GKtOtAMoxMjAwASEDAHNKEFA=");
    }
}