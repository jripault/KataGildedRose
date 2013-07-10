package org.codingdojo.gildedrose;

import org.codingdojo.gildedrose.model.Item;

import java.util.Arrays;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];

            Strategy strategy = StrategyBuilder.build(item);
            strategy.updateItem(item);
        }
    }

    public static class StrategyBuilder{
        public static Strategy build(Item item){

            Strategy strategy;

            if (isBrie(item)) {
                strategy = new BrieStrategy();
            }
            else if (isSulfuras(item)) {
                strategy = new SulfurasStrategy();
            }
            else if (isConcert(item)) {
                strategy = new PassesStrategy();
            }
            else if (isConjured(item)) {
                strategy = new ConjuredStrategy();
            }
            else{
                strategy = new DefaultStrategy();
            }

            return strategy;
        }
    }

    static class BrieStrategy implements Strategy {

        @Override
        public void updateItem(Item item) {
            decreaseSellIn(item);
            increaseQuality(item);
            if (isPerimatedeuh(item)) {
                increaseQuality(item);
            }
        }
    }
    static class SulfurasStrategy implements Strategy {

        @Override
        public void updateItem(Item item) {

        }
    }
    static class PassesStrategy implements Strategy {

        @Override
        public void updateItem(Item item) {
            decreaseSellIn(item);
            increaseQualityConcert(item);
            if (isPerimatedeuh(item)) {
                item.quality = 0;
            }
        }
    }
    static class DefaultStrategy implements Strategy{

        @Override
        public void updateItem(Item item) {
            decreaseSellIn(item);
            internalDecreaseQuality(item);
            if (isPerimatedeuh(item)) {
                internalDecreaseQuality(item);
            }
        }
    }
    static class ConjuredStrategy implements Strategy{

        @Override
        public void updateItem(Item item) {
            decreaseSellIn(item);
            internalDecreaseQuality(item);
            internalDecreaseQuality(item);
            if (isPerimatedeuh(item)) {
                internalDecreaseQuality(item);
                internalDecreaseQuality(item);
            }
        }
    }

    private static void decreaseSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private static boolean isPerimatedeuh(Item item) {
        return item.sellIn < 0;
    }

    private static void increaseQualityConcert(Item item) {
        increaseQuality(item);
        if (item.sellIn < 11) {
            increaseQuality(item);
        }
        if (item.sellIn < 6) {
            increaseQuality(item);
        }
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0 && !isSulfuras(item)) {
            internalDecreaseQuality(item);
            if(isConjured(item)){
                internalDecreaseQuality(item);
            }
        }
    }

    private static void internalDecreaseQuality(Item item) {
        if (item.quality > 0)
            item.quality = item.quality - 1;
    }

    private static void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private static boolean isSulfuras(Item i) {
        return "Sulfuras, Hand of Ragnaros".equals(i.name);
    }

    private static boolean isConcert(Item i) {
        return "Backstage passes to a TAFKAL80ETC concert".equals(i.name);
    }

    private static boolean isBrie(Item i) {
        return "Aged Brie".equals(i.name);
    }
    private static boolean isConjured(Item i) {
        return "Conjured Mana Cake".equals(i.name);
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}