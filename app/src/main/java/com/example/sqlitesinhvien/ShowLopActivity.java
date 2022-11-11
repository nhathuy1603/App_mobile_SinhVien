package com.example.sqlitesinhvien;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;
import java.util.ArrayList;

public class ShowLopActivity extends AppCompatActivity {
    private RecyclerView rcv_lop156;
    private Button btn_themlop156, btn_xoalop156, btn_sualop156;
    private EditText edt_maLop156, edt_tenLop156, edt_siSoLop156;
    MyDatabase myDatabase = new MyDatabase(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_lop);

        intViewListener();
        initView();
    }

    private void intViewListener() {
        btn_themlop156 = findViewById(R.id.btn_themLop110);
        edt_maLop156 = findViewById(R.id.edt_maLop110);
        edt_tenLop156 = findViewById(R.id.edt_tenLop110);
        edt_siSoLop156 = findViewById(R.id.edt_siSoLop110);


        btn_themlop156.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Lop lop = new Lop(edt_maLop156.getText().toString(), edt_tenLop156.getText().toString(), edt_siSoLop156.getText().toString());
                myDatabase.insertLop(lop);
                initView();
            }
        });
    }

    private void initView() {
        rcv_lop156 = findViewById(R.id.rcv_lop110);
        rcv_lop156.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rcv_lop156.setLayoutManager(linearLayoutManager);
        // them duong divider giua cac item
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rcv_lop156.addItemDecoration(itemDecoration);

        ArrayList<Lop> arrLopAdapter = (ArrayList<Lop>) myDatabase.readAllLop();

        LopAdapter adapter = new LopAdapter(arrLopAdapter, new IclickItemRecyclerview() {
            @Override
            public void onClickItemLop(Lop lop) {
                onClickGoToSinhVien(lop);
            }

            @Override
            public void onClickItemSinhVien(SinhVien sinhVien) {

            }
        });
        rcv_lop156.setAdapter(adapter);
    }

    private void onClickGoToSinhVien(Lop lop){
        Intent intent = new Intent(this, MainActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_Lop", lop);
        intent.putExtras(bundle);
        startActivity(intent);
    }


}