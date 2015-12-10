package org.codingdojo.gildedrose.model;

public class Item {
    public String name;
    public int sellIn;
    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.setName(name);
        this.setSellIn(sellIn);
        this.setQuality(quality);
    }

    /* Generated getter and setter code */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSellIn() {
        return sellIn;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        if (quality < 0 || quality > 50) {
            throw new IllegalArgumentException("Quality must be between 0 and 50");
        }

        this.quality = quality;
    }

    public String toString() {
        return "(name:" + this.name + ", sellIn:" + this.sellIn + ", quality:" + this.quality + ")";
    }
}
