package cn.evole.mods.academy;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

public class Resources {
    public static ResourceLocation getTexture(String loc) {
        return res("textures/" + loc + ".png");
    }
    public static ResourceLocation res(String loc) {
        return new ResourceLocation(AcademyCraft.MODID, loc);
    }
    public static SoundEvent sound(String loc) {
        return SoundEvent.createVariableRangeEvent(res(loc));
    }
    public static ResourceLocation getShader(String loc) {
        return res("shaders/" + loc);
    }

    public static ResourceLocation[] getEffectSeq(String effectName, int n) {
        ResourceLocation[] layers = new ResourceLocation[n];
        String baseName = "textures/effects/" + effectName + "/";
        for (int i = 0; i < n; ++i) {
            layers[i] = res( baseName + i + ".png");
        }
        return layers;
    }

    public static ResourceLocation[] getTextureSeq(String loc, int n) {
        ResourceLocation[] ret = new ResourceLocation[n];
        for(int i = 0; i < n; ++i)
            ret[i] = getTexture(loc + i);
        return ret;
    }

    public static ResourceLocation[] getRayTextures(String name) {
        ResourceLocation r1 = res("textures/effects/" + name + "/blend_in.png");
        ResourceLocation r2 = res("textures/effects/" + name + "/tile.png");
        ResourceLocation r3 = res("textures/effects/" + name + "/blend_out.png");
        return new ResourceLocation[] { r1, r2, r3 };
    }

    public static ResourceLocation
            TEX_COIN_FRONT = res("textures/items/coin_front.png"),
            TEX_COIN_BACK = res("textures/items/coin_back.png");

    public static ResourceLocation
            TEX_EMPTY = getTexture("null");

    public static ResourceLocation
            TEX_GLOW_LINE = getTexture("effects/glow_line");

    public static ResourceLocation
            ARC_SMALL[] = getEffectSeq("arcs", 10);




}
