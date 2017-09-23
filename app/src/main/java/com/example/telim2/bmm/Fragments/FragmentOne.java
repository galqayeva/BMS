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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FragmentOne extends Fragment {

    Spinner spinner;
    Button ok,monday,tuesday,wednesday,thursday,friday;
    RecyclerView rV1,rV2,rV3,rV4,rV5;
    int k=1,a=1,dm=0;
    public static final String mypreference = "mypref";
    SharedPreferences sharedpreferences;
    private List<LessonTableModel> modelList1,modelList2,modelList3,modelList4,modelList5;
    private RecyclerView.Adapter adapter1,adapter2,adapter3,adapter4,adapter5;


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

        rV1=(RecyclerView)view.findViewById(R.id.recycleview);
        rV1.setHasFixedSize(true);
        rV1.setLayoutManager(new LinearLayoutManager(getActivity()));
        rV2=(RecyclerView)view.findViewById(R.id.recycleview2);
        rV2.setHasFixedSize(true);
        rV2.setLayoutManager(new LinearLayoutManager(getActivity()));
        rV3=(RecyclerView)view.findViewById(R.id.recycleview3);
        rV3.setHasFixedSize(true);
        rV3.setLayoutManager(new LinearLayoutManager(getActivity()));
        rV4=(RecyclerView)view.findViewById(R.id.recycleview4);
        rV4.setHasFixedSize(true);
        rV4.setLayoutManager(new LinearLayoutManager(getActivity()));
        rV5=(RecyclerView)view.findViewById(R.id.recycleview5);
        rV5.setHasFixedSize(true);
        rV5.setLayoutManager(new LinearLayoutManager(getActivity()));




        modelList1=new ArrayList<>();
        modelList2=new ArrayList<>();
        modelList3=new ArrayList<>();
        modelList4=new ArrayList<>();
        modelList5=new ArrayList<>();
        sharedpreferences = this.getActivity().getSharedPreferences(mypreference, Context.MODE_PRIVATE);


        StringRequest stringRequest=new StringRequest(Request.Method.POST, Constants.LOGIN_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {


                        try {
                            JSONObject jsonObject=new JSONObject(response);
                            if (jsonObject.getString("status").equals("ok")){

                                JSONArray jsonArray=jsonObject.getJSONArray("gradeList");

                                for (int i=0;i<2;i++){
                                    JSONObject jsonObjectdemo=jsonArray.getJSONObject(i);

                                    int length=jsonObjectdemo.getJSONArray("subjects").length();
                                    for (int j=0;j<length;j++){

                                        JSONObject jsonObjectLesson=jsonObjectdemo.getJSONArray("subjects").getJSONObject(j);
                                        String name=jsonObjectLesson.getString("name");
                                        String grade=jsonObjectLesson.getString("grade");

                                        if(dm<length){
                                            LessonTableModel demo=new LessonTableModel(name,grade);
                                            modelList1.add(demo);
                                            dm++;
                                        }
                                        else if (dm>=length && dm<2*length){
                                            LessonTableModel demo2=new LessonTableModel(name,grade);
                                            modelList2.add(demo2);
                                            dm++;
                                        }
                                        else if (dm>=2*length && dm<3*length){
                                            LessonTableModel demo3=new LessonTableModel(name,grade);
                                            modelList3.add(demo3);
                                            dm++;
                                        }
                                        else if (dm>=3*length && dm<4*length){
                                            LessonTableModel demo4=new LessonTableModel(name,grade);
                                            modelList4.add(demo4);
                                            dm++;
                                        }
                                        else if (dm>=4*length && dm<5*length){
                                            LessonTableModel demo5=new LessonTableModel(name,grade);
                                            modelList5.add(demo5);
                                            dm++;
                                        }

                                    }

                                    adapter1=new MyAdapter(modelList1,getActivity());
                                    rV1.setAdapter(adapter1);

                                    adapter2=new MyAdapter(modelList2,getActivity());
                                    rV2.setAdapter(adapter2);

                                    adapter3=new MyAdapter(modelList3,getActivity());
                                    rV3.setAdapter(adapter3);

                                    adapter4=new MyAdapter(modelList4,getActivity());
                                    rV4.setAdapter(adapter4);

                                    adapter5=new MyAdapter(modelList5,getActivity());
                                    rV5.setAdapter(adapter5);


                                }

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
                params.put("week","");
                params.put("month","");
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
                    rV1.setVisibility(View.VISIBLE);
                    k++;
                }
                else{
                    tuesday.setVisibility(View.VISIBLE);
                    wednesday.setVisibility(View.VISIBLE);
                    thursday.setVisibility(View.VISIBLE);
                    friday.setVisibility(View.VISIBLE);
                    rV1.setVisibility(View.GONE);
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
                    rV1.setVisibility(View.GONE);
                    rV2.setVisibility(View.VISIBLE);
                    a++;
                }
                else{
                    monday.setVisibility(View.VISIBLE);
                    wednesday.setVisibility(View.VISIBLE);
                    thursday.setVisibility(View.VISIBLE);
                    friday.setVisibility(View.VISIBLE);
                    rV2.setVisibility(View.GONE);
                    a--;
                }
            }
        });


        return view;

    }


}