package xmod.world.meta;

import mindustry.*;
import arc.Core;
import mindustry.world.meta.StatUnit;

import java.util.Locale;

public class XStatUnit extends StatUnit{
    public static final StatUnit
    kelvins = new StatUnit("kelvins"),
    kilometers = new StatUnit("kilometers");

    public final boolean space;
    public final String name;

    public XStatUnit(String name, boolean space){
        super(name, space);
        this.name = name;
        this.space = space;
    }

    public XStatUnit(String name){
        this(name, true);
    }

    public String localized(){
        if(this == none) return "";
        return Core.bundle.get("unit." + name.toLowerCase(Locale.ROOT));
    }
}