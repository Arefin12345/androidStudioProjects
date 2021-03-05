package com.example.androidmaterialdialog;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private Button mShowDialogBtn;
    private CharSequence[] mAlertItems;

    private boolean[] mSelectedItems ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mShowDialogBtn = findViewById(R.id.showDialog);

        mAlertItems = new String[]{
                "movies",
                "photos",
                "music",
                "all"
        };
        mSelectedItems = new boolean[]{
                false,
                true,
                true
        };


        mShowDialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MaterialAlertDialogBuilder builder =  new MaterialAlertDialogBuilder(MainActivity.this);
                builder.setTitle("View Options");
//                builder.setSingleChoiceItems(mAlertItems, 0, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        //Do something
//                        Snackbar.make(mShowDialogBtn,"You have selected"+which,Snackbar.LENGTH_LONG).show();
//                    }
//                });

//                builder.setIcon(R.drawable.ic_baseline_backup_24);

                builder.setMultiChoiceItems(mAlertItems, mSelectedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                   ///Do something here
                    }

                });

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    builder.setBackground(getResources().getDrawable(R.drawable.alert_dialog_bg,null));
                }

                builder.setPositiveButton("OKAY", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setNegativeButton("DISMISS", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
//                builder.setPositiveButton("OKAY", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        //That will close the dialog
//                    }
//                });
//                builder.setNegativeButton("DISMISS", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                    }
//                });
                builder.show();
            }
        });
    }
}