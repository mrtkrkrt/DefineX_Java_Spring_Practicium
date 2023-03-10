package service;

import data.House;
import data.Structure;
import data.Summery;
import data.Villa;

import java.util.ArrayList;
import java.util.List;

public class DataService {

    private static final List<Structure> structureList = new ArrayList<>();

    // Create all structure objects and add to the list;
    public static void createStructures() {
        Structure house1 = new House(35000, 85, "3+1");
        Structure house2 = new House(40000, 90, "2+1");
        Structure house3 = new House(45000, 95, "1+1");

        structureList.add(house1);
        structureList.add(house2);
        structureList.add(house3);

        Structure villa1 = new Villa(55000, 85, "5+1");
        Structure villa2 = new Villa(75000, 55, "3+1");
        Structure villa3 = new Villa(105000, 105, "4+1");

        structureList.add(villa1);
        structureList.add(villa2);
        structureList.add(villa3);

        Structure summery1 = new Summery(100000, 50, "2+1");
        Structure summery2 = new Summery(120000, 55, "3+1");
        Structure summery3 = new Summery(110000, 52, "2+1");

        structureList.add(summery1);
        structureList.add(summery2);
        structureList.add(summery3);
    }

    public static List<Structure> getStructureList() {
        return structureList;
    }


    // Extract House objects from all structure objects and return as a list
    public static List<House> getHouseList() {
        List<House> houseList = new ArrayList<>();

        for(Structure structure: structureList) {
            if (structure instanceof House) {
                houseList.add((House) structure);
            }
        }

        return houseList;
    }

    // Extract Villa objects from all structure objects and return as a list
    public static List<Villa> getVillaList() {
        List<Villa> villaList = new ArrayList<>();

        for (Structure structure: structureList) {
            if (structure instanceof Villa) {
                villaList.add((Villa) structure);
            }
        }

        return villaList;
    }

    // Extract Summery objects from all structure objects and return as a list
    public static List<Summery> getSummeryList() {
        List<Summery> summeryList = new ArrayList<>();

        for (Structure structure: structureList) {
            if (structure instanceof Summery) {
                summeryList.add((Summery) structure);
            }
        }

        return summeryList;
    }
}
