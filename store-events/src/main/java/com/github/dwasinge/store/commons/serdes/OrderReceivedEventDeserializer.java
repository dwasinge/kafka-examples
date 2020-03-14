package com.github.dwasinge.store.commons.serdes;

import com.github.dwasinge.store.commons.domain.OrderReceivedEvent;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;

public class OrderReceivedEventDeserializer extends ObjectMapperDeserializer<OrderReceivedEvent> {

	public OrderReceivedEventDeserializer() {
		super(OrderReceivedEvent.class);
	}

}
