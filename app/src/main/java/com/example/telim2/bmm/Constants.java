package com.example.telim2.bmm;

/**
 * Created by galqayeva2 on 18.09.2017.
 */

public class Constants {

    public  static  String LOGIN_URL="http://www.portal.bakumodernschool.az/API/";
    public  static String DAILY_URL="";

    //////drawer menu

    public  static  String DRAWER_MENU_GUNLUK="Gundelik";
    public static  String DRAWER_MENU_CHAT="Mesajlasma";
    public  static String DRAWER_MENU_HOME="Ana Sehife";
    public static String DRAWER_MENU_LOGOUT="Cixis";


    ///Strings

    public  static String PLEASE_FILL_USERNAME_AND_PASS="username ve passwordu daxil edin";
    public  static String WRONG_PASSWORD_OR_USERNAME="yalnis username ve ya password";



    /*
    public void delete(){


        spinner = (Spinner) view.findViewById(R.id.spinner1);
        monday=(Button)view.findViewById(R.id.buttonMonday);
        tuesday=(Button)view.findViewById(R.id.buttonTuesday);
        wednesday=(Button)view.findViewById(R.id.buttonWednesday);
        thursday=(Button)view.findViewById(R.id.buttonThursday);
        friday=(Button)view.findViewById(R.id.buttonFriday);
        ok=(Button)view.findViewById(R.id.buttonOk);

        week1=(Button)view.findViewById(R.id.buttonWeek1);
        week2=(Button)view.findViewById(R.id.buttonWeek2);
        week3=(Button)view.findViewById(R.id.buttonWeek3);
        week4=(Button)view.findViewById(R.id.buttonWeek4);
        week5=(Button)view.findViewById(R.id.buttonWeek5);


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
        tuesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(k==1){
                    monday.setVisibility(View.GONE);
                    wednesday.setVisibility(View.GONE);
                    thursday.setVisibility(View.GONE);
                    friday.setVisibility(View.GONE);
                    rV2.setVisibility(View.VISIBLE);
                    k++;
                }
                else{
                    monday.setVisibility(View.VISIBLE);
                    wednesday.setVisibility(View.VISIBLE);
                    thursday.setVisibility(View.VISIBLE);
                    friday.setVisibility(View.VISIBLE);
                    rV2.setVisibility(View.GONE);
                    k--;
                }
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
                    rV3.setVisibility(View.VISIBLE);
                    k++;
                }
                else{
                    monday.setVisibility(View.VISIBLE);
                    tuesday.setVisibility(View.VISIBLE);
                    thursday.setVisibility(View.VISIBLE);
                    friday.setVisibility(View.VISIBLE);
                    rV3.setVisibility(View.GONE);
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
                    rV4.setVisibility(View.VISIBLE);
                    k++;
                }
                else{
                    monday.setVisibility(View.VISIBLE);
                    tuesday.setVisibility(View.VISIBLE);
                    wednesday.setVisibility(View.VISIBLE);
                    friday.setVisibility(View.VISIBLE);
                    rV4.setVisibility(View.GONE);
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
                    rV5.setVisibility(View.VISIBLE);
                    k++;
                }
                else{
                    monday.setVisibility(View.VISIBLE);
                    tuesday.setVisibility(View.VISIBLE);
                    wednesday.setVisibility(View.VISIBLE);
                    thursday.setVisibility(View.VISIBLE);
                    rV5.setVisibility(View.GONE);
                    k--;
                }
            }
        });
    }

*/

}
