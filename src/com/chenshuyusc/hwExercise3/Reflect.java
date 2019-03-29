package com.chenshuyusc.hwExercise3;

import java.lang.reflect.*;
import java.util.HashSet;
import java.util.Set;

public class Reflect {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException, NoSuchFieldException {

        Teacher teacher = new Teacher();
        Class teacherClass1 = teacher.getClass();

        Class teacherClass2 = Teacher.class;

        Class teacherClass3;
        try {
            teacherClass3 = Class.forName("com.chenshuyusc.hwExercise3.Teacher");//括号内需要一个字符串，所以要加引号
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Field[] fields1 = teacherClass1.getFields();
        Field[] fields2 = teacherClass1.getDeclaredFields();
        Set<Field> fields = new HashSet<>();
        addElement(fields, fields1);
        addElement(fields, fields2);
        System.out.println("Fields:");
        printfField(fields, teacher);
        printDivide();

        Constructor[] constructors1 = teacherClass1.getConstructors();
        Constructor[] constructors2 = teacherClass1.getDeclaredConstructors();
        Set<Constructor> constructors = new HashSet<>();
        addElement(constructors, constructors1);
        addElement(constructors, constructors2);
        System.out.println("Constructors:");
        printConstructor(constructors);
        printDivide();

        Class personClass = teacherClass1.getSuperclass();
        System.out.println("The parent class which Teacher extends:\n" + personClass);
        printDivide();

        Class<?>[] interfaces = personClass.getInterfaces();
        for (Class<?> inter : interfaces) {
            System.out.println("Interface:\n" + inter);
        }
        printDivide();

        Method[] methods1 = teacherClass1.getMethods();
        Method[] methods3 = teacherClass1.getDeclaredMethods();
        Method[] methods2 = personClass.getMethods();
        Method[] methods4 = personClass.getDeclaredMethods();
        Set<Method> methods = new HashSet<>();
        addElement(methods, methods1);
        addElement(methods, methods2);
        addElement(methods, methods3);
        addElement(methods, methods4);
        printMethods(methods);
        printDivide();

        System.out.println("Use all methods: ");
        useMethod(teacherClass1);
    }

    private static <T> Set<T> addElement(Set<T> set, T[] array) {
        for (T t : array) {
            set.add(t);
        }
        return set;
    }

    private static void printfField(Set<Field> set, Object object) throws IllegalAccessException {
        for (Field field : set) {
            field.setAccessible(true);
            System.out.println("修饰符:  " + Modifier.toString(field.getModifiers()) + "  类型:  " + field.getType().getCanonicalName() + "  属性值:  " + field.get(object));
        }
    }

    private static void printConstructor(Set<Constructor> constructors) {
        for (Constructor con : constructors) {
            System.out.println(con);
        }
    }

    private static void printMethods(Set<Method> methods) {
        for (Method m : methods) {
            m.setAccessible(true);
            System.out.println("修饰符:  " + Modifier.toString(m.getModifiers()));
            System.out.println("返回值:  " + m.getReturnType());
            System.out.println("方法名:  " + m.getName());
            Class<?>[] parameterTypes = m.getParameterTypes();
            System.out.printf("参数:");
            if (parameterTypes.length == 0) {
                System.out.printf("无参数");
            } else {
                for (Class<?> p : parameterTypes) {
                    System.out.print(p.getName() + "  ");
                }
            }
            System.out.println("\n");
        }
    }

    private static void printDivide() {
        System.out.println("--------------我是一条分割线--------------");
    }

    private static void useMethod(Class cls) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Constructor privateC = cls.getDeclaredConstructor(String.class, int.class, double.class);
        privateC.setAccessible(true);
        Teacher teacher = (Teacher) privateC.newInstance("沙拉", 22, 2222.0);

        Method m1 = cls.getMethod("AddAge", int.class);
        int age = (Integer) m1.invoke(teacher, 44);
        System.out.println("AddAge 方法的返回值: " + age);

        Method m2 = cls.getMethod("eat", String.class);
        m2.invoke(teacher, "水果");

        Method m3 = cls.getMethod("eat", String.class, int.class);
        m3.invoke(teacher, "许多水果", 1);

        Method m4 = cls.getMethod("toString");
        String str = (String) m4.invoke(teacher);
        System.out.println("toString() 方法的返回值：" + str);

        Method m5 = cls.getDeclaredMethod("testStatic");
        m5.setAccessible(true);
        m5.invoke(teacher);
    }
}
