package hr.ferit.mlenic.uniquewoodpt2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentCreate extends Fragment {

    private RadioButton rbYes, rbNo;
    private Button btnGoToCart;
    private EditText etName, etSize;
    private Spinner spinner;
    View v;

    public static FragmentCreate newInstance() {
        FragmentCreate fragment = new FragmentCreate();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.create_fragment, container, false);
        btnGoToCart = v.findViewById(R.id.btnGoToCart);
        etName = v.findViewById(R.id.etName);
        etSize = v.findViewById(R.id.etSize);
        spinner = v.findViewById(R.id.spinnerColor);


        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Item item = new Item();
                item.setItemName(etName.getText().toString());
                item.setItemSize(etSize.getText().toString());
                item.setItemColor(spinner.getSelectedItem().toString());
                item.setItemPrice(String.valueOf(200));
                ItemList.getInstance().addItem(item);
                FragmentRecyclerMediator.getInstance().addCell(item);
            }
        });

        return v;
    }




}
