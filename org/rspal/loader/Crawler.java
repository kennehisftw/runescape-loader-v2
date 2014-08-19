package org.rspal.loader;

import org.rspal.util.Internet;

/**
 * @author : const_
 */
public class Crawler {

    public static final String URL_BASE = "http://world42.runescape.com/";
    private static final String CONFIG_URL = URL_BASE + "jav_config.ws";
    private GameStub stub;

    public Crawler(GameStub stub) {
        this.stub = stub;
        crawl();
    }

    private void crawl() {
        String text = Internet.download(CONFIG_URL).text();
        for(String line : text.split(" ")) {
            if(!line.contains("=")) {
                continue;
            }
            line = line.replaceAll("param=", "");
            String key = line.substring(0, line.lastIndexOf('='));
            String value = line.substring(line.lastIndexOf('=') + 1);
            stub.setParameter(key, value);
        }
    }
}
