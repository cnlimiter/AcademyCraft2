package cn.evole.mods.academy.init.gen.provider;

import cn.evole.mods.academy.constant.Const;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class AcademyBlockTagsProvider extends BlockTagsProvider {
    public AcademyBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Const.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider p_256380_) {

//        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
//                .add(ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).toList().toArray(new Block[0]));
    }
}
