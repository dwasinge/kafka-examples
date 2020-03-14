package com.github.dwasinge.store.commons.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderCreatedAndShippedEvent {

	private Long id;
	private Integer storeId;
	private Integer itemId;
	private Integer quantityShipped;
	private LocalDateTime createdDateTime;

}
