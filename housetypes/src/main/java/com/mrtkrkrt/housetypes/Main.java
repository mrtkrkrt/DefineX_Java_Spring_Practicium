package com.mrtkrkrt.housetypes;

import com.mrtkrkrt.housetypes.data.Structure;
import com.mrtkrkrt.housetypes.service.DataService;
import com.mrtkrkrt.housetypes.service.StructureService;

import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		DataService.createStructures();
		System.out.println("Total price of all houses = " + StructureService.sumOfHousePrices(DataService.getHouseList()));
		System.out.println();
		System.out.println("Total price of all summeries = " + StructureService.sumOfSummeryPrices(DataService.getSummeryList()));
		System.out.println();
		System.out.println("Total price of all villas = " + StructureService.sumOfVillaPrices(DataService.getVillaList()));
		System.out.println();
		System.out.println("Total price of all structures = " + StructureService.sumOfAllStructurePrices(DataService.getStructureList()));

		System.out.println();
		System.out.println("Average squaremeter of all structures = " + StructureService.averageSquareMetersOfAllStructures(DataService.getStructureList()));
		System.out.println();
		System.out.println("Average squaremeter of all villas = " + StructureService.averageSquareMetersOfVillas(DataService.getVillaList()));
		System.out.println();
		System.out.println("Average squaremeter of all summeries = " + StructureService.averageSquareMetersOfSummeries(DataService.getSummeryList()));
		System.out.println();
		System.out.println("Average squaremeter of all houses = " + StructureService.averageSquareMetersOfHouses(DataService.getHouseList()));
		System.out.println();

		Map<String, List<Structure>> groupByTypes = StructureService.filterStructuresByTypes(DataService.getStructureList());
		System.out.println("Group By Number Of Rooms");

		for (String key: groupByTypes.keySet()) {
			System.out.println(key + " Structures");
			System.out.println("--------------------------------");
			for (Structure structure: groupByTypes.get(key)) {
				System.out.println(structure.toString());
			}
			System.out.println();
		}
	}

}
