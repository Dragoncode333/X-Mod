package xmod;

import arc.*;
import arc.func.*;
import arc.struct.*;
import arc.util.*;
import mindustry.*;
import mindustry.game.EventType.*;
import mindustry.game.*;
import mindustry.mod.*;
import mindustry.mod.Mods.*;
import mindustry.net.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.*;
import xmod.content.*;

import static java.lang.Float.*;
import static mindustry.Vars.*;

public class XMod extends Mod{

    public XMod(){
        
    };

    @Override
	public void loadContent() {
        XItems.load();
        XLiquids.load();
        XBlocks.load();
	}
}