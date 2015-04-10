package com.waitermanager.cvdevelopers.waitermanager.userdata;

/**
 * Created by kamiloveg1 on 4/3/15.
 */
public class Client {

    private boolean isChild;
    private String name;

    public Client(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public boolean isChild() {
        return isChild;
    }

    public void setChild(boolean isChild) {
        this.isChild = isChild;
    }


}
