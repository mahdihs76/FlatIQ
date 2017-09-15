package com.example.mahdihs76.flatiq.tool;

import android.view.View;

import com.github.amlcurran.showcaseview.targets.PointTarget;

/**
 * Created by mahdihs76 on 9/15/17.
 */

public class CaseView {
    private String title;
    private String description;
    private PointTarget targetView;

    public CaseView(String title, String description, PointTarget targetView) {
        this.title = title;
        this.description = description;
        this.targetView = targetView;
    }


    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public PointTarget getTargetView() {
        return targetView;
    }
}
