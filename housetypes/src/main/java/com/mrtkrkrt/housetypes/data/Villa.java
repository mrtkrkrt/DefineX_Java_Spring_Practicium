package com.mrtkrkrt.housetypes.data;

public class Villa extends Structure {

    public Villa(int price, int squareMeters, String structureType) {
        super(price, squareMeters, structureType);
    }
    @Override
    public String toString() {
        return "Villa: {" +
                "price=" + super.getPrice() +
                ", squareMeters=" + super.getSquareMeters() +
                ", structureType='" + super.getStructureType() + '\'' +
                '}';
    }
}
