package com.mrtkrkrt.housetypes.service;

import com.mrtkrkrt.housetypes.data.House;
import com.mrtkrkrt.housetypes.data.Structure;
import com.mrtkrkrt.housetypes.data.Summery;
import com.mrtkrkrt.housetypes.data.Villa;

import java.util.*;

public class StructureService{
    // TODO List house yerine lilst structure ordan house olanları filtrele?
    public static int sumOfHousePrices(List<House> houseList) {
        int sum = 0;
        for(House house: houseList) {
           sum += house.getPrice();
        }
        return sum;
    }

    public static int sumOfVillaPrices(List<Villa> villaList) {
        int sum = 0;
        for(Villa villa: villaList) {
            sum += villa.getPrice();
        }
        return sum;
    }

    public static int sumOfSummeryPrices(List<Summery> summeryList) {
        int sum = 0;
        for(Summery summery: summeryList) {
            sum += summery.getPrice();
        }
        return sum;
    }

    public static int sumOfAllStructurePrices(List<Structure> structureList) {
        int sum = 0;
        for(Structure structure: structureList) {
            sum += structure.getPrice();
        }
        return sum;
    }

    public static double averageSquareMetersOfHouses(List<House> houseList) {
        double sum = 0;
        for(House house: houseList) {
            sum += house.getSquareMeters();
        }
        return sum / houseList.size();
    }

    public static double averageSquareMetersOfVillas(List<Villa> villaList) {
        double sum = 0;
        for(Villa villa: villaList) {
            sum += villa.getSquareMeters();
        }
        return sum / villaList.size();
    }

    public static double averageSquareMetersOfSummeries(List<Summery> summeryList) {
        double sum = 0;
        for(Summery summery: summeryList) {
            sum += summery.getSquareMeters();
        }
        return sum / summeryList.size();
    }

    public static double averageSquareMetersOfAllStructures(List<Structure> structureList) {
        double sum = 0;
        for(Structure structure: structureList) {
            sum += structure.getSquareMeters();
        }

        return sum / structureList.size();
    }

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
