package com.ramo.test;

import com.ramo.sweetrecycleradapter.SweetModel;

public class ExampleModel extends SweetModel {

    private String text;

    public ExampleModel(int viewType, String text) {
        super(viewType);
        this.text = text;
    }

    public String getText() {
        return text;
    }
}