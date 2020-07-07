package hr.ferit.mlenic.uniquewoodpt2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewPagerAdapter extends RecyclerView.Adapter<RecyclerViewPagerAdapter.ViewHolder> {

    Context mContext;
    List<Item> mData;

    public RecyclerViewPagerAdapter(Context mContext, List<Item> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_order, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

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

    public static class ViewHolder extends RecyclerView.ViewHolder {


        private TextView tvItemName;
        private TextView tvItemSize;
        private TextView tvItemColor;
        private TextView tvItemPrice;
        private ImageView ivImage;
        private ImageView ivAdd;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvItemName = (TextView) itemView.findViewById(R.id.tvItemName);
            tvItemSize = (TextView) itemView.findViewById(R.id.tvItemSize);
            tvItemColor = (TextView) itemView.findViewById(R.id.tvItemColor);
            tvItemPrice = (TextView) itemView.findViewById(R.id.tvItemPrice);
            ivImage = (ImageView) itemView.findViewById(R.id.ivItem);
            ivAdd=(ImageView) itemView.findViewById(R.id.ivAdd);
            ivAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION) {
                        FragmentRecyclerMediator.getInstance().addCell(tvItemName.getText().toString());
                    }

                }
            });


        }
    }
}
