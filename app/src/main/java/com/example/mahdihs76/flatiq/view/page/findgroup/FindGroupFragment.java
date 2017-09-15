package com.example.mahdihs76.flatiq.view.page.findgroup;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.example.mahdihs76.flatiq.view.page.MapsActivity;
import com.example.mahdihs76.flatiq.R;
import com.example.mahdihs76.flatiq.model.Group;
import com.example.mahdihs76.flatiq.server.ViewHandler;
import com.example.mahdihs76.flatiq.view.Adapters.findGroup.GroupsAdapter;
import com.example.mahdihs76.flatiq.view.page.main.MainActivity;

import java.util.ArrayList;

/**
 * Created by hamed on 09/14/2017.
 */

public class FindGroupFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_findgroup, container, false);

        RecyclerView recyclerViewGroups = (RecyclerView) view.findViewById(R.id.recyclerview_groups);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerViewGroups.setLayoutManager(linearLayoutManager);
        GroupsAdapter groupsAdapter = new GroupsAdapter(getActivity(), Group.groupList);

        ViewHandler.groupsAdapter = groupsAdapter;

        recyclerViewGroups.setAdapter(groupsAdapter);
        ImageView imageView= (ImageView) getActivity().findViewById(R.id.map_button);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MapsActivity.class);
                ArrayList<Double> latitudes = new ArrayList<>();
                ArrayList<Double> longitudes = new ArrayList<>();
                ArrayList<String> names = new ArrayList<>();
                ArrayList<String> activities = new ArrayList<>();
                ArrayList<String> ids = new ArrayList<>();
//                WebService.setGroups();
                for (Group g : Group.groupList) {
                    String location = g.getLocation();
                    String[] coordinates = location.split("-");
                    latitudes.add(Double.parseDouble(coordinates[0]));
                    longitudes.add(Double.parseDouble(coordinates[1]));
                    names.add(g.getName());
                    ids.add(g.getId());
                    activities.add(g.getActivity());
                }
                intent.putExtra(MainActivity.LATITUDES, latitudes);
                intent.putExtra(MainActivity.LONGITUDES, longitudes);
                intent.putExtra(MainActivity.ACTIVITIES, activities);
                intent.putExtra(MainActivity.NAMES, names);
                intent.putExtra(MainActivity.IDS, ids);
                startActivity(intent);
            }
        });


        return view;
    }
}
