package com.example.condominiummanager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
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

        final TextView chat_name = findViewById(R.id.chat_name);
        final ImageView chatimage = findViewById(R.id.chat_pic);

        String target = prefs.getString("chatto", "");
        String host = prefs.getString("chathostid", "");


        final TextView first_text_maintenance_to_manager = findViewById(R.id.first_text_maintenance_to_manager);
        final TextView first_text_manager_to_maintenance = findViewById(R.id.first_text_manager_to_maintenance);
        final TextView first_text_tenant_to_manager = findViewById(R.id.first_text_tenant_to_manager);
        final TextView first_text_manager_to_tenant = findViewById(R.id.first_text_manager_to_tenant);
        final TextView first_text_maintenance_to_tenant = findViewById(R.id.first_text_maintenance_to_tenant);
        final TextView first_text_tenant_to_maintenance = findViewById(R.id.first_text_tenant_to_maintenance);
        final TextView respond_text = findViewById(R.id.respond_text);

        final ImageView first_chat_bubble_maintenance_to_manager = findViewById(R.id.first_chat_bubble_maintenance_to_manager);
        final ImageView first_chat_bubble_manager_to_maintenance = findViewById(R.id.first_chat_bubble_manager_to_maintenance);
        final ImageView first_chat_bubble_tenant_to_manager = findViewById(R.id.first_chat_bubble_tenant_to_manager);
        final ImageView first_chat_bubble_manager_to_tenant = findViewById(R.id.first_chat_bubble_manager_to_tenant);
        final ImageView first_chat_bubble_maintenance_to_tenant = findViewById(R.id.first_chat_bubble_maintenance_to_tenant);
        final ImageView first_chat_bubble_tenant_to_maintenance = findViewById(R.id.first_chat_bubble_tenant_to_maintenance);
        final ImageView respond_text_chat_bubble = findViewById(R.id.respond_text_chat_bubble);

        switch (target){
            case "manager":
                chatimage.setImageResource(R.mipmap.manager_profile_pic);
                switch (host) {
                    case "maintenance":
                        first_text_maintenance_to_manager.setVisibility(View.VISIBLE);
                        first_chat_bubble_maintenance_to_manager.setVisibility(View.VISIBLE);
                        break;
                    case "tenant":
                        first_text_tenant_to_manager.setVisibility(View.VISIBLE);
                        first_chat_bubble_tenant_to_manager.setVisibility(View.VISIBLE);
                        break;
                }
                break;
            case "maintenance":
                chatimage.setImageResource(R.mipmap.maintenance_profile_pic);
                switch (host) {
                    case "manager":
                        first_text_manager_to_maintenance.setVisibility(View.VISIBLE);
                        first_chat_bubble_manager_to_maintenance.setVisibility(View.VISIBLE);
                        break;
                    case "tenant":
                        first_text_tenant_to_maintenance.setVisibility(View.VISIBLE);
                        first_chat_bubble_tenant_to_maintenance.setVisibility(View.VISIBLE);
                        break;
                }
                break;
            case "tenant":
                chatimage.setImageResource(R.mipmap.tenant_profile_pic);
                switch (host) {
                    case "manager":
                        first_text_manager_to_tenant.setVisibility(View.VISIBLE);
                        first_chat_bubble_manager_to_tenant.setVisibility(View.VISIBLE);
                        break;
                    case "maintenance":
                        first_text_maintenance_to_tenant.setVisibility(View.VISIBLE);
                        first_chat_bubble_maintenance_to_tenant.setVisibility(View.VISIBLE);
                        break;
                }
                break;
        }

        chat_name.setText(prefs.getString("chatname", "something wrong"));

        final Button reply = findViewById(R.id.replybutton);
        final ImageView imageView7 = findViewById(R.id.imageView7);

        reply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText replytext = findViewById(R.id.answerchat);
                String answer = replytext.getText().toString();
                respond_text.setText(answer);
                respond_text.setVisibility(View.VISIBLE);
                respond_text_chat_bubble.setVisibility(View.VISIBLE);
                replytext.setText("");
            }
        });
    }

}
