package com.github.dwasinge.inventory.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.dwasinge.inventory.domain.InventoryDetail;
import com.github.dwasinge.store.commons.domain.LowInventoryEvent;

import io.quarkus.scheduler.Scheduled;
import io.smallrye.reactive.messaging.annotations.Channel;
import io.smallrye.reactive.messaging.annotations.Emitter;

@ApplicationScoped
public class LowInventoryManager {

	private Logger logger = LoggerFactory.getLogger(LowInventoryManager.class);

	@Inject
	private InventoryService service;

	@Inject
	@Channel("low-inventory-events")
	Emitter<LowInventoryEvent> lowInventoryEventEmitter;

	private static final Integer INVENTORY_THRESHOLD = 10;
	private static final Integer RESERVE_QUANTITY = 10;

	/*
	 * NOTE: This only works if the store/items already exist in inventory. Probably
	 * should be changed to pull all stores from the store service and items from
	 * items service. Then perform the checks for low inventory.
	 */

	@Scheduled(every = "300s")
	public void checkInventory() {

		logger.info("running low inventory check...");

		List<InventoryDetail> inventoryEventList = service.getAll();

		inventoryEventList.stream().filter(x -> x.getCurrentQuantity() <= INVENTORY_THRESHOLD).forEach(x -> {
			logger.info("\tgenerating low-inventory-event for " + x);
			lowInventoryEventEmitter.send(new LowInventoryEvent(x.getStoreId(), x.getItemId(), x.getCurrentQuantity(),
					INVENTORY_THRESHOLD, RESERVE_QUANTITY));
		});

		logger.info("low inventory check completed.");

	}

}
