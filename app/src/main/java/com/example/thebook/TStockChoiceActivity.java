package com.example.thebook;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TStockChoiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tstock_choice);

        final Button Register_button = findViewById(R.id.Register_button);
        final Button Check_button = findViewById(R.id.Check_button);

        Register_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(TStockChoiceActivity.this, AddNewUserActivity.class);//まだETStockRegisterActivityを作成していない
                startActivity(intent);
            }
        });
        Check_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(TStockChoiceActivity.this, MainActivity.class); //まだEditActivityを作成していない
                startActivity(intent);
            }
        });
    }
}
