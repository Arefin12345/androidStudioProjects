package com.example.firebasestoringdata;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Student> {

    private Activity context;
    //To Store The Coming  In A List
    private List<Student> studentList;

        public CustomAdapter(Activity Context context, List<Student> studentList) {
        super(context, R.layout.samplelayout, studentList);
        this.context = context;
        this.studentList = studentList;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = context.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.samplelayout,null,true);

        Student student = studentList.get(position);

        TextView textView1 = view.findViewById(R.id.nametextViewId);
        TextView textView2 = view.findViewById(R.id.agetextViewId);

        textView1.setText("Name : "+student.getName());
        textView1.setText("Age :"+student.getAge());

        return view;
    }
}
