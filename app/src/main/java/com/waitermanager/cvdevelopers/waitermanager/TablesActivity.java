package com.waitermanager.cvdevelopers.waitermanager;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.waitermanager.cvdevelopers.waitermanager.userdata.Tables;
import com.waitermanager.cvdevelopers.waitermanager.userdata.WaiterManagerApp;

import java.util.ArrayList;


public class TablesActivity extends Activity {
    TablesArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tables);

        final ListView tableList=(ListView)findViewById(R.id.tables_listView);


        ArrayList tableNumberList = new ArrayList<String>();

        for (Tables table:((WaiterManagerApp) this.getApplication()).getTables())
        {
            Resources res = getResources();
            tableNumberList.add(res.getString(R.string.table_adapter_title)+" "+table.tableNumber);

        }




         adapter = new TablesArrayAdapter(this, tableNumberList);
//        setListAdapter(adapter);

        tableList.setAdapter(adapter);

        // register onClickListener to handle click events on each item
        tableList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            // argument position gives the index of item which is clicked
            public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3) {

                String selectedTable = (String) tableList.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), "Table Selected : " + selectedTable, Toast.LENGTH_SHORT).show();
                if (WaiterManagerApp.getManager().getTables().get(position).status == Tables.TableStatus.OPEN)
                {
                    showCustomDialog(position);
                }
                else
                {
                    openSelectedTable(position);
                }


            }
        });
    }

    protected void showCustomDialog(final int position) {
        // TODO Auto-generated method stub
        final Dialog dialog = new Dialog(TablesActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.open_table_dialog_layout);

        final EditText editText = (EditText)dialog.findViewById(R.id.open_table_dialog_numcustomer);
        Button startButton = (Button)dialog.findViewById(R.id.open_table_dialog_startbutton);
        startButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Tables table = WaiterManagerApp.getManager().getTables().get(position);
                table.sitClients(Integer.parseInt(editText.getText().toString()));
                dialog.dismiss();
                adapter.notifyDataSetChanged();
               openSelectedTable(position);

            }
        });
        Button cancelButton = (Button)dialog.findViewById(R.id.open_table_dialog_cancel);
        cancelButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                dialog.dismiss();
            }
        });

        dialog.show();
    }
    public void openSelectedTable(int selectedTable)
    {
        Intent i=new Intent(TablesActivity.this,SelectedTableActivity.class);
        i.putExtra("table_number", selectedTable+"");

        TablesActivity.this.startActivity(i);
    }
}
