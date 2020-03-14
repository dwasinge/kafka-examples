package com.github.dwasinge.store.commons.serdes;

import com.github.dwasinge.store.commons.domain.ItemEvent;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;

public class ItemEventDeserializer extends ObjectMapperDeserializer<ItemEvent> {

	public ItemEventDeserializer() {
		super(ItemEvent.class);
	}

}
