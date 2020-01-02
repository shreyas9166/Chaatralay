package com.example.chaatralay.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class StudentRegistration extends AppCompatActivity {

    private EditText usernameEt,passwordEt,passwordtestEt;
    private Button registerBtn;
    private static final String TAG = "StudentRegistration";
    private ProgressDialog progressDialog;
    private String username,password,passwordtest,email,sid;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_registeration);


        usernameEt=findViewById(R.id.usernameEt);
        passwordEt=findViewById(R.id.passwordEt);
        passwordtestEt=findViewById(R.id.passrdtestEt);
        registerBtn=findViewById(R.id.registerhereBtn);

        progressDialog=new ProgressDialog(this);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                username=usernameEt.getText().toString().trim();
                password=passwordEt.getText().toString().trim();
                passwordtest=passwordtestEt.getText().toString().trim();
                Bundle b=getIntent().getExtras();
                id=b.getInt("id");
                sid=String.valueOf(id);
                email=b.getString("email");


                Log.d(TAG,"onCreate:"+password+passwordtest+id+email);
                Log.d(TAG,"onCreate:"+password.equals(passwordtest));
                if(password.equals(passwordtest))
                {
                    api_function();
                }else {
                    Toast.makeText(StudentRegistration.this, "Wrong password match", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void api_function() {


        Log.d(TAG, "onCreate: Entered function" );
        progressDialog.setMessage("Please wait...");
        progressDialog.show();

        Log.d(TAG, "onCreate: test 3" );
        StringRequest request = new StringRequest(Request.Method.POST, Constants.REGISTER_USER, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
//                Toast.makeText(MainActivity.this, "inside", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
                Log.d(TAG, "onCreate: sd " + response );
                Log.d(TAG, "onCreate: sd " + response );
//                JSONObject jsonObject = new JSONObject(response);
                try {

                    JSONObject jsonObject = new JSONObject(response);


                    Log.d(TAG,"onCreate: "+id);

                    //Toast.makeText(userRegisters.this, jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                    if(jsonObject.getString("message").equals("User registered successfully"))
                    {
                        Log.d(TAG,"oncreate: inside json if");
                        Intent i=new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(i);
                    }else {
                        Toast.makeText(StudentRegistration.this, "user not registered", Toast.LENGTH_SHORT).show();
                    }




                } catch (JSONException e) {
                    Toast.makeText(StudentRegistration.this, "ERROR"+ e.toString(), Toast.LENGTH_SHORT).show();
                }





            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "onCreate: test 5"+ error.getMessage() );
                progressDialog.hide();
                Toast.makeText(StudentRegistration.this, "ERROR: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                Log.d(TAG,"onCreate:"+email);
                params.put("username", username);
                params.put("password", password);
                params.put("id", sid);


                return params;

            }
        };
        Log.d(TAG, "onCreate: test 6" );
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
        Log.d(TAG, "onCreate: test 7" );


    }
}
