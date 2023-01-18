package com.mrtkrkrt.housetypes.data;

public class Summery extends Structure{
    public Summery(int price, int squareMeters, String structureType) {
        super(price, squareMeters, structureType);
    }

    @Override
    public String toString() {
        return "Summery: {" +
                "price=" + super.getPrice() +
                ", squareMeters=" + super.getSquareMeters() +
                ", structureType='" + super.getStructureType() + '\'' +
                '}';
    }
}
