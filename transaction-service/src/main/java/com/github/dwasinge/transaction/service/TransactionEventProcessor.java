package com.github.dwasinge.transaction.service;

import java.time.LocalDateTime;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.dwasinge.store.commons.domain.InventoryEvent;
import com.github.dwasinge.store.commons.domain.TransactionEvent;

import io.smallrye.reactive.messaging.annotations.Broadcast;

@ApplicationScoped
public class TransactionEventProcessor {

	private Logger logger = LoggerFactory.getLogger(TransactionEventProcessor.class);

	@Incoming("transaction-events")
	@Outgoing("inventory-events")
	@Broadcast
	public InventoryEvent process(TransactionEvent event) {

		logger.info("processing transaction event to inventory event: " + event);

		// Need to create an InventoryEvent
		return new InventoryEvent(event.getStoreId(), event.getItemId(), event.getQuantity(),
				event.getIsDebit(), LocalDateTime.now());

	}

}
