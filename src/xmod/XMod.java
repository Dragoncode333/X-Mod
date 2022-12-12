package xmod;

import arc.*;
import arc.func.*;
import arc.struct.*;
import arc.util.*;
import arc.scene.ui.*;
import mindustry.*;
import mindustry.gen.*;
import mindustry.game.EventType.*;
import mindustry.game.*;
import mindustry.mod.*;
import mindustry.mod.Mods.*;
import mindustry.net.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.*;
import xmod.content.*;
import xmod.stolen.solarSystem.*;
import xmod.stolen.ui.dialogs.*;
import xmod.classes.*;

import static java.lang.Float.*;
import static mindustry.Vars.*;
import static arc.Core.*;

public class XMod extends Mod {

    @Override
    public void init() {
        super.init();
        XSolarSystem.init();
        LoadedMod mod = mods.locateMod("xmod");
        if (!headless) {
            // from Betamindy by sk7725
            Func<String, String> stringf = value -> bundle.get("mod." + value);

            // mod.meta.displayName = stringf.get(mod.meta.name + ".name");
            // mod.meta.description = bundle.get("mod.ol.description") +"\n\n"+
            // bundle.get("mod.ol.musics");
            // mod.meta.author = bundle.get("mod.ol.author") + "\n\n" +
            // bundle.get("mod.ol.contributors");

            Events.on(ClientLoadEvent.class, e -> {
                app.post(() -> app.post(() -> {
                    if (!settings.getBool("mod.xmod.show", false)) {
                        new XDisclaimer().show();
                    }
                }));
            });
        }
    };

    public XMod() {

    };

    @Override
    public void loadContent() {
        XLiquids.load();
        XItems.load();
        XUnits.load();
        XBlocks.load();
        XPlanets.load();
        SerpuloTechTree.load();
        AbolTechTree.load();
        // XSerpuloTechTree.load();
    }
}