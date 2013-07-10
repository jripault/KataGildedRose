package org.codingdojo.gildedrose;

import org.codingdojo.gildedrose.model.BetterItem;
import org.codingdojo.gildedrose.model.Item;

class GildedRose {
    private Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            BetterItem item = (BetterItem) items[i];
            item.passOneDay();
        }
    }
}