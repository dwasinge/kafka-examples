package com.github.dwasinge.store.domain;

import java.time.LocalDate;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Store extends PanacheMongoEntity {

	private Integer storeId;
	private Integer regionId;
	private LocalDate dateOpened;
	private LocalDate dateClosed;

}
