public class Courier {



    public Courier(double weight, String address, boolean dnt, String registrationNumber,
                   boolean fragile, Dimensions dimensions) {
        this.weight = weight;
        this.address = address;
        this.dnt = dnt;
        this.registrationNumber = registrationNumber;
        this.fragile = fragile;
        this.dimensions = dimensions;
    }

    private final double weight;
    private final String address;
    private final boolean dnt;
    private final String registrationNumber;
    private final boolean fragile;
    private Dimensions dimensions;

    public Courier setWeight(double weight) {
        return new Courier(weight , address , dnt , registrationNumber , fragile, dimensions);
    }

    public Courier setAddress(String address) {
        return new Courier(weight , address , dnt , registrationNumber , fragile , dimensions);
    }

    public Courier setDnt(boolean dnt) {
        return new Courier(weight , address , dnt , registrationNumber , fragile, dimensions);
    }

    public Courier setRegistrationNumber(String registrationNumber) {
        return new Courier(weight , address , dnt , registrationNumber , fragile , dimensions);
    }

    public Courier setFragile(boolean fragile) {
        return new Courier(weight , address , dnt , registrationNumber , fragile , dimensions);
    }
    public Courier setDimensions(Dimensions dimensions) {
        return new Courier(weight , address , dnt , registrationNumber , fragile , dimensions);
    }



    public double getWeight() {
        return weight;
    }

    public String getAddress() {
        return address;
    }

    public boolean isDnt() {
        return dnt;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public boolean isFragile() {
        return fragile;
    }
    public double getDimensions() {
        return dimensions.getHeight() * dimensions.getLength() * dimensions.getWidth();
    }

}
