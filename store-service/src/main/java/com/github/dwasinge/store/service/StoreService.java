package com.github.dwasinge.store.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;

import com.github.dwasinge.store.domain.Store;
import com.github.dwasinge.store.repository.StoreRepository;

import io.smallrye.reactive.messaging.annotations.Channel;
import io.smallrye.reactive.messaging.annotations.Emitter;

@ApplicationScoped
public class StoreService {

	@Inject
	private StoreRepository repository;

	@Inject
	@Channel("store-events")
	Emitter<Store> storeEventEmitter;

	public Store create(Store store) {

		// check for existing id
		try {
			get(store.getStoreId());
		} catch (WebApplicationException e) {
			repository.persist(store);
			return store;
		}

		throw new WebApplicationException("resource already exists with id '" + store.getStoreId() + "'", 409);
	}

	public List<Store> create(List<Store> storeList) {

		List<Store> persistedList = new ArrayList<>();
	
		for(Store store: storeList) {
			persistedList.add(create(store));
		}

		return persistedList;

	}

	public Store update(Integer id, Store store) {

		// verify store exists
		Store existingStore = get(id);

		// set store id
		store.id = existingStore.id;

		// update
		repository.update(store);

		return store;

	}

	public Store delete(Integer id) {

		Store store = get(id);

		repository.delete(store);

		return store;

	}

	public Store get(Integer id) {

		// attempt to get by id
		Store store = repository.findByStoreId(id);
		if (null == store) {
			throw new WebApplicationException("no resource found for id '" + id + "'", 404);
		}

		return store;
	}

	public List<Store> getAll() {
		return repository.listAll();
	}

}
