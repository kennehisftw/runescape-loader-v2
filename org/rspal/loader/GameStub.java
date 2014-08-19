package org.rspal.loader;

import java.applet.AppletContext;
import java.applet.AppletStub;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : const_
 */
public class GameStub implements AppletStub {

    private static final Map<String, String> PARAMETERS = new HashMap<>();

    public GameStub() {
        new Crawler(this);
    }

    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public URL getDocumentBase() {
        try {
            return new URL(PARAMETERS.get("codebase"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public URL getCodeBase() {
        try {
            return new URL(PARAMETERS.get("codebase"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getParameter(String name) {
        return PARAMETERS.get(name);
    }

    @Override
    public AppletContext getAppletContext() {
        return null;
    }

    public void setParameter(String name, String value) {
        PARAMETERS.put(name, value);
    }

    @Override
    public void appletResize(int width, int height) {
    }
}
