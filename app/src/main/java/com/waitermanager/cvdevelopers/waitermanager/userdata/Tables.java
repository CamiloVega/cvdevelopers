package com.waitermanager.cvdevelopers.waitermanager.userdata;

import java.util.ArrayList;

/**
 * Created by kamiloveg1 on 4/4/15.
 */
public class Tables {


    public ArrayList<Client> clients;
    public enum TableStatus
    {
        OPEN,
        WAITING_FOR_SERVICE,
        WAITING_FOR_DRINKS,
        WAITING_TO_ORDER,
        WAITING_FOR_APPETIZER,
        WAITING_FOR_FOOD,
        WAITING_FOR_DESSERT,
        EATING,
        WAITING_FOR_CHECK

    }

    public int tableNumber;
    public TableStatus status;
    public boolean hasChildren;
    public Tables (int tableNumber)
    {
        this.tableNumber = tableNumber;
        status = TableStatus.OPEN;
        clients =  new ArrayList<Client>();
        hasChildren = false;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public int getTableNumber() {
        return tableNumber;
    }
    public ArrayList<Client> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

    public void sitClients (int numberOfClients)
    {
        this.clients.clear();
        for (int i = 0; i < numberOfClients; i++)
        {
            Client client = new Client("Client "+i);
            clients.add(client);
        }
        status = TableStatus.WAITING_FOR_SERVICE;
    }
}
