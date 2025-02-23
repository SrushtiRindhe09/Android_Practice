package com.example.autocompletetext;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        AutoCompleteTextView searchBar = findViewById(R.id.autoCompleteSearch);
        String[] searchSuggestions = {"Google", "Bing", "DuckDuckGo", "Yahoo", "Ask", "Baidu",
                "Yandex"};
        // Adapter to set suggestions
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_dropdown_item_1line, searchSuggestions);
        searchBar.setAdapter(adapter);
        searchBar.setThreshold(1);

        }
    }
