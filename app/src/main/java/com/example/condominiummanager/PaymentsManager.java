package com.example.condominiummanager;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class PaymentsManager extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payments_manager);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final SharedPreferences prefs = this.getSharedPreferences("com.example.condominiummanager", MODE_PRIVATE);


        final ImageView go_back = findViewById(R.id.go_back_payments_manager);

        go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        final CheckBox payment = findViewById(R.id.payment_manager);

        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (payment.isChecked()) {
                    prefs.edit().putString("tenant_payment", "true").apply();
                    TextView text1 = findViewById(R.id.first_payment_tenant_title);
                    TextView text2 = findViewById(R.id.manager_second_payment_value);

                    text1.setTextColor(Color.GREEN);
                    text2.setTextColor(Color.GREEN);


                } else {
                    prefs.edit().putString("tenant_payment", "false").apply();
                    TextView text1 = findViewById(R.id.first_payment_tenant_title);
                    TextView text2 = findViewById(R.id.manager_second_payment_value);

                    text1.setTextColor(Color.WHITE);
                    text2.setTextColor(Color.WHITE);

                }
            }
        });

        if (prefs.getString("tenant_payment", "").equals("true")) {
            TextView text1 = findViewById(R.id.first_payment_tenant_title);
            TextView text2 = findViewById(R.id.manager_second_payment_value);

            text1.setTextColor(Color.GREEN);
            text2.setTextColor(Color.GREEN);
            payment.setChecked(true);

        } else {
            TextView text1 = findViewById(R.id.first_payment_tenant_title);
            TextView text2 = findViewById(R.id.manager_second_payment_value);

            text1.setTextColor(Color.WHITE);
            text2.setTextColor(Color.WHITE);

            payment.setChecked(false);

        }


        final ImageView delete = findViewById(R.id.delete_manager_second_payment);

        if (prefs.getString("delete_payment_manager", "false").equals("true")) {
            TextView text1 = findViewById(R.id.first_payment_tenant_title);
            TextView text2 = findViewById(R.id.manager_second_payment_value);
            ImageView block = findViewById(R.id.first_payment_tenant);

            text1.setVisibility(View.INVISIBLE);
            text2.setVisibility(View.INVISIBLE);
            payment.setVisibility(View.INVISIBLE);
            delete.setVisibility(View.INVISIBLE);
            block.setVisibility(View.INVISIBLE);

        }

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text1 = findViewById(R.id.first_payment_tenant_title);
                TextView text2 = findViewById(R.id.manager_second_payment_value);
                ImageView block = findViewById(R.id.first_payment_tenant);

                text1.setVisibility(View.INVISIBLE);
                text2.setVisibility(View.INVISIBLE);
                payment.setVisibility(View.INVISIBLE);
                delete.setVisibility(View.INVISIBLE);
                block.setVisibility(View.INVISIBLE);

                prefs.edit().putString("delete_payment_manager", "true").apply();


            }
        });

        if (prefs.getString("payment_created", "").equals("true")) {

            final CheckBox checkpay2 = findViewById(R.id.second_payment_manager);

            checkpay2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (checkpay2.isChecked()) {
                        prefs.edit().putString("maintenance_payment", "true").apply();
                        TextView text1 = findViewById(R.id.second_payment_manager_title);
                        TextView text2 = findViewById(R.id.manager_second_payment_value);

                        text1.setTextColor(Color.GREEN);
                        text2.setTextColor(Color.GREEN);


                    } else {
                        prefs.edit().putString("maintenance_payment", "false").apply();
                        TextView text1 = findViewById(R.id.second_payment_manager_title);
                        TextView text2 = findViewById(R.id.manager_second_payment_value);
                        text1.setTextColor(Color.WHITE);
                        text2.setTextColor(Color.WHITE);

                    }
                }
            });

            if (prefs.getString("payment_created", "false").equals("true")
                    && prefs.getString("manager_maintenance_delete", "false").equals("false")){
                final TextView payment_amm = findViewById(R.id.manager_second_payment_value);
                final TextView payment_title = findViewById(R.id.second_payment_manager_title);
                final ImageView payblock = findViewById(R.id.second_payment_tenant);
                final ImageView paydelete = findViewById(R.id.delete_manager_second_payment);

                payment_amm.setVisibility(View.VISIBLE);
                payment_title.setVisibility(View.VISIBLE);
                checkpay2.setVisibility(View.VISIBLE);
                payblock.setVisibility(View.VISIBLE);
                paydelete.setVisibility(View.VISIBLE);
                payment_title.setText(prefs.getString("payment_title", ""));
                payment_amm.setText(prefs.getString("payment_ammount", ""));
                if (prefs.getString("maintenance_payment", "false").equals("true")){
                    TextView text1 = findViewById(R.id.second_payment_manager_title);
                    TextView text2 = findViewById(R.id.manager_second_payment_value);

                    text1.setTextColor(Color.GREEN);
                    text2.setTextColor(Color.GREEN);
                    checkpay2.setChecked(true);

                }else{
                    TextView text1 = findViewById(R.id.second_payment_manager_title);
                    TextView text2 = findViewById(R.id.manager_second_payment_value);

                    text1.setTextColor(Color.WHITE);
                    text2.setTextColor(Color.WHITE);
                    checkpay2.setChecked(false);
                }
            }



        }

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final TextView payment_amm = findViewById(R.id.manager_second_payment_value);
                final TextView payment_title = findViewById(R.id.second_payment_manager_title);
                final ImageView payblock = findViewById(R.id.second_payment_tenant);
                final ImageView paydelete = findViewById(R.id.delete_manager_second_payment);
                final CheckBox checkpay2 = findViewById(R.id.second_payment_manager);


                payment_amm.setVisibility(View.INVISIBLE);
                payment_title.setVisibility(View.INVISIBLE);
                checkpay2.setVisibility(View.INVISIBLE);
                payblock.setVisibility(View.INVISIBLE);
                paydelete.setVisibility(View.INVISIBLE);

                prefs.edit().putString("manager_maintenance_delete", "true").apply();
            }
        });
    }

}
