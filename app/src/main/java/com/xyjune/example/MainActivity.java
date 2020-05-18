package com.xyjune.example;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.xyjune.ddactionbar.DDActionBar;

public class MainActivity extends AppCompatActivity {

    private DDActionBar mDDActionBar;

    private static final int[] colors = {Color.BLUE, Color.RED, Color.YELLOW, Color.GREEN, Color.MAGENTA, Color.CYAN};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDDActionBar = findViewById(R.id.ddactionbar);
        mDDActionBar.setActionBarListener(new DDActionBar.ActionBarListener() {
            @Override
            public void onLeftClick(View v) {
                mDDActionBar.setRightTextColor(colors[random()]);
            }

            @Override
            public void onRightClick(View v) {
                mDDActionBar.setLeftIconColorFilter(colors[random()]);
            }
        });
    }

    private int random() {
        return (int) (Math.random() * colors.length);
    }
}
