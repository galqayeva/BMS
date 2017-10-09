package com.example.telim2.bmm.Fragments;

/**
 * Created by galqayeva on 20.09.2017.
 */

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.telim2.bmm.Constants;
import com.example.telim2.bmm.Models.LessonTableModel;
import com.example.telim2.bmm.Others.DatabaseHelper;
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
    Button week1,week2,week3,week4,week5;
    RecyclerView rV1;
    int k=1,a=1,dm=0, loadConst=0,i=0;
    public static final String mypreference = "mypref";
    SharedPreferences sharedpreferences;
    private List<LessonTableModel> modelList1;
    private RecyclerView.Adapter adapter1;
    String weekN="",monthN="";
    DatabaseHelper myDB;





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

        modelList1=new ArrayList<>();
        sharedpreferences = this.getActivity().getSharedPreferences(mypreference, Context.MODE_PRIVATE);

        myDB = new DatabaseHelper(getActivity());

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(spinner.getSelectedItemPosition()<4){
                    monthN=Integer.toString(spinner.getSelectedItemPosition()+9);
                }
                else{
                    monthN=Integer.toString(spinner.getSelectedItemPosition()-3);
                }
                weekN=" ";

                Log.d("nujm",monthN);

                check(weekN,monthN);

            }
        });


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

                loadListview("1");
            }
        });

        tuesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(k==1){
                    monday.setVisibility(View.GONE);
                    wednesday.setVisibility(View.GONE);
                    thursday.setVisibility(View.GONE);
                    friday.setVisibility(View.GONE);
                    rV1.setVisibility(View.VISIBLE);
                    k++;
                }
                else{
                    monday.setVisibility(View.VISIBLE);
                    wednesday.setVisibility(View.VISIBLE);
                    thursday.setVisibility(View.VISIBLE);
                    friday.setVisibility(View.VISIBLE);
                    rV1.setVisibility(View.GONE);
                    k--;
                }
                loadListview("2");
            }
        });

        wednesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(k==1){
                    monday.setVisibility(View.GONE);
                    tuesday.setVisibility(View.GONE);
                    thursday.setVisibility(View.GONE);
                    friday.setVisibility(View.GONE);
                    rV1.setVisibility(View.VISIBLE);
                    k++;
                }
                else{
                    monday.setVisibility(View.VISIBLE);
                    tuesday.setVisibility(View.VISIBLE);
                    thursday.setVisibility(View.VISIBLE);
                    friday.setVisibility(View.VISIBLE);
                    rV1.setVisibility(View.GONE);
                    k--;
                }
            }
        });
        thursday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(k==1){
                    monday.setVisibility(View.GONE);
                    tuesday.setVisibility(View.GONE);
                    wednesday.setVisibility(View.GONE);
                    friday.setVisibility(View.GONE);
                    rV1.setVisibility(View.VISIBLE);
                    k++;
                }
                else{
                    monday.setVisibility(View.VISIBLE);
                    tuesday.setVisibility(View.VISIBLE);
                    wednesday.setVisibility(View.VISIBLE);
                    friday.setVisibility(View.VISIBLE);
                    rV1.setVisibility(View.GONE);
                    k--;
                }
            }
        });
        friday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(k==1){
                    monday.setVisibility(View.GONE);
                    tuesday.setVisibility(View.GONE);
                    wednesday.setVisibility(View.GONE);
                    thursday.setVisibility(View.GONE);
                    rV1.setVisibility(View.VISIBLE);
                    k++;
                }
                else{
                    monday.setVisibility(View.VISIBLE);
                    tuesday.setVisibility(View.VISIBLE);
                    wednesday.setVisibility(View.VISIBLE);
                    thursday.setVisibility(View.VISIBLE);
                    rV1.setVisibility(View.GONE);
                    k--;
                }
            }
        });

        check(weekN,monthN);

        return view;

    }

    public void check(String weekNumber, String monthNumber){
        Cursor getAll = myDB.getAlldata();
        if(getAll.getCount() == 0)
        {
            requestAndInsert(weekNumber,monthNumber);
        }
        else {
            myDB.deleteAll();
            requestAndInsert(weekNumber,monthNumber);
        }
    }

    public void  requestAndInsert(final String weekNumber, final String monthNumber){

        final StringRequest stringRequest=new StringRequest(Request.Method.POST, Constants.LOGIN_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject responseObject=new JSONObject(response);
                            if (responseObject.getString("status").equals("ok")){
                                Log.d("gunay",response);

                                JSONArray GradeListArray=responseObject.getJSONArray("gradeList");

                                for (int i=0;i<GradeListArray.length();i++){

                                    JSONObject jsonObjectdemo=GradeListArray.getJSONObject(i);
                                    int length=jsonObjectdemo.getJSONArray("subjects").length();
                                    String day=jsonObjectdemo.getString("dayOfWeek");

                                    for (int j=0;j<length;j++){

                                        JSONObject jsonObjectLesson=jsonObjectdemo.getJSONArray("subjects").getJSONObject(j);
                                        String name=jsonObjectLesson.getString("name");
                                        String grade=jsonObjectLesson.getString("grade");

                                            boolean insertData = myDB.addData(grade,name,day);
                                            if(!insertData==true)
                                                Log.d("something","getwrong");

                                    }
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
                        Toast.makeText(getActivity(),"Check your Internet Connection",Toast.LENGTH_LONG).show();

                    }
                }
        ){
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<String, String>();
                params.put("api",sharedpreferences.getString("api", ""));
                params.put("getGradeList","1");
                params.put("week",weekNumber);
                params.put("month",monthNumber);
                return params;
            }
        };
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(2 * 1000, 2, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        MySingleTon.getInstance(getActivity()).addToRequestQueue(stringRequest);
    }


    public void loadListview(String a){

        modelList1.clear();
        Cursor data = myDB.getListContents(a);
        if(data.getCount() == 0){
            Toast.makeText(getActivity(), "There are no contents in this list!",Toast.LENGTH_LONG).show();
        }else{


            int i=1;
            while(data.moveToNext()){
                Log.d("salus",data.getString(2)+"--"+"---"+data.getCount());
                LessonTableModel demo=new LessonTableModel(data.getString(2),"", i);
                modelList1.add(demo);
                i++;

            }

            adapter1=new MyAdapter(modelList1,getActivity());
            rV1.setAdapter(adapter1);
        }
    }



}