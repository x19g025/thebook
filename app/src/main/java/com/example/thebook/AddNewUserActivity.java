package com.example.thebook;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddNewUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_user);

        final EditText titleInput = findViewById(R.id.titleInput);
        final EditText coverInput = findViewById(R.id.coverInput);
        final EditText authorInput = findViewById(R.id.authorInput);
        final EditText genreInput = findViewById(R.id.genreInput);
        final EditText stockInput = findViewById(R.id.stockInput);
        final EditText isbnInput = findViewById(R.id.isbnInput);
        final EditText dateInput = findViewById(R.id.dateInput);
        final EditText priceInput = findViewById(R.id.priceInput);
        final EditText formatInput = findViewById(R.id.formatInput);
        final EditText publisherInput = findViewById(R.id.publisherInput);
        Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNewUser(titleInput.getText().toString(),coverInput.getText().toString(),authorInput.getText().toString()
                        ,genreInput.getText().toString(),stockInput.getText().toString(),isbnInput.getText().toString(),dateInput.getText().toString()
                        ,priceInput.getText().toString(),formatInput.getText().toString(),publisherInput.getText().toString());
            }
        });
    }

    private void saveNewUser(String title, String cover, String author, String genre, String stock, String isbn, String date, String price, String format, String publisher){
        AppDatabase db = AppDatabase.getDbInstance(this.getApplicationContext());

        User user = new User();
        user.title = title;
        user.cover = cover;
        user.author = author;
        user.genre = genre;
        user.stock = stock;
        user.isbn = isbn;
        user.date = date;
        user.price = price;
        user.format = format;
        user.publisher = publisher;
        db.userDao().insertUser(user);

        finish();

    }
}