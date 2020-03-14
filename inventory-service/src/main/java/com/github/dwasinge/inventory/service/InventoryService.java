package com.github.dwasinge.inventory.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;

import com.github.dwasinge.inventory.domain.InventoryDetail;
import com.github.dwasinge.inventory.repository.InventoryRepository;

@ApplicationScoped
public class InventoryService {

	@Inject
	private InventoryRepository repository;

	public List<InventoryDetail> createOrUpdate(List<InventoryDetail> detailList) {

		List<InventoryDetail> persistedList = new ArrayList<>();

		for (InventoryDetail detail : detailList) {
			persistedList.add(createOrUpdate(detail));
		}

		return persistedList;

	}

	public InventoryDetail createOrUpdate(InventoryDetail detail) {

		InventoryDetail existingDetail = repository.findByStoreIdAndItemId(detail.getStoreId(), detail.getItemId());

		if (null == existingDetail) {
			repository.persist(detail);
		} else {

			// set id if already exists
			detail.id = existingDetail.id;

			// update
			repository.update(detail);

		}

		return detail;

	}

	public InventoryDetail getByStoreIdAndItemId(Integer storeId, Integer itemId) {

		InventoryDetail detail = repository.findByStoreIdAndItemId(storeId, itemId);

		if (null == detail) {
			throw new WebApplicationException("no resource found with key", 404);
		}

		return detail;

	}

	public List<InventoryDetail> getByStoreId(Integer storeId) {

		List<InventoryDetail> detailList = repository.findByStoreId(storeId);

		if (null == detailList) {
			return new ArrayList<InventoryDetail>();
		}

		return detailList;

	}

	public List<InventoryDetail> getAll() {
		return repository.listAll();
	}

}
