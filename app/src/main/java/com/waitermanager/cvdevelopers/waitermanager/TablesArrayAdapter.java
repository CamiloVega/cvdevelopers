package com.waitermanager.cvdevelopers.waitermanager;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.waitermanager.cvdevelopers.waitermanager.userdata.Tables;
import com.waitermanager.cvdevelopers.waitermanager.userdata.WaiterManagerApp;

import java.util.ArrayList;

/**
 * Created by kamiloveg1 on 4/4/15.
 */
public class TablesArrayAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final ArrayList<String> values;

    public TablesArrayAdapter(Context context, ArrayList<String> values) {
        super(context, R.layout.tables_adapter_layout, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Resources res = this.context.getResources();
        Tables table = WaiterManagerApp.getManager().getTables().get(position);
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.tables_adapter_layout, parent, false);
        TextView tableNumber = (TextView) rowView.findViewById(R.id.table_adapter_tabletile);
        TextView clientsNumber = (TextView) rowView.findViewById(R.id.table_adapter_clients);
        TextView statusLabel = (TextView) rowView.findViewById(R.id.table_adapter_statuslabel);
        TextView lastCheckedLabel = (TextView) rowView.findViewById(R.id.table_adapter_lastcheckedlabel);

        CheckBox childrenCheckbox = (CheckBox) rowView.findViewById(R.id.table_adapter_kidcheckbox);
        String [] statusLabels = res.getStringArray(R.array.status_names);

        tableNumber.setText(res.getString(R.string.table_adapter_title)+" "+table.tableNumber);
        clientsNumber.setText(res.getString(R.string.client_title)+" "+table.clients.size());
        statusLabel.setText(statusLabels[table.status.ordinal()]);
        // Change the icon for Windows and iPhone
        //TODO last checked label and updates.

        return rowView;
    }
}