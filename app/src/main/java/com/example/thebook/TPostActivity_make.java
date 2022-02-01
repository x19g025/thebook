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

public class TPostActivity_make extends AppCompatActivity{

    private static final int READ_REQUEST_CODE = 42;
    Button btn_import;
    ImageView img_picture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tpost_make);

        btn_import = findViewById(R.id.btn_import);
        img_picture = findViewById(R.id.img_picture);


        final Button Stockpost_button = findViewById(R.id.btn_toukou);

        Stockpost_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(TPostActivity_make.this, TPostActivity_make_fake.class); //ブログお知らせ画面に遷移
                startActivity(intent);
            }
        });
    }



    @Override
    protected void onStart() {
        super.onStart();
        btn_import.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("image/*");
                startActivityForResult(intent, READ_REQUEST_CODE);  //READ_REQUSET_CODE = 42
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode,
                                 Intent resultData) {
        super.onActivityResult(requestCode, resultCode, resultData);
        if (requestCode == READ_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            Uri uri = null;
            if (resultData != null) {
                uri = resultData.getData();//画像データのuri
                try {
                    Bitmap bmp = getBitmapFromUri(uri);
                    img_picture.setImageBitmap(bmp);
                } catch (IOException e) {
                    //TODO:例外処理
                }
            }
        }
    }

    //公式Docからそのまま転用
    private Bitmap getBitmapFromUri(Uri uri) throws IOException {
        ParcelFileDescriptor parcelFileDescriptor =
                getContentResolver().openFileDescriptor(uri, "r");
        FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
        Bitmap image = BitmapFactory.decodeFileDescriptor(fileDescriptor);
        parcelFileDescriptor.close();
        return image;
    }
}