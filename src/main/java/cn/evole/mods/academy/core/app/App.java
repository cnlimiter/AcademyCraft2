package cn.evole.mods.academy.core.app;

import cn.evole.mods.academy.constant.Resources;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * Name: AcademyCraft2 / App
 * Author: cnlimiter
 * CreateTime: 2023/12/23 2:45
 * Description:
 */

public abstract class App {
    int appid;
    private final String name;
    protected ResourceLocation icon;

    private boolean preInstalled = false;

    public App(String _name) {
        name = _name;
        icon = getTexture("icon");
    }

    protected ResourceLocation getTexture(String texname) {
        return Resources.getTexture("guis/apps/" + name + "/" + texname);
    }

    private String localKey(String key) {
        return "ac.app." + name + "." + key;
    }

    protected String local(String key) {
        return I18n.get(localKey(key));
    }

    @OnlyIn(Dist.CLIENT)
    public ResourceLocation getIcon() {
        return icon;
    }

    public App setPreInstalled() {
        preInstalled = true;
        return this;
    }

    public int getID() {
        return appid;
    }

    public String getName() {
        return name;
    }

    public String getDisplayName() {
        return local("name");
    }

    public String getDisplayKey() {
        return localKey("name");
    }

    public final boolean isPreInstalled() {
        return preInstalled;
    }

    @OnlyIn(Dist.CLIENT)
    public abstract AppEnvironment createEnvironment();
}
