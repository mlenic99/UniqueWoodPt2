package hr.ferit.mlenic.uniquewoodpt2;

import android.media.browse.MediaBrowser;

import java.util.ArrayList;
import java.util.List;

public class ItemList {
    private static ItemList instance;
    private List<Item> items;

    public static ItemList getInstance(){
        if(instance == null)
            instance = new ItemList();
        return instance;
    }

    public ItemList(){
        items = new ArrayList<>();
        items.add(new Item("Regular", "30", "Brown", "150", "https://qtour.org/wp-content/uploads/2020/04/oborak-1.jpg"));
        items.add(new Item("Big Regular", "50", "Brown", "180", "https://upload.wikimedia.org/wikipedia/commons/6/6f/Oborak.jpg"));
        items.add(new Item("Small Regular", "20", "Brown", "100", "https://qtour.org/wp-content/uploads/2020/03/oborak-2-300x210.jpg"));
        items.add(new Item("The Big One", "60", "Red", "200", "https://www.njuskalo.hr/image-w920x690/stare-stvari/drvena-posuda-slika-87883359.jpg"));
        items.add(new Item("The Small One", "20", "Red", "80", "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0d/Oborci.jpg/440px-Oborci.jpg"));
       /* items.add(new Item("Bluish", "30", "Blue", "100", "https://gm1.ggpht.com/bXYnrQSjb04hXm5a9Z0Fj2cD0XZVLfSDw0uWjivKFQiL-GNsmY4YJlMrSGYFzknHJJmtCeMAp61NL6Dsdoa2tSvUt9yhExorXBMbbri2uQHBWEV15FOYh_SJVfoUbrrdh-t0I0rE7_rxLbf0-kQMX_x73I6DWtVtf5mXeCSyG6p5ZLLuY8pRU_ktx81PhXGBqTNuMMJ2Xb-SDa-1e40vEc91zs7H-lprpb2Su0gon3Dcap-fuyGcZxk-n7I6LMhk3XnQxv0_w8inW6GtnP9a-4iGB1hE05qVxSPF-82PdjlAqDY-Ro9_edkJsWpywBLPV3y7spKnFLIJ0MMt1NCwYjvDFVO5FM-9V7qUtPZiEFlTM8gId-EJH-DrzMF9naTcTdCZUN21NWw2xmxhEF9jInNzX7DvAzBOBDbEax2DdvupTh4JU2LKmOVB1ce4vUqREnJnpvj6cV41hhSadPLtVwQpJq1ua1qgvxIZTu4H-jckxkfBjRA-L7RFvWpl5hZKuoymTWzLEk4iZoKIOkz3DWy8iacSWnL_8OvFURCPEA4MtmjWrOWRNZRElIfE0As2N5KjKe3dNdhl5f_GN7g4D2PgDZd7aeQRAYJ62cVAX_YKV1e5QpK-emM7F_3IUP0nisaUPfaSMyqZehqBMs2XTSMvhiNHoXkm02bo0R9xd75EAKetWMykzzw_zxVnMNDG8JbEhPM0F0VwwbqzqFt0n5W-WajMsU65oBJkFk5-PxWUmybUB1AYIBiljNGtIGu1-hDB=s0-l75-ft-l75-ft"));
        items.add(new Item("Bigger Box", "60", "Black", "150","https://scontent.fzag2-1.fna.fbcdn.net/v/t1.15752-9/83995900_175708740409742_3228569397924724736_n.jpg?_nc_cat=106&_nc_ohc=V3-Vu9eSSH4AX_hWnwR&_nc_ht=scontent.fzag2-1.fna&oh=fb293541203f0bf214199bc2df5d75b9&oe=5EC362ED"));
        items.add(new Item("Feed animals", "50", "Brown", "160", "https://scontent.fzag2-1.fna.fbcdn.net/v/t1.15752-9/83633379_466521960710533_4813191654729056256_n.jpg?_nc_cat=103&_nc_ohc=CnvD-pdIH-EAX8-UZGe&_nc_ht=scontent.fzag2-1.fna&oh=a9054ffb18ab8e5d6c71239568b39738&oe=5ECDAE13"));*/
        items.add(new Item("Store smth", "30", "Black", "100", "https://upload.wikimedia.org/wikipedia/commons/6/6f/Oborak.jpg"));
        items.add(new Item("Decor", "30", "Green", "80", "https://qtour.org/wp-content/uploads/2020/03/oborak-2-300x210.jpg"));
    }

    public List<Item> getItems(){
        return items;
    }

    public void addItem(Item item){
        items.add(item);
    }
}
