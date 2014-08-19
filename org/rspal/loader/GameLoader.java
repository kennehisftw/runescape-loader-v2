package org.rspal.loader;

import org.rspal.util.Internet;

import java.applet.Applet;
import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.concurrent.Callable;

/**
 * @author : const_
 */
public class GameLoader implements Callable<Applet> {

    private Applet applet;
    private GameStub stub;
    private ClassLoader classLoader;

    public GameLoader() {
        stub = new GameStub();
    }

    @Override
    public Applet call() throws Exception {
        String initial = stub.getParameter("initial_class");
        System.out.println(stub.getParameter("initial_jar"));
        URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{new URL(Crawler.URL_BASE + stub.getParameter("initial_jar"))});
        Class<?> clazz = urlClassLoader.loadClass(initial.substring(0, initial.indexOf(".class")));
        applet = clazz.asSubclass(Applet.class).newInstance();
        applet.setStub(stub);
        applet.init();
        applet.start();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.getType().equals(Class.class)) {
                field.setAccessible(true);
                classLoader = ((Class) field.get(applet)).getClassLoader();
                break;
            }
        }
        return applet;
    }

    public ClassLoader classLoader() {
        return classLoader;
    }
}
