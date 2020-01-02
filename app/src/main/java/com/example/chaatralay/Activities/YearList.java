package com.example.chaatralay.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.chaatralay.R;

public class YearList extends AppCompatActivity {

    private Button a1Btn,a2Btn,a3Btn,a4Btn,a5Btn,b1Btn,b2Btn,b3Btn,b4Btn,b5Btn;
    private String id,course;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_year_list);

        a1Btn=findViewById(R.id.a1Btn);
        a2Btn=findViewById(R.id.a2Btn);
        a3Btn=findViewById(R.id.a3Btn);
        a4Btn=findViewById(R.id.a4Btn);
        a5Btn=findViewById(R.id.a5Btn);
        b1Btn=findViewById(R.id.b1Btn);
        b2Btn=findViewById(R.id.b2Btn);
        b3Btn=findViewById(R.id.b3Btn);
        b4Btn=findViewById(R.id.b4Btn);
        b5Btn=findViewById(R.id.b5Btn);
        Bundle b=getIntent().getExtras();
        id=b.getString("id");
        course=b.getString("course");
        Toast.makeText(this, id+course, Toast.LENGTH_SHORT).show();


        a1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), StudentList.class);
                i.putExtra("course",course);
                i.putExtra("year","1");
                startActivity(i);
            }
        });

        a2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), StudentList.class);
                i.putExtra("course",course);
                i.putExtra("year","2");
                startActivity(i);
            }
        });

        a3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), StudentList.class);
                i.putExtra("course",course);
                i.putExtra("year","3");
                startActivity(i);
            }
        });

        a4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), StudentList.class);
                i.putExtra("course",course);
                i.putExtra("year","4");
                startActivity(i);
            }
        });

        a5Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), StudentList.class);
                i.putExtra("course",course);
                i.putExtra("year","5");
                startActivity(i);
            }
        });

        b1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), StudentList.class);
                i.putExtra("course",course);
                i.putExtra("year","1");
                startActivity(i);
            }
        });

        b2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(getApplicationContext(),StudentList.class);
                i.putExtra("course",course);
                i.putExtra("year","2");
                startActivity(i);
            }
        });


        b3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), StudentList.class);
                i.putExtra("course",course);
                i.putExtra("year","3");
                startActivity(i);
            }
        });

        b4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), StudentList.class);
                i.putExtra("course",course);
                i.putExtra("year","4");
                startActivity(i);
            }
        });

        b5Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), StudentList.class);
                i.putExtra("course",course);
                i.putExtra("year","5");
                startActivity(i);
            }
        });

    }
}
