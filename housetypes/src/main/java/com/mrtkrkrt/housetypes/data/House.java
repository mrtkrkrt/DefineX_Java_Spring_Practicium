package com.mrtkrkrt.housetypes.data;

public class House extends Structure{

    public House(int price, int squareMeters, String structureType) {
        super(price, squareMeters, structureType);
    }

    @Override
    public String toString() {
        return "House: {" +
                "price=" + super.getPrice() +
                ", squareMeters=" + super.getSquareMeters() +
                ", structureType='" + super.getStructureType() + '\'' +
                '}';
    }
}
