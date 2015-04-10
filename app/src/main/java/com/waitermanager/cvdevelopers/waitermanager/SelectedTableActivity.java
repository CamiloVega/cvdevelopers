package com.waitermanager.cvdevelopers.waitermanager;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.waitermanager.cvdevelopers.waitermanager.userdata.Client;
import com.waitermanager.cvdevelopers.waitermanager.userdata.Tables;
import com.waitermanager.cvdevelopers.waitermanager.userdata.WaiterManagerApp;

import java.util.ArrayList;


public class SelectedTableActivity extends Activity {
    TablesArrayAdapter adapter;
    Tables table;
    int tableNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_table);
        final ListView clientList=(ListView)findViewById(R.id.selected_table_listView);
        Intent intent = getIntent();
        tableNumber = Integer.parseInt( intent.getStringExtra("table_number"));
        TextView titleLabel = (TextView)findViewById(R.id.selected_table_title_label);


        ArrayList clientValues = new ArrayList<String>();
        table = ((WaiterManagerApp) this.getApplication()).getTables().get(tableNumber);
        String title = titleLabel.getText().toString()+" "+table.tableNumber;
        titleLabel.setText(title);
        for (Client client:table.getClients())
        {
            Resources res = getResources();
            clientValues.add(client.getName());
        }


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, clientValues);

        clientList.setAdapter(adapter);

//        adapter = new TablesArrayAdapter(this, tableNumberList);
////        setListAdapter(adapter);
//
//        tableList.setAdapter(adapter);

        // register onClickListener to handle click events on each item
        clientList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            // argument position gives the index of item which is clicked
            public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3) {

               //String selectedTable = (String) tableList.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), "Customer Selected : " + position, Toast.LENGTH_SHORT).show();
                openMenuActivity(0);
//                showCustomDialog(position);


            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.selected_table_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void openMenuActivity(int selectedClient)
    {
        Intent i=new Intent(SelectedTableActivity.this,MenuActivity.class);
        i.putExtra("selected_client", selectedClient+"");

        SelectedTableActivity.this.startActivity(i);
    }
}
