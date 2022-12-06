import org.jetbrains.annotations.NotNull;

public class Account {
    private long money;
    private String accNumber;

    public Account(String accNumber, long money) {
        this.money = money;
        this.accNumber = accNumber;
    }

    public Account() {

    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public  void setAccNumber(@NotNull String accNumber) {
        final String INVOICETEMPLATE = "40817810000000000000";
        final String WEIGHTING_FACTOR = "71371371371371371371";
        int rez1 = 0;
        String rez2;
        String accNumberStart = INVOICETEMPLATE
                .substring(0, (INVOICETEMPLATE.length() - accNumber.length())) + accNumber;
        for (int i = 0; i < accNumberStart.length(); i++) {
            int rezultMid = Character.getNumericValue(accNumberStart.charAt(i))
                    * Character.getNumericValue(WEIGHTING_FACTOR.charAt(i));
            rez1 = rez1 + Character.getNumericValue(Integer.toString(rezultMid)
                    .charAt(Integer.toString(rezultMid).length() - 1));
        }
        rez2 = Integer.toString(rez1);

        int rezultKey = Character.getNumericValue(rez2.charAt(rez2.length() - 1)) * 3;
        String key = Character.toString(Integer.toString(rezultKey).charAt(Integer.toString(rezultKey).length() - 1));

        this.accNumber = INVOICETEMPLATE.substring(0, 8)
                + key
                + INVOICETEMPLATE.substring(9, INVOICETEMPLATE.length() - accNumber.length())
                + accNumber;


    }
}
