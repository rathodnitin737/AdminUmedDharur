package com.rathodnitin.adminumeddharur.facultystaff;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rathodnitin.adminumeddharur.R;

import java.util.ArrayList;
import java.util.List;

public class Updaatefacultystaff extends AppCompatActivity {

    FloatingActionButton fab;
    private RecyclerView bdoStaff,bmmStaff,bmfiStaff,bmmisStaff,bmibcbStaff,ccStaff,icrpStaff;
    private LinearLayout bdoNoData,bmmNoData,bmfiNoData,bmmisNoData,bmibcNoData,ccNoData,icrpNoData;
    private List<StaffData> list1, list2, list3, list4, list5, list6, list7;
    private StaffAdapter adapter;

    private DatabaseReference reference, dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updaate_facultystaff);
        bdoStaff = findViewById(R.id.bdoStaff);
        bmmStaff = findViewById(R.id.bmmStaff);
        bmfiStaff = findViewById(R.id.bmfiStaff);
        bmmisStaff = findViewById(R.id.bmmisStaff);
        bmibcbStaff = findViewById(R.id.bmibcbStaff);
        ccStaff = findViewById(R.id.ccStaff);
        icrpStaff = findViewById(R.id.icrpStaff);

        bdoNoData = findViewById(R.id.bdoNoData);
        bmmNoData = findViewById(R.id.bmmNoData);
        bmfiNoData = findViewById(R.id.bmfiNoData);
        bmmisNoData = findViewById(R.id.bmmisNoData);
        bmibcNoData = findViewById(R.id.bmibcNoData);
        ccNoData = findViewById(R.id.ccNoData);
        icrpNoData = findViewById(R.id.icrpNoData);

        reference = FirebaseDatabase.getInstance().getReference().child("Staff");

        bdoStaff();
        bmmStaff();
        bmfiStaff();
        bmmisStaff();
        bmibcbStaff();
        ccStaff();
        icrpStaff();





        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Updaatefacultystaff.this,AddStaff.class));
            }
        });
    }

    private void bdoStaff() {
        dbRef = reference.child("BDO");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1 =  new ArrayList<>();
                if (!dataSnapshot.exists()){
                    bdoNoData.setVisibility(View.VISIBLE);
                    bdoStaff.setVisibility(View.GONE);
                }else {
                    bdoNoData.setVisibility(View.GONE);
                    bdoStaff.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        StaffData data = snapshot.getValue(StaffData.class);
                        list1.add(data);
                    }
                    bdoStaff.setHasFixedSize(true);
                    bdoStaff.setLayoutManager(new LinearLayoutManager(Updaatefacultystaff.this));
                    adapter = new StaffAdapter(list1, Updaatefacultystaff.this, "BLOCK DEVLOPEMENT OFFICER");
                    bdoStaff.setAdapter(adapter);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Updaatefacultystaff.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void bmmStaff() {
        dbRef = reference.child("BMM");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list2 =  new ArrayList<>();
                if (!dataSnapshot.exists()){
                    bmmNoData.setVisibility(View.VISIBLE);
                    bmmStaff.setVisibility(View.GONE);
                }else {
                    bmmNoData.setVisibility(View.GONE);
                    bmmStaff.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        StaffData data = snapshot.getValue(StaffData.class);
                        list2.add(data);
                    }
                    bmmStaff.setHasFixedSize(true);
                    bmmStaff.setLayoutManager(new LinearLayoutManager(Updaatefacultystaff.this));
                    adapter = new StaffAdapter(list2, Updaatefacultystaff.this, "BLOCK MISSION MANAGER");
                    bmmStaff.setAdapter(adapter);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Updaatefacultystaff.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
    private void bmfiStaff() {
        dbRef = reference.child("BMFI");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list3 =  new ArrayList<>();
                if (!dataSnapshot.exists()){
                    bmfiNoData.setVisibility(View.VISIBLE);
                    bmfiStaff.setVisibility(View.GONE);
                }else {
                    bmfiNoData.setVisibility(View.GONE);
                    bmfiStaff.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        StaffData data = snapshot.getValue(StaffData.class);
                        list3.add(data);
                    }
                    bmfiStaff.setHasFixedSize(true);
                    bmfiStaff.setLayoutManager(new LinearLayoutManager(Updaatefacultystaff.this));
                    adapter = new StaffAdapter(list3, Updaatefacultystaff.this,"BMFI");
                    bmfiStaff.setAdapter(adapter);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Updaatefacultystaff.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void bmmisStaff() {
        dbRef = reference.child("BM-MIS");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list4 =  new ArrayList<>();
                if (!dataSnapshot.exists()){
                    bmmisNoData.setVisibility(View.VISIBLE);
                    bmmisStaff.setVisibility(View.GONE);
                }else {
                    bmmisNoData.setVisibility(View.GONE);
                    bmmisStaff.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        StaffData data = snapshot.getValue(StaffData.class);
                        list4.add(data);
                    }
                    bmmisStaff.setHasFixedSize(true);
                    bmmisStaff.setLayoutManager(new LinearLayoutManager(Updaatefacultystaff.this));
                    adapter = new StaffAdapter(list4, Updaatefacultystaff.this,"BM-MIS");
                    bmmisStaff.setAdapter(adapter);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Updaatefacultystaff.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void bmibcbStaff() {
        dbRef = reference.child("BM-IBCB");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list5 =  new ArrayList<>();
                if (!dataSnapshot.exists()){
                    bmibcNoData.setVisibility(View.VISIBLE);
                    bmibcbStaff.setVisibility(View.GONE);
                }else {
                    bmibcNoData.setVisibility(View.GONE);
                    bmibcbStaff.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        StaffData data = snapshot.getValue(StaffData.class);
                        list5.add(data);
                    }
                    bmibcbStaff.setHasFixedSize(true);
                    bmibcbStaff.setLayoutManager(new LinearLayoutManager(Updaatefacultystaff.this));
                    adapter = new StaffAdapter(list5, Updaatefacultystaff.this,"BM-IBCB");
                    bmibcbStaff.setAdapter(adapter);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Updaatefacultystaff.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void ccStaff() {
        dbRef = reference.child("CLUSTER COORDINATOR");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list6 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    ccNoData.setVisibility(View.VISIBLE);
                    ccStaff.setVisibility(View.GONE);
                } else {
                    ccNoData.setVisibility(View.GONE);
                    ccStaff.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        StaffData data = snapshot.getValue(StaffData.class);
                        list6.add(data);
                    }
                    ccStaff.setHasFixedSize(true);
                    ccStaff.setLayoutManager(new LinearLayoutManager(Updaatefacultystaff.this));
                    adapter = new StaffAdapter(list6, Updaatefacultystaff.this, "CLUSTER COORDINATOR");
                    ccStaff.setAdapter(adapter);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Updaatefacultystaff.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void icrpStaff() {
        dbRef = reference.child("ICRP");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list7 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    icrpNoData.setVisibility(View.VISIBLE);
                    icrpStaff.setVisibility(View.GONE);
                } else {
                    icrpNoData.setVisibility(View.GONE);
                    icrpStaff.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        StaffData data = snapshot.getValue(StaffData.class);
                        list7.add(data);
                    }
                    icrpStaff.setHasFixedSize(true);
                    icrpStaff.setLayoutManager(new LinearLayoutManager(Updaatefacultystaff.this));
                    adapter = new StaffAdapter(list7, Updaatefacultystaff.this, "ICRP");
                    icrpStaff.setAdapter(adapter);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Updaatefacultystaff.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }}