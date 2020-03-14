package com.github.dwasinge.orders.service;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import com.github.dwasinge.store.commons.domain.InventoryEvent;
import com.github.dwasinge.store.commons.domain.OrderReceivedEvent;

public class OrderReceivedEventProcessor {

	@Incoming("order-received-events")
	@Outgoing("inventory-events")
	public InventoryEvent updateInventory(OrderReceivedEvent event) {
		return new InventoryEvent(event.getStoreId(), event.getEventId(), event.getQuantityReceived(), Boolean.FALSE,
				event.getCreatedDateTime());
	}

}
