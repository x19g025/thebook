package com.example.thebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TMapCreateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tmap_create);

        final Button Hensyu_button = findViewById(R.id.Hensyu_button);
        final Button Kousin_button = findViewById(R.id.Kousin_button);

        Hensyu_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(TMapCreateActivity.this, GazouHozonActivity.class); //画像保存場所
                startActivity(intent);
            }
        });
        Kousin_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(TMapCreateActivity.this, FakeCreateActivity.class); //画像保存場所
                startActivity(intent);
            }
        });
    }
}
