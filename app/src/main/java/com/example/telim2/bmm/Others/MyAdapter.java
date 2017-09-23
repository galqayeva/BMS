package com.example.telim2.bmm.Others;

/**
 * Created by telim2 on 23.09.2017.
 */


import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import com.example.telim2.bmm.Models.LessonTableModel;
import com.example.telim2.bmm.R;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.content.Context.MODE_PRIVATE;



public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<LessonTableModel> modelList;
    private Context context;


    public MyAdapter(List<LessonTableModel> modelList, Context context) {
        this.modelList=modelList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.lessontable,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final LessonTableModel model=modelList.get(position);

        holder.subjectName.setText(model.getSubjectName());
        holder.subjectGrade.setText(model.getSubjectGrade());

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        public  TextView subjectName,subjectGrade;

        public ViewHolder(View itemView) {
            super(itemView);

            subjectGrade=(TextView)itemView.findViewById(R.id.subjectGrade);
            subjectName=(TextView)itemView.findViewById(R.id.subjectName);
        }
    }
}