package com.csoft.kata.javafeatures.mapflatmap;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

public class MapFlatMapTest {

    static BrandGroup brandGroupIT = new BrandGroup(List.of("Apple", "Microsoft", "Google"));
    static BrandGroup brandGroupSocial = new BrandGroup(List.of("Facebook", "Instagram"));
    static List<BrandGroup> brandGroups = List.of(brandGroupIT, brandGroupSocial);

    @Test
    void test_map() {
        var map = brandGroups.stream()
                .map(BrandGroup::getBrands)
                .toList();
        Assertions.assertThat(map.toString()).isEqualTo("[[Apple, Microsoft, Google], [Facebook, Instagram]]");
    }

    @Test
    void test_flatmap() {
        var map = brandGroups.stream()
                .map(BrandGroup::getBrands)
                .flatMap(Collection::stream)
                .toList();
        Assertions.assertThat(map.toString()).isEqualTo("[Apple, Microsoft, Google, Facebook, Instagram]");
    }

    @AllArgsConstructor
    @Getter
    static class BrandGroup {
        List<String> brands;
    }
}
