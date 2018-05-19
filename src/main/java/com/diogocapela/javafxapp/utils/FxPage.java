package com.diogocapela.javafxapp.utils;

public class FxPage {

    private String pageName;
    private String pageFile;

    public FxPage(String name, String file) {
        this.pageName = name;
        this.pageFile = file;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public String getPageFile() {
        return pageFile;
    }

    public void setPageFile(String pageFile) {
        this.pageFile = pageFile;
    }

}
