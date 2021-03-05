package com.example.androdimaterialsnackbar16october;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private Button mSnackBar;
    private FloatingActionButton floatingActionButton;

    private CoordinatorLayout mSnackBarLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSnackBar = findViewById(R.id.button);
        floatingActionButton = findViewById(R.id.floatingActionButton);
        mSnackBarLayout = findViewById(R.id.snackbarLayout);

        mSnackBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar.make(mSnackBarLayout,"You just Clicked the button"
                        ,Snackbar.LENGTH_LONG);
                snackbar.setDuration(10000);
                snackbar.setAnimationMode(BaseTransientBottomBar.ANIMATION_MODE_SLIDE);
                snackbar.setAnchorView(floatingActionButton);
//                snackbar.setAnchorView(floatingActionButton);   //for showing the snackbar above floting action button

                snackbar.setAction("OKAY", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //do something here

                    }
                });
                snackbar.show();
            }
        });
    }
}