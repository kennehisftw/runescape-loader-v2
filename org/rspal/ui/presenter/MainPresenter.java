package org.rspal.ui.presenter;

import org.rspal.loader.GameLoader;
import org.rspal.ui.model.MainModel;
import org.rspal.ui.view.MainView;

/**
 * @author : const_
 */
public class MainPresenter extends Presenter<MainView, MainModel> {

    @Override
    public void link() {
        MainView view = new MainView(this);
        MainModel model = new MainModel(this);
        set(view, model);
        view.link();
        model.link();
    }

    @Override
    public void show() {
        view().frame().setVisible(true);
        try {
            view().frame().getContentPane().add(new GameLoader().call());
        } catch (Exception e) {
            e.printStackTrace();
        }
        view().frame().revalidate();
    }

    @Override
    public void hide() {

    }
}
