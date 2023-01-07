package com.pizzahouse.pizzahouse;

public class RecyclerviewStructure
{
    int imageicon;
    String productname,productprice;

    public RecyclerviewStructure(int imageicon, String productname, String productprice) {
        this.imageicon = imageicon;
        this.productname = productname;
        this.productprice = productprice;
    }



    public int getImageicon() {
        return imageicon;
    }

    public String getProductname() {
        return productname;
    }

    public String getProductprice() {
        return productprice;
    }
}
