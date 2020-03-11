package com.github.dwasinge.store.repository;

import javax.enterprise.context.ApplicationScoped;

import com.github.dwasinge.store.domain.Store;

import io.quarkus.mongodb.panache.PanacheMongoRepository;

@ApplicationScoped
public class StoreRepository implements PanacheMongoRepository<Store> {

	public Store findByStoreId(Integer storeId) {
		return find("storeId", storeId).firstResult();
	}

}
