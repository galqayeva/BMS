package com.example.telim2.bmm.Fragments;

/**
 * Created by galqayeva on 20.09.2017.
 */

import android.content.Context;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FragmentOne extends Fragment {

    Spinner spinner;
    Button ok,monday,tuesday,wednesday,thursday,friday;
    Button week1,week2,week3,week4,week5;
    RecyclerView rV1,rV2,rV3,rV4,rV5;
    int k=1,a=1,dm=0, loadConst=0;
    public static final String mypreference = "mypref";
    SharedPreferences sharedpreferences;
    private List<LessonTableModel> modelList1,modelList2,modelList3,modelList4,modelList5;
    private RecyclerView.Adapter adapter1,adapter2,adapter3,adapter4,adapter5;
    String weekN="",monthN="";
    DatabaseHelper myDB,myDB2;


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
                weekN="1";

                Log.d("nujm",monthN);

                 insertDB(weekN,monthN);
               // myDB.deleteAll();



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
            }
        });

      //  loadListview();

        return view;

    }

    public void loadListview(){



        Cursor data = myDB.getListContents();
        if(data.getCount() == 0){
            Toast.makeText(getActivity(), "There are no contents in this list!",Toast.LENGTH_LONG).show();
        }else{


            while(data.moveToNext()){

                LessonTableModel demo=new LessonTableModel(data.getString(2),data.getString(1),'1');
                modelList1.add(demo);
                Log.d("salus",data.getString(2));

            }

            adapter1=new MyAdapter(modelList1,getActivity());
            rV1.setAdapter(adapter1);
        }
    }

    public void  insertDB(final String weekNumber, final String monthNumber){

        final StringRequest stringRequest=new StringRequest(Request.Method.POST, Constants.LOGIN_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject=new JSONObject(response);
                            if (jsonObject.getString("status").equals("ok")){
                                Log.d("gunay",response);


                                JSONArray jsonArray=jsonObject.getJSONArray("gradeList");

                                for (int i=0;i<jsonArray.length();i++){

                                    JSONObject jsonObjectdemo=jsonArray.getJSONObject(i);
                                    int length=jsonObjectdemo.getJSONArray("subjects").length();

                                    for (int j=0;j<length;j++){

                                        JSONObject jsonObjectLesson=jsonObjectdemo.getJSONArray("subjects").getJSONObject(j);
                                        String name=jsonObjectLesson.getString("name");
                                        String grade=jsonObjectLesson.getString("grade");
                                        int number=j+1;

                                        if(dm<length){
                                            addData(grade,name,"1");
                                            dm++;
                                        }

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

    public void addData(String grade,String subject,String day) {

        if(loadConst==0){

            boolean insertData = myDB.addData(grade,subject,day);

            if(!insertData==true)
            {

                Toast.makeText(getActivity(), "Something went wrong :(.", Toast.LENGTH_LONG).show();
            }
            else
            {
                loadListview();
            }

            loadConst++;
        }
        else{

            myDB.deleteAll();
            boolean insertData = myDB.addData(grade,subject,day);

            if(!insertData==true)
            {

                Toast.makeText(getActivity(), "Something went wrong :(.", Toast.LENGTH_LONG).show();
            }
            else
            {
                loadListview();
            }
            loadConst--;

        }


    }




}