package com.example.chaatralay.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.chaatralay.Activities.StudentList;
import com.example.chaatralay.R;

public class DepartmentList extends AppCompatActivity {

    private Button bca1Btn,bca2Btn,bca3Btn,bcom1Btn,bcom2Btn,bcom3Btn;
    private TextView bcaTv,bcomTv;

    private String course,year;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department_list);

        bcaTv=findViewById(R.id.bcaTv);
        bcomTv=findViewById(R.id.bcomTv);
        bca1Btn=findViewById(R.id.bca1Btn);
        bca2Btn=findViewById(R.id.bca2Btn);
        bca3Btn=findViewById(R.id.bca3Btn);
        bcom1Btn=findViewById(R.id.bcom1Btn);
        bcom2Btn=findViewById(R.id.bcom2Btn);
        bcom3Btn=findViewById(R.id.bcom3Btn);


        bcaTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(getApplicationContext(), StudentList.class);
                i.putExtra("course","BCA");
                i.putExtra("year","0");
                startActivity(i);

            }
        });

        bcomTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(getApplicationContext(), StudentList.class);
                i.putExtra("course","BCOM");
                i.putExtra("year","0");
                startActivity(i);

            }
        });

        bca1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(getApplicationContext(), StudentList.class);
                i.putExtra("course","BCA");
                i.putExtra("year","1");
                startActivity(i);

            }
        });

        bca2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(getApplicationContext(), StudentList.class);
                i.putExtra("course","BCA");
                i.putExtra("year","2");
                startActivity(i);

            }
        });
        bca3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(getApplicationContext(), StudentList.class);
                i.putExtra("course","BCA");
                i.putExtra("year","3");
                startActivity(i);

            }
        });
        bcom1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(getApplicationContext(), StudentList.class);
                i.putExtra("course","BCOM");
                i.putExtra("year","1");
                startActivity(i);

            }
        });
        bcom2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(getApplicationContext(), StudentList.class);
                i.putExtra("course","BCOM");
                i.putExtra("year","2");
                startActivity(i);

            }
        });
        bcom3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(getApplicationContext(), StudentList.class);
                i.putExtra("course","BCOM");
                i.putExtra("year","3");
                startActivity(i);

            }
        });




    }
}
