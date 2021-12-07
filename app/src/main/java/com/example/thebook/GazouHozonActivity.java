package com.example.thebook;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class GazouHozonActivity extends AppCompatActivity {

    private TextView textView;
    private ImageView imageView;

    // asset の画像ファイル名
    private final String fileName = "sample_image.jpg";
    private File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gazou_hozon);


        Context context = getApplicationContext();

        // 画像を置く外部ストレージ
        file = new File(context.getExternalFilesDir(Environment.DIRECTORY_PICTURES), fileName);

        Log.d("log","path: " + file);

        textView = findViewById(R.id.text_view);
        String str = "image file: "+fileName;
        textView.setText(str);

        imageView = findViewById(R.id.image_view);

        setUpWriteExternalStorage();
    }

    private void setUpWriteExternalStorage(){
        Button buttonSave = findViewById(R.id.button_save);
        // 外部ストレージに画像を保存する
        buttonSave.setOnClickListener( v -> {
            if(isExternalStorageWritable()){
                try(// assetsから画像ファイルを取り出し
                    InputStream inputStream =
                            getResources().getAssets().open(fileName);
                    // 外部ストレージに画像を保存
                    FileOutputStream output =
                            new FileOutputStream(file)) {

                    // バッファーを使って画像を書き出す
                    int DEFAULT_BUFFER_SIZE = 10240 * 4;
                    byte[] buf = new byte[DEFAULT_BUFFER_SIZE];
                    int len;

                    while((len=inputStream.read(buf))!=-1){
                        output.write(buf,0, len);
                    }
                    output.flush();

                    textView.setText(R.string.saved);

                } catch (IOException e) {
                    e.printStackTrace();
                    textView.setText(R.string.error);
                }

            }
        });

        Button buttonRead = findViewById(R.id.button_read);
        buttonRead.setOnClickListener( v -> {
            if(isExternalStorageReadable()){
                try(InputStream inputStream0 =
                            new FileInputStream(file) ) {

                    Bitmap bitmap = BitmapFactory.decodeStream(inputStream0);
                    imageView.setImageBitmap(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /* Checks if external storage is available for read and write */
    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        return (Environment.MEDIA_MOUNTED.equals(state));
    }

    /* Checks if external storage is available to at least read */
    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        return (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state));
    }
}
