package com.waitermanager.cvdevelopers.waitermanager.userdata;

import android.app.Application;

import java.util.ArrayList;


/**
 * Created by kamiloveg1 on 4/4/15.
 */
public class WaiterManagerApp extends Application {




    private String waiterName;
    private ArrayList<Tables> tables;
    private static WaiterManagerApp instance;
    public void onCreate()
    {
        super.onCreate();
        instance = this;
        tables = new ArrayList<Tables>();
    }
    public void setAssignedTables(int [] assignedTables)
    {
        if (tables.size() == 0){
            for (int i = 0; i < assignedTables.length; i++) {
                Tables assignedTable = new Tables(assignedTables[i]);
                tables.add(assignedTable);
            }
        }
    }
    public static WaiterManagerApp getManager() {
        return instance;
    }

    public String getWaiterName() {
        return waiterName;
    }

    public void setWaiterName(String waiterName) {
        this.waiterName = waiterName;
    }

    public ArrayList<Tables> getTables() {
        return tables;
    }

    public void setTables(ArrayList<Tables> tables) {
        this.tables = tables;
    }
}
