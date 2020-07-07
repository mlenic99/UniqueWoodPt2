package hr.ferit.mlenic.uniquewoodpt2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentHome extends Fragment {

    View v;

    public static FragmentHome newInstance(){
        FragmentHome fragment =new FragmentHome();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.home_fragment, container, false);
        return v;
    }

    public FragmentHome() {
    }
}
