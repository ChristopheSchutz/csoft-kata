package com.csoft.kata.adventofcraft.day01;

import java.time.LocalDate;
import java.util.UUID;
import java.util.function.Supplier;

public record Food(LocalDate expirationDate,
                   Boolean approvedForConsumption,
                   UUID inspectorId) {
    public boolean isEdible(Supplier<LocalDate> now) {
        return isFresh(now) && isApproved() && hasNotBeenInspected();
    }

    private boolean hasNotBeenInspected() {
        return this.inspectorId != null;
    }

    private Boolean isApproved() {
        return this.approvedForConsumption;
    }

    private boolean isFresh(Supplier<LocalDate> now) {
        return this.expirationDate.isAfter(now.get());
    }
}