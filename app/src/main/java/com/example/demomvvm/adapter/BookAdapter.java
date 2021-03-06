package com.example.demomvvm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demomvvm.R;
import com.example.demomvvm.datamodel.Book;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.Holder> {

    private List<Book> bookList;
    private Context context;
    private boolean isChecked = false;

    public BookAdapter(List<Book> bookList, Context context) {
        this.bookList = bookList;
        this.context = context;
    }

    @NonNull
    @Override
    public BookAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookAdapter.Holder holder, int position) {
        Book book = bookList.get(position);
        if (book == null) {
            Toast.makeText(context, "Không có dữ liệu", Toast.LENGTH_SHORT).show();
        }
        holder.tvName.setText(book.getName());
        holder.tvDescription.setText(book.getDescription());
        holder.tvAuthor.setText(book.getAuthor());
        holder.tvPrice.setText(book.getPrice() + "");
        holder.itemView.setOnClickListener(v -> {

            if (!isChecked) {
                holder.tvPrice.setVisibility(View.VISIBLE);
                holder.tvDescription.setVisibility(View.VISIBLE);
                holder.tvAuthor.setVisibility(View.VISIBLE);
                isChecked = true;
            } else {
                holder.tvPrice.setVisibility(View.GONE);
                holder.tvDescription.setVisibility(View.GONE);
                holder.tvAuthor.setVisibility(View.GONE);
                isChecked = false;
            }


        });
    }

    @Override
    public int getItemCount() {
        if (bookList != null) {
            return bookList.size();
        }
        return 0;
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvDescription;
        TextView tvAuthor;
        TextView tvPrice;


        public Holder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvAuthor = itemView.findViewById(R.id.tvAuthor);
            tvPrice = itemView.findViewById(R.id.tvPrice);

        }
    }
}
