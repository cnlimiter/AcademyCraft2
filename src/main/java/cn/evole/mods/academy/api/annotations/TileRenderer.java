package cn.evole.mods.academy.api.annotations;

import cn.evole.mods.academy.AcademyCraft;
import cn.evole.mods.academy.utils.DistUtils;
import cn.evole.mods.academy.utils.ScanDataUtils;
import net.neoforged.api.distmarker.Dist;
import org.jetbrains.annotations.ApiStatus;
import org.objectweb.asm.Type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;

/**
 * Author cnlimiter
 * CreateTime 2023/12/24 0:09
 * Name TileRenderer
 * Description
 */

@Retention(RetentionPolicy.CLASS)
@Target(ElementType.FIELD)
public @interface TileRenderer
{
    Class<?> value();

    @ApiStatus.Internal
    record Info(Runnable applicant)
    {
        public static final Map<ScanDataUtils.ScanTarget, Info> TILE_RENDERS = DistUtils.unsafeCallWhenOn(Dist.CLIENT, () -> () -> ScanDataUtils.gatherScans(TileRenderer.class, ElementType.FIELD, (target, mc, data) ->
                new Info(
                        () -> mc.getEventBus().addListener(
                                AcademyCraft.PROXY.addTESR(data.clazz(), data.getMemberName(), data.getProperty("value")
                                        .map(Type.class::cast).orElse(null))
                        )
                )
        ));

        public static Info get(Class<?> cls, String field)
        {
            return TILE_RENDERS.get(ScanDataUtils.ScanTarget.of(cls, field));
        }

        public void apply()
        {
            applicant.run();
        }
    }
}
