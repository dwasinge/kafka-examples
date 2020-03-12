package com.github.dwasinge.items.domain;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Item extends PanacheEntity {

	private String name;
	private String description;
	private String size;
	private String color;

}
