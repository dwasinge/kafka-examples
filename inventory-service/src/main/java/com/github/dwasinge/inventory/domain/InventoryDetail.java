package com.github.dwasinge.inventory.domain;

import com.github.dwasinge.store.commons.domain.InventoryEvent;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class InventoryDetail extends PanacheMongoEntity {

	private Integer storeId;
	private Integer itemId;
	private Integer currentQuantity;

	public InventoryDetail(InventoryEvent event) {

		this.storeId = event.getStoreId();
		this.itemId = event.getItemId();
		this.currentQuantity = event.getQuantity();

	}

}
