package org.example;

import org.testng.annotations.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;

public class App
{
    public static void main( String[] args ) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException
    {
        Class clazz = Class.forName("org.example.MyProgram");
        System.out.println("Name: " + clazz.getName());
        System.out.println("Package: " + clazz.getPackageName());
        System.out.println("Is interface: " + clazz.isInterface());
        Method[] methods = clazz.getMethods();
        System.out.println("\nMethods:");
        for(Method method : methods)
        {
            System.out.println(method.getName());
        }
        System.out.println("\nConstructors:");
        Constructor[] constructors = clazz.getConstructors();
        for(Constructor constructor : constructors)
        {
            System.out.println(constructor);
        }

        int passed = 0, failed = 0;
        for (Method m : Class.forName("org.example.MyProgram").getMethods()) {
            if (m.isAnnotationPresent(Test.class)) {
                try {
                    m.invoke(null);
                    passed++;
                } catch (Throwable ex) {
                    System.out.printf("Test %s failed: %s %n",
                            m, ex.getCause());
                    failed++;
                }
            }
        }
        System.out.printf("Passed: %d, Failed %d%n", passed, failed);


    }
}
