package org.codingdojo.gildedrose.model;

public class BetterItem extends Item {

    public static final int MAX_QUALITY = 50;
    public static final int MIN_QUALITY = 0;

    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    public static final String CONJURED = "Conjured";

    public BetterItem() {
        super("default", 0, 0);
    }

    public BetterItem(Item item) {
        super(item.getName(), item.getSellIn(), item.getQuality());
    }

    public BetterItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public boolean is(String name) {
        return (name != null) && name.equals(this.name);
    }

    protected void increaseQuality() {
        this.increaseQuality(1);
    }

    protected void increaseQuality(int value) {
        this.quality += value;
        if (this.quality > MAX_QUALITY) {
            this.quality = MAX_QUALITY;
        }
    }

    protected void decreaseQuality() {
        this.decreaseQuality(1);
    }

    protected void decreaseQuality(int value) {
        this.quality -= value;
        if (this.quality < MIN_QUALITY) {
            this.quality = 0;
        }
    }

    public void passOneDay() {
        this.sellIn--;
        if (sellIn < 0) {
            this.decreaseQuality(2);
        } else {
            this.decreaseQuality();
        }
    }
}
