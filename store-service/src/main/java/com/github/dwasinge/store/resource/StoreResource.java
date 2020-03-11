package com.github.dwasinge.store.resource;

import java.util.List;

import javax.inject.Inject;
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

import com.github.dwasinge.store.domain.Store;
import com.github.dwasinge.store.service.StoreService;

@Path("/stores")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StoreResource {

	@Inject
	private StoreService service;

	@POST
	public Response post(Store store) {
		return Response.status(201).entity(service.create(store)).build();
	}

	@PUT
	@Path("/{storeId}")
	public Store put(@PathParam("storeId") Integer storeId, Store store) {
		return service.update(storeId, store);
	}

	@DELETE
	@Path("/{storeId}")
	public Store delete(@PathParam("storeId") Integer storeId) {
		return service.delete(storeId);
	}

	@GET
	@Path("/{storeId}")
	public Store get(@PathParam("storeId") Integer storeId) {
		return service.get(storeId);
	}

	@GET
	public List<Store> getAll() {
		return service.getAll();
	}

}
