package com.github.dwasinge.store.commons.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionEvent {

	private Integer storeId;
	private Integer itemId;
	private Integer quantity;
	private LocalDateTime soldDateTime;
	private LocalDateTime createdDateTime;
	private BigDecimal totalAmount;
	private Boolean isDebit;

}
