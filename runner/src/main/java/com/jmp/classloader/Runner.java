package com.jmp.classloader;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class Runner {

    static final Logger logger = LogManager.getLogger(Runner.class.getName());
    private Object   instance;
    private Class<?> clazz;

    public static void main(String[] args) throws Exception {

        new Runner().readConsole();
    }

    private void readConsole() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



        while (true) {
           logger.info("Enter reload for 'reload' implementation and 'say', 'exit' for exit.");
            String s = br.readLine();
            if ("reload".equals(s)) {
                reload();
            } else if ("say".equals(s)) {
                Method method = clazz.getMethod("sayHello");
                method.invoke(instance);
            } else if ("exit".equals(s)) {
                return;
            }
        }
    }

    private void reload() throws Exception {

        URL[] classLoaderUrls = new URL[]{ new URL(
                "file:///home/aliaksandr/implWorld-1.0-SNAPSHOT.jar") };
        URLClassLoader urlClassLoader = new URLClassLoader(classLoaderUrls);
        clazz = urlClassLoader.loadClass("classloader.impl.HelloImpl");
        instance = clazz.getConstructor().newInstance();
    }
}
