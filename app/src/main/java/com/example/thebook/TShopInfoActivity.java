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
            "船橋書店",
            "FJB書店"
    };
    private static final String[] address = {
            "〒273-0005 千葉県船橋市本町7丁目",
            "〒273-0005 千葉県船橋市本町7丁目12-16"
    };
    private static final String[] time = {
            "営業時間 10：00 ~ 20:00",
            "営業時間 10：00 ~ 22:00"
    };
    private static final String[] tel = {
            "03-123-1594",
            "03-459-1932"
    };
    private static final String[] hp = {
            "funabashi.net",
            "fjb.net"
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
                R.layout.list,scenes,tel);

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
        String selectedText2 = address[position];
        String selectedText3 = time[position];
        String selectedText4 = tel[position];
        String selectedText5 = hp[position];
        // インテントにセット
        intent.putExtra("Text", selectedText);
        intent.putExtra("Text2", selectedText2);
        intent.putExtra("Text3", selectedText3);
        intent.putExtra("Text4", selectedText4);
        intent.putExtra("Text5", selectedText5);
        // SubActivityへ遷移
        startActivity(intent);
    }
}