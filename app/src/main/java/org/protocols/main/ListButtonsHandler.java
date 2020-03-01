package org.protocols.main;

import android.content.Context;
import android.content.Intent;
import android.view.View;

public class ListButtonsHandler implements View.OnClickListener {

    private Context context;

    private Class activityToRun;

    public ListButtonsHandler(
            Context context,
            Class activityToRun
    ) {
        this.context = context;
        this.activityToRun = activityToRun;
    }

    @Override
    public void onClick(View view) {
        Protocol protocol = (Protocol) view.getTag();

        Intent intent = new Intent(context, activityToRun);
        intent.putExtra("name", protocol.getName());
        intent.putExtra("id", protocol.getId());

        context.startActivity(intent);
    }
}
