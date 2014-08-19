package org.rspal.ui;

import org.rspal.ui.presenter.MainPresenter;
import org.rspal.ui.presenter.Presenter;

import java.util.LinkedList;
import java.util.List;

/**
 * @author : const_
 */
public class UIManager {

    private static List<Presenter> PRESENTERS = new LinkedList<>();

    static {
        PRESENTERS.add(new MainPresenter());
    }

    public static <T> T get(Class<T> clazz) {
        for(Presenter presenter : PRESENTERS) {
            if(presenter.getClass().equals(clazz)) {
                return (T) presenter;
            }
        }
        return null;
    }
}
