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
import com.example.mahdihs76.flatiq.server.WebService;
import com.example.mahdihs76.flatiq.tool.Queries;
import com.example.mahdihs76.flatiq.view.Adapters.findGroup.GroupMemberAdapter;

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

    public static final String personID = "1000";

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
        joinButton = (ImageView) view.findViewById(R.id.join_btn);

        joinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WebService.addMember(personID, Queries.getGroupWithId(getArguments().getString("groupId")).getId(), getActivity());
//                Log.i("debug", "onClick person's groups: " + Queries.getGroupWithId(getArguments().getString("groupId")).getMembers());
//                Log.i("debug", "onClick group's members: " + Queries.getPersonWithId(personID).getGroups());
            }
        });

        Glide.with(getActivity()).load(Queries.getGroupWithId(getArguments().getString("groupId")).getImageSrc()).into(groupImage);
        groupName.setText(Queries.getGroupWithId(getArguments().getString("groupId")).getName());
        groupLocation.setText(Queries.getGroupWithId(getArguments().getString("groupId")).getLocationName());
        groupSchedule.setText(Queries.getGroupWithId(getArguments().getString("groupId")).getSchedule());
        groupField.setText(Queries.getGroupWithId(getArguments().getString("groupId")).getActivity());


        RecyclerView recyclerViewMembers = (RecyclerView) view.findViewById(R.id.group_members_recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerViewMembers.setLayoutManager(linearLayoutManager);
        //// TODO: 09/14/2017

        ViewHandler.groupMemberAdapter =new GroupMemberAdapter(getActivity(), Queries.getGroupMembers(getArguments().getString("groupId")));
        recyclerViewMembers.setAdapter(ViewHandler.groupMemberAdapter);


        return view;


    }


}
