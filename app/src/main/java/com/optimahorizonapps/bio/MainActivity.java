package com.optimahorizonapps.bio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.optimahorizonapps.bio.data.Bio;
import com.optimahorizonapps.bio.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Bio bio = new Bio();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        bio.setName("Emma Harris");

        binding.setBio(bio);
        binding.saveHobbiesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                saveHobbies(v);
            }
        });
    }
    public void saveHobbies(View v) {
        bio.setHobbies(String.format("Hobbies: %s", binding.hobbiesEditText.getText().toString().trim()));
//        binding.hobbiesTextView.setText(String.format("Hobbies: %s", binding.hobbiesEditText.getText().toString().trim()));
        binding.saveHobbiesButton.setVisibility(View.VISIBLE);

        // hide keyboard
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }
}