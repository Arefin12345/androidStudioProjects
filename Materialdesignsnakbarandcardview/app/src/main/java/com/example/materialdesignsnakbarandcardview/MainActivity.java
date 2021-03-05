package com.example.materialdesignsnakbarandcardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private MaterialCardView materialCardView;

    private ConstraintLayout constraintLayout;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        constraintLayout = findViewById(R.id.parent);
        button = findViewById(R.id.buttonid);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSnakBar();
            }
        });

        materialCardView = findViewById(R.id.cardViewId);
        materialCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Card has been clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showSnakBar(){
        Snackbar.make(constraintLayout,"This is a snackbar",Snackbar.LENGTH_INDEFINITE)
                .setAction("Retry", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "Retry clicked", Toast.LENGTH_SHORT).show();
                    }
                })
//                .setActionTextColor(getResources().getColor(R.color.colorAccent))
                .setActionTextColor(Color.RED)
                .setTextColor(Color.YELLOW)
                .show();
    }
}