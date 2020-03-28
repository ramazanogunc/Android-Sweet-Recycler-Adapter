package com.ramo.sweetrecycleradapter;

public abstract class SweetModel {

    private int viewType = 0;

    public SweetModel(int viewType) {
        this.viewType = viewType;
    }

    public int getViewType() {
        return viewType;
    }


}
