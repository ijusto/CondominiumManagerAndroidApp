package com.example.condominiummanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
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

        final ImageView add_payment = findViewById(R.id.add_payment);
        final ImageView add_payment_rect_info = findViewById(R.id.add_payment_rect_info);
        final TextView add_event_title = findViewById(R.id.add_event_title);
        final TextView payment_name = findViewById(R.id.payment_name);
        final TextView payment_name_input = findViewById(R.id.payment_name_input);
        final TextView payment_amount = findViewById(R.id.payment_amount);
        final TextView payment_amount_input = findViewById(R.id.payment_amount_input);
        final ImageView check_payment = findViewById(R.id.check_payment);


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
            }
        });






    }

}
