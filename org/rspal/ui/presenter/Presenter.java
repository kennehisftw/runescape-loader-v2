package org.rspal.ui.presenter;

import org.rspal.ui.model.Model;
import org.rspal.ui.view.View;

/**
 * @author : const_
 * Used to do all the work for the ui
 */
public abstract class Presenter <V extends View, M extends Model> {

    private V view;
    private M model;

    protected Presenter() {
        link();
    }

    public abstract void link();

    public abstract void show();

    public abstract void hide();

    public V view() {
        return view;
    }

    public M model() {
        return model;
    }

    protected void set(V view, M model) {
        this.view = view;
        this.model = model;
        model.link();
        view.link();
    }
}
