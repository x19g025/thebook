package com.example.thebook;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class TShopInfoActivity extends AppCompatActivity
        implements AdapterView.OnItemClickListener {

    private static final String[] scenes = {
            "AA書店",
            "NB書店"
    };
    private static final String[] tel = {
            "03-123-1594",
            "03-459-1594"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tshop_info);

        // ListViewのインスタンスを生成
        ListView listView = findViewById(R.id.list_view);

        // BaseAdapter を継承したadapterのインスタンスを生成
        // レイアウトファイル list.xml を activity_main.xml に
        // inflate するためにadapterに引数として渡す
        BaseAdapter adapter = new ListViewAdapter(this.getApplicationContext(),
                R.layout.list, scenes ,tel);

        // ListViewにadapterをセット
        listView.setAdapter(adapter);

        // クリックリスナーをセット
        listView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View v,
                            int position, long id) {

        Intent intent = new Intent(
                this.getApplicationContext(), SubTShopInfoActivity.class);

        // clickされたpositionのtextとphotoのID
        String selectedText = scenes[position];
        String selectedText2 = scenes[position];
        // インテントにセット
        intent.putExtra("Text", selectedText);
        intent.putExtra("Text2", selectedText2);
        // SubActivityへ遷移
        startActivity(intent);
    }
}