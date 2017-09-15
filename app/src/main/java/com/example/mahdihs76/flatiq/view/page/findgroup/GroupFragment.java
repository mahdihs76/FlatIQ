package com.example.mahdihs76.flatiq.view.page.findgroup;

import android.os.Bundle;
import android.support.annotation.Nullable;
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
import com.example.mahdihs76.flatiq.server.ViewHandler;
import com.example.mahdihs76.flatiq.tool.Queries;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

/**
 * Created by hamed on 09/14/2017.
 */

public class GroupFragment extends Fragment {
    TextView groupName;
    TextView groupLocation;
    TextView groupSchedule;
    TextView groupField;
    CardView cardView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.group_fragment, container, false);

        ImageView groupImage = (ImageView) view.findViewById(R.id.group_image);
        groupName = (TextView) view.findViewById(R.id.group_name);
        groupLocation = (TextView) view.findViewById(R.id.group_location);
        groupSchedule = (TextView) view.findViewById(R.id.group_schedule);
        groupField = (TextView) view.findViewById(R.id.group_field);
        cardView = (CardView) view.findViewById(R.id.group_card);

        Glide.with(getActivity()).load(Queries.getGroupWithId(getArguments().getString("groupId")).getImageSrc()).into(groupImage);
        groupName.setText(Queries.getGroupWithId(getArguments().getString("groupId")).getName());
        groupLocation.setText(Queries.getGroupWithId(getArguments().getString("groupId")).getLocationName());
        groupSchedule.setText(Queries.getGroupWithId(getArguments().getString("groupId")).getSchedule());
        groupField.setText(Queries.getGroupWithId(getArguments().getString("groupId")).getActivity());


        RecyclerView recyclerViewMembers = (RecyclerView) view.findViewById(R.id.group_members_recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerViewMembers.setLayoutManager(linearLayoutManager);
        //GroupMemberAdapter groupMemberAdapter = new GroupMemberAdapter(getActivity(), Queries.getGroupMembers(getArguments().getString("groupId")));
        //// TODO: 09/14/2017
        recyclerViewMembers.setAdapter(ViewHandler.groupMemberAdapter);
        BarChart chart=(BarChart)view.findViewById(R.id.group_chart);
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
       // int color = getResources().getColor(R.color.light_text_holiday);




      //  dataset.setColors(ColorTemplate.createColors(new int[]{color}));
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);
        chart.animateXY(1500,1500);
        chart.getAxisLeft().setAxisMaxValue(80f);
        chart.getAxisLeft().setEnabled(false);
        chart.getAxisRight().setAxisMaxValue(80f);
        chart.getAxisRight().setEnabled(false);


        return view;


    }


}
