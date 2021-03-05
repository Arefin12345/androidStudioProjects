package com.example.fiebaseimage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button choosebutton,savebutton,displaybutton;
    private ImageView imageView;
    private EditText imagenameEditext;
    private ProgressBar progressBar;
    private Uri imageuri;
    StorageTask uploadtask;

    DatabaseReference databaseReference;

    StorageReference storageReference;

    public static final int IMAGE_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        databaseReference = FirebaseDatabase.getInstance().getReference("Upload");
        storageReference = FirebaseStorage.getInstance().getReference("Upload");

        choosebutton = (Button) findViewById(R.id.choosebuttonId);
        savebutton = (Button) findViewById(R.id.saveImageButtonId);
        displaybutton = (Button) findViewById(R.id.loadImageButtonId);

        imageView = (ImageView) findViewById(R.id.imageViewid);
        progressBar = (ProgressBar) findViewById(R.id.progresssbarid);

        savebutton.setOnClickListener(this);
        choosebutton.setOnClickListener(this);
        displaybutton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.choosebuttonId:
                  openFileChooser();
                break;

            case R.id.loadImageButtonId:
                break;

            case R.id.saveImageButtonId:
                if(uploadtask!=null && uploadtask.isInProgress()){
                    Toast.makeText(getApplicationContext(),"Uploading In Progress",Toast.LENGTH_LONG).show();

                }
                else{
                    saveData();
                }

                break;
        }

    }

    //To get the file extention for storing into the database

    public String getFileExtention(Uri uri){
        ContentResolver contentResolver = getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(imageuri));
    }

    private void saveData() {
        final String imagename = imagenameEditext.getText().toString().trim();
        if(imagename.isEmpty()){
            imagenameEditext.setError("Enter A Name For Your Image");
            imagenameEditext.requestFocus();
            return;
        }

        //Image id
        StorageReference ref = storageReference.child(System.currentTimeMillis()+"."+getFileExtention(imageuri));

        ref.putFile(imageuri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        // Get a URL to the uploaded content
                        Toast.makeText(getApplicationContext(),"Image Is Stored Successfully",Toast.LENGTH_LONG).show();
                        //Excess
                        upload uploa = new upload(imagename,taskSnapshot.getStorage().getDownloadUrl().toString());

                        String uploadid = databaseReference.push().getKey();

                        databaseReference.child(uploadid).setValue(uploa);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Handle unsuccessful uploads
                        // ...
                        Toast.makeText(getApplicationContext(),"Image Is Not Stored Successfully",Toast.LENGTH_LONG).show();

                    }
                });
    }

    void openFileChooser() {
         Intent intent = new Intent();
         intent.setType("image/*");
         intent.setAction(Intent.ACTION_GET_CONTENT);
         startActivityForResult(intent,IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


        if(requestCode==IMAGE_REQUEST && resultCode==RESULT_OK && data!=null && data.getData()!=null){
            //To loadThe Image
            imageuri = data.getData();
            Picasso.with(this).load(imageuri);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
