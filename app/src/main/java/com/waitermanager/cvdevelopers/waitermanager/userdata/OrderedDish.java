package com.waitermanager.cvdevelopers.waitermanager.userdata;

/**
 * Created by kamiloveg1 on 4/3/15.
 */

public class OrderedDish {
    public static enum DishStatus{
        ORDERED,
        COOKING,
        READY,
        SERVED
    }
    DishStatus status; //determines the state of the dish
    String notes;
    public OrderedDish(DishStatus status, String notes)
    {
        this.notes=notes;
        this.status = status;
    }

    public void setStatus(DishStatus status) {
        this.status = status;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getNotes() {
        return notes;
    }

    public DishStatus getStatus() {
        return status;
    }
}
