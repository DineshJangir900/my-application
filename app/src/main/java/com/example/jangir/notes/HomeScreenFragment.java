package com.example.jangir.notes;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class HomeScreenFragment extends Fragment {
    public HomeScreenFragment() {
        // Required empty public constructor
    }
    DatabaseReference rootRef, demoRef;
    ArrayList<DataModelClass> arrayList;
    dataAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home_screen, container, false);
        arrayList = new ArrayList<>();


        rootRef = FirebaseDatabase.getInstance().getReference();

        rootRef = FirebaseDatabase.getInstance().getReference();
        demoRef = rootRef.child("Notes");
        Log.d("www",""+demoRef.toString());
        demoRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                arrayList.clear();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    DataModelClass dataModelClass = new DataModelClass();
                    dataModelClass = postSnapshot.getValue(DataModelClass.class);
                    arrayList.add(dataModelClass);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        adapter = new dataAdapter(getContext(),arrayList );
        GridView gridView = (GridView) view.findViewById(R.id.grid);
        gridView.setAdapter(adapter);


//        gridView.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//
//
//                Intent intent = new Intent(getActivity(), AddNote.class);
//                startActivity(intent);
//                return true;
//            }
//        });
//
       return view;
  }


    public void onResume(){
        super.onResume();

        ((HomeScreen) getActivity())
                .setActionBarTitle("Notes");
    }
}

