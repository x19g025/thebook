package com.example.thebook;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import android.widget.TextView;
import android.os.AsyncTask;

public class TStockEditActivity extends AppCompatActivity {

    class TaskDbConnect extends AsyncTask<Void, Void, String> {
        Activity activity = null;
        public TaskDbConnect(Activity act){

            activity = act;
        }

        @Override
        protected String doInBackground(Void... params) {
            String text1 = " ";

            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn=DriverManager.getConnection("jdbc:mysql://172.16.3.137/zaikodb","root014","fjbg010126");
                Statement stmt=conn.createStatement();
                ResultSet rs=stmt.executeQuery("SELECT * FROM syosekijouhou");
                while(rs.next()){
                    String isbn=rs.getString(1);
                    String title=rs.getString(2);
                    String cover=rs.getString(3);
                    String author=rs.getString(4);
                    String genre=rs.getString(5);
                    String label=rs.getString(6);
                    String release=rs.getString(7);
                    int price=rs.getInt(8);
                    String format=rs.getString(9);
                    int code=rs.getInt(10);

                    text1 += isbn+" "+title+" "+cover+" "+author+" "+genre+" "+label+" "+release+" "+price+" "+format+" "+code+"  "+"\r\n";
                }
            }catch(Exception e){
                text1=e.getMessage();
            }
            return  text1;
        }

        protected void onPostExecute(String result){
            TextView tv = (TextView)activity.findViewById(R.id.textview1);
            tv.setText(result);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tstock_edit);

        // Asyncタスククラスのインスタンスを作成し、実行する
        TaskDbConnect task = new TaskDbConnect(TStockEditActivity.this);
        task.execute();
    }
}

