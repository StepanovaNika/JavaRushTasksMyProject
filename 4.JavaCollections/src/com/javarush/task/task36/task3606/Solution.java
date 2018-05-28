package com.javarush.task.task36.task3606;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/* 
Осваиваем ClassLoader и Reflection
*/
public class Solution {
    private List<Class> hiddenClasses = new ArrayList<>();
    private String packageName;

    public Solution(String packageName) {
        this.packageName = packageName;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Solution solution = new Solution(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "com/javarush/task/task36/task3606/data/second");
        solution.scanFileSystem();
        System.out.println(solution.getHiddenClassObjectByKey("hiddenclassimplse"));
        System.out.println(solution.getHiddenClassObjectByKey("hiddenclassimplf"));
        System.out.println(solution.getHiddenClassObjectByKey("packa"));
    }

    public void scanFileSystem() throws ClassNotFoundException {
        File dir = new File(packageName);
        String[] classFile = dir.list();
        for (String file : classFile) {
            String path = dir.getAbsolutePath() + File.separator;
            ClassLoader classLoader = new ClassLoader() {
                @Override
                protected Class<?> findClass(String name) throws ClassNotFoundException {
                    byte[] b = getBytesFromFile(path + name + ".class");

                    return defineClass(null, b, 0, b.length);
                }

                private byte[] getBytesFromFile(String fileName) {
                    File file1 = new File(fileName);
                    FileInputStream fis = null;
                    try {
                        fis = new FileInputStream(file1);
                    } catch (Exception e) {
                        return null;
                    }
                    BufferedInputStream bis = new BufferedInputStream(fis);
                    int size = (int) file1.length();
                    byte[] bytes = new byte[size];
                    int rb = 0;
                    int chunk = 0;
                    while ((size - rb) > 0) {
                        try {
                            chunk = bis.read(bytes, rb, size - rb);
                            if (chunk == -1) {
                                break;
                            }
                            rb += chunk;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    return bytes;

                }
            };
            Class clazz = classLoader.loadClass(file.substring(0, file.lastIndexOf(".")));
            if (HiddenClass.class.isAssignableFrom(clazz)) {
                hiddenClasses.add(clazz);
            }
        }
    }

    public HiddenClass getHiddenClassObjectByKey(String key) {
        for (Class clas : hiddenClasses) {
            if (clas.getSimpleName().toLowerCase().startsWith(key.toLowerCase())) {
                try {
                    Constructor[] constructors = clas.getDeclaredConstructors();
                    for (Constructor constructor : constructors) {
                        if (constructor.getParameterTypes().length == 0) {
                            constructor.setAccessible(true);
                            return (HiddenClass) constructor.newInstance(null);
                        }
                    }
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}

