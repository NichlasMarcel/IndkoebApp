package com.example.myapplication.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.DialogFragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ListView;

import com.example.myapplication.Common.Grocery;
import com.example.myapplication.GroceryList.GroceryList;
import com.example.myapplication.R;

import java.util.ArrayList;

public class AddGrocery extends DialogFragment {
    DialogArrayAdapter parentAdapter;
    ListView listView;
    Context context;
    TextInputEditText inputField;



    /**
     * The system calls this to get the DialogFragment's layout, regardless
     * of whether it's being displayed as a dialog or an embedded fragment.
     */
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout to use as dialog or embedded fragment
        View view = inflater.inflate(R.layout.add_grocery, container, false);
        listView = (ListView) view.findViewById(R.id.add_grocery_list);
        context = view.getContext();
        inputField = (TextInputEditText) view.findViewById(R.id.inputText);
        inputField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                fillList(inputField.getText().toString());
            }
        });

        fillList("");

        return view;
    }

    /**
     * The system calls this only when creating the layout in a dialog.
     */
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

    public void fillList(String query) {
        GroceryList activity = (GroceryList)getActivity();
        DialogArrayAdapter adapter = new DialogArrayAdapter(context, getGroceryList(), activity);
        if (query.equals("")) {
            listView.setAdapter(adapter);
            return;
        }


        ArrayList<Grocery> filtered = new ArrayList<>();
        for (Grocery g : getGroceryList()) {
            if (g.getName().toLowerCase().startsWith(query.toLowerCase()))
                filtered.add(g);
            adapter = new DialogArrayAdapter(context, filtered, activity);
        }
        listView.setAdapter(adapter);
        activity.fillList();
    }

    public ArrayList<Grocery> getGroceryList() {
        ArrayList list = new ArrayList();
        list.add(new Grocery("Apple", false));
        list.add(new Grocery("Banana", true));
        list.add(new Grocery("Orange", false));
        list.add(new Grocery("Peach", true));

        return list;
    }
}
