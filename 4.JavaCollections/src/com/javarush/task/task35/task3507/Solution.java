package com.javarush.task.task35.task3507;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;

/* 
ClassLoader - что это такое?
*/
public class Solution {
    public static void main(String[] args) {
        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        Set<Animal> set = new HashSet<>();
        if (!pathToAnimals.endsWith("\\") && !pathToAnimals.endsWith("/")) pathToAnimals += "/";
        final File file = new File(pathToAnimals);
        File[] files = file.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".class");
            }
        });
        for (final File f : files) {
            ClassLoader classLoader = new ClassLoader() {
                @Override
                public Class<?> findClass(String name) throws ClassNotFoundException {
                    try {
                        byte[] buffer = java.nio.file.Files.readAllBytes(f.toPath());
                        return defineClass(null, buffer, 0, buffer.length);
                    }
                    catch (IOException e) {
                        return super.findClass(name);
                    }
                }
            };
            String shortName = file.getName().substring(0, file.getName().length() - 6);
            try {
                Class clazz = classLoader.loadClass(shortName);
                boolean isInterface = false;
                Class[] interfaces = clazz.getInterfaces();
                for (Class c : interfaces) {
                    if (c.equals(Animal.class)) {
                        isInterface = true;
                        break;
                    }
                }
                if (!isInterface) continue;
                boolean isConstructor = false;
                Constructor[] constructors = clazz.getConstructors();
                for (Constructor c : constructors) {
                    if (!Modifier.isAbstract(c.getModifiers()) && Modifier.isPublic(c.getModifiers())) {
                        isConstructor = true;
                        break;
                    }
                }
                if (!isConstructor) continue;
                set.add((Animal) clazz.newInstance());
            }
            catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            catch (InstantiationException e){
                e.printStackTrace();
            }
            catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return set;
    }
    }
