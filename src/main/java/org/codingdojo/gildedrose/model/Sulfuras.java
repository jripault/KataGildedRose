package org.codingdojo.gildedrose.model;

public class Sulfuras extends BetterItem {

    public Sulfuras(int sellIn, int quality) {
        this.name = SULFURAS;
		this.setSellIn(sellIn);
		this.setQuality(quality);
	}

    @Override
    public void passOneDay() {
        // do nothing
    }

    @Override
    public void increaseQuality() {
        // do nothing
    }

    @Override
    public void decreaseQuality() {
        // do nothing
    }
}
