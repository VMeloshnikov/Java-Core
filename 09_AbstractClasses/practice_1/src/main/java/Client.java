public abstract class Client {
    protected double amount;
    protected String name;
    protected double takeComission = 0.99;
    protected double smallPutComission = 0.995;
    protected double bigPutComisson = 0.99;





    public double getAmount() {
        return amount;
    }


    public abstract void put(double amount);

    public abstract void take(double amount);
    abstract void getName (String name);

}
