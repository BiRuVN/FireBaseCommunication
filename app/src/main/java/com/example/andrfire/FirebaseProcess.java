package com.example.andrfire;

import android.support.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FirebaseProcess {

    DatabaseReference RR = FirebaseDatabase.getInstance().getReference();
    DatabaseReference CR = RR.child("Condition");

    CallBack theCall;

    String text = "Not yet";

    public FirebaseProcess(){

    }
    public void sendData(){

        CR.setValue("ABCd");

    }

    public String getData(){

        CR.addListenerForSingleValueEvent(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                text = dataSnapshot.getValue(String.class);
                theCall.callbackCall();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });

        return text;
    }

}
