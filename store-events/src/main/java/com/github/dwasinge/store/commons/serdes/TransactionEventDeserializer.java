package com.github.dwasinge.store.commons.serdes;

import com.github.dwasinge.store.commons.domain.TransactionEvent;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;

public class TransactionEventDeserializer extends ObjectMapperDeserializer<TransactionEvent> {

	public TransactionEventDeserializer() {
		super(TransactionEvent.class);
	}

}
