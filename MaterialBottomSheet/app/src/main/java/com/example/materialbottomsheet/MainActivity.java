package com.example.materialbottomsheet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class MainActivity extends AppCompatActivity {
    private BottomAppBar mbottomAppBar;

    private LinearLayout mBottomsheet;
    private BottomSheetBehavior mbottomSheetBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBottomsheet = findViewById(R.id.bottom_sheet);
        mbottomAppBar = findViewById(R.id.bottom_app_bar);

        mbottomSheetBehavior = BottomSheetBehavior.from(mBottomsheet);

        mbottomAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mbottomSheetBehavior.setState(mbottomSheetBehavior.STATE_EXPANDED);
            }
        });

    }
}