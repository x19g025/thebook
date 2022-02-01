package com.example.thebook;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import java.io.FileDescriptor;
import java.io.IOException;

public class TPostActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tpost);

        final Button Stockpost_button = findViewById(R.id.btn_import);

        Stockpost_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(TPostActivity.this, TPostActivity_make.class); //ブログお知らせ画面に遷移
                startActivity(intent);
            }
        });
    }
}

