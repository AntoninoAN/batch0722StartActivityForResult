package com.example.todoapp;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NewTaskActivity extends AppCompatActivity {

    TextInputLayout taskLayout;
    TextInputLayout categoryLayout;
    Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        taskLayout = findViewById(R.id.til_add_task);
        categoryLayout = findViewById(R.id.til_add_category);
        addButton = findViewById(R.id.btn_add_task);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String task = taskLayout.getEditText().getText().toString();
                String category = categoryLayout.getEditText().getText().toString();
                Intent intent = new Intent();
                intent.putExtra("Task", task);
                intent.putExtra("Category", category);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
