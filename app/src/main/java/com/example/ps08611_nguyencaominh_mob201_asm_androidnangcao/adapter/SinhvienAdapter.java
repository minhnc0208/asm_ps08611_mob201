package com.example.ps08611_nguyencaominh_mob201_asm_androidnangcao.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ps08611_nguyencaominh_mob201_asm_androidnangcao.CoursesActivity;
import com.example.ps08611_nguyencaominh_mob201_asm_androidnangcao.R;
import com.example.ps08611_nguyencaominh_mob201_asm_androidnangcao.database.DatabaseHelper;
import com.example.ps08611_nguyencaominh_mob201_asm_androidnangcao.model.Sinhvien;

import java.util.List;

public class SinhvienAdapter extends RecyclerView.Adapter<SinhvienAdapter.SinhvienHolder> {

    private CoursesActivity context;
    private List<Sinhvien> sinhvienList;
    private DatabaseHelper databaseHelper;

    public SinhvienAdapter(CoursesActivity context, List<Sinhvien> sinhvienList, DatabaseHelper databaseHelper) {
        this.context = context;
        this.sinhvienList = sinhvienList;
        this.databaseHelper = databaseHelper;
    }

    @NonNull
    @Override
    public SinhvienAdapter.SinhvienHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_courses, parent, false);
        return new SinhvienHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SinhvienAdapter.SinhvienHolder holder, final int position) {
        final Sinhvien sinhvien = sinhvienList.get(position);
        holder.imganh.setImageResource(R.drawable.fpt);
        holder.tvmasv.setText(sinhvien.getMasv());
        holder.tvtensv.setText(sinhvien.getTensv());

        holder.imgdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.deleteSinhvien(sinhvienList.get(position).getMasv());
                sinhvienList.remove(position);
                databaseHelper.updateSinhvien(sinhvien);
                notifyDataSetChanged();
            }
        });

        holder.imgedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "sua", Toast.LENGTH_SHORT).show();
            }
        });

        holder.tvmasv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.dangkikhoahoc();
            }
        });

    }

    @Override
    public int getItemCount() {
        if (sinhvienList == null) {
            return 0;
        }
        return sinhvienList.size();
    }

    public class SinhvienHolder extends RecyclerView.ViewHolder {

        final ImageView imganh;
        final TextView tvmasv;
        final TextView tvtensv;
        final ImageView imgedit;
        final ImageView imgdelete;

        public SinhvienHolder(View itemView) {
            super(itemView);

            imganh = itemView.findViewById(R.id.imganh);
            tvmasv = itemView.findViewById(R.id.tvmasv);
            tvtensv = itemView.findViewById(R.id.tvtensv);
            imgedit = itemView.findViewById(R.id.imgedit);
            imgdelete = itemView.findViewById(R.id.imgdelete);

        }


    }
}