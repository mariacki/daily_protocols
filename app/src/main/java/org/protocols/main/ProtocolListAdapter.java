package org.protocols.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import org.protocols.R;
import java.util.List;

public class ProtocolListAdapter extends BaseAdapter {

    private Context context;

    private LayoutInflater inflater;

    private List<Protocol> protocols;

    private EditButtonHandler onEditClicked;

    public ProtocolListAdapter(
            Context context,
            List<Protocol> protocols,
            EditButtonHandler onEditClicked
    ) {
        this.context = context;
        this.protocols = protocols;
        this.onEditClicked = onEditClicked;
        setInflater(context);
    }

    private void setInflater(Context context) {
        inflater = (LayoutInflater) context.getApplicationContext().getSystemService(
                Context.LAYOUT_INFLATER_SERVICE
        );
    }

    public void add(Protocol protocol) {
        protocols.add(protocol);
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View recycledView, ViewGroup parent) {
        View protocolItemView = inflateOrReuse(recycledView, parent);
        Protocol protocol = protocols.get(position);

        TextView protocolName = (TextView) protocolItemView.findViewById(R.id.viewProtocolName);
        protocolName.setText(protocol.getName());

        Button editButton = (Button) protocolItemView.findViewById(R.id.edit);
        editButton.setOnClickListener(onEditClicked);
        editButton.setTag(protocol);

        Button deployButton = (Button) protocolItemView.findViewById(R.id.run);



        return protocolItemView;
    }

    private View inflateOrReuse(View recycledView, ViewGroup parent) {
        if (recycledView == null) {
            return inflatedView(parent);
        }

        return recycledView;
    }

    private View inflatedView(ViewGroup parent)
    {
        return inflater.inflate(R.layout.protocol_item, parent, false);
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return protocols.get(i).getId();
    }

    @Override
    public int getCount() {
        return protocols.size();
    }
}
