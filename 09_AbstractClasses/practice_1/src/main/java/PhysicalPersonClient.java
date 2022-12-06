public class PhysicalPersonClient extends Client {
    @Override
    void getName(String name) {
        this.name = "Физическое лицо";
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public void put(double amount) {
        if (amount > 0) {
            this.amount = getAmount() + amount;
        } else {
            System.out.println("Неверная сумма пополнения!");
        }
    }


    @Override
    public void take(double amount) {
        if (amount > 0 && amount < getAmount()) {
            this.amount = getAmount() - amount;
        } else {
            System.out.println("Неверная сумма");
        }
    }
}

