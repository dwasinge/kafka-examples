package com.github.dwasinge.data.generator.transactions;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.dwasinge.store.commons.domain.TransactionEvent;

import io.reactivex.Flowable;
import io.smallrye.reactive.messaging.kafka.KafkaMessage;

@ApplicationScoped
public class TransactionGenerator {

	private Logger logger = LoggerFactory.getLogger(TransactionGenerator.class);

	private Random random = new Random();
	private int returnCounter = 0;

	@Outgoing("transaction-events")
	public Flowable<KafkaMessage<Integer, TransactionEvent>> transactions() {

		return Flowable.interval(500, TimeUnit.MILLISECONDS).onBackpressureDrop().map(tick -> {

			// stores numbered from 1000-1008
			Integer storeId = 1000 + random.nextInt(9);
			// item ids numbered from 1-144
			Integer itemId = 1 + random.nextInt(144);

			// generate quantity between 1-10
			Integer quantity = 1 + random.nextInt(10);

			BigDecimal total = generateTotalAmount();

			// Arbitrary, but 1 out of every 15 will be a returned item
			Boolean isDebit = Boolean.TRUE;
			returnCounter += 1;
			if (returnCounter >= 15) {
				returnCounter = 0;
				isDebit = Boolean.FALSE;
			}

			TransactionEvent event = new TransactionEvent(storeId, itemId, quantity, LocalDateTime.now(),
					LocalDateTime.now(), total, isDebit);

			logger.info("generated transaction event: " + event);

			return KafkaMessage.of(event.getStoreId(), event);

		});

	}

	private BigDecimal generateTotalAmount() {

		BigDecimal dollars = new BigDecimal(random.nextInt(15));
		BigDecimal cents = new BigDecimal(random.nextGaussian()).setScale(2, RoundingMode.HALF_UP);

		return dollars.add(cents);

	}

}
