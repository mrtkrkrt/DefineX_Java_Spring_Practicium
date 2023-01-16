package com.mrtkrkrt.housetypes.service;

import com.mrtkrkrt.housetypes.dto.House;
import com.mrtkrkrt.housetypes.dto.IStructure;
import com.mrtkrkrt.housetypes.dto.Summery;
import com.mrtkrkrt.housetypes.dto.Villa;

import java.util.List;

public class StructureService{
    // TODO List house yerine lilst structure ordan house olanları filtrele?
    public static int sumOfHousePrices(List<IStructure> iStructures) {
        int sum = 0;
        for(IStructure structure: iStructures) {
            if (structure.getClass() == House.class) {
                sum += structure.getPrice();
            }
        }
        return sum;
    }

    public static int sumOfVillaPrices(List<IStructure> structures) {
        int sum = 0;
        for(IStructure structure: structures) {
            if (structure.getClass() == Villa.class) {
                sum += structure.getPrice();
            }
        }
        return sum;
    }

    public static int sumOfSummeryPrices(List<IStructure> iStructures) {
        int sum = 0;
        for(IStructure structure: iStructures) {
            if (structure.getClass() == Summery.class) {
                sum += structure.getPrice();
            }
        }
        return sum;
    }

    public static int sumOfAllStructurePrices(List<IStructure> structures) {
        int sum = 0;
        for(IStructure iStructure: structures) {
            sum += iStructure.getPrice();
        }
        return sum;
    }

    public static double averageSquareMetersOfHouses(List<IStructure> structures) {
        int sum = 0;
        int houseCount = 0;
        for(IStructure structure: structures) {
            if (structure.getClass() == House.class) {
                sum += structure.getSquareMeters();
                houseCount += 1;
            }
        }
        return sum / houseCount;
    }

    public static double averageSquareMetersOfVillas(List<IStructure> structures) {
        int sum = 0;
        int villaCount = 0;
        for(IStructure structure: structures) {
            if (structure.getClass() == Villa.class) {
                sum += structure.getSquareMeters();
                villaCount += 1;
            }
        }
        return sum / villaCount;
    }

    public static double averageSquareMetersOfSummeries(List<IStructure> structures) {
        int sum = 0;
        int summeryCount = 0;
        for(IStructure structure: structures) {
            if (structure.getClass() == Summery.class) {
                sum += structure.getSquareMeters();
                summeryCount += 1;
            }
        }
        return sum / summeryCount;
    }

    public static double averageSquareMetersOfAllStructures(List<IStructure> iStructures) {
        int sum = 0;
        for(IStructure iStructure: iStructures) {
            sum += iStructure.getSquareMeters();
        }

        return sum / iStructures.size();
    }


}
