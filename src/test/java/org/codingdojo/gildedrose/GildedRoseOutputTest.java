package org.codingdojo.gildedrose;

import org.codingdojo.gildedrose.builder.ItemBuilder;
import org.codingdojo.gildedrose.model.Item;
import org.codingdojo.GildedRoseLegacy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * run mvn clean package
 * go to \target\site\jacoco\index.html to consult
 */

@RunWith(JUnit4.class)
public class GildedRoseOutputTest {

    @Test
    public void compareOutputs() {
        Item itemLegacy = ItemBuilder.anItem().withName("Default").withQuality(10).withSellIn(10).build();
        Item agedBrieLegacy = ItemBuilder.anItem().withName("Aged Brie").withQuality(10).withSellIn(10).build();
        Item backstageLegacy = ItemBuilder.anItem().withName("Backstage passes to a TAFKAL80ETC concert").withQuality(10).withSellIn(10).build();
        Item sulfurasLegacy = ItemBuilder.anItem().withName("Sulfuras, Hand of Ragnaros").withQuality(10).withSellIn(10).build();

        GildedRoseLegacy gildedRoseLegacy = new GildedRoseLegacy(new Item[] { itemLegacy, agedBrieLegacy, backstageLegacy, sulfurasLegacy });
        gildedRoseLegacy.updateQuality();
        gildedRoseLegacy.updateQuality();
        gildedRoseLegacy.updateQuality();
        gildedRoseLegacy.updateQuality();

        Item item = ItemBuilder.anItem().withName("Default").withQuality(10).withSellIn(10).build();
        Item agedBrie = ItemBuilder.anItem().withName("Aged Brie").withQuality(10).withSellIn(10).build();
        Item backstage = ItemBuilder.anItem().withName("Backstage passes to a TAFKAL80ETC concert").withQuality(10).withSellIn(10).build();
        Item sulfuras = ItemBuilder.anItem().withName("Sulfuras, Hand of Ragnaros").withQuality(10).withSellIn(10).build();

        GildedRose gildedRose = new GildedRose(new Item[] { item, agedBrie, backstage, sulfuras });
        gildedRose.updateQuality();
        gildedRose.updateQuality();
        gildedRose.updateQuality();
        gildedRose.updateQuality();

        assertThat(gildedRose.toString()).isEqualTo(gildedRoseLegacy.toString());
    }
}