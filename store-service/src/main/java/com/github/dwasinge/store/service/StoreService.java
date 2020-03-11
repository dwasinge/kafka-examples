package com.github.dwasinge.store.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;

import com.github.dwasinge.store.domain.Store;
import com.github.dwasinge.store.repository.StoreRepository;

@ApplicationScoped
public class StoreService {

	@Inject
	private StoreRepository repository;

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
