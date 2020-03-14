package com.github.dwasinge.store.commons.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderReceivedEvent {

	private Long id;
	private Integer storeId;
	private Integer eventId;
	private Integer quantityReceived;
	private LocalDateTime createdDateTime;
	
}
