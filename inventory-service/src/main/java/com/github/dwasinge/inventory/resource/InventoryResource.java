package com.github.dwasinge.inventory.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.github.dwasinge.inventory.domain.InventoryDetail;
import com.github.dwasinge.inventory.service.InventoryService;

@Path("/inventory")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class InventoryResource {

	@Inject
	private InventoryService service;

	@POST
	public Response post(InventoryDetail detail) {
		return Response.status(201).entity(service.createOrUpdate(detail)).build();
	}

	@POST
	@Path("/list")
	public Response postList(List<InventoryDetail> detailList) {
		return Response.status(201).entity(service.createOrUpdate(detailList)).build();
	}

	@GET
	@Path("/stores/{storeId}/items/{itemId}")
	public InventoryDetail getByStoreIdAndItemId(@PathParam("storeId") Integer storeId,
			@PathParam("itemId") Integer itemId) {
		return service.getByStoreIdAndItemId(storeId, itemId);
	}

	@GET
	@Path("/stores/{storeId}")
	public List<InventoryDetail> getByStore(@PathParam("storeId") Integer storeId) {
		return service.getByStoreId(storeId);
	}

	@GET
	public List<InventoryDetail> getAll() {
		return service.getAll();
	}

}
