package com.github.dwasinge.store.commons.serdes;

import com.github.dwasinge.store.commons.domain.StoreEvent;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;

public class StoreEventDeserializer extends ObjectMapperDeserializer<StoreEvent> {

	public StoreEventDeserializer() {
		super(StoreEvent.class);
	}

}
