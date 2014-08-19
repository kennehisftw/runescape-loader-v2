package org.rspal;

import com.jtattoo.plaf.hifi.HiFiLookAndFeel;
import org.rspal.ui.UIManager;
import org.rspal.ui.presenter.MainPresenter;

import javax.swing.*;

/**
 * @author : const_
 */
public class Application {

    public static void main(String[] args) {
        try {
            javax.swing.UIManager.setLookAndFeel(new HiFiLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        MainPresenter presenter = UIManager.get(MainPresenter.class);
        presenter.show();
    }

}
