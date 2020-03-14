package com.github.dwasinge.store.commons.domain;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryEvent {

	private Integer storeId;
	private Integer itemId;
	private Integer quantity;
	private Boolean isDebit;
	private LocalDateTime created;

}
