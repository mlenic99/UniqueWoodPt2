package hr.ferit.mlenic.uniquewoodpt2;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class PagerAdapter extends FragmentStatePagerAdapter {

    private FragmentCart fragmentCart;
    private FragmentOrder fragmentOrder;
    private FragmentCreate fragmentCreate;
    private static final int NUM_PAGES = 4;

    public PagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0: return FragmentHome.newInstance();
            case 3: return FragmentCreate.newInstance();
            case 1: return FragmentOrder.newInstance();
            default: if(fragmentCart != null){
                return FragmentCart.newInstance(fragmentCart.getRecyclerData());
            }
            else return FragmentCart.newInstance();
        }
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        Fragment createdFragment =(Fragment) super.instantiateItem(container, position);
        if(position == 1){
            fragmentOrder = (FragmentOrder) createdFragment;
        }
        else if(position == 2){
            fragmentCart = (FragmentCart) createdFragment;
        }
        else if(position == 3){
            fragmentCreate = (FragmentCreate) createdFragment;
        }
        FragmentRecyclerMediator.getInstance().setFragmentCart(fragmentCart);
        return createdFragment;
        }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Home";
            case 1:
                return "Order";
            case 2:
                return "Cart";
            default:
                return "Create";
        }
    }
}
