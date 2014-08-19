package org.rspal.ui.view;

import org.rspal.util.Internet;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Kenneth on 8/18/2014.
 */
public class ContentPane extends JPanel {

    private final Font font = new Font("Calibri", Font.PLAIN, 15);

    private Image progress;

    public ContentPane() {
        setLayout(new BorderLayout());
        progress = Internet.image("http://img1.wikia.nocookie.net/__cb20131222004220/runescape/images/5/5e/RS3_Load.gif");
    }

    public void paint(Graphics graphics) {
        final Graphics2D g2d = (Graphics2D) graphics;
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2d.setFont(font);
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, getWidth(), getHeight());
        g2d.setColor(Color.WHITE);

        final FontMetrics fm = g2d.getFontMetrics();
        final String status = "Please wait while the client loads!";
        g2d.drawString(status, (getWidth() / 2) - (fm.stringWidth(status) / 2), getHeight() - 15);

        if(progress != null) {
            g2d.drawImage(progress, (getWidth() / 2) - (progress.getWidth(null) / 2), (getHeight() / 2) - progress.getHeight(null) / 2, null);
        }

        repaint(200);
    }
}
