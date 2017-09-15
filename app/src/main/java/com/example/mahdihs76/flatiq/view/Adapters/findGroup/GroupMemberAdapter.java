package com.example.mahdihs76.flatiq.view.Adapters.findGroup;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mahdihs76.flatiq.R;
import com.example.mahdihs76.flatiq.model.Group;
import com.example.mahdihs76.flatiq.model.Person;
import com.example.mahdihs76.flatiq.tool.Queries;

import java.util.ArrayList;

public class GroupMemberAdapter extends RecyclerView.Adapter<GroupMemberAdapter.MyViewHolder> {

    Context context;

    public GroupMemberAdapter(Context context, ArrayList<Person> persons) {
        this.context = context;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_group_member, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {


        holder.memberName.setText(Person.getPersonFirstName(Person.personList).get(position)+" "+Person.getPersonLastName(Person.personList).get(position));
        holder.memberRating.setText(Person.getPersonScore(Person.personList).get(position));

        Glide.with(context).load(Person.getPersonImageSrc(Person.personList).get(position)).apply(RequestOptions.circleCropTransform()).into(holder.memberImage);

    }

    @Override
    public int getItemCount() {
        return Person.personList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView memberName;
        ImageView memberImage;
        TextView memberRating;


        public MyViewHolder(View itemView) {
            super(itemView);

            memberName = (TextView) itemView.findViewById(R.id.member_name);
            memberImage = (ImageView) itemView.findViewById(R.id.member_image);
            memberRating = (TextView) itemView.findViewById(R.id.member_rating);
        }
    }


}
