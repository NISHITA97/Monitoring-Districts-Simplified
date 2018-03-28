package com.example.android.monitoringdistrictssimplified.Adapters;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.monitoringdistrictssimplified.Activity.ProgrammeActivity;
import com.example.android.monitoringdistrictssimplified.Activity.SchemeActivity;
import com.example.android.monitoringdistrictssimplified.Model.ProgrammeModel;
import com.example.android.monitoringdistrictssimplified.R;

import java.util.ArrayList;

import static android.support.v4.content.ContextCompat.startActivity;

/**
 * Created by Shiv Kumar Aggarwal on 27-03-2018.
 */

public class ProgrammeAdapter extends RecyclerView.Adapter<ProgrammeAdapter.ProgrammeViewHolder> {

    private ArrayList<ProgrammeModel> programmeList;

    public ProgrammeAdapter(ArrayList<ProgrammeModel> dataList) {

        this.programmeList = dataList;
    }

    @Override
    public ProgrammeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.programme_row, parent, false);
        return new ProgrammeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProgrammeViewHolder holder, final int position) {

        holder.programmeName.setText(programmeList.get(position).getName());
        holder.programmeDescription.setText(programmeList.get(position).getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                Intent toScheme;
                toScheme = new Intent(view.getContext(), SchemeActivity.class);
                toScheme.putExtra("pid",programmeList.get(position).getPid());
                view.getContext().startActivity(toScheme);
            }
        });

    }

    @Override
    public int getItemCount() {
        return programmeList.size();
    }

    class ProgrammeViewHolder extends RecyclerView.ViewHolder{
        TextView programmeName, programmeDescription;
        ProgrammeViewHolder(View programmeView)
        {
            super(programmeView);
            programmeName=programmeView.findViewById(R.id.textView_programme_name);
            programmeDescription=programmeView.findViewById(R.id.textView_programme_description);


        }

    }
}
