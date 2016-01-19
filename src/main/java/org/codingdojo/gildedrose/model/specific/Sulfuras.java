package org.codingdojo.gildedrose.model.specific;

import org.codingdojo.gildedrose.model.BetterItem;

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
}
