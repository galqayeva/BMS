package com.example.telim2.bmm.Others;

/**
 * Created by galqayeva on 18.09.2017.
 */

import android.content.Context;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class MySingleTon {
    private static MySingleTon mInstance;
    private RequestQueue requestQueue;
    private static Context mCxt;

    private MySingleTon(Context context){

        mCxt=context;
        requestQueue=getRequestQueue();

    }

    public RequestQueue getRequestQueue(){


        if(requestQueue==null){

            requestQueue= Volley.newRequestQueue(mCxt.getApplicationContext());
        }
        return requestQueue;

    }

    public static synchronized MySingleTon getInstance(Context context){

        if(mInstance==null){

            mInstance=new MySingleTon(context);
        }
        return mInstance;

    }

    public <T>void addToRequestQueue(Request<T> request){

        requestQueue.add(request);

    }




}