package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GroceryList extends AppCompatActivity {
    String[] mobileArray = {"Android","IPhone","WindowsMobile","Blackberry",
            "WebOS","Ubuntu","Windows7","Max OS X"};
    ListView listView;
    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grocery_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
//                getSupportFragmentManager().beginTransaction().replace(R.id.container, FragmentCustomDialog.newInstance("Title 10","Message 10 ,Message 10 ,Message 10 ,Message 10 ")).commit();
//                getSupportFragmentManager().beginTransaction().replace(R.id.test, AddGrocery.newInstance("Grocery test")).commit();
            }
        });

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview, mobileArray);

        listView = (ListView) findViewById(R.id.mobile_list);
        fillList("");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
//        MenuItem searchItem = menu.findItem(R.id.app_bar_search);
//        searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
//        searchView.setQueryHint("Hint");
//        searchView.setIconifiedByDefault(true);
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String s) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String s) {
//                fillList(s);
//                return false;
//            }
//        });

        return super.onCreateOptionsMenu(menu);
    }

    public void fillList(String query){
        CustomArrayAdapter adapter = new CustomArrayAdapter(GroceryList.this, getGroceryList());
        if(searchView != null){
            ArrayList<Grocery> filtered = new ArrayList<>();
            for(Grocery g : getGroceryList()){
                if(g.name.toLowerCase().startsWith(query.toLowerCase()))
                    filtered.add(g);
                adapter = new CustomArrayAdapter(GroceryList.this, filtered);
            }
        }
        listView.setAdapter(adapter);
    }

    public ArrayList<Grocery> getGroceryList(){
        ArrayList list = new ArrayList();
        list.add(new Grocery("Apple", false));
        list.add(new Grocery("Banana", true));
        list.add(new Grocery("Orange", false));
        list.add(new Grocery("Peach", true));

        return list;
    }

}
