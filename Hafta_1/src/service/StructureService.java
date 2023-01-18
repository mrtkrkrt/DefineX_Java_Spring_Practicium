package service;

import data.House;
import data.Structure;
import data.Summery;
import data.Villa;

import java.util.*;

public class StructureService{

    // Return sum price of house list
    public static int sumOfHousePrices(List<House> houseList) {
        int sum = 0;
        for(House house: houseList) {
           sum += house.getPrice();
        }
        return sum;
    }

    // Return sum price of villa list
    public static int sumOfVillaPrices(List<Villa> villaList) {
        int sum = 0;
        for(Villa villa: villaList) {
            sum += villa.getPrice();
        }
        return sum;
    }

    // Return sum price of summery list
    public static int sumOfSummeryPrices(List<Summery> summeryList) {
        int sum = 0;
        for(Summery summery: summeryList) {
            sum += summery.getPrice();
        }
        return sum;
    }

    // Return sum price of all structures
    public static int sumOfAllStructurePrices(List<Structure> structureList) {
        int sum = 0;
        for(Structure structure: structureList) {
            sum += structure.getPrice();
        }
        return sum;
    }


    // Return average Squaremeter of Houses
    public static double averageSquareMetersOfHouses(List<House> houseList) {
        double sum = 0;
        for(House house: houseList) {
            sum += house.getSquareMeters();
        }
        return sum / houseList.size();
    }

    // Return average Squaremeter of Villas
    public static double averageSquareMetersOfVillas(List<Villa> villaList) {
        double sum = 0;
        for(Villa villa: villaList) {
            sum += villa.getSquareMeters();
        }
        return sum / villaList.size();
    }

    // Return average Squaremeter of Summeries
    public static double averageSquareMetersOfSummeries(List<Summery> summeryList) {
        double sum = 0;
        for(Summery summery: summeryList) {
            sum += summery.getSquareMeters();
        }
        return sum / summeryList.size();
    }

    // Return average Squaremeter of all structures
    public static double averageSquareMetersOfAllStructures(List<Structure> structureList) {
        double sum = 0;
        for(Structure structure: structureList) {
            sum += structure.getSquareMeters();
        }

        return sum / structureList.size();
    }

    // Filter all structures and group on list by structure types
    public static Map<String, List<Structure>> filterStructuresByTypes(List<Structure> structureList) {
        Map<String, List<Structure>> groupByTypes = new HashMap<>();
        Set<String> typesSet = new HashSet<>();

        for(Structure structure: structureList) {
            typesSet.add(structure.getStructureType());
        }

        for (String type: typesSet) {
            List<Structure> temp = new ArrayList<>();
            for(Structure structure: structureList) {
                if (structure.getStructureType().equals(type)) {
                    temp.add(structure);
                }
            }
            groupByTypes.put(type, temp);
        }

        return groupByTypes;
    }
}
