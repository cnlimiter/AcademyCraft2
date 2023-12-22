package cn.evole.mods.academy.common;

import cn.evole.mods.academy.common.capability.IIFCapability;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;


public class AcademyCapability {

    public static Capability<IIFCapability> IF_CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {
        @Override
        public String toString() {
            return super.toString();
        }
    });
}
