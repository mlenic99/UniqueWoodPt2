package hr.ferit.mlenic.uniquewoodpt2;

public class FragmentRecyclerMediator {
    private FragmentCart fragmentCart;
    private static FragmentRecyclerMediator instance;

    private FragmentRecyclerMediator() {
    }

    public static FragmentRecyclerMediator getInstance() {
        if (instance == null)
            instance = new FragmentRecyclerMediator();
        return instance;
    }

    public void setFragmentCart(FragmentCart cart){fragmentCart = cart;}

    public void addCell(String name){
        fragmentCart.toggleButtonEnabled(true);
        fragmentCart.addItem(name);
    }

    public void addCell(Item item){
        fragmentCart.addItem(item);
    }
}
