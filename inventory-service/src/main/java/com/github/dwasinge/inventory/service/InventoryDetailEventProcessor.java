package com.github.dwasinge.inventory.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.dwasinge.inventory.domain.InventoryDetail;
import com.github.dwasinge.inventory.domain.InventoryDetailEvent;

@ApplicationScoped
public class InventoryDetailEventProcessor {

	private Logger logger = LoggerFactory.getLogger(InventoryDetailEventProcessor.class);

	@Inject
	private InventoryService service;

	@Incoming("inventory-detail-events")
	public void process(InventoryDetailEvent event) {

		logger.info("processing inventory event...");

		service.createOrUpdate(new InventoryDetail(event));

		logger.info("persisted.");

	}
	

}
