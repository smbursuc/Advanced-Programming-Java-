package org.bursucserban;

import org.testng.annotations.Test;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class App
{
    //String root = "D:\\PA_Bursuc_Serban-Mihai_2E3\\Laboratoare\\Lab12\\compulsory12\\target\\classes\\org\\example";
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        String root = "D:\\PA_Bursuc_Serban-Mihai_2E3\\Laboratoare\\Lab12\\compulsory12\\target\\classes";
        String Package = "org.example.";
        Files.walk(Paths.get(root))
                .filter(Files::isRegularFile)
                .forEach(path ->
                        {
                            File classDirectory = new File(root);
                            Class<?> clazz = null;
                            try
                            {
                                URLClassLoader classLoader = new URLClassLoader(new URL[]{classDirectory.toURI().toURL()});
                                String filename = path.getFileName().toString();
                                clazz = classLoader.loadClass(Package + filename.substring(0,filename.length()-".class".length()));
                            }
                            catch (Exception e)
                            {
                                // something went wrong..
                                e.printStackTrace();
                            }

                            System.out.println("\nClass name: " + clazz.getName());
                            System.out.println("Constructors: ");
                            for(Constructor constructor : clazz.getConstructors())
                            {
                                System.out.println(constructor);
                            }
                            System.out.println("Methods:");
                            for(Method method : clazz.getMethods())
                            {
                                System.out.println(method.getReturnType() + " " + method.getName());
                            }
                            int passed = 0, failed = 0;
                            for (Method m : clazz.getMethods())
                            {
                                if (m.isAnnotationPresent(Test.class))
                                {
                                    try
                                    {
                                        m.invoke(null);
                                        passed++;
                                    }
                                    catch (Throwable ex)
                                    {
                                        System.out.printf("Test %s failed: %s %n",
                                                m, ex.getCause());
                                        failed++;
                                    }
                                }
                            }
                            System.out.printf("Passed: %d, Failed %d%n", passed, failed);

                        }
                );

    }
}
