package hr.ferit.mlenic.uniquewoodpt2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CartRecyclerAdapter extends RecyclerView.Adapter<CartRecyclerAdapter.CartViewHolder> {
    Context mContext;
    List<Item> mData;
    private RemoveButtonClickListener listener;

    public CartRecyclerAdapter(Context mContext, RemoveButtonClickListener listener) {
        this.mContext = mContext;
        this.mData = new ArrayList<>();
        this.listener = listener;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_cart, parent, false);
        CartViewHolder viewHolder = new CartViewHolder(v, listener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {

        holder.tvItemName.setText(mData.get(position).getItemName());
        holder.tvItemSize.setText(mData.get(position).getItemSize());
        holder.tvItemColor.setText(mData.get(position).getItemColor());
        holder.tvItemPrice.setText(mData.get(position).getItemPrice());
        Picasso.get().load(mData.get(position).getImage())
                .resize(120,120)
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.ivImage);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void removeCell(int position){
        if(mData.size() > position) {
            mData.remove(position);
            notifyItemRemoved(position);
        }
    }

    public void addNewCell(String name){
        Item item = new Item();
        for(Item i : ItemList.getInstance().getItems()){
            if(i.getItemName().equals(name)){
                item=i;
                break;
            }
        }
        mData.add(item);
        notifyItemInserted(mData.size()-1);
    }

    public void addNewCell(Item item){
        mData.add(item);
        notifyItemInserted(mData.size()-1);
    }

    public List<String> getNames(){
        List<String> names = new ArrayList<>();
        for(Item i : mData){
            names.add(i.getItemName());
        }
        return names;
    }

    public static class CartViewHolder extends RecyclerView.ViewHolder {


        private TextView tvItemName;
        private TextView tvItemSize;
        private TextView tvItemColor;
        private TextView tvItemPrice;
        private ImageView ivImage;
        private ImageView ivRemove;
        private RemoveButtonClickListener listener;

        public CartViewHolder(@NonNull View itemView, final RemoveButtonClickListener listener) {
            super(itemView);

            this.listener = listener;
            tvItemName = (TextView) itemView.findViewById(R.id.tvItemNameCart);
            tvItemSize = (TextView) itemView.findViewById(R.id.tvItemSizeCart);
            tvItemColor = (TextView) itemView.findViewById(R.id.tvItemColorCart);
            tvItemPrice = (TextView) itemView.findViewById(R.id.tvItemPriceCart);
            ivImage = (ImageView) itemView.findViewById(R.id.ivItemCart);
            ivRemove = (ImageView)itemView.findViewById(R.id.ivRemove);
            ivRemove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION) {
                        listener.onRemoveButtonClicked(getAdapterPosition());
                    }
                }
            });
        }
    }
}
