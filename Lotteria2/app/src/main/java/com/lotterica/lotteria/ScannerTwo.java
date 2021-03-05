package com.lotterica.lotteria;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

public class ScannerTwo extends AppCompatActivity {

    public static final String RESULT_KEY_MESSAGE = "com.lotterica.lotteria.Scanner - Return Message";

    EditText editText;
    ImageView imageView;
    Button button;

    private static final int CAMERA_REQUEST_CODE = 200;
    private static final int STORAGE_REQUEST_CODE = 400;
    private static final int IMAGE_PICK_GALLERY_CODE = 1000;
    private static final int IMAGE_PICK_CAMERA_CODE = 1001;

    String cameraPermission[];

    String storagePermission[];
    Uri image_uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setSubtitle("Click To Insert Image");

        editText = findViewById(R.id.resultEditTextId);
        imageView = findViewById(R.id.imageviewid);

        //camera permission
        cameraPermission = new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};
        //Storage Permission
        storagePermission = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE};
        button = (Button)findViewById(R.id.doneButtonId);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value2 = editText.getText().toString();
                Intent resultIntent = new Intent();
                resultIntent.putExtra("value2",value2);
                setResult(3,resultIntent);
                finish();
            }
        });


    }

    //action bar menu

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate Menu
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }
    //Handle Action Bar Item Clicks

// Here is add image id

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.addimageid) {
            showImageImportDialouge();
        }

        return super.onOptionsItemSelected(item);
    }

    private void showImageImportDialouge() {
        //Items to display in the dialog
        String[] items = {"Camera", "Gallery"};

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        //Set Title
        dialog.setTitle("Select Image");
        dialog.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == 0) {
                    //Camera Option Is Clicked

                    //For os marshmallo and above  we need to ask runtime
                    // permission for camera and storage
                    if (!checkCameraPermission()) {
                        //Camera permission is not allowed request it
                        requestCameraPermission();
                    } else {
                        //Permission Allowed, take picture
                        pickCamera();
                    }
                }

                if (which == 1) {
                    //Gallery Option Is Clicked

                    if (!checkStoragePermission()) {
                        //Camera permission is not allowed request it
                        requestStoragePermission();
                    } else {
                        //Permission Allowed, take picture
                        pickGallery();
                    }

                }
            }
        });
        dialog.create().show(); //Show dialog
    }

    private void pickGallery() {
        //Intent to pick image from gallery
        Intent intent = new Intent(Intent.ACTION_PICK);
        //Set intent type to image
        intent.setType("image/*");
        startActivityForResult(intent, IMAGE_PICK_GALLERY_CODE);
    }

    private void pickCamera() {
        //Intent to take Image From Camera
        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.TITLE, "NewPic"); //Title of The picture
        values.put(MediaStore.Images.Media.DESCRIPTION, "Image To Text");//Description
        image_uri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);

        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, image_uri);
        startActivityForResult(cameraIntent, IMAGE_PICK_CAMERA_CODE);
    }

    private void requestStoragePermission() {
        ActivityCompat.requestPermissions(this, storagePermission, STORAGE_REQUEST_CODE);

    }

    private boolean checkStoragePermission() {
        boolean result = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                == (PackageManager.PERMISSION_GRANTED);
        return result;
    }

    private void requestCameraPermission() {
        ActivityCompat.requestPermissions(this, cameraPermission, CAMERA_REQUEST_CODE);
    }

    private boolean checkCameraPermission() {
        boolean result = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) ==
                (PackageManager.PERMISSION_GRANTED);

        boolean result1 = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                == (PackageManager.PERMISSION_GRANTED);
        return result && result1;
    }

    //handle permission result

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case CAMERA_REQUEST_CODE:
                if (grantResults.length > 0) {
                    boolean cameraAccPected = grantResults[0]
                            == PackageManager.PERMISSION_GRANTED;

                    boolean writeStorageAccpected = grantResults[0]
                            == PackageManager.PERMISSION_GRANTED;

                    if (cameraAccPected && writeStorageAccpected) {
                        pickCamera();
                    } else {
                        Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            case STORAGE_REQUEST_CODE:
                if (grantResults.length > 0) {
                    boolean writeStorageAccpected = grantResults[0]
                            == PackageManager.PERMISSION_GRANTED;
                    if (writeStorageAccpected) {
                        pickGallery();
                    } else {
                        Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
        }
    }

    //handle image result

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_OK) {
            if (requestCode == IMAGE_PICK_GALLERY_CODE) {
                //got image from gallery now crop it
                CropImage.activity(data.getData()).setGuidelines(CropImageView.Guidelines.ON).start(this); //enable image guidelines
            }
        }
        if (requestCode == IMAGE_PICK_CAMERA_CODE) {
            //got image from camera now crop it
            CropImage.activity(image_uri).setGuidelines(CropImageView.Guidelines.ON)
                    .start(this); //enable image guidelines
        }
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);

            if (resultCode == RESULT_OK) {
                Uri resultUri = result.getUri();

                //set image to imageview
                imageView.setImageURI(resultUri);

                //get drawable bitmap
                BitmapDrawable bitmapDrawable = (BitmapDrawable) imageView.getDrawable();
                Bitmap bitmap = bitmapDrawable.getBitmap();

                TextRecognizer recognizer = new TextRecognizer.Builder(getApplicationContext()).build();
                if (!recognizer.isOperational()) {
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
                } else {
                    Frame frame = new Frame.Builder().setBitmap(bitmap).build();
                    SparseArray<TextBlock> items = recognizer.detect(frame);
                    StringBuilder sb = new StringBuilder();

                    //Get text from user until there is no text
                    for (int i = 0; i < items.size(); i++) {
                        TextBlock myItem = items.valueAt(i);
                        sb.append(myItem.getValue());
                        sb.append("\n");
                    }
                    /////////Important Important Important

                    //Do it in morning
                    editText.setText(sb.toString());
                }
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                //If there is error show it
                Exception error = result.getError();
                Toast.makeText(this, "" + error, Toast.LENGTH_SHORT).show();
            }

        }
    }




}