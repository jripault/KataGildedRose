package org.codingdojo.gildedrose;


import org.codingdojo.gildedrose.model.*;
import org.codingdojo.gildedrose.model.specific.AgedBrie;
import org.codingdojo.gildedrose.model.specific.Backstage;
import org.codingdojo.gildedrose.model.specific.Conjured;
import org.codingdojo.gildedrose.model.specific.Sulfuras;
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

    static GildedRose buildGildedRoseAndUpdateQuality(Item item) {
        GildedRose gildedRose = new GildedRose(new Item[] { item });
        gildedRose.updateQuality();
        return gildedRose;
    }

    @Test
    //exemple
    public void unTest() {
        Item item = anItem().withName("test").withQuality(12).withSellIn(13).build();
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
        AgedBrie item = new AgedBrie(10, 50);
        GildedRose gildedRose = buildGildedRoseAndUpdateQuality(item);
        gildedRose.updateQuality();
        assertThat(item).hasQuality(50);
    }

    @Test
    public void agedBrieShouldIncreaseQualityAsDaysGoBy() {
        AgedBrie item = new AgedBrie(10, 10);
        GildedRose gildedRose = buildGildedRoseAndUpdateQuality(item);
        assertThat(item).hasQuality(11);
    }

    @Test
    public void backstagePassShouldIncreaseQualityAsDaysGoBy() {
        Backstage item = new Backstage(20, 10);
        GildedRose gildedRose = buildGildedRoseAndUpdateQuality(item);
        assertThat(item).hasQuality(11);
    }

    @Test
    public void backstagePassShouldIncreaseQualityByTwoWhenSellInInferiorToTenDays() {
        Backstage item = new Backstage(9, 10);
        GildedRose gildedRose = buildGildedRoseAndUpdateQuality(item);
        assertThat(item).hasQuality(12);
    }

    @Test
    public void backstagePassShouldIncreaseQualityByThreeWhenSellInInferiorToFiveDays() {
        Backstage item = new Backstage(4, 10);
        GildedRose gildedRose = buildGildedRoseAndUpdateQuality(item);
        assertThat(item).hasQuality(13);
    }

    @Test
    public void backstagePassShouldHaveQualityZeroAfterSellIn() {
        Backstage item = new Backstage(0, 10);
        GildedRose gildedRose = buildGildedRoseAndUpdateQuality(item);
        assertThat(item).hasQuality(0);
    }

    @Test
    public void sulfurasShouldNeverChangeQuality() {
        Sulfuras item = new Sulfuras(10, 10);
        GildedRose gildedRose = buildGildedRoseAndUpdateQuality(item);
        assertThat(item).hasQuality(10);
    }

    @Test
    public void conjuredShouldDecreaseQualityByTwoAsDaysGoBy() {
        Conjured item = new Conjured(10, 10);
        GildedRose gildedRose = buildGildedRoseAndUpdateQuality(item);
        assertThat(item).hasQuality(8);
    }

    @Test
    public void conjuredShouldDecreaseQualityByFourAsDaysGoByAfterSellIn() {
        Conjured item = new Conjured(0, 10);
        GildedRose gildedRose = buildGildedRoseAndUpdateQuality(item);
        assertThat(item).hasQuality(6);
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
        Sulfuras item = new Sulfuras(10, 10);
        GildedRose gildedRose = buildGildedRoseAndUpdateQuality(item);
        assertThat(item).hasSellIn(10);
    }
}