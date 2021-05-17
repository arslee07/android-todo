package dev.arslee.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView tasksV;
    Button   submitV;
    EditText inputV;

    ArrayList<String> tasks = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tasksV  = findViewById(R.id.list);
        submitV = findViewById(R.id.submitButton);
        inputV  = findViewById(R.id.taskInput);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tasks);
        tasksV.setAdapter(adapter);

        submitV.setOnClickListener(view -> {
            String text = inputV.getText().toString();
            if (!text.equals("")) tasks.add(text);
            inputV.setText("");
            adapter.notifyDataSetChanged();
        });

        tasksV.setOnItemClickListener((adapterView, view, i, l) -> {
            tasks.remove(i);
            adapter.notifyDataSetChanged();
        });
    }
}