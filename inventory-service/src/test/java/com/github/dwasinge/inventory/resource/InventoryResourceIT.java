package com.github.dwasinge.inventory.resource;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.dwasinge.inventory.domain.InventoryDetail;


public class InventoryResourceIT {

	@Test
	public void testLoadInventory() throws JsonProcessingException {

		List<InventoryDetail> initialDetails = mockInventory();

		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(initialDetails);
		
		System.out.println(json);

//        given()
//        .body("{\"name\": \"Pear\", \"description\": \"Winter fruit\"}")
//        .header("Content-Type", MediaType.APPLICATION_JSON)
//    .when()
//        .post("/fruits")
//    .then()
//        .statusCode(200)
		
		
	}

	private List<InventoryDetail> mockInventory() {

		List<InventoryDetail> detailList = new ArrayList<>();

		// for each store
		for(int i = 0; i < 9; i++) {

			int storeId = 1000 + i;

			System.out.println("current store: " + storeId);

			for(int j = 1; j < 145; j++) {

				System.out.println("\tcurrent item: " + j);
				detailList.add(new InventoryDetail(storeId, j, 25));

			}
			
		}
		
		return detailList;

	}

}
