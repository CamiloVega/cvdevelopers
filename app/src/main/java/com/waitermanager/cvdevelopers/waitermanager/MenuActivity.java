package com.waitermanager.cvdevelopers.waitermanager;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.waitermanager.cvdevelopers.waitermanager.userdata.MenuGridAdapter;


public class MenuActivity extends Activity {

    MenuGridAdapter entreeAdapter;
    MenuGridAdapter appetizerAdapter;
    MenuGridAdapter lunchMenuAdapter;
    MenuGridAdapter dessertAdapter;

    MenuGridAdapter juiceDrinkAdapter;
    MenuGridAdapter sodaDrinkAdapter;
    MenuGridAdapter alcoholDrinkAdapter;

    GridView mainGridView;
    boolean foodSubmenuShowing;
    boolean drinksSubmenuShowing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        foodSubmenuShowing = false;
        drinksSubmenuShowing =  false;
        mainGridView = (GridView) findViewById(R.id.menu_gridview);
        //TODO this is where we load the menu from the DB
        Resources res = this.getResources();
        Integer [] entreeImageResources = new Integer[res.getStringArray(R.array.entree_names).length];
        Integer [] appetizerImageResources = new Integer[res.getStringArray(R.array.appetizer_names).length];
        Integer [] lunchImageResources = new Integer[res.getStringArray(R.array.lunch_names).length];
        Integer [] dessertImageResources = new Integer[res.getStringArray(R.array.desserts_names).length];

        Integer [] juiceImageResources = new Integer[res.getStringArray(R.array.juice_names).length];
        Integer [] sodaImageResources = new Integer[res.getStringArray(R.array.soda_names).length];
        Integer [] alcoholImageResources = new Integer[res.getStringArray(R.array.alcohol_names).length];


        for (int i = 0; i < entreeImageResources.length; i++)
        {
            entreeImageResources[i] = R.mipmap.dish_1;
        }
        for (int i = 0; i < appetizerImageResources.length; i++)
        {
            appetizerImageResources[i] = R.mipmap.appetizer_1;
        }

        for (int i = 0; i < lunchImageResources.length; i++)
        {
            lunchImageResources[i] = R.mipmap.lunch_1;
        }
        for (int i = 0; i < dessertImageResources.length; i++)
        {
            dessertImageResources[i] = R.mipmap.dessert_1;
        }


        for (int i = 0; i < juiceImageResources.length; i++)
        {
            juiceImageResources[i] = R.mipmap.juice_1;
        }

        for (int i = 0; i < sodaImageResources.length; i++)
        {
            sodaImageResources[i] = R.mipmap.soda_1;
        }
        for (int i = 0; i < alcoholImageResources.length; i++)
        {
            alcoholImageResources[i] = R.mipmap.alcohol_1;
        }

        entreeAdapter = new MenuGridAdapter(this, res.getStringArray(R.array.entree_names), entreeImageResources);
        appetizerAdapter = new MenuGridAdapter(this, res.getStringArray(R.array.appetizer_names), appetizerImageResources);
        lunchMenuAdapter = new MenuGridAdapter(this, res.getStringArray(R.array.lunch_names), lunchImageResources);
        dessertAdapter = new MenuGridAdapter(this, res.getStringArray(R.array.desserts_names), dessertImageResources);

        juiceDrinkAdapter = new MenuGridAdapter(this, res.getStringArray(R.array.juice_names), juiceImageResources);
        sodaDrinkAdapter = new MenuGridAdapter(this, res.getStringArray(R.array.soda_names), sodaImageResources);
        alcoholDrinkAdapter = new MenuGridAdapter(this, res.getStringArray(R.array.alcohol_names), alcoholImageResources);


        mainGridView.setAdapter(appetizerAdapter);

        mainGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                Toast.makeText(MenuActivity.this, "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void foodButtonPressed(View button)
    {
       if (drinksSubmenuShowing) changeDrinksSubmenu(false);
       changeFoodSubmenu(!foodSubmenuShowing);
       // mainGridView.setAdapter(appetizerAdapter);
    }
    public void drinksButtonPressed(View button)
    {
        if (foodSubmenuShowing) changeFoodSubmenu(false);
        changeDrinksSubmenu(!drinksSubmenuShowing);

       // mainGridView.setAdapter(appetizerAdapter);
    }

    public void appetizerButtonClicked(View button)
    {
        mainGridView.setAdapter(appetizerAdapter);
        changeFoodSubmenu(false);
    }

    public void entreeButtonClicked(View button)
    {
        mainGridView.setAdapter(entreeAdapter);
        changeFoodSubmenu(false);
    }

    public void lunchButtonClicked(View button)
    {
        mainGridView.setAdapter(lunchMenuAdapter);
        changeFoodSubmenu(false);
    }

    public void dessertButtonClicked(View button)
    {
        mainGridView.setAdapter(dessertAdapter);
        changeFoodSubmenu(false);
    }

    public void juiceButtonClicked(View button)
    {
        mainGridView.setAdapter(juiceDrinkAdapter);
        changeDrinksSubmenu(false);
    }

    public void sodaButtonClicked(View button)
    {
        mainGridView.setAdapter(sodaDrinkAdapter);
        changeDrinksSubmenu(false);
    }

    public void alcoholButtonClicked(View button)
    {
        mainGridView.setAdapter(alcoholDrinkAdapter);
        changeDrinksSubmenu(false);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu, menu);
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
    public void changeDrinksSubmenu(boolean show)
    {
        if (show) {
            LinearLayout drinksSubmenuLayout = (LinearLayout) findViewById(R.id.drinks_submenu_buttons);
            LinearLayout menuButtonsLayout = (LinearLayout) findViewById(R.id.food_drink_buttons);
            translateView(drinksSubmenuLayout, menuButtonsLayout.getBottom(), 0);
            drinksSubmenuShowing = true; 
        }
        else
        {
            LinearLayout drinksSubmenuLayout = (LinearLayout) findViewById(R.id.drinks_submenu_buttons);
            LinearLayout menuButtonsLayout = (LinearLayout) findViewById(R.id.food_drink_buttons);
            translateView(drinksSubmenuLayout, -menuButtonsLayout.getBottom(), 0);
            drinksSubmenuShowing = false;
        }
    }

    public void changeFoodSubmenu(boolean show)
    {
        if (!foodSubmenuShowing) {
            LinearLayout foodSubmenuLayout = (LinearLayout) findViewById(R.id.food_submenu_buttons);
            LinearLayout menuButtonsLayout = (LinearLayout) findViewById(R.id.food_drink_buttons);
            translateView(foodSubmenuLayout, menuButtonsLayout.getBottom(), 0);
            foodSubmenuShowing = true;
        }
        else
        {
            LinearLayout foodSubmenuLayout = (LinearLayout) findViewById(R.id.food_submenu_buttons);
            LinearLayout menuButtonsLayout = (LinearLayout) findViewById(R.id.food_drink_buttons);
            translateView(foodSubmenuLayout, 0, 0);
            foodSubmenuShowing = false;
        }
    }
    public void translateView(View theView, int up, int left) {
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) theView
                .getLayoutParams();
        TranslateAnimation anim;
        if (left != 0) {
            params.rightMargin = left;
            theView.setLayoutParams(params);

            anim = new TranslateAnimation(-left, 0, 0, 0.0f); // new
            // TranslateAnimation(xFrom,xTo,
            // yFrom,yTo)
        } else {
            //float currentTop = params.topMargin;
            params.topMargin = up;
            theView.setLayoutParams(params);
            anim = new TranslateAnimation(0, 0, -up, 0);
        }
        anim.setDuration(250); // animation duration
        anim.setRepeatCount(0); // animation repeat count
        //anim.setFillAfter(true);
        anim.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                // get layoutparams here and set it in this example your views
                // parent is a relative layout, please change that to your
                // desires

            }
        });
         theView.startAnimation(anim);
    }

}
