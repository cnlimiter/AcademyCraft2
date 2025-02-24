package cn.evole.mods.academy.api.common;

import cn.evole.mods.academy.api.init.adapter.TagAdapter;
import cn.evole.mods.academy.api.init.registry.FluidApi;
import cn.evole.mods.academy.api.interfaces.ICustomReg;
import cn.evole.mods.academy.api.interfaces.IRegListener;
import cn.evole.mods.academy.utils.DistUtils;
import cn.evole.mods.academy.utils.game.FluidIngredient;
import cn.evole.mods.academy.utils.game.FluidIngredientStack;
import cn.evole.mods.academy.utils.java.Cast;
import com.google.common.base.Suppliers;
import com.google.common.collect.Lists;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.fluids.FluidUtil;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.RegisterEvent;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * Name: AcademyCraft2 / FluidFactory
 * Author: cnlimiter
 * CreateTime: 2023/12/24 0:35
 * Description:
 */

public class FluidFactory implements ICustomReg, ItemLike
{
    public final FluidType type;
    public final Supplier<Item> bucket;
    public final BaseFlowingFluid.Properties fluidProps;
    public final Supplier<BaseFlowingFluid.Source> source;
    public final Supplier<BaseFlowingFluid.Flowing> flowing;
    public final Supplier<LiquidBlock> block;
    protected Supplier<Supplier<RenderType>> renderType = () -> RenderType::solid;
    protected final List<TagKey<Fluid>> fluidTags = Lists.newArrayList();
    protected final List<CreativeTab> tabs = Lists.newArrayList();

    public FluidFactory(
            Supplier<FluidType> typeGenerator,
            Function<Supplier<FlowingFluid>, Item> bucket,
            UnaryOperator<BaseFlowingFluid.Properties> propertyModifier,
            Function<Supplier<? extends FlowingFluid>, LiquidBlock> block,
            Function<BaseFlowingFluid.Properties, BaseFlowingFluid.Source> sourceGen,
            Function<BaseFlowingFluid.Properties, BaseFlowingFluid.Flowing> flowingGen
    )
    {
        this.type = typeGenerator.get();

        this.block = block != null ? Suppliers.memoize(() -> block.apply(this::getFlowing)) : null;
        this.bucket = bucket != null ? Suppliers.memoize(() ->
        {
            var item = bucket.apply(this::getSource);
            for(CreativeTab tab : tabs)
                tab.add(item);
            return item;
        }) : null;

        var fp = new BaseFlowingFluid.Properties(this::getType, this::getSource, this::getFlowing);

        if(this.block != null) fp = fp.block(this::getBlock);
        if(this.bucket != null) fp = fp.bucket(this::getBucket);

        this.fluidProps = propertyModifier != null ? propertyModifier.apply(fp) : fp;

        this.source = Suppliers.memoize(() -> sourceGen.apply(this.fluidProps));
        this.flowing = Suppliers.memoize(() -> flowingGen.apply(this.fluidProps));
    }

    protected FluidFactory addFluidTags(Collection<TagKey<Fluid>> fluidTags)
    {
        this.fluidTags.addAll(fluidTags);
        return this;
    }

    protected FluidFactory withRenderType(Supplier<Supplier<RenderType>> renderType)
    {
        this.renderType = renderType;
        return this;
    }

    protected FluidFactory addToTabs(Collection<CreativeTab> tab)
    {
        tabs.addAll(tab);
        return this;
    }

    public FluidStack stack(int amount)
    {
        return new FluidStack(this.source.get(), amount);
    }

    public FluidIngredient ingredient()
    {
        return FluidIngredient.ofFluids(List.of(new FluidStack(this.source.get(), 1)));
    }

    public FluidIngredientStack ingredient(int amount)
    {
        return new FluidIngredientStack(ingredient(), amount);
    }

    public FluidType getType()
    {
        return type;
    }

    public BaseFlowingFluid.Source getSource()
    {
        return source.get();
    }

    public BlockState getSourceBlockState()
    {
        return source.get().getSource(false).createLegacyBlock();
    }

    public BaseFlowingFluid.Flowing getFlowing()
    {
        return flowing.get();
    }

    @Nullable
    public Item getBucket()
    {
        return bucket != null ? bucket.get() : null;
    }

    @Nullable
    public LiquidBlock getBlock()
    {
        return block != null ? block.get() : null;
    }

    public ResourceLocation subId(ResourceLocation fluidId, String thing)
    {
        return new ResourceLocation(fluidId.getNamespace(), fluidId.getPath() + "_" + thing);
    }

    public boolean is(Fluid fluid)
    {
        return fluid == source || fluid == flowing;
    }

    public boolean is(FluidType fluid)
    {
        return fluid == type;
    }

    public boolean is(FluidStack fluid)
    {
        return fluid != null && !fluid.isEmpty() && is(fluid.getFluid());
    }

    public boolean is(Block fluid)
    {
        return fluid == getBlock();
    }

    public boolean is(Item bucket)
    {
        return bucket == getBucket();
    }

    public boolean has(ItemStack stack)
    {
        return !stack.isEmpty() &&
                FluidUtil.getFluidHandler(stack)
                        .resolve()
                        .map(h ->
                        {
                            int t = h.getTanks();
                            for(int i = 0; i < t; i++)
                            {
                                var ft = h.getFluidInTank(i);
                                if(is(ft))
                                    return true;
                            }
                            return false;
                        })
                        .orElse(false);
    }

    public boolean has(ItemStack stack, int minAmount)
    {
        return !stack.isEmpty() &&
                FluidUtil.getFluidHandler(stack)
                        .resolve()
                        .map(h ->
                        {
                            int amt = 0;
                            int t = h.getTanks();
                            for(int i = 0; i < t; i++)
                            {
                                var ft = h.getFluidInTank(i);
                                if(is(ft))
                                {
                                    amt += ft.getAmount();
                                    if(amt >= minAmount)
                                        return true;
                                }
                            }
                            return amt >= minAmount;
                        })
                        .orElse(false);
    }

    @Override
    public void performRegister(RegisterEvent e, ResourceLocation fluidId)
    {
        var key = e.getRegistryKey();

        if(NeoForgeRegistries.Keys.FLUID_TYPES.equals(key))
        {
            if(type instanceof IRegListener rl) rl.onPreRegistered(fluidId);
            e.register(NeoForgeRegistries.Keys.FLUID_TYPES, fluidId, Cast.constant(type));
            if(type instanceof IRegListener rl) rl.onPostRegistered(fluidId);
        }

        if(Registries.FLUID.equals(key))
        {
            if(getSource() instanceof IRegListener rl) rl.onPreRegistered(fluidId);
            if(getFlowing() instanceof IRegListener rl) rl.onPreRegistered(subId(fluidId, "flow"));

            e.register(Registries.FLUID, fluidId, source::get);
            e.register(Registries.FLUID, subId(fluidId, "flow"), flowing::get);

            if(getSource() instanceof IRegListener rl) rl.onPostRegistered(fluidId);
            if(getFlowing() instanceof IRegListener rl) rl.onPostRegistered(subId(fluidId, "flow"));

            DistUtils.unsafeRunWhenOn(Dist.CLIENT, () -> () -> ItemBlockRenderTypes.setRenderLayer(getSource(), Cast.get2(renderType)));
            DistUtils.unsafeRunWhenOn(Dist.CLIENT, () -> () -> ItemBlockRenderTypes.setRenderLayer(getFlowing(), Cast.get2(renderType)));
        }

        if(block != null && Registries.BLOCK.equals(key))
        {
            if(getBlock() instanceof IRegListener rl) rl.onPreRegistered(subId(fluidId, "bucket"));
            e.register(Registries.BLOCK, fluidId, block::get);
            if(getBlock() instanceof IRegListener rl) rl.onPostRegistered(subId(fluidId, "bucket"));
        }

        if(bucket != null && Registries.ITEM.equals(key))
        {
            if(getBucket() instanceof IRegListener rl) rl.onPreRegistered(subId(fluidId, "bucket"));
            e.register(Registries.ITEM, subId(fluidId, "bucket"), bucket);
            if(getBucket() instanceof IRegListener rl) rl.onPostRegistered(subId(fluidId, "bucket"));
        }

        for(var tag : fluidTags)
            TagAdapter.bind(tag, this.source.get(), this.flowing.get());
    }

    @Override
    public Item asItem()
    {
        return bucket.get();
    }

    public static Builder builder(Supplier<FluidType> typeGenerator)
    {
        return new Builder(typeGenerator);
    }

    public static Builder builder(FluidType.Properties typeProps)
    {
        return new Builder(() -> new FluidApi(typeProps));
    }

    public static class Builder
    {
        protected final Supplier<FluidType> typeGenerator;
        protected final List<TagKey<Fluid>> fluidTags = Lists.newArrayList();
        protected final List<CreativeTab> tabs = Lists.newArrayList();
        protected UnaryOperator<BaseFlowingFluid.Properties> propertyModifier = UnaryOperator.identity();
        protected Function<Supplier<FlowingFluid>, Item> bucket;
        protected Function<Supplier<? extends FlowingFluid>, LiquidBlock> block;

        protected Function<BaseFlowingFluid.Properties, BaseFlowingFluid.Source> sourceGen = BaseFlowingFluid.Source::new;
        protected Function<BaseFlowingFluid.Properties, BaseFlowingFluid.Flowing> flowingGen = BaseFlowingFluid.Flowing::new;

        protected Supplier<Supplier<RenderType>> renderType = () -> RenderType::solid;

        public Builder(Supplier<FluidType> typeGenerator)
        {
            this.typeGenerator = typeGenerator;
        }

        public Builder withBucket()
        {
            return withBucket(fluid -> new BucketItem(fluid,
                    new Item.Properties()
                            .craftRemainder(Items.BUCKET)
                            .stacksTo(1)
            ));
        }

        public Builder withBlock()
        {
            return withBlock(flowing -> new LiquidBlock(flowing,
                    BlockBehaviour.Properties.of()
                            .replaceable()
                            .noCollission()
                            .strength(100.0F)
                            .pushReaction(PushReaction.DESTROY)
                            .noLootTable()
                            .liquid()
                            .sound(SoundType.EMPTY)
            ));
        }

        public Builder propertyModifier(UnaryOperator<BaseFlowingFluid.Properties> propertyModifier)
        {
            var pm = this.propertyModifier;
            this.propertyModifier = v -> propertyModifier.apply(pm.apply(v));
            return this;
        }

        public Builder withBucket(Function<Supplier<FlowingFluid>, Item> bucket)
        {
            this.bucket = bucket;
            return this;
        }

        public Builder withBlock(Function<Supplier<? extends FlowingFluid>, LiquidBlock> block)
        {
            this.block = block;
            return this;
        }

        public Builder withSource(Function<BaseFlowingFluid.Properties, BaseFlowingFluid.Source> sourceGen)
        {
            this.sourceGen = sourceGen;
            return this;
        }

        public Builder withFlowing(Function<BaseFlowingFluid.Properties, BaseFlowingFluid.Flowing> flowingGen)
        {
            this.flowingGen = flowingGen;
            return this;
        }

        public Builder withRenderType(Supplier<Supplier<RenderType>> renderType)
        {
            this.renderType = renderType;
            return this;
        }

        public Builder addFluidTag(TagKey<Fluid> tag)
        {
            fluidTags.add(tag);
            return this;
        }

        public Builder addFluidTags(List<TagKey<Fluid>> fluidTags)
        {
            this.fluidTags.addAll(fluidTags);
            return this;
        }

        public Builder addToTab(CreativeTab tab)
        {
            tabs.add(tab);
            return this;
        }

        public Builder addToTabs(Collection<CreativeTab> tab)
        {
            tabs.addAll(tab);
            return this;
        }

        public FluidFactory build()
        {
            return new FluidFactory(
                    typeGenerator,
                    bucket,
                    propertyModifier,
                    block,
                    sourceGen,
                    flowingGen
            ).withRenderType(renderType)
                    .addFluidTags(fluidTags)
                    .addToTabs(tabs);
        }
    }
}
