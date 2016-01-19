package org.codingdojo.gildedrose;

import org.codingdojo.gildedrose.model.Item;
import org.codingdojo.gildedrose.model.specific.AgedBrie;
import org.codingdojo.gildedrose.model.specific.Backstage;
import org.codingdojo.gildedrose.model.specific.Sulfuras;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.codingdojo.gildedrose.builder.ItemBuilder.anItem;
import static org.codingdojo.gildedrose.model.ItemAssert.assertThat;

/**
 * run 'mvn clean package'
 * go to \target\site\jacoco\index.html to consult
 */
@RunWith(JUnit4.class)
public class GildedRoseTest {

    //Example
    @Test
    public void example() {
        //Given
        Item item = anItem().withName("test").withSellIn(12).withQuality(8).build();
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        //When
        gildedRose.updateQuality();

        //Then
        assertThat(item).hasSellIn(11).hasQuality(7);
    }

    @Test
    public void defaultItemShouldDecreaseQualityByOneAsDaysGoBy() {
        //Given
        Item item = anItem().withName("test").withSellIn(12).withQuality(8).build();
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        //When
        gildedRose.updateQuality();

        //Then
        assertThat(item).hasQuality(7);
    }

    @Test
    public void defaultItemShouldDecreaseSellInByOneAsDaysGoBy() {
        //Given
        Item item = anItem().withName("test").withSellIn(12).withQuality(8).build();
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        //When
        gildedRose.updateQuality();

        //Then
        assertThat(item).hasSellIn(11);
    }

    @Test
    public void defaultItemShouldDecreaseQualityTwiceFasterAfterSellIn() {
        //Given
        Item item = anItem().withName("test").withSellIn(0).withQuality(8).build();
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        //When
        gildedRose.updateQuality();

        //Then
        assertThat(item).hasQuality(6);
    }

    @Test
    public void defaultItemShouldNotHaveNegativeQuality() {
        //Given
        Item item = anItem().withName("test").withSellIn(12).withQuality(0).build();
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        //When
        gildedRose.updateQuality();

        //Then
        assertThat(item).hasQuality(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void itemShouldNotHaveQualityMoreThanFifty() {
        //Given
        anItem().withName("test").withQuality(51).build();

        //When
        //Then
    }

    @Test
    public void agedBrieShouldIncreaseQualityAsDaysGoBy() {
        //Given
        Item item = new AgedBrie(12, 8);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        //When
        gildedRose.updateQuality();

        //Then
        assertThat(item).hasQuality(9);
    }

    @Test
    public void sulfurasShouldNeverDecreaseQuality() {
        //Given
        Item item = new Sulfuras(12, 8);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        //When
        gildedRose.updateQuality();

        //Then
        assertThat(item).hasQuality(8);
    }

    @Test
    public void sulfurasShouldNotDecreaseSellIn() {
        //Given
        Item item = new Sulfuras(12, 8);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        //When
        gildedRose.updateQuality();

        //Then
        assertThat(item).hasSellIn(12);
    }

    @Test
    public void backstagePassShouldIncreaseQualityAsDaysGoBy() {
        //Given
        Item item = new Backstage(12, 8);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        //When
        gildedRose.updateQuality();

        //Then
        assertThat(item).hasQuality(9);
    }

    @Test
    public void backstagePassShouldIncreaseQualityByTwoWhenSellInInferiorToTenDays() {
        //Given
        Item item = new Backstage(10, 8);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        //When
        gildedRose.updateQuality();

        //Then
        assertThat(item).hasQuality(10);
    }

    @Test
    public void backstagePassShouldIncreaseQualityByThreeWhenSellInInferiorToFiveDays() {
        //Given
        Item item = new Backstage(5, 8);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        //When
        gildedRose.updateQuality();

        //Then
        assertThat(item).hasQuality(11);
    }

    @Test
    public void backstagePassShouldHaveQualityZeroAfterSellIn() {
        //Given
        Item item = new Backstage(0, 8);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        //When
        gildedRose.updateQuality();

        //Then
        assertThat(item).hasQuality(0);
    }
}
