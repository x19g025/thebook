package com.example.thebook;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;


public class TStockEditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_johen2);

    ActionBar actionBar = getSupportActionBar();
    actionBar.setTitle("情報編集");
    //actionBar.setSubtitle("onaziku");
    actionBar.setDisplayHomeAsUpEnabled(false);


    final Button Hens_button = findViewById(R.id.Hens_button);

    Connection con = null;  //データベースへの下準備

        try {
            con = DriverManager.getConnection(url, user, password);

            Statement stmt = con.createStatement();
            String sql = "update kabukatable set company='楽天(株)' where code = 4755";
            int num = stmt.executeUpdate(sql);
        }catch (SQLException e){
            out.println("SQLException:" + e.getMessage());
        }

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }
        });

    }


}
