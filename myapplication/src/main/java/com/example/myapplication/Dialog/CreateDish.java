package com.example.myapplication.Dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ListView;

import com.example.myapplication.Database.ActivityDatabase;
import com.example.myapplication.Dishes.FindDishArrayAdapter;
import com.example.myapplication.GroceryList.GroceryList;
import com.example.myapplication.R;

public class CreateDish extends DialogFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_find_dish, container, false);
        ListView listView = view.findViewById(R.id.find_dish_list);
        listView.setAdapter(new FindDishArrayAdapter(view.getContext(), (GroceryList) getActivity(), ActivityDatabase.getRecipeRepository().getAllRecipes()));

        return view;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // The only reason you might override this method when using onCreateView() is
        // to modify any dialog characteristics. For example, the dialog includes a
        // title by default, but your custom layout might not need it. So here you can
        // remove the dialog title, but you must call the superclass to get the Dialog.
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }
}
