package com.maxsop.customlistviewall;

public class Model {
    String title;
    String description;
    int icon;

    public Model(String title, String description, int icon) {
        this.title = title;
        this.description = description;
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getIcon() {
        return icon;
    }
}
