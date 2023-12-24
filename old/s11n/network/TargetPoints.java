package cn.evole.mods.academy.api.s11n.network;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.network.PacketDistributor.TargetPoint;

import java.util.HashMap;
import java.util.Map;

/**
 * Helper to convert objects into {@link TargetPoints}.
 *
 * @author WeAthFolD
 */
public class TargetPoints {

    public static final double DEFAULT_RANGE = 16;
    private static Map<Class<?>, TargetPointConverter> converters = new HashMap();

    static {
        addConverter(TargetPoint.class, new TargetPointConverter<TargetPoint>() {

            @Override
            public TargetPoint convert(TargetPoint object, double range) {
                return object;
            }

        });

        addConverter(Entity.class, new TargetPointConverter<Entity>() {

            @Override
            public TargetPoint convert(Entity object, double range) {
                if (range == -1)
                    range = DEFAULT_RANGE;
                return new TargetPoint(object.position().x, object.position().y, object.position().z, range, object.level().dimension());
            }

        });

        addConverter(BlockEntity.class, new TargetPointConverter<BlockEntity>() {

            @Override
            public TargetPoint convert(BlockEntity object, double range) {
                if (range == -1)
                    range = DEFAULT_RANGE;
                return new TargetPoint(object.getBlockPos().getX() + 0.5,
                        object.getBlockPos().getY() + 0.5, object.getBlockPos().getZ() + 0.5, range, object.getLevel().dimension());
            }

        });
    }

    public static void addConverter(Class<?> klass, TargetPointConverter conv) {
        if (converters.containsKey(klass)) {
            throw new RuntimeException("Cannot add multiple TargetPointConverter for class " + klass);
        }
        converters.put(klass, conv);
    }

    public static TargetPointConverter findConverter(Object obj) {
        Class klass = obj.getClass();
        TargetPointConverter conv;
        while (klass != null) {
            if ((conv = converters.get(klass)) != null)
                return conv;
            klass = klass.getSuperclass();
        }
        return null;
    }

    public static TargetPoint convert(Object obj, double range) {
        TargetPointConverter conv = findConverter(obj);
        if (conv == null) {
            throw new UnsupportedOperationException("Didn't find TargetPoint converter for " + obj);
        }
        return conv.convert(obj, range);
    }

    public interface TargetPointConverter<T> {
        TargetPoint convert(T object, double range);
    }

}
