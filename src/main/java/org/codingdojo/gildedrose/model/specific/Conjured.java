package org.codingdojo.gildedrose.model.specific;

import org.codingdojo.gildedrose.model.BetterItem;

public class Conjured extends BetterItem {

    public Conjured(int sellIn, int quality) {
        this.name = SULFURAS;
        this.setSellIn(sellIn);
        this.setQuality(quality);
    }

    @Override
    public void passOneDay() {
        this.sellIn--;
        if (this.sellIn < 0) {
            this.decreaseQuality(4);
        } else {
            this.decreaseQuality(2);
        }
    }
}
