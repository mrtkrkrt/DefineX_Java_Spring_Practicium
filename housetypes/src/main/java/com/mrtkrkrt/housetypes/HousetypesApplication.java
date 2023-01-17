package com.mrtkrkrt.housetypes;

import com.mrtkrkrt.housetypes.dto.Structure;
import com.mrtkrkrt.housetypes.service.DataService;
import com.mrtkrkrt.housetypes.service.StructureService;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Map;

@SpringBootApplication
public class HousetypesApplication {

	public static void main(String[] args) {
		System.out.println("Total price of all houses = " + StructureService.sumOfHousePrices(DataService.getHouseList()));
		System.out.println("Total price of all summeries = " + StructureService.sumOfSummeryPrices(DataService.getSummeryList()));
		System.out.println("Total price of all villas = " + StructureService.sumOfVillaPrices(DataService.getVillaList()));
		System.out.println("Total price of all structures = " + StructureService.sumOfAllStructurePrices(DataService.getStructureList()));

		System.out.println("Average squaremeter of all structures = " + StructureService.averageSquareMetersOfAllStructures(DataService.getStructureList()));
		System.out.println("Average squaremeter of all villas = " + StructureService.averageSquareMetersOfVillas(DataService.getVillaList()));
		System.out.println("Average squaremeter of all summeries = " + StructureService.averageSquareMetersOfSummeries(DataService.getSummeryList()));
		System.out.println("Average squaremeter of all houses = " + StructureService.averageSquareMetersOfHouses(DataService.getHouseList()));

		Map<String, List<Structure>> groupByTypes = StructureService.filterStructuresByTypes(DataService.getStructureList());
//		SpringApplication.run(HousetypesApplication.class, args);
	}

}
