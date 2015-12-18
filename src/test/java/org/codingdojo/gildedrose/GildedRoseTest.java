package org.codingdojo.gildedrose;

import org.codingdojo.gildedrose.model.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.codingdojo.gildedrose.builder.ItemBuilder.anItem;
import static org.codingdojo.gildedrose.model.ItemAssert.assertThat;
import static org.junit.Assert.fail;

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
        fail("Not yet implemented");
    }

    @Test
    public void defaultItemShouldDecreaseSellInByOneAsDaysGoBy() {
        fail("Not yet implemented");
    }

    @Test
    public void defaultItemShouldDecreaseQualityTwiceFasterAfterSellIn() {
        fail("Not yet implemented");
    }

    @Test
    public void defaultItemShouldNotHaveNegativeQuality() {
        fail("Not yet implemented");
    }

    @Test
    public void itemShouldNotHaveQualityMoreThanFifty() {
        fail("Not yet implemented");
    }

    @Test
    public void agedBrieShouldIncreaseQualityAsDaysGoBy() {
        fail("Not yet implemented");
    }

    @Test
    public void sulfurasShouldNeverDecreaseQuality() {
        fail("Not yet implemented");
    }

    @Test
    public void sulfurasShouldNotDecreaseSellIn() {
        fail("Not yet implemented");
    }

    @Test
    public void backstagePassShouldIncreaseQualityAsDaysGoBy() {
        fail("Not yet implemented");
    }

    @Test
    public void backstagePassShouldIncreaseQualityByTwoWhenSellInInferiorToTenDays() {
        fail("Not yet implemented");
    }

    @Test
    public void backstagePassShouldIncreaseQualityByThreeWhenSellInInferiorToFiveDays() {
        fail("Not yet implemented");
    }

    @Test
    public void backstagePassShouldHaveQualityZeroAfterSellIn() {
        fail("Not yet implemented");
    }
}
