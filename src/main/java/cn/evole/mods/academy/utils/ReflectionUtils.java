package cn.evole.mods.academy.utils;

import cn.evole.mods.academy.constant.Debug;
import cn.evole.mods.academy.utils.java.Cast;
import com.google.common.collect.Lists;
import net.neoforged.fml.ModList;
import net.neoforged.neoforgespi.language.ModFileScanData;
import org.objectweb.asm.Type;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Name: AcademyCraft2 / ReflectionUtils
 * Author: cnlimiter
 * CreateTime: 2023/12/23 2:49
 * Description:
 */

public class ReflectionUtils {
    public static List<ModFileScanData> scanData = ModList.get().getAllScanData();


    public static List<ModFileScanData.AnnotationData> getAnnotations(Class<? extends Annotation> annoClass){
        final Type MOD_TYPE = Type.getType(annoClass);

        return scanData
                .stream()
                .map(ModFileScanData::getAnnotations)
                .flatMap(Collection::stream)
                .filter(a -> MOD_TYPE.equals(a.annotationType()))
                .toList();
    }

    /**
     * Get all methods in all classes with given annotation.
     */
    public static List<Method> getMethods(Class<? extends Annotation> annoClass) {

        final List<ModFileScanData.AnnotationData> annotations = getAnnotations(annoClass);


        return annotations.stream()
                .map(data -> {
                    try {
                        Class<?> type = Class.forName(data.clazz().getClassName());

                        String fullDesc = data.targetType().name();
                        int idx = fullDesc.indexOf('(');
                        String methodName = fullDesc.substring(0, idx);
                        String desc = fullDesc.substring(idx);

                        Type[] rawArgs = Type.getArgumentTypes(desc);
                        Class[] args = new Class[rawArgs.length];
                        for (int i = 0; i < rawArgs.length; ++i) {
                            args[i] = Class.forName(rawArgs[i].getClassName());
                        }

                        return type.getDeclaredMethod(methodName, args);
                    } catch (RuntimeException e) {
                        throw e;
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.toList());
    }


    /**
     * Get all classes with given annotation.
     */
    public static List<Class<?>> getClasses(Class<? extends Annotation> annoClass) {
        final List<ModFileScanData.AnnotationData> annotations = getAnnotations(annoClass);

        return annotations.stream()
                .map(ModFileScanData.AnnotationData::clazz)
                .distinct()
                .map(it -> {
                    try {
                        return Class.forName(it.getClassName());
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.toList());
    }

    /**
     * Get all fields with given annotation.
     */
    public static List<Field> getFields(Class<? extends Annotation> annoClass) {
        final List<ModFileScanData.AnnotationData> annotations = getAnnotations(annoClass);
        List<Field> ret = annotations.stream()
                .filter(data -> !data.targetType().name().equals(data.clazz().getClassName()))
                .map(it -> {
                    try {
                        return Class.forName(it.clazz().getClassName()).getDeclaredField(it.targetType().name());
                    } catch (ClassNotFoundException|NoSuchFieldException ex) {
                        throw new RuntimeException(ex);
                    } catch (NoClassDefFoundError ex)
                    {
                        Debug.log(String.format("Error when get field %s.%s ", it.clazz().getClassName(), it.targetType().name()));
                        throw new RuntimeException(ex);
                    }
                })
                .toList();
        for (Field f : ret)
            f.setAccessible(true);
        return ret;
    }

    /**
     * Get all the methods for a class, including those that are private or protected in parent class.
     * All the methods are made accessible.
     */
    public static List<Method> getAccessibleMethods(Class<?> cls) {
        List<Method> ret = new ArrayList<>();

        while (cls != null) {
            for (Method m : cls.getDeclaredMethods()) {
                m.setAccessible(true);
                ret.add(m);
            }
            cls = cls.getSuperclass();
        }

        return ret;
    }

    public static Method getObfMethod(Class<?> cl, String methodName, String obfName, Class<?>... parameterTypes) {
        Method m = null;
        try {
            try {
                m = cl.getDeclaredMethod(methodName, parameterTypes);
            } catch (Exception ignored) {
            }

            if (m == null)
                m = cl.getDeclaredMethod(obfName, parameterTypes);

            m.setAccessible(true);
            return m;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Get a class field (both in workspace and in builds) by its deobf name and obf name.
     */
    public static Field getObfField(Class<?> cl, String normName, String obfName) {
        Field f = null;
        try {
            try {
                f = cl.getDeclaredField(normName);
            } catch (Exception ignored) {}

            if (f == null) {
                f = cl.getDeclaredField(obfName);
            }
            f.setAccessible(true);
            return f;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    private static Field modifiersField;
    private static Object reflectionFactory;
    private static Method newFieldAccessor;
    private static Method fieldAccessorSet;

    public static Class<?> getArrayComponent(Class<?> array)
    {
        return array.isArray() ? getArrayComponent(array.getComponentType()) : array;
    }

    public static <T> Class<?> findCommonSuperClass(Collection<T> coll)
    {
        if(coll.isEmpty())
        {
            return Void.class;
        } else
        {
            Class<?> oclass = null;

            for(T t : coll)
            {
                if(oclass == null)
                    oclass = t.getClass();
                else
                    oclass = findClosestAncestor(oclass, t.getClass());
            }

            return oclass;
        }
    }

    public static <T> Class<?> findCommonSuperClass(Collection<T> coll, Function<T, Class<?>> toClass)
    {
        if(coll.isEmpty())
        {
            return Void.class;
        } else
        {
            Class<?> oclass = null;
            for(T t : coll)
                if(oclass == null)
                    oclass = toClass.apply(t);
                else
                    oclass = findClosestAncestor(oclass, toClass.apply(t));
            return oclass;
        }
    }

    public static Class<?> findClosestAncestor(Class<?> a, Class<?> b)
    {
        while(!a.isAssignableFrom(b))
            a = a.getSuperclass();
        return a;
    }

    public static boolean doesParameterTypeArgsMatch(Parameter param, Class<?>... baseArgs)
    {
        java.lang.reflect.Type[] args = getTypeArgs(param.getParameterizedType());
        if(args.length != baseArgs.length)
            return false;
        for(int i = 0; i < args.length; ++i)
            if(!(args[i] instanceof Class) || !baseArgs[i].isAssignableFrom((Class) args[i]))
                return false;
        return true;
    }

    public static boolean doesParameterTypeArgsMatch(Field field, Class<?>... baseArgs)
    {
        java.lang.reflect.Type[] args = getTypeArgs(field.getGenericType());
        if(args.length != baseArgs.length)
            return false;
        for(int i = 0; i < args.length; ++i)
            if(!(args[i] instanceof Class) || !baseArgs[i].isAssignableFrom((Class) args[i]))
                return false;
        return true;
    }

    /**
     * Examples: For List< String> returns [Type(String)]
     */
    public static java.lang.reflect.Type[] getTypeArgs(java.lang.reflect.Type type)
    {
        if(type instanceof ParameterizedType)
        {
            ParameterizedType pt = (ParameterizedType) type;
            return pt.getActualTypeArguments();
        }
        return new java.lang.reflect.Type[0];
    }

    public static Class<?> fetchClassAny(Type type)
    {
        return fetchClass(type.getSort() < Type.ARRAY ? type.getClassName() : type.getInternalName().replace('/', '.'));
    }

    public static <T> Class<T> fetchClass(Type type)
    {
        return fetchClass(type.getSort() < Type.ARRAY ? type.getClassName() : type.getInternalName().replace('/', '.'));
    }

    public static <T> Class<T> fetchClass(String name)
    {
        try
        {
            return Cast.cast(Class.forName(name));
        } catch(ClassNotFoundException ignored)
        {
        } catch(RuntimeException e)
        {
            if(e.getMessage().contains("invalid dist"))
            {
                Debug.warn("Attempted to load class from invalid dist: " + name, e);
            }
        }
        return null;
    }

    public static Iterable<Field> getFieldsUpTo(@Nonnull Class<?> startClass,
                                                @Nullable Class<?> exclusiveParent)
    {

        List<Field> currentClassFields = Lists.newArrayList(startClass.getDeclaredFields());
        Class<?> parentClass = startClass.getSuperclass();

        if(parentClass != null &&
                (exclusiveParent == null || !(parentClass.equals(exclusiveParent))))
        {
            List<Field> parentClassFields =
                    (List<Field>) getFieldsUpTo(parentClass, exclusiveParent);
            currentClassFields.addAll(parentClassFields);
        }

        return currentClassFields;
    }

    public static Object lookupValue(Object object, Class<?> type)
    {
        Field field = lookupField(object.getClass(), type);
        if(field == null)
            return null;
        try
        {
            return field.get(object);
        } catch(Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    public static Field lookupField(Class<?> clazz, Class<?> type)
    {
        Field ret = null;
        for(Field field : clazz.getDeclaredFields())
        {
            if(type.isAssignableFrom(field.getType()))
            {
                if(ret != null)
                    return null;
                field.setAccessible(true);
                ret = field;
            }
        }
        return ret;
    }

    public static List<Field> lookupFields(Class<?> clazz, Class<?> type)
    {
        List<Field> fields = new ArrayList<>();
        for(Field field : clazz.getDeclaredFields())
        {
            if(type.isAssignableFrom(field.getType()))
            {
                field.setAccessible(true);
                fields.add(field);
            }
        }
        return fields;
    }

    public static Field lookupField(Class<?> clazz, String name)
    {
        Field ret = null;
        for(Field field : clazz.getDeclaredFields())
        {
            if(name.equals(field.getName()))
            {
                if(ret != null)
                    return null;
                field.setAccessible(true);
                ret = field;
            }
        }
        return ret;
    }

    public static <T> Optional<T> fetchValue(Field field, Object instance, Class<T> targetType)
    {
        try
        {
            field.setAccessible(true);
            return Cast.optionally(field.get(instance), targetType);
        } catch(Throwable err)
        {
        }
        return Optional.empty();
    }

    public static Class<?> getCaller()
    {
        try
        {
            return Class.forName(Thread.currentThread().getStackTrace()[1].getClassName());
        } catch(ClassNotFoundException e)
        {
            return null;
        }
    }

    public static <T> Optional<T> getField(Object anything, int i, Class<T> cast)
    {
        try
        {
            Field f = anything.getClass().getDeclaredFields()[i];
            f.setAccessible(true);
            return Cast.optionally(f.get(anything), cast);
        } catch(Throwable e)
        {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public static <T> Optional<T> getStaticFinalField(Class<?> owner, String member)
    {
        try
        {
            Field f = owner.getDeclaredField(member);
            f.setAccessible(true);
            return Optional.ofNullable(Cast.cast(f.get(null)));
        } catch(ReflectiveOperationException e)
        {
            if(!(e instanceof NoSuchFieldException))
                e.printStackTrace();
        }
        return Optional.empty();
    }

    public static Method findDeclaredMethod(Class<?> c, String member, Predicate<Method> o) throws NoSuchMethodException
    {
        for(Method method : c.getDeclaredMethods())
            if(method.getName().equals(member) && o.test(method))
                return method;
        throw new NoSuchMethodException(c.getName() + "/" + member);
    }

}
