package com.example.thebook;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class THomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thome);

        final Button StockChoice_button = findViewById(R.id.StockChoice_button);
        final Button TBlog_button = findViewById(R.id.TBlog_button);
        final Button TShopInfoEdit_button = findViewById(R.id.TShopInfoEdit_button);
        final Button TMap_button = findViewById(R.id.TMap_button);

        StockChoice_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(THomeActivity.this, TStockChoiceActivity.class); //ブログお知らせ画面に遷移
                startActivity(intent);
            }
        });
        TBlog_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(THomeActivity.this, TPostActivity.class); //ブログお知らせ画面に遷移
                startActivity(intent);
            }
        });
        TShopInfoEdit_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(THomeActivity.this, TShopInfoActivity.class); //店舗情報編集に遷移
                startActivity(intent);
            }
        });
        TMap_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(THomeActivity.this, TMapCreateActivity.class); //店舗情報編集画面
                startActivity(intent);
            }
        });
    }
}
