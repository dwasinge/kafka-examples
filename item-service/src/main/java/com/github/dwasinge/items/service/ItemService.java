package com.github.dwasinge.items.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;

import com.github.dwasinge.items.domain.Item;
import com.github.dwasinge.items.repository.ItemRepository;

@ApplicationScoped
public class ItemService {

	@Inject
	private ItemRepository repository;

	public Item create(Item item) {

		try {
			get(item.id);
		} catch(WebApplicationException e) {
			repository.persist(item);
			return item;
		}
		
		throw new WebApplicationException("resource already exists with id '" + item.id + "'", 409);

	}

	public Item update(Long id, Item item) {

		Item existingItem = get(id);

		// This seems strange.  should be a better way to update an existing entity...
		existingItem.setName(item.getName());
		existingItem.setDescription(item.getDescription());
		existingItem.setColor(item.getColor());
		existingItem.setSize(item.getSize());

		return existingItem;

	}

	public Item delete(Long id) {

		Item item = get(id);

		repository.delete(item);

		return item;

	}

	public Item get(Long id) {

		if(null == id) {
			throw new WebApplicationException("id is required to get resource", 422);
		}

		Item item = repository.findById(id);

		if(null == item) {
			throw new WebApplicationException("no resource found for id '" + id + "'", 404);
		}

		return item;

	}

	public List<Item> getAll() {
		return repository.listAll();
	}

}
