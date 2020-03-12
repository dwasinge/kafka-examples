package com.github.dwasinge.inventory.domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class InventoryDetailEvent {

	private Integer storeId;
	private Integer itemId;
	private Integer quantity;
	private LocalDateTime created;

	public InventoryDetailEvent() {
	}

	public InventoryDetailEvent(InventoryDetail detail) {
		this.setStoreId(detail.getStoreId());
		this.setItemId(detail.getItemId());
		this.setQuantity(detail.getQuantity());
		this.created = LocalDateTime.now();
	}

}
