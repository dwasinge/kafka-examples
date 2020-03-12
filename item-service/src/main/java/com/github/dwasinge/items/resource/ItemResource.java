package com.github.dwasinge.items.resource;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.github.dwasinge.items.domain.Item;
import com.github.dwasinge.items.service.ItemService;

@Path("/items")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ItemResource {

	@Inject
	private ItemService service;

	@POST
	@Transactional
	public Response post(Item item) {
		return Response.status(201).entity(service.create(item)).build();
	}

	@PUT
	@Path("/{id}")
	@Transactional
	public Item put(@PathParam("id") Long id, Item item) {
		return service.update(id, item);
	}

	@DELETE
	@Path("/{id}")
	@Transactional
	public Item delete(@PathParam("id") Long id) {
		return service.delete(id);
	}

	@GET
	@Path("/{id}")
	public Item get(@PathParam("id") Long id) {
		return service.get(id);
	}

	@GET
	public List<Item> getAll() {
		return service.getAll();
	}

}
