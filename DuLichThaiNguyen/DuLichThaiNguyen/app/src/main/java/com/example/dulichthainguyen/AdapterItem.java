package com.example.dulichthainguyen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AdapterItem extends RecyclerView.Adapter<AdapterItem.ViewHolder> {
    private List<Item> list;
    private Context context;
// kh.tao
    public AdapterItem(List<Item> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    //item
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item,viewGroup,false);
        return new ViewHolder(view);
    }
//ghi du lieu
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Item it = list.get(i);
        viewHolder.ivAvatar.setImageResource(it.getAvatar());
        viewHolder.tvTen.setText(it.getName());
        viewHolder.tvDiaDanh.setText(it.getDiaDanh());
        viewHolder.geod.setText(it.getLatitude()+","+it.getLongitude()+"");
        viewHolder.img=it.getAvatar();
    }
//tra ve so phan tu cua list
    @Override
    public int getItemCount() {
        return list.size();
    }
//lop
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTen,tvDiaDanh, geod;
        private ImageView ivAvatar;
        private int img;
//anh xa thuoc tinh
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTen = itemView.findViewById(R.id.tvName);
            tvDiaDanh = itemView.findViewById(R.id.tvDiaDanh);
            ivAvatar = itemView.findViewById(R.id.tvAvata);
            geod = itemView.findViewById(R.id.geod);
            // bat su kien item khi click
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, Detail.class);
// cho du lieu ve bundle va gui ra Detail
                    Bundle data = new Bundle();
                    TextView name = (TextView)v.findViewById(R.id.tvName);
                    TextView address = (TextView)v.findViewById(R.id.tvDiaDanh);
                    TextView geod = (TextView)v.findViewById(R.id.geod);
                    data.putString("name",name.getText().toString() );
                    data.putString("address",address.getText().toString() );
                    data.putString("geod", geod.getText().toString());
                    data.putInt("img", img);
                    intent.putExtras(data);

                    context.startActivity(intent);
                }
            });
        }
    }
}
