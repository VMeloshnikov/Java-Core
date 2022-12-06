public class IndividualEntrepreneurClient extends Client {


    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public void put(double amount) {
        if (amount > 0 && amount >= 1000) {
            this.amount = (getAmount() + amount) * smallPutComission;
        } else if
        (amount > 0 && amount < 1000) {
            this.amount = (getAmount() + amount) * bigPutComisson;
        } else {
            System.out.println("Неверная сумма пополнения!");
        }
    }


    @Override
    public void take(double amount) {
        if (amount > 0 && amount < getAmount()) {
            this.amount = (getAmount() - amount);
        } else {
            System.out.println("Неверная сумма");
        }
    }

    @Override
    void getName(String name) {
        this.name = "Индивидуальный предприниматель";
    }
}
