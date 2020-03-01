package org.protocols.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import org.protocols.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ProtocolListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Protocol> protocols = new ArrayList<>();
        protocols.add(new Protocol(1, "Dupa jaś"));
        protocols.add(new Protocol(1, "Other"));
        listAdapter = new ProtocolListAdapter(
                getBaseContext(),
                protocols,
                new EditButtonHandler(getBaseContext())
        );

        ListView protocolList = (ListView) findViewById(R.id.resultList);
        protocolList.setAdapter(listAdapter);

        Button searchActionButton = (Button) findViewById(R.id.executeSearch);
        searchActionButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        listAdapter.add(new Protocol(1, "Some adapter"));
    }
}
