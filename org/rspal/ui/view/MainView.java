package org.rspal.ui.view;

import org.rspal.Application;
import org.rspal.ui.model.MainModel;
import org.rspal.ui.presenter.MainPresenter;
import org.rspal.util.Internet;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URL;

/**
 * @author : const_
 */
public class MainView extends View<MainPresenter, MainModel> {

    private JFrame frame;

    public MainView(MainPresenter presenter) {
        super(presenter);
    }

    @Override
    public void init() {
        frame = new JFrame("RuneScape");
        frame.setIconImage(Internet.image("http://i.imgur.com/G4CyXLQ.png"));
        frame.setContentPane(new ContentPane());
        frame.setSize(1024, 600);
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                confirmClose();
            }
        });
    }

    private void confirmClose() {
        final int option = JOptionPane.showConfirmDialog(frame, "Are you sure you want to close RuneScape?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);
        if(option == 0) {
            System.exit(0);
        }
    }

    public JFrame frame() {
        return frame;
    }
}
