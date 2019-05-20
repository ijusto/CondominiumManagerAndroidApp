package com.example.condominiummanager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

public class TaskList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final SharedPreferences prefs = this.getSharedPreferences("com.example.condominiummanager", Context.MODE_PRIVATE);
        final CheckBox check1 = findViewById(R.id.checkBox2);
        final CheckBox check2 = findViewById(R.id.checkBox3);
        final CheckBox check3 = findViewById(R.id.tasktoadd);

        final ImageView add_task = findViewById(R.id.add_task_list);

        add_task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Report.class);
                startActivity(i);
            }
        });

        final ImageView go_back = findViewById(R.id.go_back_task_list);

        go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });




        if (prefs.getString("reportDone", "false").equals("true")){
            CheckBox task = findViewById(R.id.tasktoadd);
            task.setText(prefs.getString("reporttitle", "Something wrong some place"));
            task.setVisibility(View.VISIBLE);
        }

        check1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check1.isChecked()){
                    check1.setPaintFlags(check1.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

                }else{
                    check1.setPaintFlags(check1.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
                }
            }
        });

        check2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check2.isChecked()){
                    check2.setPaintFlags(check2.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

                }else{
                    check2.setPaintFlags(check2.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
                }
            }
        });

        check3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check3.isChecked()){
                    check3.setPaintFlags(check3.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

                }else{
                    check3.setPaintFlags(check3.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
                }
            }
        });


    }

}
