package org.codingdojo.gildedrose;

import org.codingdojo.gildedrose.model.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * run 'mvn clean package'
 * go to \target\site\jacoco\index.html to consult
 */
@RunWith(JUnit4.class)
public class GildedRoseTest {
    @Test
    public void foo() {
        Item[] items = new Item[]{new Item("+5 Dexterity Vest", 10, 20),
                new Item("Aged Brie", 2, 0),
                new Item("Elixir of the Mongoose", 5, 7),
                new Item("Sulfuras, Hand of Ragnaros", 0, 40),
                new Item("Sulfuras, Hand of Ragnaros", -1, 40),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6)};

        GildedRose app = new GildedRose(items);
        int days = 60;
        for (int i = 0; i < days; i++) {
            app.updateQuality();
            for (int j = 0; j < items.length; j++) {
                assertTrue(items[0].quality >= 0);
            }
        }
        assertEquals(9, items.length);
        assertEquals("(name:+5 Dexterity Vest, sellIn:-50, quality:0)", items[0].toString());
        assertEquals("(name:Aged Brie, sellIn:-58, quality:50)", items[1].toString());
        assertEquals("(name:Elixir of the Mongoose, sellIn:-55, quality:0)", items[2].toString());
        assertEquals("(name:Sulfuras, Hand of Ragnaros, sellIn:0, quality:40)", items[3].toString());
        assertEquals("(name:Sulfuras, Hand of Ragnaros, sellIn:-1, quality:40)", items[4].toString());
        assertEquals("(name:Backstage passes to a TAFKAL80ETC concert, sellIn:-45, quality:0)", items[5].toString());
        assertEquals("(name:Backstage passes to a TAFKAL80ETC concert, sellIn:-50, quality:0)", items[6].toString());
        assertEquals("(name:Backstage passes to a TAFKAL80ETC concert, sellIn:-55, quality:0)", items[7].toString());
        assertEquals("(name:Conjured Mana Cake, sellIn:-57, quality:0)", items[8].toString());
    }

    @Test
    public void bar() {
        Item[] items = new Item[]{new Item("+5 Dexterity Vest", 1, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        assertEquals(17, items[0].quality);
        app.updateQuality();
        assertEquals(15, items[0].quality);
    }

    @Test
    public void conjuredTest() {
        Item[] items = new Item[]{new Item("Conjured Mana Cake", 1, 15)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, items[0].sellIn);
        assertEquals(13, items[0].quality);
        app.updateQuality();
        assertEquals(9, items[0].quality);
        app.updateQuality();
        assertEquals(5, items[0].quality);
    }
}
