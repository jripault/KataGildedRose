package org.codingdojo.gildedrose.model.specific;

import org.codingdojo.gildedrose.model.BetterItem;

public class Backstage extends BetterItem {

    private static final int LONG_LIMIT_DAYS = 10;
    private static final int SHORT_LIMIT_DAYS = 5;

    public Backstage(int sellIn, int quality) {
        this.name = BACKSTAGE;
		this.setSellIn(sellIn);
		this.setQuality(quality);
	}

    @Override
    public void passOneDay() {
        this.sellIn--;
        if(this.sellIn < 0) {
            this.quality = 0;
        }
        else if(this.sellIn < SHORT_LIMIT_DAYS) {
            this.increaseQuality(3);
        }
        else if(this.sellIn < LONG_LIMIT_DAYS) {
            this.increaseQuality(2);
        }
        else {
            this.increaseQuality(1);
        }
    }
}
