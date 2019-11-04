package com.gildedrose;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class GildedRoseTest {

    //Regular Names

    @Test
    void decreaseRegularNameSellinAllDay() {
        Item[] items = new Item[] { new Item("foo", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn).isEqualTo(9);
    }

    @Test
    void decreaseRegularNameQualityAllDay() {
        Item[] items = new Item[] { new Item("foo", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(9);
    }

    @Test
    void dateHasPassedQualityDegradeTwice() {
        Item[] items = new Item[] { new Item("foo", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(8);
    }

    @Test
    void dateHasPassedAndQualityNeverNegativ() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(0);
    }

    @Test
    void QualityNeverGreaterThan50() {
        Item[] items = new Item[] { new Item("foo", 10,  50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isLessThanOrEqualTo(50);
    }



    //Named Items

    @Test
    void sulfurasNeverChangeQuality() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 10,  30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(30);
    }


    @Test
    void QualityNeverGreaterThan50BackstagePasses() {
        Item[] items = new Item[] { new Item("Backstage passes", 10,  50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isLessThanOrEqualTo(50);
    }


    @Test
    void backstageIncreaseQuality() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 20,  30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(31);
    }

    @Test
    void brieIncreaseQuality() {
        Item[] items = new Item[] { new Item("Aged Brie", 20,  10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(11);
    }


    // 10 days less increase Value
    @Test
    void backstageIncrease_Quality_By_Two_While_Sellin_Under_Or_Less_10() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10,  30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(32);
    }

    @Test
    void brie_Not_Increase_Quality_By_Two_While_Sellin_Under_Or_Less_10() {
        Item[] items = new Item[] { new Item("Aged Brie", 10,  30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(31);
    }

    @Test
    void foo_Not_Increase_Quality_By_Two_While_Sellin_Under_Or_Less_10() {
        Item[] items = new Item[] { new Item("foo", 10,  30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(29);
    }


    // 5 days less increase Value
    @Test
    void backstageIncrease_Quality_By_Three_While_Sellin_Under_Or_Less_5() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5,  30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(33);
    }

    @Test
    void brie_Not_Increase_Quality_By_Three_While_Sellin_Under_Or_Less_5() {
        Item[] items = new Item[] { new Item("Aged Brie", 5,  30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(31);
    }

    @Test
    void foo_Not_Increase_Quality_By_Three_While_Sellin_Under_Or_Less_5() {
        Item[] items = new Item[] { new Item("foo", 5,  30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(29);
    }


    @Test
    void backstage_Drop_Quality_To_zero_if_Sellin_equal_Or_Less_Zero() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0,  30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(0);
    }





}
