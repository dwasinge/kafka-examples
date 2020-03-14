package com.github.dwasinge.inventory.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.dwasinge.inventory.domain.InventoryDetail;
import com.github.dwasinge.store.commons.domain.InventoryEvent;

@ApplicationScoped
public class InventoryDetailEventProcessor {

	private Logger logger = LoggerFactory.getLogger(InventoryDetailEventProcessor.class);

	@Inject
	private InventoryService service;

	@Incoming("inventory-events")
	public void process(InventoryEvent event) {

		logger.info("processing inventory event... " + event);

		// check if detail already exists
		InventoryDetail existingDetail = service.getByStoreIdAndItemId(event.getStoreId(), event.getItemId());

		// create new detail
		InventoryDetail detailToPersist = new InventoryDetail(event);

		if (null != existingDetail) {

			// calc new quantity
			Integer currentQuantity = existingDetail.getCurrentQuantity();
			Integer quantityChange = event.getQuantity();

			if (event.getIsDebit()) {

				// subtract new quantity from current quantity
				Integer newQuantity = currentQuantity - quantityChange;
				detailToPersist.setCurrentQuantity((newQuantity < 0) ? 0 : newQuantity);

			} else {

				// add new quantity to current quantity
				Integer newQuantity = currentQuantity + quantityChange;
				detailToPersist.setCurrentQuantity(newQuantity);

			}

		}

		service.createOrUpdate(detailToPersist);

	}

}
