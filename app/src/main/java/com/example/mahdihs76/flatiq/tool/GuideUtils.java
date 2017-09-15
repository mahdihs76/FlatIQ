package com.example.mahdihs76.flatiq.tool;

import android.app.Activity;
import android.view.MotionEvent;
import android.widget.Button;

import com.example.mahdihs76.flatiq.R;
import com.github.amlcurran.showcaseview.OnShowcaseEventListener;
import com.github.amlcurran.showcaseview.ShowcaseView;

import java.util.ArrayList;

/**
 * Created by mahdihs76 on 9/15/17.
 */

public class GuideUtils {


    public static void showGuide(final Activity activity, final ArrayList<CaseView> list, final int id) {

//        Button btn = (Button) activity.findViewById(R.id.next_button);
        Button button = new Button(activity);
        button.setText("فهمیدم");
        button.setBackground(activity.getResources().getDrawable(R.drawable.filter_button_background));
        new ShowcaseView.Builder(activity, true)
                .setTarget(list.get(id).getTargetView())
                .replaceEndButton(button)
                .singleShot(0)
                .setContentTitle(list.get(id).getTitle())
                .setContentText(list.get(id).getDescription())
                .withHoloShowcase()
                .setStyle(R.style.CustomShowcaseTheme)
                .setShowcaseEventListener(new OnShowcaseEventListener() {
                    @Override
                    public void onShowcaseViewHide(ShowcaseView showcaseView) {
                        if (id < list.size()) {
                            showGuide(activity, list, id + 1);
                        }
                    }

                    @Override
                    public void onShowcaseViewDidHide(ShowcaseView showcaseView) {

                    }

                    @Override
                    public void onShowcaseViewShow(ShowcaseView showcaseView) {

                    }

                    @Override
                    public void onShowcaseViewTouchBlocked(MotionEvent motionEvent) {

                    }
                })
                .hideOnTouchOutside()
                .build();
    }
}
