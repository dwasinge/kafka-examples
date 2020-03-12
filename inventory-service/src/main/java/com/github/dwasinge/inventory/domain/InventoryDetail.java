package com.github.dwasinge.inventory.domain;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class InventoryDetail extends PanacheMongoEntity {

	private Integer storeId;
	private Integer itemId;
	private Integer quantity;

	public InventoryDetail() {
	}

	public InventoryDetail(InventoryDetailEvent event) {
		this.storeId = event.getStoreId();
		this.itemId = event.getItemId();
		this.quantity = event.getQuantity();
	}

}
