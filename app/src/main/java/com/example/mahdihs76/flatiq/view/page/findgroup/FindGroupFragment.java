package com.example.mahdihs76.flatiq.view.page.findgroup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import com.example.mahdihs76.flatiq.R;
import com.example.mahdihs76.flatiq.model.Group;
import com.example.mahdihs76.flatiq.view.Adapters.findGroup.GroupsAdapter;

import java.util.ArrayList;
import java.util.Arrays;

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
        recyclerViewGroups.setAdapter(groupsAdapter);

        return view;
    }
}
