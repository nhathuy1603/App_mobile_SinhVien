package com.example.sqlitesinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SinhVienDetailActivity extends AppCompatActivity {

    private TextView tv_MaSV_dt, tv_tenSV_dt, tv_Mota_dt, tv_maLop_dt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinh_vien_detail);

        initView();
    }

    private void initView() {
        tv_MaSV_dt = findViewById(R.id.tv_MaSV_dt);
        tv_tenSV_dt = findViewById(R.id.tv_tenSV_dt);
        tv_Mota_dt = findViewById(R.id.tv_Mota_dt);
        tv_maLop_dt = findViewById(R.id.tv_maLop_dt);

        Intent intent = getIntent();
        SinhVien sinhVien = (SinhVien) intent.getSerializableExtra("object_SV");

        tv_MaSV_dt.setText(sinhVien.getMaSV156());
        tv_tenSV_dt.setText(sinhVien.getTenSV156());
        tv_Mota_dt.setText(sinhVien.getMota156());
        tv_maLop_dt.setText(sinhVien.getMaLop());


    }
}