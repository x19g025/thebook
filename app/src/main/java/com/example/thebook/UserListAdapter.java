package com.example.thebook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.MyViewHolder> {

    private Context context;
    private List<User> userList;
    public UserListAdapter(Context context){
        this.context = context;
    }

    public void setUserList(List<User> userList){
        this.userList = userList;
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_row, parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvTitle.setText(this.userList.get(position).title);
        holder.tvCover.setText(this.userList.get(position).cover);
        holder.tvAuthor.setText(this.userList.get(position).author);
        holder.tvGenre.setText(this.userList.get(position).genre);
        holder.tvStock.setText(this.userList.get(position).stock);
        holder.tvIsbn.setText(this.userList.get(position).isbn);
        holder.tvDate.setText(this.userList.get(position).date);
        holder.tvPrice.setText(this.userList.get(position).price);
        holder.tvFormat.setText(this.userList.get(position).format);
        holder.tvPublisher.setText(this.userList.get(position).publisher);
    }

    @Override
    public int getItemCount() {
        return this.userList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvTitle;
        TextView tvCover;
        TextView tvAuthor;
        TextView tvGenre;
        TextView tvStock;
        TextView tvIsbn;
        TextView tvDate;
        TextView tvPrice;
        TextView tvFormat;
        TextView tvPublisher;

        public MyViewHolder(View view){
            super(view);
            tvTitle = view.findViewById(R.id.tvTitle);
            tvCover = view.findViewById(R.id.tvCover);
            tvAuthor = view.findViewById(R.id.tvAuthor);
            tvGenre = view.findViewById(R.id.tvGenre);
            tvStock = view.findViewById(R.id.tvStock);
            tvIsbn = view.findViewById(R.id.tvIsbn);
            tvDate = view.findViewById(R.id.tvDate);
            tvPrice = view.findViewById(R.id.tvPrice);
            tvFormat = view.findViewById(R.id.tvFormat);
            tvPublisher = view.findViewById(R.id.tvPublisher);
        }
    }
}
