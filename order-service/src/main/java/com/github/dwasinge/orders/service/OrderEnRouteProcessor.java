package com.github.dwasinge.orders.service;

import java.time.LocalDateTime;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import com.github.dwasinge.store.commons.domain.OrderCreatedAndShippedEvent;
import com.github.dwasinge.store.commons.domain.OrderReceivedEvent;

public class OrderEnRouteProcessor {

	@Incoming("order-shipped-events")
	@Outgoing("order-received-events")
	public OrderReceivedEvent receiveOrder(OrderCreatedAndShippedEvent event) {
		return new OrderReceivedEvent(event.getId(), event.getStoreId(), event.getItemId(), event.getQuantityShipped(),
				LocalDateTime.now());
	}

}
