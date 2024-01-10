package com.csoft.kata.telldontask.usecase.request;

import com.csoft.kata.telldontask.domain.OrderApprovalStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OrderApprovalRequest {
    private int orderId;
    private OrderApprovalStatus status;

    public boolean isApproved() {
        return status == OrderApprovalStatus.APPROVED;
    }
}