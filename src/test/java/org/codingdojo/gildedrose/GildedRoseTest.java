package org.codingdojo.gildedrose;


import org.codingdojo.gildedrose.model.BetterItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.codingdojo.gildedrose.model.ItemAssert.*;
import static org.codingdojo.gildedrose.builder.ItemBuilder.anItem;

/**
 * run mvn clean package
 * go to \target\site\jacoco\index.html to consult
 */

@RunWith(JUnit4.class)
public class GildedRoseTest {

    static GildedRose buildGildedRoseAndUpdateQuality(BetterItem item) {
        GildedRose gildedRose = new GildedRose(new BetterItem[] { item });
        gildedRose.updateQuality();
        return gildedRose;
    }

    @Test
    //exemple
    public void unTest() {
        BetterItem item = anItem().withName("test").withQuality(12).withSellIn(13).build();
        assertThat(item).hasQuality(12).hasSellIn(13);
    }

    /**
     * QUALITY
     */
    @Test
    public void defaultItemShouldChangeQualityOneByOne() {
        Item item = anItem().withName("default").withQuality(12).withSellIn(13).build();
        GildedRose gildedRose = buildGildedRoseAndUpdateQuality(item);
        assertThat(item).hasQuality(11);
    }

    @Test
    public void defaultItemShouldChangeQualityTwiceFasterAfterSellIn() {
        Item item = anItem().withName("default").withQuality(12).withSellIn(0).build();
        GildedRose gildedRose = buildGildedRoseAndUpdateQuality(item);
        assertThat(item).hasQuality(10);
    }

    @Test
    public void defaultItemShouldNotHaveNegativeQuality() {
        Item item = anItem().withName("default").withQuality(0).withSellIn(10).build();
        GildedRose gildedRose = buildGildedRoseAndUpdateQuality(item);
        assertThat(item).hasQuality(0);
    }

    @Test
    public void itemShouldNotHaveQualityMoreThanFifty() {
        Item item = anItem().withName("Aged Brie").withQuality(50).withSellIn(10).build();
        GildedRose gildedRose = buildGildedRoseAndUpdateQuality(item);
        gildedRose.updateQuality();
        assertThat(item).hasQuality(50);
    }

    @Test
    public void agedBrieShouldIncreaseQualityAsDaysGoBy() {
        Item item = anItem().withName("Aged Brie").withQuality(10).withSellIn(10).build();
        GildedRose gildedRose = buildGildedRoseAndUpdateQuality(item);
        assertThat(item).hasQuality(11);
    }

    @Test
    public void backstagePassShouldIncreaseQualityAsDaysGoBy() {
        Item item = anItem().withName("Backstage passes to a TAFKAL80ETC concert").withQuality(10).withSellIn(20).build();
        GildedRose gildedRose = buildGildedRoseAndUpdateQuality(item);
        assertThat(item).hasQuality(11);
    }

    @Test
    public void backstagePassShouldIncreaseQualityByTwoWhenSellInInferiorToTenDays() {
        Item item = anItem().withName("Backstage passes to a TAFKAL80ETC concert").withQuality(10).withSellIn(9).build();
        GildedRose gildedRose = buildGildedRoseAndUpdateQuality(item);
        assertThat(item).hasQuality(12);
    }

    @Test
    public void backstagePassShouldIncreaseQualityByThreeWhenSellInInferiorToFiveDays() {
        Item item = anItem().withName("Backstage passes to a TAFKAL80ETC concert").withQuality(10).withSellIn(4).build();
        GildedRose gildedRose = buildGildedRoseAndUpdateQuality(item);
        assertThat(item).hasQuality(13);
    }

    @Test
    public void backstagePassShouldHaveQualityZeroAfterSellIn() {
        Item item = anItem().withName("Backstage passes to a TAFKAL80ETC concert").withQuality(10).withSellIn(0).build();
        GildedRose gildedRose = buildGildedRoseAndUpdateQuality(item);
        assertThat(item).hasQuality(0);
    }

    @Test
    public void sulfurasShouldNeverChangeQuality() {
        Item item = anItem().withName("Sulfuras, Hand of Ragnaros").withQuality(10).withSellIn(10).build();
        GildedRose gildedRose = buildGildedRoseAndUpdateQuality(item);
        assertThat(item).hasQuality(10);
    }

    /**
     * SELL IN
     */
    @Test
    public void sellInShouldDecreaseByOneAsDaysGoBy() {
        Item item = anItem().withName("default").withQuality(10).withSellIn(10).build();
        GildedRose gildedRose = buildGildedRoseAndUpdateQuality(item);
        assertThat(item).hasSellIn(9);
    }

    @Test
    public void sulfurasSellInShouldNotDecrease() {
        Item item = anItem().withName("Sulfuras, Hand of Ragnaros").withQuality(10).withSellIn(10).build();
        GildedRose gildedRose = buildGildedRoseAndUpdateQuality(item);
        assertThat(item).hasSellIn(10);
    }
}