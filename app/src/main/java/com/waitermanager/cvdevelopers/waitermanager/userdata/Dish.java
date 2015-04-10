package com.waitermanager.cvdevelopers.waitermanager.userdata;

/**
 * Created by kamiloveg1 on 4/3/15.
 */
public class Dish {
    public static enum DishType
    {
        ENTREE,
        MAIN_DISH,
        LUNCH_DISH,
        DRINK,
        DESSERT
    }
    String name;
    String ingredients;
//TODO image resource
    int stimatedTime;
    DishType type;
    public Dish (String name, String ingredients, int stimatedTime, DishType type)
    {
        this.name = name;
        this.ingredients = ingredients;
        this.stimatedTime =  stimatedTime;
        this.type = type;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStimatedTime(int stimatedTime) {
        this.stimatedTime = stimatedTime;
    }

    public void setType(DishType type) {
        this.type = type;
    }

    public int getStimatedTime() {
        return stimatedTime;
    }

    public DishType getType() {
        return type;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getName() {
        return name;
    }

}
