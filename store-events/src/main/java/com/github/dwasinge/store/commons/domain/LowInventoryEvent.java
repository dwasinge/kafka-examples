package com.github.dwasinge.store.commons.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LowInventoryEvent {

	private Integer storeId;
	private Integer itemId;
	private Integer currentQuantity;
	private Integer thresholdQuantity;
	private Integer reserveQuantity;

}
