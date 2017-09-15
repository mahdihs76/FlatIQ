package com.example.mahdihs76.flatiq.view.page.map;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import com.example.mahdihs76.flatiq.R;
import com.example.mahdihs76.flatiq.tool.Queries;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

/**
 * Created by kosar on 9/14/17.
 */

public class MyInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {

    Activity activity;


    public MyInfoWindowAdapter(Activity activity) {
        this.activity = activity;

    }

    @Override
    public View getInfoWindow(Marker marker) {
        View itemView = activity.getLayoutInflater().inflate(R.layout.item_group_for_map, null);

        TextView groupName;
        TextView groupSize;
        TextView groupLocation;
        TextView groupSchedule;
        TextView groupField;

        groupName = (TextView) itemView.findViewById(R.id.group_name);
        groupSize = (TextView) itemView.findViewById(R.id.group_size);
        groupLocation = (TextView) itemView.findViewById(R.id.group_location);
        groupSchedule = (TextView) itemView.findViewById(R.id.group_schedule);
        groupField = (TextView) itemView.findViewById(R.id.group_field);

        groupName.setText(Queries.getGroupWithId(marker.getTitle()).getName());
        groupSize.setText(String.valueOf(Queries.getGroupMembers(marker.getTitle()).size()));
        groupLocation.setText(Queries.getGroupWithId(marker.getTitle()).getLocationName());
        groupSchedule.setText(Queries.getGroupWithId(marker.getTitle()).getSchedule());
        groupField.setText(Queries.getGroupWithId(marker.getTitle()).getActivity());

        return itemView;
    }

    @Override
    public View getInfoContents(Marker marker) {
        return null;
    }
}
