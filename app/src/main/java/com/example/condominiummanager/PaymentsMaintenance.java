package com.example.condominiummanager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class PaymentsMaintenance extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payments_maintenance);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ImageView go_back = findViewById(R.id.go_back_payments_maintenance);

        go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        final SharedPreferences prefs = this.getSharedPreferences("com.example.condominiummanager", Context.MODE_PRIVATE);


        final ImageView add_payment = findViewById(R.id.add_payment);
        final ImageView add_payment_rect_info = findViewById(R.id.add_payment_rect_info);
        final TextView add_event_title = findViewById(R.id.add_event_title);
        final TextView payment_name = findViewById(R.id.payment_name);
        final TextView payment_name_input = findViewById(R.id.payment_name_input);
        final TextView payment_amount = findViewById(R.id.payment_amount);
        final TextView payment_amount_input = findViewById(R.id.payment_amount_input);
        final ImageView check_payment = findViewById(R.id.check_payment);
        final TextView payment_title = findViewById(R.id.payment_title);
        final TextView payment_amm = findViewById(R.id.payment_ammount);
        final CheckBox checkpay = findViewById(R.id.payment_maintenance_check);
        final ImageView payblock = findViewById(R.id.payment_maintenance_block);
        final ImageView paydelete = findViewById(R.id.payment_maintenance_delete);


        add_payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add_payment_rect_info.setVisibility(View.VISIBLE);
                add_event_title.setVisibility(View.VISIBLE);
                payment_name.setVisibility(View.VISIBLE);
                payment_name_input.setVisibility(View.VISIBLE);
                payment_amount.setVisibility(View.VISIBLE);
                payment_amount_input.setVisibility(View.VISIBLE);
                add_payment.setVisibility((View.INVISIBLE));
                check_payment.setVisibility((View.VISIBLE));
            }
        });

        check_payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add_payment_rect_info.setVisibility(View.INVISIBLE);
                add_event_title.setVisibility(View.INVISIBLE);
                payment_name.setVisibility(View.INVISIBLE);
                payment_name_input.setVisibility(View.INVISIBLE);
                payment_amount.setVisibility(View.INVISIBLE);
                payment_amount_input.setVisibility(View.INVISIBLE);
                add_payment.setVisibility((View.VISIBLE));
                check_payment.setVisibility((View.INVISIBLE));
                prefs.edit().putString("payment_title", payment_name_input.getText().toString()).apply();
                prefs.edit().putString("payment_ammount", payment_amount_input.getText().toString()).apply();
                prefs.edit().putString("payment_created", "true").apply();
                prefs.edit().putString("maintenance_delete", "false").apply();
                payment_amm.setText(payment_amount_input.getText().toString());
                payment_title.setText(payment_name_input.getText().toString());
                payment_amm.setVisibility(View.VISIBLE);
                payment_title.setVisibility(View.VISIBLE);
                checkpay.setVisibility(View.VISIBLE);
                payblock.setVisibility(View.VISIBLE);
                paydelete.setVisibility(View.VISIBLE);



            }
        });

        checkpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkpay.isChecked()){
                    prefs.edit().putString("maintenance_payment", "true").apply();
                    TextView text1 = findViewById(R.id.payment_title);
                    TextView text2 = findViewById(R.id.payment_ammount);

                    text1.setTextColor(Color.GREEN);
                    text2.setTextColor(Color.GREEN);


                }else{
                    prefs.edit().putString("maintenance_payment", "false").apply();
                    TextView text1 = findViewById(R.id.payment_title);
                    TextView text2 = findViewById(R.id.payment_ammount);
                    text1.setTextColor(Color.WHITE);
                    text2.setTextColor(Color.WHITE);

                }
            }
        });

        if (prefs.getString("payment_created", "false").equals("true")
        && prefs.getString("maintenance_delete", "false").equals("false")) {
            payment_amm.setVisibility(View.VISIBLE);
            payment_title.setVisibility(View.VISIBLE);
            checkpay.setVisibility(View.VISIBLE);
            payblock.setVisibility(View.VISIBLE);
            paydelete.setVisibility(View.VISIBLE);
            TextView text1 = findViewById(R.id.payment_title);
            TextView text2 = findViewById(R.id.payment_ammount);
            text1.setText(prefs.getString("payment_title", ""));
            text2.setText(prefs.getString("payment_ammount", ""));



            if (prefs.getString("maintenance_payment", "false").equals("true")){
                text1 = findViewById(R.id.payment_title);
                text2 = findViewById(R.id.payment_ammount);

                text1.setTextColor(Color.GREEN);
                text2.setTextColor(Color.GREEN);
                checkpay.setChecked(true);

            }else{
                text1 = findViewById(R.id.payment_title);
                text2 = findViewById(R.id.payment_ammount);
                text1.setTextColor(Color.WHITE);
                text2.setTextColor(Color.WHITE);
                checkpay.setChecked(false);
            }
        }


        paydelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                payment_amm.setVisibility(View.INVISIBLE);
                payment_title.setVisibility(View.INVISIBLE);
                checkpay.setVisibility(View.INVISIBLE);
                payblock.setVisibility(View.INVISIBLE);
                paydelete.setVisibility(View.INVISIBLE);

                prefs.edit().putString("maintenance_delete", "true").apply();
            }
        });







    }

}
