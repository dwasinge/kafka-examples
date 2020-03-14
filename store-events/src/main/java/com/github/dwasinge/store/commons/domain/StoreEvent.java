package com.github.dwasinge.store.commons.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreEvent {

	private Integer storeId;
	private Integer regionId;
	private LocalDate dateOpened;
	private LocalDate dateClosed;
	private LocalDateTime createDateTime;

}
