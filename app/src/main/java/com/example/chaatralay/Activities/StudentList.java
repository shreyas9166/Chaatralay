package com.example.chaatralay.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.chaatralay.Adapter.RecyclerAdapter;
import com.example.chaatralay.Includes.Constants;
import com.example.chaatralay.Model.RecyclerviewModel;
import com.example.chaatralay.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentList extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private String course,year;
    private static final String TAG = "Dashboard";
    private ProgressDialog progressDialog;
    private final List<RecyclerviewModel> recyclerlist = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        Bundle b =getIntent().getExtras();
        course=b.getString("course");
        year=b.getString("year");
        Log.d(TAG, "aayaaa "+course+year);
        progressDialog=new ProgressDialog(this);
        recyclerView = findViewById(R.id.recyclerViewStudentList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getdata();



    }

    private void getdata() {

        progressDialog.setMessage("Please wait...");
        progressDialog.show();

        Log.d(TAG, "onCreate: test 3" );
        StringRequest request = new StringRequest(Request.Method.POST, Constants.GET_ALL_DATA, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
//                Toast.makeText(MainActivity.this, "inside", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
                Log.d(TAG, "onCreate: sd " + response );
//                JSONObject jsonObject = new JSONObject(response);
                try {

                    Log.d(TAG,"OnCreate: entered tyr");
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray array = jsonObject.names();


                    for (int i=0; i<array.length(); i++){
//                        String values = array.getString(i);
                        String values = jsonObject.getString(array.getString(i));
                        JSONObject studentInfo = new JSONObject(values);

//                        Log.d(TAG, "sohan1: "+studentInfo.getString("name")+studentInfo.getString("dist")+ studentInfo.getString("hostel"));
//Image dala hai
                        String defaultimage;
                        if (studentInfo.getString("img_url").equals(""))
                        {
                            defaultimage=Constants.IMAGE_URL+"Defaultimage.png";
                        }
                        else {

                            defaultimage=Constants.URL+studentInfo.getString("img_url");
                            Log.d(TAG, "shreyas: "+Constants.URL+studentInfo.getString("img_url"));
                        }

                        Log.d(TAG, "onResponse: " +defaultimage);

                        RecyclerviewModel data=new RecyclerviewModel(studentInfo.getString("SN"),studentInfo.getString("name"),studentInfo.getString("course"),studentInfo.getString("hostel"),defaultimage);
                        recyclerlist.add(data);
//
//
//                        Log.d(TAG, "sohan1: " + values);


                    }

                    adapter = new RecyclerAdapter(getApplicationContext(), recyclerlist);
                    recyclerView.setAdapter(adapter);



                } catch (JSONException e) {
                    Log.d(TAG,"onCreate"+e.toString());
                    Toast.makeText(StudentList.this, "ERROR"+ e.toString(), Toast.LENGTH_SHORT).show();
                }





            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "onCreate: test 5" );
                progressDialog.hide();
                Toast.makeText(StudentList.this, "ERROR: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                Log.d(TAG,"onCreate:"+course+year);
                params.put("course", course);
                params.put("year", year);


                return params;

            }
        };
        Log.d(TAG, "onCreate: test 6" );
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
        Log.d(TAG, "onCreate: test 7" );
    }
}
