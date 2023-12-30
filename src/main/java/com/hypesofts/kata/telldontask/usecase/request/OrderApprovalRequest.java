package com.hypesofts.kata.telldontask.usecase.request;

import com.hypesofts.kata.telldontask.domain.OrderApprovalStatus;
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