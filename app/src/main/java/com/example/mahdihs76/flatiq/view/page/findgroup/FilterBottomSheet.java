package com.example.mahdihs76.flatiq.view.page.findgroup;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.ViewUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.mahdihs76.flatiq.R;
import com.example.mahdihs76.flatiq.model.Group;
import com.example.mahdihs76.flatiq.server.ViewHandler;

import java.util.ArrayList;


public class FilterBottomSheet extends BottomSheetDialogFragment {

    private AppCompatCheckBox ropeCheckBox;
    private AppCompatCheckBox soccerCheckBox;
    private AppCompatCheckBox volleyballCheckBox;

    private Button filterButton;


    private BottomSheetBehavior.BottomSheetCallback mBottomSheetBehaviorCallback = new BottomSheetBehavior.BottomSheetCallback() {

        @Override
        public void onStateChanged(@NonNull View bottomSheet, int newState) {
            if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                dismiss();
            }

        }

        @Override
        public void onSlide(@NonNull View bottomSheet, float slideOffset) {
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.filter_bottomsheet,container,false);


        ropeCheckBox = (AppCompatCheckBox) contentView.findViewById(R.id.radioButton4);
        soccerCheckBox = (AppCompatCheckBox) contentView.findViewById(R.id.radioButton2);
        volleyballCheckBox = (AppCompatCheckBox) contentView.findViewById(R.id.radioButton3);

        filterButton = (Button) contentView.findViewById(R.id.filter_button);
        filterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Group> toRemain = new ArrayList<>();
                ArrayList<Group> groups = Group.groupList;

                for(Group g : groups) {
                    if(ropeCheckBox.isChecked() && g.getActivity().equals("طناب زنی")) {
                        toRemain.add(g);
                        continue;
                    }
                    if(soccerCheckBox.isChecked() && g.getActivity().equals("فوتبال")) {
                        toRemain.add(g);
                        continue;
                    }
                    if(volleyballCheckBox.isChecked() && g.getActivity().equals("والیبال")) {
                        toRemain.add(g);
                        continue;
                    }
                }

                ViewHandler.groupsAdapter.setGroups(toRemain);
                ViewHandler.groupsAdapter.notifyDataSetChanged();
                dismiss();
                Toast.makeText(getActivity(), "فیلترسازی انجام شد.", Toast.LENGTH_SHORT).show();
            }
        });
        return contentView;
    }

    @Override
    public void setupDialog(Dialog dialog, int style) {
        super.setupDialog(dialog, style);
        View contentView = View.inflate(getContext(), R.layout.filter_bottomsheet, null);
        dialog.setContentView(contentView);
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) ((View) contentView.getParent()).getLayoutParams();
        CoordinatorLayout.Behavior behavior = params.getBehavior();

        if( behavior != null && behavior instanceof BottomSheetBehavior ) {
            ((BottomSheetBehavior) behavior).setBottomSheetCallback(mBottomSheetBehaviorCallback);
        }
    }

    public AppCompatCheckBox getRopeCheckBox() {
        return ropeCheckBox;
    }

    public AppCompatCheckBox getSoccerCheckBox() {
        return soccerCheckBox;
    }

    public AppCompatCheckBox getVolleyballCheckBox() {
        return volleyballCheckBox;
    }
}