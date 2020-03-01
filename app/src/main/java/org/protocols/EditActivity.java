package org.protocols;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EditActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        TextView viewName = findViewById(R.id.name);
        viewName.setText(
                "Protocol name:" +getIntent().getStringExtra("name")
        );
    }
}
