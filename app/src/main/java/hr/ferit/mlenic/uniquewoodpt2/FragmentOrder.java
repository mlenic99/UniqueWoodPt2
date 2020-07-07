package hr.ferit.mlenic.uniquewoodpt2;

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
import java.util.List;

public class FragmentOrder extends Fragment {

    View v;
    private RecyclerView recyclerView;
    private List<Item>item;
    private Button ibAdd;

    public static FragmentOrder newInstance() {
        FragmentOrder fragment = new FragmentOrder();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.order_fragment, container, false);
        recyclerView = v.findViewById(R.id.rvRecycler);
        RecyclerViewPagerAdapter recyclerViewPagerAdapter = new RecyclerViewPagerAdapter(getContext(), item);
        recyclerView.setLayoutManager((new LinearLayoutManager(getActivity())));
        recyclerView.setAdapter(recyclerViewPagerAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        item = ItemList.getInstance().getItems();
    }
}
