package cn.evole.mods.academy.utils;

import cn.evole.mods.academy.constant.Debug;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forgespi.language.ModFileScanData;
import org.objectweb.asm.Type;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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

}
