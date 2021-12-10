package com.example.thebook;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SubTShopInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tshop_info_sub);

        Intent intent = getIntent();
        // MainActivityからintentで受け取ったものを取り出す
        String selectedText = intent.getStringExtra("Text");
        String selectedText2 = intent.getStringExtra("Text2");

        TextView textView = findViewById(R.id.selected_text);
        textView.setText(selectedText);

        TextView textView2 = findViewById(R.id.selected_text2);
        textView2.setText(selectedText2);

    }
}