package com.example.mahdihs76.flatiq.view.page.findgroup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mahdihs76.flatiq.R;
import com.example.mahdihs76.flatiq.model.Group;
import com.example.mahdihs76.flatiq.server.ViewHandler;
import com.example.mahdihs76.flatiq.server.WebService;
import com.example.mahdihs76.flatiq.tool.Queries;
import com.example.mahdihs76.flatiq.view.Adapters.findGroup.GroupMemberAdapter;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import static android.view.View.GONE;

/**
 * Created by hamed on 09/14/2017.
 */

public class GroupFragment extends Fragment {
    TextView groupName;
    TextView groupLocation;
    TextView groupSchedule;
    TextView groupField;
    CardView cardView;
    ImageView joinButton;
    BarChart chart;
    View view;

    public static final String personID = "1000";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.group_fragment, container, false);

        ImageView groupImage = (ImageView) view.findViewById(R.id.group_image);
        groupName = (TextView) view.findViewById(R.id.group_name);
        groupLocation = (TextView) view.findViewById(R.id.group_location);
        groupSchedule = (TextView) view.findViewById(R.id.group_schedule);
        groupField = (TextView) view.findViewById(R.id.group_field);
        cardView = (CardView) view.findViewById(R.id.group_card);
        joinButton = (ImageView) view.findViewById(R.id.join_btn);
        chart = (BarChart) view.findViewById(R.id.group_chart);


        joinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Group thisGroup = Queries.getGroupWithId(getArguments().getString("groupId"));
                WebService.addMember(personID, thisGroup.getId(), getActivity());
                ViewHandler.groupMemberAdapter.notifyDataSetChanged();
                if (joinButton.getTag().equals("ok"))
                    Snackbar.make(view, "شما به گروه " + "\"" + thisGroup.getName() + "\"" + " ملحق شدید!", Snackbar.LENGTH_LONG).show();
                else
                    Snackbar.make(view, "شما از گروه " + "\"" + thisGroup.getName() + "\"" + " خارج شدید!", Snackbar.LENGTH_LONG).show();
                switchIcon();
            }
        });

        Group group = Queries.getGroupWithId(getArguments().getString("groupId"));
        if (group != null) {
            Glide.with(getActivity()).load(group.getImageSrc()).into(groupImage);
            groupName.setText(group.getName());
            groupLocation.setText(group.getLocationName());
            groupSchedule.setText(group.getSchedule());
            groupField.setText(group.getActivity());
        }


        RecyclerView recyclerViewMembers = (RecyclerView) view.findViewById(R.id.group_members_recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerViewMembers.setLayoutManager(linearLayoutManager);

        ViewHandler.groupMemberAdapter = new GroupMemberAdapter(getActivity(), Queries.getGroupMembers(getArguments().getString("groupId")));
        recyclerViewMembers.setAdapter(ViewHandler.groupMemberAdapter);

        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(70f, 0));
        entries.add(new BarEntry(68f, 1));
        entries.add(new BarEntry(60f, 2));
        entries.add(new BarEntry(72f, 3));
        entries.add(new BarEntry(70f, 4));
        entries.add(new BarEntry(54f, 5));

        BarDataSet dataset = new BarDataSet(entries, "");
        ArrayList<String> labels = new ArrayList<String>();
        labels.add("یکشنبه");
        labels.add("دوشنبه");
        labels.add("سه شنبه");
        labels.add("چهارشنبه");
        labels.add("پنج شنبه");
        labels.add("جمعه");

        BarData data = new BarData(labels, dataset);
        chart.setData(data);
        chart.setDescription("");

        dataset.setColors(ColorTemplate.COLORFUL_COLORS);
        chart.animateXY(3000, 3000);
        chart.getAxisLeft().setAxisMaxValue(80f);
        chart.getAxisLeft().setEnabled(false);
        chart.getAxisRight().setAxisMaxValue(80f);
        chart.getAxisRight().setEnabled(false);

        (getActivity().findViewById(R.id.map_button)).setVisibility(GONE);
        (getActivity().findViewById(R.id.setting_button)).setVisibility(GONE);


        return view;
    }

    private void switchIcon() {
        if (joinButton.getTag().equals("ok")) {
            joinButton.setTag("notOk");
            joinButton.setImageResource(R.drawable.ic_left_group);
        } else {
            joinButton.setTag("ok");
            joinButton.setImageResource(R.drawable.ic_add_circle);
        }
    }

}