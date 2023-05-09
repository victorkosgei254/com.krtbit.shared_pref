package com.kritbit.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText the_text;
    Button save_btn;
    TextView saved_text;
    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        the_text = findViewById(R.id.the_text);
        save_btn = findViewById(R.id.saveBtn);
        saved_text = findViewById(R.id.saved_text);

        getStoreMessages();
        save_btn.setOnClickListener(it->{
            data = the_text.getText().toString();
            displayAndSave(data);
        });
    }

    private void getStoreMessages() {
        //Retrieving from shared preferences
        SharedPreferences preferences = getSharedPreferences("my_pref",MODE_PRIVATE);
        String txt = preferences.getString("the_text","null");
        saved_text.setText(txt);
    }

    private void displayAndSave(String text) {
        //displaying the text
        saved_text.setText(text);

        //saving the text into shared preferences
        SharedPreferences sharedPreferences = getSharedPreferences("my_pref",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("the_text",text);
        editor.commit();
    }
}