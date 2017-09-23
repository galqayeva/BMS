package com.example.telim2.bmm.Fragments;

/**
 * Created by telim2 on 20.09.2017.
 */

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.telim2.bmm.Activities.MainActivity;
import com.example.telim2.bmm.Constants;
import com.example.telim2.bmm.Models.LessonTableModel;
import com.example.telim2.bmm.Others.MyAdapter;
import com.example.telim2.bmm.Others.MySingleTon;
import com.example.telim2.bmm.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FragmentOne extends Fragment {

    Spinner spinner;
    Button ok,monday,tuesday,wednesday,thursday,friday;
    RecyclerView recyclerView,recyclerView2;
    int k=1,a=1;
    public static final String mypreference = "mypref";
    SharedPreferences sharedpreferences;
    private List<LessonTableModel> modelList,modelList2;
    private RecyclerView.Adapter adapter,adapter2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment1,container,false);

        spinner = (Spinner) view.findViewById(R.id.spinner1);
        monday=(Button)view.findViewById(R.id.buttonMonday);
        tuesday=(Button)view.findViewById(R.id.buttonTuesday);
        wednesday=(Button)view.findViewById(R.id.buttonWednesday);
        thursday=(Button)view.findViewById(R.id.buttonThursday);
        friday=(Button)view.findViewById(R.id.buttonFriday);
        ok=(Button)view.findViewById(R.id.buttonOk);

        recyclerView=(RecyclerView)view.findViewById(R.id.recycleview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView2=(RecyclerView)view.findViewById(R.id.recycleview2);
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getActivity()));


        modelList=new ArrayList<>();
        modelList2=new ArrayList<>();
        sharedpreferences = this.getActivity().getSharedPreferences(mypreference, Context.MODE_PRIVATE);


        StringRequest stringRequest=new StringRequest(Request.Method.POST, Constants.LOGIN_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                       // Toast.makeText(getActivity(), response, Toast.LENGTH_LONG).show();

                        try {
                            JSONObject jsonObject=new JSONObject(response);
                            if (jsonObject.getString("status").equals("ok")){

                                JSONArray jsonArray=jsonObject.getJSONArray("gradeList");
                                JSONObject jsonObjectDayone=jsonArray.getJSONObject(0);
                                for (int i=0;i<jsonObjectDayone.getJSONArray("subjects").length();i++){

                                    JSONObject jsonObjectLesson=jsonObjectDayone.getJSONArray("subjects").getJSONObject(i);
                                    String name=jsonObjectLesson.getString("name");
                                    String grade=jsonObjectLesson.getString("grade");

                                    LessonTableModel item=new LessonTableModel(name,grade);
                                    modelList.add(item);


                                }
                                adapter=new MyAdapter(modelList,getActivity());
                                recyclerView.setAdapter(adapter);

                                JSONObject jsonObjectDayTwo=jsonArray.getJSONObject(1);
                                for (int i=0;i<jsonObjectDayTwo.getJSONArray("subjects").length();i++){

                                    JSONObject jsonObjectLesson=jsonObjectDayTwo.getJSONArray("subjects").getJSONObject(i);
                                    String name=jsonObjectLesson.getString("name");
                                    String grade=jsonObjectLesson.getString("grade");

                                    LessonTableModel item2=new LessonTableModel(name,grade);
                                    modelList2.add(item2);


                                }
                                adapter2=new MyAdapter(modelList2,getActivity());
                                recyclerView2.setAdapter(adapter2);

                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity(),"check your internet connectio",Toast.LENGTH_LONG).show();
                    }
                }
        ){
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<String, String>();
                params.put("api",sharedpreferences.getString("api", ""));
                params.put("getGradeList","1");
                return params;
            }
        };
        MySingleTon.getInstance(getActivity()).addToRequestQueue(stringRequest);


        monday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(k==1){
                    tuesday.setVisibility(View.GONE);
                    wednesday.setVisibility(View.GONE);
                    thursday.setVisibility(View.GONE);
                    friday.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.VISIBLE);
                    k++;
                }
                else{
                    tuesday.setVisibility(View.VISIBLE);
                    wednesday.setVisibility(View.VISIBLE);
                    thursday.setVisibility(View.VISIBLE);
                    friday.setVisibility(View.VISIBLE);
                    recyclerView.setVisibility(View.GONE);
                    k--;
                }
            }
        });
        tuesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(a==1){
                    monday.setVisibility(View.GONE);
                    wednesday.setVisibility(View.GONE);
                    thursday.setVisibility(View.GONE);
                    friday.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.GONE);
                    recyclerView2.setVisibility(View.VISIBLE);
                    a++;
                }
                else{
                    monday.setVisibility(View.VISIBLE);
                    wednesday.setVisibility(View.VISIBLE);
                    thursday.setVisibility(View.VISIBLE);
                    friday.setVisibility(View.VISIBLE);
                    recyclerView.setVisibility(View.GONE);
                    a--;
                }
            }
        });


        return view;

    }
}