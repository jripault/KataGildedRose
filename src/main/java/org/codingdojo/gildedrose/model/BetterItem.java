package org.codingdojo.gildedrose.model;

public class BetterItem extends Item {

    public static final int MAX_QUALITY = 50;
    public static final int MIN_QUALITY = 0;

    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

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

    public void decreaseQuality() {
        if(this.quality > MIN_QUALITY) {
            this.quality--;
        }
    }

    public void increaseQuality() {
        if(this.quality < MAX_QUALITY) {
            this.quality++;
        }
    }

    public void passOneDay() {
        this.sellIn--;
        this.decreaseQuality();
        if(sellIn < 0) {
            this.decreaseQuality();
        }
    }
}
