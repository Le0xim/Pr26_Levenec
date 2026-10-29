package com.example.pr26_levenec;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Button btnCall = findViewById(R.id.btnCall);
        Button btnSms = findViewById(R.id.btnSms);
        Button btnBack = findViewById(R.id.btnBackFromCallSms);

        btnCall.setOnClickListener(this);
        btnSms.setOnClickListener(this);

        // Кнопка "Назад"
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        int id = v.getId();

        if (id == R.id.btnCall) {
            // Открытие телефона
            intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:112"));
            startActivity(intent);
        } else if (id == R.id.btnSms) {
            // Открытие  СМС
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("smsto:89137771020"));
            intent.putExtra("sms_body", "Привет! Это тестовое сообщение.");
            startActivity(intent);
        }
    }
}
