public class Manager implements Employee {

    private static final int FIX_SALARY = 50_000;
    private final int earningsForCompany;

    public Manager() {
        this.earningsForCompany = (int) (Math.random() * 25_000) + 115_000;
    }

    public int getMonthSalary() {
        return FIX_SALARY + (int) (earningsForCompany * 0.05);
    }
}
