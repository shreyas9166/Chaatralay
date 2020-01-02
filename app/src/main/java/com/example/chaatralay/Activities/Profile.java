package com.example.chaatralay.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.chaatralay.Includes.Constants;
import com.example.chaatralay.R;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;

public class Profile extends AppCompatActivity {

    private String id,defaultimage;
    private TextView nameTv,rollnoTv,dobTv,genderTv,languageTv,mobileTv,emailTv,fatherTv,motherTv,addressTv,father_noTv,distTv,hostelTv,doaTv;
    private ProgressDialog progressDialog;
    private static final String TAG = "Profile";
    private ImageView profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Log.d(TAG, "onCreate: enter profile" );
        progressDialog=new ProgressDialog(this);
        Bundle bundle=getIntent().getExtras();
        id=bundle.getString("id");

        nameTv = findViewById(R.id.nameTv);
        profile = findViewById(R.id.profile);
        nameTv=findViewById(R.id.nameTv);
        rollnoTv=findViewById(R.id.RollNoTv);
        dobTv=findViewById(R.id.dobTv);
        genderTv=findViewById(R.id.genderTv);
        languageTv=findViewById(R.id.languageTv);
        mobileTv=findViewById(R.id.mobileTv);
        emailTv=findViewById(R.id.emailTv);
        fatherTv=findViewById(R.id.fatherTv);
        motherTv=findViewById(R.id.motherTv);
        addressTv=findViewById(R.id.addressTv);
        father_noTv=findViewById(R.id.father_noTv);
        distTv=findViewById(R.id.distTv);
        hostelTv=findViewById(R.id.hostelTv);
        doaTv=findViewById(R.id.doaTv);
//        Toast.makeText(this, id, Toast.LENGTH_SHORT).show();

        profileData();





    }

    private void profileData() {

        progressDialog.setMessage("Please wait...");
        progressDialog.show();

        Log.d(TAG, "onCreate: test 3" );
        StringRequest request = new StringRequest(Request.Method.POST, Constants.GET_DATA, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
//                Toast.makeText(MainActivity.this, "inside", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
                Log.d(TAG, "onCreate: sd " + response );
                Log.d(TAG, "onCreate: sd " + response );
//                JSONObject jsonObject = new JSONObject(response);
                try {

                    JSONObject jsonObject = new JSONObject(response);
                    Picasso.get().load(Constants.URL + jsonObject.getString("img_url")).into(profile);
//                    Toast.makeText(Profile.this, jsonObject.getString("name"), Toast.LENGTH_SHORT).show();

                    Log.d(TAG,"onCreate:"
                            +jsonObject.getString("name")
                            +jsonObject.getString("rollno")
                            +jsonObject.getString("dob")
                            +jsonObject.getString("gen")
                            +jsonObject.getString("lan")
                            +jsonObject.getString("phoneno")
                            +jsonObject.getString("email")
                            +jsonObject.getString("fname")
                            +jsonObject.getString("mname")
                            +jsonObject.getString("address")
                            +jsonObject.getString("pmob")
                            +jsonObject.getString("dist")
                            +jsonObject.getString("hostel")
                            +jsonObject.getString("doa")
                    );
                    nameTv.setText(jsonObject.getString("name"));
                    rollnoTv.setText(jsonObject.getString("rollno"));
                    dobTv.setText(jsonObject.getString("dob"));
                    genderTv.setText(jsonObject.getString("gen"));
                    languageTv.setText(jsonObject.getString("lan"));
                    mobileTv.setText(jsonObject.getString("phoneno"));
                    emailTv.setText(jsonObject.getString("email"));
                    fatherTv.setText(jsonObject.getString("fname"));
                    motherTv.setText(jsonObject.getString("mname"));
                    addressTv.setText(jsonObject.getString("address"));
                    father_noTv.setText(jsonObject.getString("pmob"));
                    distTv.setText(jsonObject.getString("dist"));
                    hostelTv.setText(jsonObject.getString("hostel"));
                    doaTv.setText(jsonObject.getString("doa"));
                    if (jsonObject.getString("img_url").equals(""))
                    {
                        defaultimage=Constants.IMAGE_URL+"Defaultimage.png";
                    }
                    else {

                        defaultimage=Constants.URL+jsonObject.getString("img_url");
                        Log.d(TAG, "shreyas: "+Constants.URL+jsonObject.getString("img_url"));
                    }
                    Picasso.get().load(defaultimage).transform(new CropCircleTransformation()).into(profile);



                } catch (JSONException e) {
                    Toast.makeText(Profile.this, "ERROR"+ e.toString(), Toast.LENGTH_SHORT).show();
                }





            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "onCreate: test 5" );
                progressDialog.hide();
                Toast.makeText(Profile.this, "ERROR: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                Log.d(TAG,"onCreate:"+id);
                params.put("id", id);


                return params;

            }
        };
        Log.d(TAG, "onCreate: test 6" );
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
        Log.d(TAG, "onCreate: test 7" );
    }
}
