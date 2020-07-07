package hr.ferit.mlenic.uniquewoodpt2;

public class Item{

    private String ItemName;
    private String ItemSize;
    private String ItemColor;
    private String ItemPrice;
    private String image;

    public Item(){}
    public Item(String itemName, String itemSize, String itemColor, String itemPrice, String image) {
        ItemName = itemName;
        ItemSize = itemSize;
        ItemColor = itemColor;
        ItemPrice = itemPrice;
        this.image = image;
    }

    public String getItemName() {
        return ItemName;
    }

    public String getItemSize() {
        return ItemSize;
    }

    public String getItemColor() {
        return ItemColor;
    }

    public String getItemPrice() { return ItemPrice;}

    public String getImage() {
        return image;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public void setItemSize(String itemSize) {
        ItemSize = itemSize;
    }

    public void setItemColor(String itemColor) {
        ItemColor = itemColor;
    }

    public void setItemPrice(String itemPrice) {ItemPrice = itemPrice;}

    public void setImage(String image) {
        this.image = image;
    }
}
