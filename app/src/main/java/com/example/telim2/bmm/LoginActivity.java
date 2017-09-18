package com.example.telim2.bmm;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private Button loginButton;
    private EditText loginPass,loginUser;
    private String pass,username,status;
    public static final String mypreference = "mypref";
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton=(Button)findViewById(R.id.loginLogin);
        loginPass=(EditText)findViewById(R.id.loginPass);
        loginUser=(EditText)findViewById(R.id.loginUsername);

        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);
        if (sharedpreferences.contains("username") && sharedpreferences.contains("password")) {
            if(!(sharedpreferences.getString("username", "").equals("") && sharedpreferences.getString("password", "").equals("") )){
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);

            }
        }


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pass=loginPass.getText().toString();
                username=loginUser.getText().toString();

                if (pass.equals("") || username.equals("")){

                    Toast.makeText(getApplicationContext(),Constants.PLEASE_FILL_USERNAME_AND_PASS,Toast.LENGTH_LONG).show();

                }
                else{

                    final StringRequest stringRequest=new StringRequest(Request.Method.POST, Constants.LOGIN_URL,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {

                                    try {

                                        JSONObject jsonObject=new JSONObject(response);
                                        status=jsonObject.getString("status");


                                        if(status.equals("ok")){

                                            SharedPreferences.Editor editor = sharedpreferences.edit();
                                            editor.putString("userID",jsonObject.getString("uid"));
                                            editor.putString("api",jsonObject.getString("api"));
                                            editor.putString("userImageLink",jsonObject.getString("photo"));
                                            editor.putString("username",username);
                                            editor.putString("password",pass);
                                            editor.putString("name",jsonObject.getString("name"));
                                            editor.putString("surname",jsonObject.getString("surname"));
                                            editor.putString("father",jsonObject.getString("father"));
                                            editor.putString("classNumber",jsonObject.getString("classNumber"));
                                            editor.putString("classLetter",jsonObject.getString("classLetter"));
                                            editor.putString("studyYear",jsonObject.getString("studyYear"));
                                            editor.commit();
                                            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                                            startActivity(intent);

                                        }
                                        else{
                                            Toast.makeText(getApplicationContext(),Constants.WRONG_PASSWORD_OR_USERNAME,Toast.LENGTH_LONG).show();
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }

                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Toast.makeText(getApplicationContext(),"check your internet connectio",Toast.LENGTH_LONG).show();
                                }
                            }
                    ){
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String,String> params=new HashMap<String, String>();
                            params.put("login",username);
                            params.put("password",pass);
                            params.put("token","pro_school_api_token");
                            return params;
                        }
                    };
                    MySingleTon.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);

                }

            }
        });

    }

}
