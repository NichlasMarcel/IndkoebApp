package com.example.myapplication.GroceryList;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import com.darwindeveloper.horizontalscrollmenulibrary.custom_views.HorizontalScrollMenuView;
import com.darwindeveloper.horizontalscrollmenulibrary.extras.MenuItem;
import com.example.myapplication.R;


public class GroceryList extends AppCompatActivity {
    HorizontalScrollMenuView menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grocery_list);

        menu = (HorizontalScrollMenuView)findViewById(R.id.horizontalMenuId);
        initMenu();

//        final FragmentManager fragmentManager = getSupportFragmentManager();
//        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        BasketFragment fragment = new BasketFragment();
//        fragmentTransaction.add(R.id.fragment_container, fragment);
//        fragmentTransaction.commit();
    }

    private void initMenu() {
        menu.addItem("Basket", R.drawable.grocery_list_icon);
        menu.addItem("New list", R.drawable.add_grocery_list_icon);
        menu.addItem("Settings", R.drawable.settings_icon);

        menu.setOnHSMenuClickListener(new HorizontalScrollMenuView.OnHSMenuClickListener() {
            @Override
            public void onHSMClick(MenuItem menuItem, int position) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

}
