package com.hypesofts.kata.telldontask.usecase;

import com.hypesofts.kata.telldontask.domain.Order;
import com.hypesofts.kata.telldontask.domain.OrderApprovalStatus;
import com.hypesofts.kata.telldontask.domain.OrderStatus;
import com.hypesofts.kata.telldontask.doubles.TestOrderRepository;
import com.hypesofts.kata.telldontask.usecase.exception.ApprovedOrderCannotBeRejectedException;
import com.hypesofts.kata.telldontask.usecase.exception.RejectedOrderCannotBeApprovedException;
import com.hypesofts.kata.telldontask.usecase.exception.ShippedOrdersCannotBeChangedException;
import com.hypesofts.kata.telldontask.usecase.request.OrderApprovalRequest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OrderApprovalUseCaseTest {
    private final TestOrderRepository orderRepository = new TestOrderRepository();
    private final OrderApprovalUseCase useCase = new OrderApprovalUseCase(orderRepository);

    @Test
    public void approvedExistingOrder() {
        Order initialOrder = new Order(OrderStatus.CREATED, 1);
        orderRepository.addOrder(initialOrder);

        OrderApprovalRequest request = new OrderApprovalRequest(1, OrderApprovalStatus.APPROVED);

        useCase.run(request);

        final Order savedOrder = orderRepository.getSavedOrder();
        assertThat(savedOrder.getStatus()).isEqualTo(OrderStatus.APPROVED);
    }

    @Test
    public void rejectedExistingOrder() {
        Order initialOrder = new Order(OrderStatus.CREATED, 1);
        orderRepository.addOrder(initialOrder);

        OrderApprovalRequest request = new OrderApprovalRequest(1, OrderApprovalStatus.REJECTED);

        useCase.run(request);

        final Order savedOrder = orderRepository.getSavedOrder();
        assertThat(savedOrder.getStatus()).isEqualTo(OrderStatus.REJECTED);
    }

    @Test
    public void cannotApproveRejectedOrder() {
        Order initialOrder = new Order(OrderStatus.REJECTED, 1);
        orderRepository.addOrder(initialOrder);

        OrderApprovalRequest request = new OrderApprovalRequest(1, OrderApprovalStatus.APPROVED);

        assertThatThrownBy(() -> useCase.run(request)).isExactlyInstanceOf(RejectedOrderCannotBeApprovedException.class);
        assertThat(orderRepository.getSavedOrder()).isNull();
    }

    @Test
    public void cannotRejectApprovedOrder() {
        Order initialOrder = new Order(OrderStatus.APPROVED, 1);
        orderRepository.addOrder(initialOrder);

        OrderApprovalRequest request = new OrderApprovalRequest(1, OrderApprovalStatus.REJECTED);
        
        assertThatThrownBy(() -> useCase.run(request)).isExactlyInstanceOf(ApprovedOrderCannotBeRejectedException.class);
        assertThat(orderRepository.getSavedOrder()).isNull();
    }

    @Test
    public void shippedOrdersCannotBeApproved() {
        Order initialOrder = new Order(OrderStatus.SHIPPED, 1);
        orderRepository.addOrder(initialOrder);

        OrderApprovalRequest request = new OrderApprovalRequest(1, OrderApprovalStatus.APPROVED);

        assertThatThrownBy(() -> useCase.run(request)).isExactlyInstanceOf(ShippedOrdersCannotBeChangedException.class);
        assertThat(orderRepository.getSavedOrder()).isNull();
    }

    @Test
    public void shippedOrdersCannotBeRejected() {
        Order initialOrder = new Order(OrderStatus.SHIPPED, 1);
        orderRepository.addOrder(initialOrder);

        OrderApprovalRequest request = new OrderApprovalRequest(1, OrderApprovalStatus.REJECTED);

        assertThatThrownBy(() -> useCase.run(request)).isExactlyInstanceOf(ShippedOrdersCannotBeChangedException.class);
        assertThat(orderRepository.getSavedOrder()).isNull();
    }
}