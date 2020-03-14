package com.github.dwasinge.inventory.resource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.dwasinge.inventory.domain.InventoryDetail;

public class InventoryResourceIT {

	// @Test
	public void createLoadInventoryJson() throws IOException {

		List<InventoryDetail> initialDetails = mockInventory();

		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(initialDetails);

		Files.write(Paths.get("/tmp/inventory-load.json"), json.getBytes());

	}

	private List<InventoryDetail> mockInventory() {

		List<InventoryDetail> detailList = new ArrayList<>();

		// for each store
		for (int i = 0; i < 9; i++) {

			int storeId = 1000 + i;

			for (int j = 1; j < 145; j++) {

				detailList.add(new InventoryDetail(storeId, j, 25));

			}

		}

		return detailList;

	}

}
