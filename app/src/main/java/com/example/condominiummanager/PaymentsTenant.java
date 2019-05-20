package com.example.condominiummanager;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class PaymentsTenant extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payments_tenant);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final SharedPreferences prefs = this.getSharedPreferences("com.example.condominiummanager", MODE_PRIVATE);

        final ImageView go_back = findViewById(R.id.go_back_payments_tenant);

        go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        final CheckBox payment = findViewById(R.id.checkpayment);

        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(payment.isChecked()){
                    prefs.edit().putString("tenant_payment", "true").apply();
                    TextView text1 = findViewById(R.id.second_payment_tenant_title);
                    TextView text2 = findViewById(R.id.tenant_payment_value);

                    text1.setTextColor(Color.GREEN);
                    text2.setTextColor(Color.GREEN);


                }else{
                    prefs.edit().putString("tenant_payment", "false").apply();
                    TextView text1 = findViewById(R.id.second_payment_tenant_title);
                    TextView text2 = findViewById(R.id.tenant_payment_value);

                    text1.setTextColor(Color.WHITE);
                    text2.setTextColor(Color.WHITE);

                }
            }
        });

        if(prefs.getString("tenant_payment", "").equals("true")){
            TextView text1 = findViewById(R.id.second_payment_tenant_title);
            TextView text2 = findViewById(R.id.tenant_payment_value);

            text1.setTextColor(Color.GREEN);
            text2.setTextColor(Color.GREEN);
            payment.setChecked(true);

        }else{
            TextView text1 = findViewById(R.id.second_payment_tenant_title);
            TextView text2 = findViewById(R.id.tenant_payment_value);

            text1.setTextColor(Color.WHITE);
            text2.setTextColor(Color.WHITE);
            payment.setChecked(false);

        }

        final ImageView delete = findViewById(R.id.delete_payment_tenant);

        if(prefs.getString("delete_payment_tenant","false").equals("true")){
            TextView text1 = findViewById(R.id.second_payment_tenant_title);
            TextView text2 = findViewById(R.id.tenant_payment_value);
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
                TextView text1 = findViewById(R.id.second_payment_tenant_title);
                TextView text2 = findViewById(R.id.tenant_payment_value);
                ImageView block = findViewById(R.id.first_payment_tenant);

                text1.setVisibility(View.INVISIBLE);
                text2.setVisibility(View.INVISIBLE);
                payment.setVisibility(View.INVISIBLE);
                delete.setVisibility(View.INVISIBLE);
                block.setVisibility(View.INVISIBLE);

                prefs.edit().putString("delete_payment_tenant","true").apply();



            }
        });



    }

}
