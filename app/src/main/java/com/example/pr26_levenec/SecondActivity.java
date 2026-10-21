package com.example.pr26_levenec;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button btnWeb = findViewById(R.id.btnWeb);
        Button btnMap = findViewById(R.id.btnMap);
        Button btnBack = findViewById(R.id.btnBackFromWebMap);

        btnWeb.setOnClickListener(this);
        btnMap.setOnClickListener(this);

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

        if (id == R.id.btnWeb) {
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://yandex.ru"));
            startActivity(intent);
        } else if (id == R.id.btnMap) {
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:55.754283,37.62002"));
            startActivity(intent);
        }
    }
}