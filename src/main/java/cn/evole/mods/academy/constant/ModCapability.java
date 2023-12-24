package cn.evole.mods.academy.constant;

import cn.evole.mods.academy.common.capability.IIFCapability;
import net.neoforged.neoforge.common.capabilities.Capability;
import net.neoforged.neoforge.common.capabilities.CapabilityManager;
import net.neoforged.neoforge.common.capabilities.CapabilityToken;


public class ModCapability {

    public static Capability<IIFCapability> IF_CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {
        @Override
        public String toString() {
            return super.toString();
        }
    });
}
