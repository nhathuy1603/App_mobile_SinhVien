package com.example.sqlitesinhvien;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class SinhVienAdapter extends  RecyclerView.Adapter<SinhVienAdapter.ViewHolder>{
    private List<SinhVien> list;
    IclickItemRecyclerview iclickItemRecyclerview;

    public SinhVienAdapter(List<SinhVien> list, IclickItemRecyclerview iclickItemRecyclerview) {
        this.list = list;
        this.iclickItemRecyclerview = iclickItemRecyclerview;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sinhvien, parent, false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SinhVien sinhVien = list.get(position);
        if (sinhVien == null){
            return;
        }

        holder.tv_MaSV.setText(sinhVien.getMaSV156());
        holder.tv_TenSV.setText(sinhVien.getTenSV156());
        holder.tv_MoTa.setText(sinhVien.getMota156());
//        holder.tv_DiemSV.setText(sinhVien.getDiem());
        holder.tv_MaLopSV.setText(sinhVien.getMaLop());

        holder.layout_item_SV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iclickItemRecyclerview.onClickItemSinhVien(sinhVien);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (list != null)
            return list.size();
        return 0;

    }




    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_MaSV;
        private TextView tv_TenSV;
        private TextView tv_MoTa;
        private TextView tv_MaLopSV;
        private TextView tv_DiemSV;
        private ConstraintLayout layout_item_SV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_MaSV= itemView.findViewById(R.id.tv_MaSV);
            tv_TenSV = itemView.findViewById(R.id.tv_TenSV);
            tv_MoTa= itemView.findViewById(R.id.tv_MoTa);
            tv_DiemSV = itemView.findViewById(R.id.tv_DiemSV);
            tv_MaLopSV = itemView.findViewById(R.id.tv_MaLopSV);
            layout_item_SV = itemView.findViewById(R.id.layout_item_SV);
        }
    }

}
