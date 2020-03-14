package com.github.dwasinge.store.commons.domain;

import java.time.LocalDateTime;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderCreatedAndShippedEvent {

	private Long id;
	private Integer storeId;

	private Map<Integer, Integer> itemsQuantityMap;

	private LocalDateTime createdDateTime;

}
