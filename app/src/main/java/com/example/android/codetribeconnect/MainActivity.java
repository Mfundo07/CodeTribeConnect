package com.example.android.codetribeconnect;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<DataItem> ItemList;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mDataItemDatabaseReference;
    ChildEventListener childEventListener;
    DataItemAdapter dataItemAdapter;
    ListView dataItemListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDataItemDatabaseReference = mFirebaseDatabase.getReference().child("names");

        dataItemListView = (ListView) findViewById(R.id.list);
        ItemList = new ArrayList<>();
        dataItemAdapter = new DataItemAdapter(this,R.layout.list_item,ItemList);
        dataItemListView.setAdapter(dataItemAdapter);







        childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                DataItem item = dataSnapshot.getValue(DataItem.class);
                dataItemAdapter.add(item);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        mDataItemDatabaseReference.addChildEventListener(childEventListener);








    }
}
