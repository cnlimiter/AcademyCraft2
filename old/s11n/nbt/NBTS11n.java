package cn.evole.mods.academy.api.s11n.nbt;

import cn.evole.mods.academy.api.s11n.SerializationHelper;
import cn.evole.mods.academy.api.s11n.SerializeDynamic;
import cn.evole.mods.academy.constant.Debug;
import cn.evole.mods.academy.utils.ReflectionUtils;
import com.google.common.base.Preconditions;
import net.minecraft.nbt.*;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.*;
import java.util.Map.Entry;
import java.util.function.Supplier;

/**
 * Handles NBT (Notch Bull**** Tag) serialization.
 *
 * @author WeAthFolD
 */
public class NBTS11n {

    private static final BaseSerializer<ByteTag, Enum> enumSer = new BaseSerializer<ByteTag, Enum>() {
        @Override
        public ByteTag write(Enum value) {
            Preconditions.checkArgument(value.ordinal() < Byte.MAX_VALUE);
            return ByteTag.valueOf((byte) value.ordinal());
        }

        @Override
        public Enum read(ByteTag tag, Class<? extends Enum> type) {
            return type.getEnumConstants()[tag.getAsByte()];
        }
    };
    private static SerializationHelper helper = new SerializationHelper();
    private static Map<Class, BaseSerializer> baseSerializerMap = new HashMap<>();
    private static Map<Class, CompoundSerializer> compoundSerializerMap = new HashMap<>();
    private static Map<Class, Supplier<?>> supplierMap = new HashMap<>();

    static {
        {
            BaseSerializer<ByteTag, Byte> ser = new BaseSerializer<ByteTag, Byte>() {
                @Override
                public ByteTag write(Byte value) {
                    return ByteTag.valueOf(value);
                }

                @Override
                public Byte read(ByteTag tag, Class<? extends Byte> type) {
                    return tag.getAsByte();
                }
            };
            addBase(byte.class, ser);
            addBase(Byte.class, ser);
        }
        {
            BaseSerializer<ShortTag, Short> ser = new BaseSerializer<ShortTag, Short>() {
                @Override
                public ShortTag write(Short value) {
                    return ShortTag.valueOf(value);
                }

                @Override
                public Short read(ShortTag tag, Class<? extends Short> type) {
                    return tag.getAsShort();
                }
            };
            addBase(short.class, ser);
            addBase(Short.class, ser);
        }
        {
            BaseSerializer<IntTag, Integer> ser = new BaseSerializer<IntTag, Integer>() {
                @Override
                public IntTag write(Integer value) {
                    return IntTag.valueOf(value);
                }

                @Override
                public Integer read(IntTag tag, Class<? extends Integer> type) {
                    return tag.getAsInt();
                }
            };
            addBase(int.class, ser);
            addBase(Integer.class, ser);
        }
        {
            BaseSerializer<FloatTag, Float> ser = new BaseSerializer<FloatTag, Float>() {
                @Override
                public FloatTag write(Float value) {
                    return FloatTag.valueOf(value);
                }

                @Override
                public Float read(FloatTag tag, Class<? extends Float> type) {
                    return tag.getAsFloat();
                }
            };
            addBase(float.class, ser);
            addBase(Float.class, ser);
        }
        {
            BaseSerializer<DoubleTag, Double> ser = new BaseSerializer<DoubleTag, Double>() {
                @Override
                public DoubleTag write(Double value) {
                    return DoubleTag.valueOf(value);
                }

                @Override
                public Double read(DoubleTag tag, Class<? extends Double> type) {
                    return tag.getAsDouble();
                }
            };
            addBase(double.class, ser);
            addBase(Double.class, ser);
        }
        {
            BaseSerializer<LongTag, Long> ser = new BaseSerializer<LongTag, Long>() {
                @Override
                public LongTag write(Long value) {
                    return LongTag.valueOf(value);
                }

                @Override
                public Long read(LongTag tag, Class<? extends Long> type) {
                    return tag.getAsLong();
                }
            };
            addBase(long.class, ser);
            addBase(Long.class, ser);
        }
        {
            BaseSerializer<ByteTag, Boolean> ser = new BaseSerializer<ByteTag, Boolean>() {
                @Override
                public ByteTag write(Boolean value) {
                    return ByteTag.valueOf((byte) (value ? 1 : 0));
                }

                @Override
                public Boolean read(ByteTag tag, Class<? extends Boolean> type) {
                    return tag.getAsByte() != 0;
                }
            };
            addBase(boolean.class, ser);
            addBase(Boolean.class, ser);
        }
        {
            BaseSerializer<ByteArrayTag, byte[]> ser = new BaseSerializer<ByteArrayTag, byte[]>() {
                @Override
                public ByteArrayTag write(byte[] value) {
                    return new ByteArrayTag(value);
                }

                @Override
                public byte[] read(ByteArrayTag tag, Class<? extends byte[]> type) {
                    return tag.getAsByteArray();
                }
            };
            addBase(byte[].class, ser);
        }
        {
            BaseSerializer<IntArrayTag, int[]> ser = new BaseSerializer<IntArrayTag, int[]>() {
                @Override
                public IntArrayTag write(int[] value) {
                    return new IntArrayTag(value);
                }

                @Override
                public int[] read(IntArrayTag tag, Class<? extends int[]> type) {
                    return tag.getAsIntArray();
                }
            };
            addBase(int[].class, ser);
        }
        {
            BaseSerializer<StringTag, String> ser = new BaseSerializer<StringTag, String>() {
                @Override
                public StringTag write(String value) {
                    return StringTag.valueOf(value);
                }

                @Override
                public String read(StringTag tag, Class<? extends String> type) {
                    return tag.getAsString();
                }
            };
            addBase(String.class, ser);
        }
        {
            CompoundSerializer<CompoundTag> ser = new CompoundSerializer<CompoundTag>() {
                Field tagMapField;

                {
                    tagMapField = ReflectionUtils.getObfField(CompoundTag.class, "tagMap", "field_74784_a");
                    tagMapField.setAccessible(true);
                }

                @Override
                public void write(CompoundTag tag, CompoundTag value) {
                    move(value, tag);
                }

                @Override
                public void read(CompoundTag tag, CompoundTag value) {
                    move(tag, value);
                }

                @SuppressWarnings("unchecked")
                private void move(CompoundTag from, CompoundTag to) {
                    try {
                        Map<String, Tag> map = (Map) tagMapField.get(from);
                        for (String id : map.keySet()) {
                            to.put(id, from.get(id));
                        }
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            };
            addCompound(CompoundTag.class, ser);
        }
        { // Collection
            addSupplier(Collection.class, ArrayList::new);
            addSupplier(List.class, ArrayList::new);
            addSupplier(Set.class, HashSet::new);
            CompoundSerializer<Collection> ser = new CompoundSerializer<Collection>() {
                @Override
                public void write(CompoundTag tag, Collection value) {
                    ListTag ret = new ListTag();

                    for (Object obj : value) {
                        ret.add(writeDynamic(obj));
                    }

                    tag.put("l", ret);
                }

                @Override
                public void read(CompoundTag tag_, Collection value) {
                    value.clear();

                    ListTag tag = (ListTag) tag_.get("l");
                    for (int i = 0; i < tag.size(); ++i) {
                        value.add(readDynamic(tag.getCompound(i)));
                    }
                }
            };
            addCompound(Collection.class, ser);
        }
        { // Map
            addSupplier(Map.class, HashMap::new);
            CompoundSerializer<Map<?, ?>> ser = new CompoundSerializer<Map<?, ?>>() {
                @Override
                public void write(CompoundTag tag, Map<?, ?> value) {
                    ListTag ret = new ListTag();

                    for (Entry ent : value.entrySet()) {
                        CompoundTag kvpair = new CompoundTag();
                        kvpair.put("k", writeDynamic(ent.getKey()));
                        kvpair.put("v", writeDynamic(ent.getValue()));

                        ret.add(kvpair);
                    }

                    tag.put("l", ret);
                }

                @Override
                public void read(CompoundTag tag_, Map<?, ?> map) {
                    map.clear();

                    Map erasedMap = (Map) map;
                    ListTag tag = (ListTag) tag_.get("l");

                    for (int i = 0; i < tag.size(); ++i) {
                        CompoundTag tag2 = tag.getCompound(i);

                        Object key = readDynamic(tag2.getCompound("k"));
                        Object value = readDynamic(tag2.getCompound("v"));

                        erasedMap.put(key, value);
                    }
                }
            };
            addCompound(Map.class, (CompoundSerializer) ser);
        }
        {
            addBase(BitSet.class, new BaseSerializer<Tag, BitSet>() {
                @Override
                public Tag write(BitSet value) {
                    return new ByteArrayTag(value.toByteArray());
                }

                @Override
                public BitSet read(Tag tag, Class<? extends BitSet> type) {
                    return BitSet.valueOf(((ByteArrayTag) tag).getAsByteArray());
                }
            });
        }

    }

    /**
     * Writes the object to given {@link CompoundTag}.
     * If the object is recursive (no custom helper that handles obj has been added via
     * {@link #addCompound(Class, CompoundSerializer)}, fields according to the rules of core API will be written.
     * Otherwise, the custom helper will be used to write the object.
     */
    @SuppressWarnings("unchecked")
    public static void write(CompoundTag tag, Object obj) {
        Preconditions.checkNotNull(obj);

        final Class<?> type = obj.getClass();
        CompoundSerializer serializer = _compound(type);
        if (serializer != null) {
            serializer.write(tag, obj);
        } else { // recursive
            List<Field> fields = helper.getExposedFields(type);
            for (Field f : fields) {
                try {
                    String fieldName = f.getName();
                    Object value = f.get(obj);
                    if (value != null) {
                        if (f.isAnnotationPresent(SerializeDynamic.class)) {
                            tag.put(fieldName, writeDynamic(value));
                        } else {
                            tag.put(fieldName, writeBase(value));
                        }
                    }
                } catch (IllegalAccessException | IllegalArgumentException ex) {
                    Debug.error("Error writing field " + f + " in object " + obj);
                }
            }
        }
    }

    /**
     * Reads the object from given {@link CompoundTag}
     * If the object is recursive (no custom helper that handles obj has been added via
     * {@link #addCompound(Class, CompoundSerializer)}, fields according to the rules of core API will be read.
     * Otherwise, the custom helper will be used to read the object.
     */
    @SuppressWarnings("unchecked")
    public static void read(CompoundTag tag, Object obj) {
        Preconditions.checkNotNull(obj);

        final Class<?> type = obj.getClass();
        CompoundSerializer serializer = _compound(type);
        if (serializer != null) {
            serializer.read(tag, obj);
        } else { // recursive
            List<Field> fields = helper.getExposedFields(type);
            for (Field f : fields) {
                try {
                    String fieldName = f.getName();
                    Tag base = tag.get(fieldName);
                    if (base != null) {
                        if (f.isAnnotationPresent(SerializeDynamic.class)) {
                            f.set(obj, readDynamic((CompoundTag) base));
                        } else {
                            f.set(obj, readBase(base, f.getType()));
                        }
                    }
                } catch (IllegalAccessException |
                        RuntimeException ex) {
                    ex.printStackTrace();
                    // LambdaLib.log.error("Error reading field " + f + " in object " + obj, ex);
                }
            }
        }
    }

    public static Tag writeBase(Object obj) {
        return writeBase(obj, obj.getClass());
    }

    @SuppressWarnings("unchecked")
    public static Tag writeBase(Object obj, Class<?> type) {
        Preconditions.checkNotNull(obj);

        if (type.isEnum()) {
            return enumSer.write((Enum) obj);
        }

        BaseSerializer serializer = _base(type);

        if (serializer != null) {
            return serializer.write(obj);
        } else if (type.isArray()) {
            Class baseType = type.getComponentType();

            CompoundTag tag = new CompoundTag();

            int length = Array.getLength(obj);
            tag.putInt("size", length);
            for (int i = 0; i < length; ++i) {
                tag.put(String.valueOf(i), writeBase(Array.get(obj, i), baseType));
            }

            return tag;
        } else {
            CompoundTag tag = new CompoundTag();
            write(tag, obj);
            return tag;
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T readBase(Tag base, Class<T> type) {
        Preconditions.checkNotNull(base);

        if (type.isEnum()) {
            return (T) enumSer.read((ByteTag) base, (Class) type);
        }

        BaseSerializer serializer = _base(type);
        if (serializer != null) {
            return (T) serializer.read(base, type);
        } else if (type.isArray()) {
            CompoundTag tag = (CompoundTag) base;
            Class baseType = type.getComponentType();
            int size = tag.getInt("size");
            Object array = Array.newInstance(baseType, size);

            for (int i = 0; i < size; ++i) {
                Array.set(array, i, readBase(tag.get(String.valueOf(i)), baseType));
            }
            return (T) array;
        } else if (base instanceof CompoundTag) {
            CompoundTag tag = (CompoundTag) base;
            T instance = instantiate(type);

            read(tag, instance);

            return instance;
        } else throw new RuntimeException("Doesn't support tag type " + base);
    }

    public static <T> void addBase(Class<T> type, BaseSerializer<?, T> serializer) {
        baseSerializerMap.put(type, serializer);
        helper.regS11nType(type);
    }

    public static <T> void addCompound(Class<T> type, CompoundSerializer<? super T> serializer) {
        compoundSerializerMap.put(type, serializer);
        helper.regS11nType(type);
    }

    public static <T> void addSupplier(Class<T> type, Supplier<? extends T> supplier) {
        supplierMap.put(type, supplier);
    }

    public static CompoundTag writeDynamic(Object obj) {
        CompoundTag tag = new CompoundTag();
        tag.putString("t", obj.getClass().getCanonicalName());
        tag.put("d", writeBase(obj));

        return tag;
    }

    public static Object readDynamic(CompoundTag tag) {
        try {
            String klass = tag.getString("t");
            Class type = Class.forName(klass);
            return readBase(tag.get("d"), type);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    private static <T> T instantiate(Class<T> type) {
        if (supplierMap.containsKey(type)) {
            return (T) supplierMap.get(type).get();
        }
        try {
            Constructor<T> ctor = type.getConstructor();
            ctor.setAccessible(true);
            return ctor.newInstance();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Make given type to be exposed in recursive s11n. Subtypes not included.
     */
    public static void regS11nType(Class<?> type) {
        helper.regS11nType(type);
    }

    @SuppressWarnings("unchecked")
    private static <T> BaseSerializer<?, T> _base(Class<T> type) {
        return baseSerializerMap.get(type);
    }

    @SuppressWarnings("unchecked")
    private static <T> CompoundSerializer<? super T> _compound(Class<T> type) {
        Class<? super T> cur = type;
        while (cur != null) {
            if (compoundSerializerMap.containsKey(cur)) {
                return compoundSerializerMap.get(cur);
            }
            cur = cur.getSuperclass();
        }
        // Interfaces
        for (Class c : type.getInterfaces()) {
            CompoundSerializer<? super T> test = _compound(c);
            if (test != null) {
                return test;
            }
        }
        return null;
    }

    public interface BaseSerializer<NBT extends Tag, T> {
        NBT write(T value);

        T read(NBT tag, Class<? extends T> type);
    }

    public interface CompoundSerializer<T> {
        void write(CompoundTag tag, T value);

        void read(CompoundTag tag, T value);
    }

}
