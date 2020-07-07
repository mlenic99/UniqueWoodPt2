package hr.ferit.mlenic.uniquewoodpt2;

import android.graphics.Color;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PurchaseEndActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_end);
        setupHyperlink();
    }

    private void setupHyperlink(){
        TextView linkOpcina = findViewById(R.id.tvLinkOpcina);
        TextView linkWebsite = findViewById(R.id.tvLinkWebsite);
        linkOpcina.setMovementMethod(LinkMovementMethod.getInstance());
        linkWebsite.setMovementMethod(LinkMovementMethod.getInstance());
        linkOpcina.setLinkTextColor(Color.BLUE);
        linkWebsite.setLinkTextColor(Color.BLUE);
    }
}
