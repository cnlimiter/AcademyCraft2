package cn.evole.mods.academy.core.app.guis.settings;

import cn.evole.mods.academy.core.app.App;
import cn.evole.mods.academy.core.app.AppEnvironment;
import cn.evole.mods.academy.core.app.RegApp;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * Name: AcademyCraft2 / AppSettings
 * Author: cnlimiter
 * CreateTime: 2023/12/23 2:47
 * Description:
 */

public class AppSettings extends App {

    @RegApp(priority = -1)
    public static AppSettings instance = new AppSettings();

    private AppSettings() {
        super("settings");
        setPreInstalled();
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public AppEnvironment createEnvironment() {
        return new AppEnvironment() {
            @Override
            @OnlyIn(Dist.CLIENT)
            public void onStart() {
                //Minecraft.getInstance().setScreen(new SettingsUI());
            }
        };
    }
}
