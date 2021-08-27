package com.optimahorizonapps.bio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.optimahorizonapps.bio.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.saveHobbiesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                saveHobbies(v);
            }
        });
    }
    public void saveHobbies(View v) {
        binding.hobbiesTextView.setText(String.format("Hobbies: %s", binding.hobbiesEditText.getText().toString().trim()));
        binding.saveHobbiesButton.setVisibility(View.VISIBLE);

        // hide keyboard
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }
}