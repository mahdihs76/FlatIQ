package com.example.mahdihs76.flatiq.view.page.findgroup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mahdihs76.flatiq.R;
import com.example.mahdihs76.flatiq.tool.Queries;
import com.example.mahdihs76.flatiq.view.Adapters.findGroup.GroupMemberAdapter;

/**
 * Created by hamed on 09/14/2017.
 */

public class GroupFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.group_fragment, container, false);


        RecyclerView recyclerViewMembers = (RecyclerView) view.findViewById(R.id.recyclerview_groups);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerViewMembers.setLayoutManager(linearLayoutManager);
        GroupMemberAdapter groupMemberAdapter=new GroupMemberAdapter(getActivity(), Queries.getGroupMembers(getArguments().getString("groupId")));
        recyclerViewMembers.setAdapter(groupMemberAdapter);

        return view;


    }
}
