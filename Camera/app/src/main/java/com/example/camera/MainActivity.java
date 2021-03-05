package com.example.camera;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private static final int REQUEST_IMAGE_CAPTURE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageViewId);
    }


    public void takepicture(View view) {

        Intent imageTAkeIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if (imageTAkeIntent.resolveActivity(getPackageManager())!=null) {
            startActivityForResult(imageTAkeIntent, REQUEST_IMAGE_CAPTURE);
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imagebitmap = (Bitmap) extras.get("data");
            imageView.setImageBitmap(imagebitmap);
        }

        super.onActivityResult(requestCode, resultCode, data);

//        super.onActivityResult(requestCode, resultCode, data);
    }
}
