package hr.ferit.mlenic.uniquewoodpt2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FragmentCart extends Fragment implements RemoveButtonClickListener{
    View v;
    private RecyclerView recyclerView;
    private CartRecyclerAdapter adapter = new CartRecyclerAdapter(getContext(), this);
    private Button btnConfirmPurchase;
    public FragmentCart() {
    }

    public static Fragment newInstance() {
        FragmentCart fragment = new FragmentCart();
        return fragment;
    }

    public static FragmentCart newInstance (ArrayList<String> items){
        FragmentCart fragment = new FragmentCart();
        Bundle args = new Bundle();
        args.putStringArrayList("ITEMS", items);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.cart_fragment, container, false);
        recyclerView = v.findViewById(R.id.rvRecyclerCart);
        adapter = new CartRecyclerAdapter(getContext(), this);
        recyclerView.setLayoutManager((new LinearLayoutManager(getActivity())));
        recyclerView.setAdapter(adapter);
        setUpRecyclerData();
        btnConfirmPurchase = v.findViewById(R.id.btnConfirmPurchase);
        btnConfirmPurchase.setOnClickListener(new View.OnClickListener(){
        @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), PurchaseEndActivity.class);
                startActivity(intent);
            }
        });
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void setUpRecyclerData() {
        if(getArguments() != null){
            ArrayList<String> items = getArguments().getStringArrayList("ITEMS");
            if(items != null) {
                for (int i = 0; i < items.size(); i++) {
                    adapter.addNewCell(items.get(i));
                }
            }
        }
    }

    public void addItem(String name){
        adapter.addNewCell(name);
    }

    public void addItem(Item item){
        adapter.addNewCell(item);
    }

    public java.util.ArrayList<String> getRecyclerData(){
        return (ArrayList<String>) adapter.getNames();
    }

    @Override
    public void onRemoveButtonClicked(int position) {
        if(adapter.getItemCount()==1) toggleButtonEnabled(false);
        adapter.removeCell(position);

    }

    public void toggleButtonEnabled (boolean state) {
        btnConfirmPurchase.setEnabled(state);
    }
}
