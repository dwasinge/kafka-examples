package com.github.dwasinge.inventory.serdes;

import com.github.dwasinge.inventory.domain.InventoryDetailEvent;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;

public class InventoryDetailEventDeserializer extends ObjectMapperDeserializer<InventoryDetailEvent> {

	public InventoryDetailEventDeserializer() {
		super(InventoryDetailEvent.class);
	}

}
