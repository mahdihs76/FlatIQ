package com.example.mahdihs76.flatiq.view.Adapters.findGroup;

import android.content.Context;
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

import java.util.ArrayList;

public class GroupsAdapter extends RecyclerView.Adapter<GroupsAdapter.MyViewHolder> {

    private ArrayList<Group> groups = new ArrayList<>();


    Context context;

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
        holder.groupSize.setText(Queries.getGroupMembers(Group.getGroupID(groups).get(position)).size());
        holder.groupLocation.setText(Group.getGroupLocation(groups).get(position));
        holder.groupSchedule.setText(Group.getGroupSchedule(groups).get(position));
        holder.groupField.setText(Group.getGroupActivity(groups).get(position));
        Glide.with(context).load( Group.getGroupImageSrc(groups).get(position)).into(holder.groupImage);

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

        public MyViewHolder(View itemView) {
            super(itemView);

            groupName = (TextView) itemView.findViewById(R.id.group_name);
            groupImage = (ImageView) itemView.findViewById(R.id.group_image);
            groupSize = (TextView) itemView.findViewById(R.id.group_size);
            groupLocation = (TextView) itemView.findViewById(R.id.group_location);
            groupSchedule=(TextView)itemView.findViewById(R.id.group_schedule);
            groupField=(TextView)itemView.findViewById(R.id.group_field);



        }
    }


}
