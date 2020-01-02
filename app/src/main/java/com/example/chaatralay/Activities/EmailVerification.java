package com.example.chaatralay.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class EmailVerification extends AppCompatActivity {

    private static final String TAG = "EmailVerification";
    private EditText emailEt;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Button backBtn,verifyBtn;
    private String email,userType;
    private ProgressDialog progressDialog;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_verification);

        radioGroup=findViewById(R.id.optionRg);
        emailEt=findViewById(R.id.emailEt);
        backBtn=findViewById(R.id.backbtn);
        verifyBtn=findViewById(R.id.verifyBtn);
        progressDialog=new ProgressDialog(this);

        verifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                email=emailEt.getText().toString().trim();
                studentLogin();

            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });


    }
    private void studentLogin() {

        progressDialog.setMessage("Please wait...");
        progressDialog.show();

        Log.d(TAG, "onCreate: test 3" );
        StringRequest request = new StringRequest(Request.Method.POST, Constants.VERIFY_EMAIL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
//                Toast.makeText(MainActivity.this, "inside", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
                Log.d(TAG, "onCreate: sd " + response );
                Log.d(TAG, "onCreate: sd " + response );
//                JSONObject jsonObject = new JSONObject(response);
                try {

                    JSONObject jsonObject = new JSONObject(response);

                    id=jsonObject.getInt("id");
                    Log.d(TAG,"onCreate: "+id);

                    //Toast.makeText(userRegisters.this, jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                    if(jsonObject.getString("message").equals("Verified"))
                    {
                        Log.d(TAG,"oncreate: inside json if");
                        Intent i=new Intent(getApplicationContext(), StudentRegistration.class);
                        i.putExtra("id",id);
                        i.putExtra("email",email);
                        startActivity(i);
                    }else {
                        Toast.makeText(EmailVerification.this, "user not registered", Toast.LENGTH_SHORT).show();
                    }




                } catch (JSONException e) {
                    Toast.makeText(EmailVerification.this, "ERROR"+ e.toString(), Toast.LENGTH_SHORT).show();
                }





            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "onCreate: test 5" );
                progressDialog.hide();
                Toast.makeText(EmailVerification.this, "ERROR: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                Log.d(TAG,"onCreate:"+email);
                params.put("email", email);


                return params;

            }
        };
        Log.d(TAG, "onCreate: test 6" );
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
        Log.d(TAG, "onCreate: test 7" );

    }
}
