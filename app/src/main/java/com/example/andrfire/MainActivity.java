package com.example.andrfire;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity {

    TextView txtCondition;
    Button btnSunny;
    Button btnFoggy;
    Button btnGetOnce;
    FirebaseProcess ConditionFB = new FirebaseProcess();
    String text;

    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mCondRef = mRootRef.child("Condition");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCondition = (TextView) findViewById(R.id.txtCondition);
        btnSunny = (Button) findViewById(R.id.btnSunny);
        btnFoggy = (Button) findViewById(R.id.btnFoggy);
        btnGetOnce = (Button) findViewById(R.id.btnGet);


        btnSunny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCondRef.setValue("Sunny");
            }
        });

        btnFoggy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCondRef.setValue("Foggy");
            }
        });

        btnGetOnce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConditionFB.theCall = new CallBack() {
                    @Override
                    public void callbackCall() {
                        text = ConditionFB.getData();
                    }
                };

                ConditionFB.theCall.callbackCall();
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();


            }
        });

        mCondRef.addValueEventListener(new ValueEventListener() {
            @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            String text = dataSnapshot.getValue(String.class);
            txtCondition.setText(text);
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    });

    }

}
