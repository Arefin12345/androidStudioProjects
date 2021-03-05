package com.example.storingdatausingfile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
private EditText editText;
private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.edittextid);
        button = (Button) findViewById(R.id.savebuttonid);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                if(text != null){
                    writeToFile(text);
                }
                else if(text==null){
                    Toast.makeText(getApplicationContext(),"Please Put Some Notes",Toast.LENGTH_LONG).show();

                }
            }
        });
        try {
            readfromfile();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void writeToFile(String text){
        try {
            FileOutputStream fileOutputStream = openFileOutput("diary.txt", Context.MODE_PRIVATE);
            fileOutputStream.write(text.getBytes());
            fileOutputStream.close();

        }catch (FileNotFoundException e){
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readfromfile() throws IOException {
        FileInputStream fileInputStream = openFileInput("diary.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line;
        StringBuffer stringBuffer = new StringBuffer();

        //Reading Strings From Bufferreader
        while((line = bufferedReader.readLine())!=null){
            stringBuffer.append(line+"\n");
        }
        editText.setText(stringBuffer.toString());
    }
}
