package xmod.stolen.ui.dialogs;

import mindustry.*;
import arc.*;
import arc.scene.ui.*;
import arc.util.Align;
import arc.scene.actions.*;
import mindustry.ui.dialogs.*;

import static arc.Core.settings;

public class XDisclaimer extends BaseDialog {
    public XDisclaimer(){
        super("@mod.xmod.disclaimer.title");
        cont.add("@mod.xmod.disclaimer.text").width(500f).wrap().pad(4f).get().setAlignment(Align.center, Align.center);
        buttons.defaults().size(200f, 54f).pad(2f);
        setFillParent(false);

        TextButton b = buttons.button("@mod.xmod.disclaimer.ok", this::hide).get();

        if(shouldSkip()) return;

        b.setDisabled(() -> b.color.a < 1);
        b.actions(
                Actions.alpha(0), Actions.moveBy(0f, 0f),
                Actions.delay(1.5f),
                Actions.fadeIn(1f),
                Actions.delay(1f)
        );
        b.getStyle().disabledFontColor = b.getStyle().fontColor;
        b.getStyle().disabled = b.getStyle().up;

        TextButton s = buttons.button("@mod.xmod.diaclaimer.doNotShowItAgain", () -> {
            hide();
            settings.put("mod.xmod.show", true);
        }).get();

        s.setDisabled(() -> s.color.a < 1);
        s.actions(
                Actions.alpha(0), Actions.moveBy(0f, 0f),
                Actions.delay(1.5f),
                Actions.fadeIn(1f),
                Actions.delay(1f)
        );
        s.getStyle().disabledFontColor = b.getStyle().fontColor;
        s.getStyle().disabled = s.getStyle().up;
    }
    boolean shouldSkip(){
        return Core.settings.getBool("mod.xmod.show", false);
    }
}
