package org.protocols.main;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import org.protocols.EditActivity;

public class EditButtonHandler implements View.OnClickListener {

    private Context context;

    public EditButtonHandler(
            Context context
    ) {
        this.context = context;
    }

    @Override
    public void onClick(View view) {
        Protocol protocol = (Protocol) view.getTag();

        Intent intent = new Intent(context, EditActivity.class);
        intent.putExtra("name", protocol.getName());
        intent.putExtra("id", protocol.getId());

        context.startActivity(intent);
    }
}
