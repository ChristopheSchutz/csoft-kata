package com.hypesofts.kata.gildedrose;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class GildedRoseTest {

    @Test
    void shouldUpdateForOneDay() {
        GildedRose rose = new GildedRose(ItemsProvider.items());
        rose.updateQuality();
        assertThat(rose.items).extracting(item -> item.sellIn).containsExactly(9, 1, 4, 0, -1, 14, 9, 4, 2);
        assertThat(rose.items).extracting(item -> item.quality).containsExactly(19, 1, 6, 80, 80, 21, 50, 50, 4);
    }

    @Test
    void shouldUpdateForHundredDay() {
        GildedRose rose = new GildedRose(ItemsProvider.items());
        for (int i = 0; i < 100; i++) {
            rose.updateQuality();
        }
        assertThat(rose.items).extracting(item -> item.sellIn).containsExactly(-90, -98, -95, 0, -1, -85, -90, -95, -97);
        assertThat(rose.items).extracting(item -> item.quality).containsExactly(0, 50, 0, 80, 80, 0, 0, 0, 0);
    }

    @Test
    void shouldBehaveLikeGoldenMaster() {
        GildedRose rose = new GildedRose(ItemsProvider.items());
        GildedRoseGolden roseGolden = new GildedRoseGolden(ItemsProvider.items());

        assertThat(rose.items).extracting(item -> item.sellIn).containsExactly(Arrays.stream(roseGolden.items).map(item -> item.sellIn).toArray(Integer[]::new));
        assertThat(rose.items).extracting(item -> item.quality).containsExactly(Arrays.stream(roseGolden.items).map(item -> item.quality).toArray(Integer[]::new));
    }

    @Test
    void shouldUpdateConjuredItem() {
        GildedRose rose = new GildedRose(ItemsProvider.conjuredItems());
        rose.updateQuality();
        assertThat(rose.items).extracting(item -> item.sellIn).containsExactly(2);
        assertThat(rose.items).extracting(item -> item.quality).containsExactly(4);
    }
}