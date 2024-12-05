package com.nhom3.bduan1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nhom3.bduan1.R;
import com.nhom3.bduan1.models.QuanLyPhongTroModels;

import java.util.List;

public class XuLyYeuCauAdapter extends RecyclerView.Adapter<XuLyYeuCauAdapter.ViewHolder> {
    private final Context context;
    private final List<QuanLyPhongTroModels> list;


    public XuLyYeuCauAdapter(Context context, List<QuanLyPhongTroModels> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_xu_ly_yeu_cau, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        QuanLyPhongTroModels phongTro = list.get(position);


        holder.tvtenphong.setText(phongTro.getTenPhong() != null ? phongTro.getTenPhong() : "Không có tên phòng");


        String trangThai = phongTro.getTrangThaiPhong();
        if (trangThai != null && trangThai.equalsIgnoreCase("Đã xử lý")) {
            holder.tvtrangthai.setText("Đã xử lý");
            holder.tvtrangthai.setTextColor(context.getResources().getColor(android.R.color.holo_green_dark));
        } else {
            holder.tvtrangthai.setText("Chưa xử lý");
            holder.tvtrangthai.setTextColor(context.getResources().getColor(android.R.color.holo_red_dark));
        }


        holder.tvtrangthai.setOnClickListener(v -> {
            String newTrangThai = trangThai.equals("Đã xử lý") ? "Chưa xử lý" : "Đã xử lý";
            updateTrangThai(position, newTrangThai);
        });
    }

    // Trả về số lượng mục trong danh sách
    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    // Phương thức cập nhật trạng thái
    public void updateTrangThai(int position, String newTrangThai) {
        if (position >= 0 && position < list.size()) {
            QuanLyPhongTroModels phongTro = list.get(position);
            phongTro.setTrangThaiPhong(newTrangThai);
            notifyItemChanged(position);
        }
    }

    // Lớp ViewHolder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView tvtenphong;
        final TextView tvtrangthai;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvtenphong = itemView.findViewById(R.id.tvtenphong_xlyc);
            tvtrangthai = itemView.findViewById(R.id.sptrangthai_xlyc);
        }
    }
}
