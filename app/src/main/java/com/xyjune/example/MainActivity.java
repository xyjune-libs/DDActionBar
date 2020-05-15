package com.xyjune.example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.xyjune.ddactionbar.BaseActionBar;
import com.xyjune.ddactionbar.DDActionBar;

public class MainActivity extends AppCompatActivity {

    private DDActionBar mDDActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDDActionBar = findViewById(R.id.ddactionbar);
        mDDActionBar.setActionBarListener(new DDActionBar.ActionBarListener() {
            @Override
            public void onLeftClick(View v) {
                Toast.makeText(MainActivity.this, "click left", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRightClick(View v) {
                Toast.makeText(MainActivity.this, "click right", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
