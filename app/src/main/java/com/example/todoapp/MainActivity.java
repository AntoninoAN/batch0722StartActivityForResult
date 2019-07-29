package com.example.todoapp;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_ADD_TASK = 135567;//random.org
    ListView lv_todo_list;
    EditText et_task;
    Button btn_save_task;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv_todo_list = findViewById(R.id.lv_todo_task);
        et_task = findViewById(R.id.et_task);
        btn_save_task = findViewById(R.id.btn_save_task);

        adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1
        );
        lv_todo_list.setAdapter(adapter);

        btn_save_task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String task = et_task.getText().toString();
//                if(task.isEmpty()) return;
//
//                adapter.add(task);
//                et_task.setText("");
////                adapter.notifyDataSetChanged();
                Intent intent = new Intent(
                        getBaseContext(),
                        NewTaskActivity.class
                );
//                startActivity(intent);
                startActivityForResult(intent, REQUEST_ADD_TASK);
            }
        });

        lv_todo_list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent,
                                           View view,
                                           int position,
                                           long id) {

                //todo remove the element in that position
                adapter.remove(
                    adapter.getItem(position));
                return false;
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode,
                                    @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_ADD_TASK){
            if(resultCode == RESULT_OK){
                String category = data.getStringExtra("Category");
                String task = data.getStringExtra("Task");
                //todo add values to Adapter...
            }
        }
    }
}






