package org.codingdojo;

import org.codingdojo.gildedrose.model.Item;
import org.codingdojo.gildedrose.model.BetterItem;

import java.util.Arrays;

public class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            BetterItem item = (BetterItem) items[i];
            item.passOneDay();
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}