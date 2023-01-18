package data;

public abstract class Structure {
    private int price;
    private int squareMeters;
    private String structureType;

    public Structure(int price, int squareMeters, String structureType) {
        this.price = price;
        this.squareMeters = squareMeters;
        this.structureType = structureType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSquareMeters() {
        return squareMeters;
    }

    public void setSquareMeters(int squareMeters) {
        this.squareMeters = squareMeters;
    }

    public String getStructureType() {
        return structureType;
    }

    public void setStructureType(String structureType) {
        this.structureType = structureType;
    }

    @Override
    public String toString() {
        return "Structure{" +
                "price=" + price +
                ", squareMeters=" + squareMeters +
                ", structureType='" + structureType + '\'' +
                '}';
    }
}
