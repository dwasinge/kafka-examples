package com.github.dwasinge.store.commons.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemEvent {

	private String brandName;
	private String type;
	private String description;
	private String gender;
	private String size;
	private String color;
	private BigDecimal price;
	private LocalDateTime createdDateTime;

}
