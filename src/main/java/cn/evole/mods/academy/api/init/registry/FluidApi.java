package cn.evole.mods.academy.api.init.registry;

import cn.evole.mods.academy.api.interfaces.IRegListener;
import cn.evole.mods.academy.constant.Resources;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.fluids.FluidType;

import java.util.function.Consumer;

/**
 * Name: AcademyCraft2 / FluidApi
 * Author: cnlimiter
 * CreateTime: 2023/12/24 11:38
 * Description:
 */

public class FluidApi extends FluidType implements IRegListener {
    protected ResourceLocation
            still = Resources.res("block/default"),
            flow = Resources.res("block/default");

    public FluidApi(FluidType.Properties properties)
    {
        super(properties);
    }

    @Override
    public void onPreRegistered(ResourceLocation id)
    {
        still = new ResourceLocation(id.getNamespace(), "block/" + id.getPath());
        flow = new ResourceLocation(id.getNamespace(), "block/" + id.getPath() + "_flow");
    }

    @Override
    public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer)
    {
        consumer.accept(new IClientFluidTypeExtensions()
        {
            @Override
            public ResourceLocation getStillTexture()
            {
                return still;
            }

            @Override
            public ResourceLocation getFlowingTexture()
            {
                return flow;
            }
        });
    }
}
