package com.github.dwasinge.store.commons.serdes;

import com.github.dwasinge.store.commons.domain.OrderCreatedAndShippedEvent;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;

public class OrderCreatedAndShippedEventDeserializer extends ObjectMapperDeserializer<OrderCreatedAndShippedEvent> {

	public OrderCreatedAndShippedEventDeserializer() {
		super(OrderCreatedAndShippedEvent.class);
	}

}
