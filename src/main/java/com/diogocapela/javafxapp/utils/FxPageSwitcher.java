package com.diogocapela.javafxapp.utils;

import javafx.scene.layout.Pane;

import java.util.List;
import java.util.Optional;

public class FxPageSwitcher {

    private List<FxPage> pages;
    private MainPane pane;

    public FxPageSwitcher(MainPane pane, List<FxPage> pages) {
        this.pane = pane;
        this.pages = pages;
    }

    public void showPage(String page) {
        FxPage selectedPage = null;

        try {
            Optional pageFinder = pages.stream().filter(pg -> pg.getPageName() == page).findFirst();
            if(pageFinder.isPresent()) {
                selectedPage = (FxPage) pageFinder.get();
            } else {
                Logger.log("FxPageSwitcher: Can't find page " + page);
                return;
            }
            String viewFile = selectedPage.getPageFile();
            Pane view = new FxView(viewFile).get();
            pane.setPage(view);
        } catch (Exception e) {
            Logger.log("FxPageSwitcher: No page " + page + " please check FxPageSwitcher.");
        }
    }

}
