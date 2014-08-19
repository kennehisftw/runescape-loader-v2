package org.rspal.ui.view;

import org.rspal.ui.model.Model;
import org.rspal.ui.presenter.Presenter;

/**
 * @author : const_
 * Used for the design of the ui
 */
public abstract class View<P extends Presenter, M extends Model> {

    private P presenter;
    private M model;

    public View(P presenter) {
        this.presenter = presenter;
        init();
    }

    public abstract void init();

    @SuppressWarnings("unchecked")
    public void link() {
        model = (M) presenter.model();
    }

    public P presenter() {
        return presenter;
    }

    public M model() {
        return model;
    }
}
