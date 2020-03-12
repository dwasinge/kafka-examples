package com.github.dwasinge.inventory.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.github.dwasinge.inventory.domain.InventoryDetail;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import io.quarkus.panache.common.Parameters;

@ApplicationScoped
public class InventoryRepository implements PanacheMongoRepository<InventoryDetail> {

	public InventoryDetail findByStoreIdAndItemId(Integer storeId, Integer itemId) {
		return find("storeId = :storeId and itemId = :itemId",
				Parameters.with("storeId", storeId).and("itemId", itemId).map()).firstResult();
	}

	public List<InventoryDetail> findByStoreId(Integer storeId) {
		return find("storeId", storeId).list();
	}

}
