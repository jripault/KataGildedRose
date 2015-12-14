package org.codingdojo.gildedrose;

import org.codingdojo.gildedrose.model.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.codingdojo.gildedrose.builder.ItemBuilder.anItem;
import static org.codingdojo.gildedrose.model.ItemAssert.assertThat;

/**
 * run mvn clean package
 * go to \target\site\jacoco\index.html to consult
 */
@RunWith(JUnit4.class)
public class GildedRoseTest {

    @Test
    //example
    public void unTest() {
        //Given
        Item item;
        GildedRose gildedRose;

        //When
        item = anItem().withName("test").withQuality(12).withSellIn(13).build();
        gildedRose = new GildedRose(new Item[]{item});
        gildedRose.updateQuality();

        //Then
        assertThat(item).hasQuality(11).hasSellIn(12);
    }

    @Test
    public void defaultItemShouldDecreaseQualityByOneAsDaysGoBy() {

    }

    @Test
    public void defaultItemShouldDecreaseSellInByOneAsDaysGoBy() {

    }

    @Test
    public void defaultItemShouldDecreaseQualityTwiceFasterAfterSellIn() {

    }

    @Test
    public void defaultItemShouldNotHaveNegativeQuality() {

    }

    @Test
    public void itemShouldNotHaveQualityMoreThanFifty() {

    }

    @Test
    public void agedBrieShouldIncreaseQualityAsDaysGoBy() {

    }

    @Test
    public void sulfurasShouldNeverDecreaseQuality() {

    }

    @Test
    public void sulfurasShouldNotDecreaseSellIn() {

    }

    @Test
    public void backstagePassShouldIncreaseQualityAsDaysGoBy() {

    }

    @Test
    public void backstagePassShouldIncreaseQualityByTwoWhenSellInInferiorToTenDays() {

    }

    @Test
    public void backstagePassShouldIncreaseQualityByThreeWhenSellInInferiorToFiveDays() {

    }

    @Test
    public void backstagePassShouldHaveQualityZeroAfterSellIn() {

    }
}
