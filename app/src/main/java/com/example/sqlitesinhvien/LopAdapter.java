package com.example.sqlitesinhvien;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LopAdapter extends RecyclerView.Adapter<LopAdapter.ViewHolder> {

    private List<Lop> mlist;
    private IclickItemRecyclerview iClickItemRecyclerview;

    public LopAdapter(List<Lop> mlist, IclickItemRecyclerview iClickItemRecyclerview) {
        this.mlist = mlist;
        this.iClickItemRecyclerview = iClickItemRecyclerview;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lop, parent, false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Lop lop = mlist.get(position);
        if (lop == null){
            return;
        }

        holder.tv_MaLop.setText(lop.getMalop());
        holder.tv_TenLop.setText(lop.getTenLop());
        holder.tv_SiSo.setText(lop.getSiSo());

        holder.layout_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iClickItemRecyclerview.onClickItemLop(lop);
            }
        });

    }

    @Override
    public int getItemCount() {
        if(mlist != null){
            return mlist.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_TenLop;
        private TextView tv_MaLop;
        private TextView tv_SiSo;
        private ConstraintLayout layout_item;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_MaLop = itemView.findViewById(R.id.tv_MaLop);
            tv_TenLop= itemView.findViewById(R.id.tv_TenLop);
            tv_SiSo= itemView.findViewById(R.id.tv_SiSo);
            layout_item = itemView.findViewById(R.id.layout_item_lop);
        }
    }
}
