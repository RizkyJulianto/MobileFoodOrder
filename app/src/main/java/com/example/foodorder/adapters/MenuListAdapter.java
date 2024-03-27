package com.example.foodorder.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodorder.R;
import com.example.foodorder.model.Menu;
import com.example.foodorder.model.RestaurantModel;

import java.util.List;

public class MenuListAdapter extends RecyclerView.Adapter<MenuListAdapter.MyViewHolder> {

   private List<Menu> MenuList;
   private MenuListClickListener clickListener;

   public MenuListAdapter(List<Menu> restaurantModelList, MenuListClickListener clickListener){
       this.MenuList = MenuList;
       this.clickListener = clickListener;
   }

   public void  updateData(List<Menu> MenuList){
       this.MenuList = MenuList;
       notifyDataSetChanged();
   }

    @NonNull
    @Override
    public MenuListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_recycler_row, parent, false);
      return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuListAdapter.MyViewHolder holder, int position) {
        holder.menuName.setText(MenuList.get(position).getNama());
        holder.menuPrice.setText("Harha: RP" +MenuList.get(position).getHarga());
        holder.addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.onAddToCartClick(MenuList.get(position));
            }
        });
        Glide.with(holder.thumbImage)
                .load(MenuList.get(position).getUrl())
                .into(holder.thumbImage);
    }

    @Override
    public int getItemCount() {
        return MenuList.size();
    }

    static  class MyViewHolder extends RecyclerView.ViewHolder {
        TextView menuName;
        TextView menuPrice;
        TextView addToCartButton;
        ImageView thumbImage;

        public MyViewHolder(View view){
            super(view);

            menuName = view.findViewById(R.id.menuName);
            menuPrice = view.findViewById(R.id.menuPrice);
            addToCartButton = view.findViewById(R.id.addToCartButton);
            thumbImage = view.findViewById(R.id.thumbImage);

        }
    }

    public interface MenuListClickListener {
       public void onAddToCartClick(Menu menu);
    }
}
