package org.rspal.util;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.awt.*;
import java.io.IOException;
import java.net.URL;

/**
 * @author : const_
 */
public class Internet {

    public static Connection connect(String url) {
        return Jsoup.connect(url);
    }

    public static Document download(String url) {
        Connection conn = connect(url);
        try {
            return conn.get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Image image(String url) {
        try {
            return Toolkit.getDefaultToolkit().createImage(new URL(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Error getting image");
        return null;
    }
}
