package com.github.dwasinge.orders.service;

import java.time.LocalDateTime;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import com.github.dwasinge.store.commons.domain.LowInventoryEvent;
import com.github.dwasinge.store.commons.domain.OrderCreatedAndShippedEvent;

@ApplicationScoped
public class LowInventoryEventProcessor {

	/*
	 * TODO: The order id is not currently being generated. Will always be 1L.
	 */

	@Incoming("low-inventory-events")
	@Outgoing("order-shipped-events")
	public OrderCreatedAndShippedEvent createOrderAndShip(LowInventoryEvent event) {

		// calculate number to order/ship
		Integer quantityToShip = (event.getThresholdQuantity() - event.getCurrentQuantity())
				+ event.getReserveQuantity();

		return new OrderCreatedAndShippedEvent(1L, event.getStoreId(), event.getItemId(), quantityToShip,
				LocalDateTime.now());

	}

}
