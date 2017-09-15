package com.example.mahdihs76.flatiq.view.Adapters.findGroup;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mahdihs76.flatiq.R;
import com.example.mahdihs76.flatiq.model.Group;
import com.example.mahdihs76.flatiq.tool.Queries;
import com.example.mahdihs76.flatiq.view.page.findgroup.GroupFragment;

import java.util.ArrayList;

public class GroupsAdapter extends RecyclerView.Adapter<GroupsAdapter.MyViewHolder> {

    Context context;
    private ArrayList<Group> groups = new ArrayList<>();

    public GroupsAdapter(Context context, ArrayList<Group> groups) {
        this.context = context;
        this.groups = groups;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_group, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {


        holder.groupName.setText(Group.getGroupName(groups).get(position));
        holder.groupSize.setText(String.valueOf(Queries.getGroupMembers(Group.getGroupID(groups).get(position)).size()));
        holder.groupLocation.setText(Group.getGroupLocationNames(groups).get(position));
        holder.groupSchedule.setText(Group.getGroupSchedule(groups).get(position));
        holder.groupField.setText(Group.getGroupActivity(groups).get(position));
        Glide.with(context).load(Group.getGroupImageSrc(groups).get(position)).into(holder.groupImage);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("groupId", Group.getGroupID(groups).get(position));
                //might be problematic
                Fragment groupFragment = new GroupFragment();
                groupFragment.setArguments(bundle);
                ((FragmentActivity) context).getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, groupFragment).commit();
            }
        });

    }

    @Override
    public int getItemCount() {
        return groups.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView groupName;
        ImageView groupImage;
        TextView groupSize;
        TextView groupLocation;
        TextView groupSchedule;
        TextView groupField;
        CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);

            groupName = (TextView) itemView.findViewById(R.id.group_name);
            groupImage = (ImageView) itemView.findViewById(R.id.group_image);
            groupSize = (TextView) itemView.findViewById(R.id.group_size);
            groupLocation = (TextView) itemView.findViewById(R.id.group_location);
            groupSchedule = (TextView) itemView.findViewById(R.id.group_schedule);
            groupField = (TextView) itemView.findViewById(R.id.group_field);
            cardView = (CardView) itemView.findViewById(R.id.group_card);



        }
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<Group> groups) {
        this.groups = groups;
    }
}
