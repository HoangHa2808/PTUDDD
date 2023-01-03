package deso1.doancaonhatha.dlu_2012353;

import java.io.Serializable;

public class Food implements Serializable {
    private int id;
    private String name;
    private int price;
    private String unit;
    private int img;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getUnit() {
        return unit;
    }

    public int getImg() {
        return img;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public Food(int id, String name, int price, String unit, int img) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.unit = unit;
        this.img = img;
    }
}
