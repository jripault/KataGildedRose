package org.codingdojo.gildedrose.model.specific;

import org.codingdojo.gildedrose.model.BetterItem;

public class AgedBrie extends BetterItem {

    public AgedBrie(int sellIn, int quality) {
        this.name = AGED_BRIE;
		this.setSellIn(sellIn);
		this.setQuality(quality);
	}

    @Override
    public void passOneDay() {
        this.sellIn--;
        if(this.sellIn >= 0) {
            this.increaseQuality(1);
        }
        else {
            this.increaseQuality(2);
        }
    }
}
