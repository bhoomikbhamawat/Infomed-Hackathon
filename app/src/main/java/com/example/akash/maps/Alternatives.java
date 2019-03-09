package com.example.akash.maps;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Alternatives extends AppCompatActivity {
    private Button abtn1;
    private EditText av1;
    private TextView t1;
    private TextView t2;

    private TextView t3;
    private Button abtn2;
    public String ce1,ce2,i1,i2,p1,p2;
    public ProgressDialog pdilog1;

    private Button abtn3;
    //firebase
    FirebaseDatabase fdbase;
    DatabaseReference dref;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alternatives);


        pdilog1=new  ProgressDialog(this);
        abtn1=(Button)findViewById(R.id.abtn1);
        t1=(TextView)findViewById(R.id.t1);
        t2=(TextView)findViewById(R.id.t2);
        t3=(TextView)findViewById(R.id.t3);

        abtn2=(Button)findViewById(R.id.abtn2);

        fdbase= FirebaseDatabase.getInstance();
        dref = fdbase.getReference();
        abtn2=(Button)findViewById(R.id.abtn2);
        abtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dref.child("CETIRIZINE").child("C2").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Log.e("Availabiliy","Data read ho gya"+dataSnapshot.getValue().toString());
                         ce1=dataSnapshot.getValue().toString();
                         t1.setText(ce1);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });







            }
        });
        abtn3=(Button)findViewById(R.id.abtn3);
        abtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                dref.child("IBUPROFEN").child("T2").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        i1=dataSnapshot.getValue().toString();

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                ;
                dref.child("IBUPROFEN").child("T2").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Log.e("Availabiliy","Data read ho gya"+dataSnapshot.getValue().toString());
                        i2=dataSnapshot.getValue().toString();

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


            }
        });
        abtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dref.child("PARACETAMOL").child("P1").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        p1=dataSnapshot.getValue().toString();

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                ;
                dref.child("PARACETAMOL").child("T2").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Log.e("Availabiliy","Data read ho gya"+dataSnapshot.getValue().toString());
                        p2=dataSnapshot.getValue().toString();

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });




            }
        });
    }
}
