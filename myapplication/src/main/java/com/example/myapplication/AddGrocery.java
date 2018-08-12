package com.example.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

public class AddGrocery extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("test")
                .setMessage("test123");
        // Create the AlertDialog object and return it
        return builder.create();
    }


    //    private String title;
//    private static final String ARG_TITLE = "param1";

//    public AddGrocery() {
//    }
//
//    public static AddGrocery newInstance(String title) {
//        AddGrocery addGrocery = new AddGrocery();
//        Bundle args = new Bundle();
//        args.putString(ARG_TITLE, title);
//        addGrocery.setArguments(args);
//
//        return addGrocery;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState){
//        super.onCreate(savedInstanceState);
//        if(getArguments() != null){
//            title = getArguments().getString(ARG_TITLE);
//        }
//    }
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View rootView = inflater.inflate(R.layout.add_grocery, container, false);
//        ((TextView)rootView.findViewById(R.id.label)).setText(title);
//        return rootView;
//    }
}
