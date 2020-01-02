package com.example.chaatralay.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class StudentLeaveApplication extends AppCompatActivity {

    private TextView fromdateTv,todateTv;
    private EditText reasonEt;
    private Button submit_applicationBtn;
    private String id,reason,todate,fromdate;
    private Calendar calendar;
    private DatePickerDialog datePickerDialog;
    private ProgressDialog progressDialog;
    private static final String TAG = "StudentLeaveApplication";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_leave_application);

        fromdateTv=findViewById(R.id.from_dateTv);
        todateTv=findViewById(R.id.to_dateTv);
        reasonEt=findViewById(R.id.reasonEt);
        submit_applicationBtn=findViewById(R.id.submit_applicationsBtn);
        Bundle b=getIntent().getExtras();
        id=b.getString("id");
        progressDialog=new ProgressDialog(this);


        fromdateTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calendar=Calendar.getInstance();
                int y = calendar.get(Calendar.YEAR);
                int m = calendar.get(Calendar.MONTH);
                int d = calendar.get(Calendar.DAY_OF_MONTH);

                datePickerDialog=new DatePickerDialog(StudentLeaveApplication.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        month=month+1;
                        fromdateTv.setText(dayOfMonth+"/"+month+"/"+year);
                    }
                },y,m,d);
                datePickerDialog.show();

            }
        });


        todateTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calendar=Calendar.getInstance();
                int y = calendar.get(Calendar.YEAR);
                int m = calendar.get(Calendar.MONTH);
                int d = calendar.get(Calendar.DAY_OF_MONTH);

                datePickerDialog=new DatePickerDialog(StudentLeaveApplication.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        month=month+1;
                        todateTv.setText(dayOfMonth+"/"+month+"/"+year);
                    }
                },y,m,d);
                datePickerDialog.show();

            }
        });

        submit_applicationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                reason=reasonEt.getText().toString();
                fromdate=fromdateTv.getText().toString();
                todate=todateTv.getText().toString();

                if(reason.equals("")&&fromdate.equals("")&&todate.equals("")){

                    Toast.makeText(StudentLeaveApplication.this, "Enter all the Fields", Toast.LENGTH_SHORT).show();
                }else {

                    Toast.makeText(StudentLeaveApplication.this, reason, Toast.LENGTH_SHORT).show();
                    submitapplication();
                }


            }
        });


    }

    private void submitapplication() {

        progressDialog.setMessage("Please wait...");
        progressDialog.show();

        Log.d(TAG, "onCreate: test 3" );
        StringRequest request = new StringRequest(Request.Method.POST, Constants.POST_LEAVE_APPLICATION, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
//                Toast.makeText(MainActivity.this, "inside", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
                Log.d(TAG, "onCreate: sd " + response );
                Log.d(TAG, "onCreate: sd " + response );
//                JSONObject jsonObject = new JSONObject(response);
                try {

                    JSONObject jsonObject = new JSONObject(response);


                    Toast.makeText(StudentLeaveApplication.this,jsonObject.getString("message"), Toast.LENGTH_SHORT).show();





                } catch (JSONException e) {
                    Toast.makeText(StudentLeaveApplication.this, "ERROR"+ e.toString(), Toast.LENGTH_SHORT).show();
                }





            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "onCreate: test 5" );
                progressDialog.hide();
                Toast.makeText(StudentLeaveApplication.this, "ERROR: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                Log.d(TAG,"onCreate:"+reason);
                params.put("reason", reason);
                params.put("fromdate", fromdate);
                params.put("todate", todate);
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
