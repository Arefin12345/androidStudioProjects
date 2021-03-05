package com.example.materialflotingactionbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton MainAddfab,AddUserFab,AddContactFab;
    private TextView AdduserText,addContactText;
    private boolean isOpen;

    //Accessing animation xml file
    private Animation mFAbOpenAnim,mFabCloseAnim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainAddfab = findViewById(R.id.main_add_fab);
        AddUserFab = findViewById(R.id.add_user_fab);
        AddContactFab = findViewById(R.id.addd_contact_fab);

        isOpen = false;

        AdduserText  = findViewById(R.id.textView2);
        addContactText = findViewById(R.id.textView3);

        mFAbOpenAnim = AnimationUtils.loadAnimation(MainActivity.this,R.anim.fab_open);
        mFabCloseAnim = AnimationUtils.loadAnimation(MainActivity.this,R.anim.fab_close);

        MainAddfab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isOpen){

                    AddUserFab.setAnimation(mFabCloseAnim);
                    AddContactFab.setAnimation(mFabCloseAnim);
                    addContactText.setVisibility(View.INVISIBLE);
                    AdduserText.setVisibility(View.INVISIBLE);
                    isOpen = false;
                }
                else{
                    AddUserFab.setAnimation(mFAbOpenAnim);
                    AddContactFab.setAnimation(mFAbOpenAnim);
                    addContactText.setVisibility(View.VISIBLE);
                    AdduserText.setVisibility(View.VISIBLE);
                    isOpen = true;
                }
            }
        });
    }


}