package com.example.condominiummanager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class PrivateChat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_private_chat);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final SharedPreferences prefs = this.getSharedPreferences("com.example.condominiummanager", MODE_PRIVATE);

        final ImageView go_back = findViewById(R.id.go_back_private_chat);

        go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        TextView chat_name = findViewById(R.id.chat_name);
        ImageView chatimage = findViewById(R.id.chat_pic);

        String target = prefs.getString("chatto", "");

        switch (target){
            case "manager":
                chatimage.setImageResource(R.mipmap.manager_profile_pic);
                break;
            case "maintenance":
                chatimage.setImageResource(R.mipmap.maintenance_profile_pic);
                break;
            case "tenant":
                chatimage.setImageResource(R.mipmap.tenant_profile_pic);
                break;
        }

        chat_name.setText(prefs.getString("chatname", "something wrong"));

        final Button reply = findViewById(R.id.replybutton);

        reply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText replytext = findViewById(R.id.answerchat);
                String answer = replytext.getText().toString();
                //TODO REPLY CHAT
            }
        });


    }

}
