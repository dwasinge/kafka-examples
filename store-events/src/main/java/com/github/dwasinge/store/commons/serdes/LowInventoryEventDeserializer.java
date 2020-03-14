package com.github.dwasinge.store.commons.serdes;

import com.github.dwasinge.store.commons.domain.LowInventoryEvent;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;

public class LowInventoryEventDeserializer extends ObjectMapperDeserializer<LowInventoryEvent> {

	public LowInventoryEventDeserializer() {
		super(LowInventoryEvent.class);
	}

}
