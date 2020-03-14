package com.github.dwasinge.store.commons.serdes;

import com.github.dwasinge.store.commons.domain.InventoryEvent;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;

public class InventoryEventDeserializer extends ObjectMapperDeserializer<InventoryEvent> {

	public InventoryEventDeserializer() {
		super(InventoryEvent.class);
	}

}
