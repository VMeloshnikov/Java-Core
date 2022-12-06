import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;


public class Bank implements Runnable {
    private static HashMap<String, Account> accounts = new HashMap<>();
    private static List<String> fraudList = new ArrayList<>();
    private AtomicInteger transfersCount = new AtomicInteger();
    private AtomicInteger balanceRequestsCount = new AtomicInteger();
    private long numberAccounts;
    private long maxSumOnAccount;
    private int fraudTestCounter;
    private final Random random = new Random();
    private int recBalanceCount = 0;
    private int transferCount = 0;
    private long bankBallanceStart = 0;
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_PURPLE = "\u001B[35m";

    public void setNumIteration(long numIteration) {
        this.numIteration = numIteration;
    }

    private long numIteration = 0;

    public int getBalanceRequestsCount() {
        return balanceRequestsCount.get();
    }

    public void setBalanceRequestsCount(int balanceRequestsCount) {
        this.balanceRequestsCount.set(balanceRequestsCount);
    }

    public void setTransfersCount(int transfersCount) {
        this.transfersCount.set(transfersCount);
    }

    public int getTransfersCount() {
        return transfersCount.get();
    }

    public static void setAccounts(HashMap<String, Account> accounts) {
        Bank.accounts = accounts;
    }

    public int getFraudTestCounter() {
        return fraudTestCounter;
    }

    public int getRecBalanceCount() {
        return recBalanceCount;
    }

    public int getLenth() {
        return lenth;
    }

    private int lenth = 0;

    public long getBankBallanceStart() {
        return bankBallanceStart;
    }

    public static List<String> getFraudList() {
        return fraudList;
    }

    public int getTransferCount() {
        return transferCount;
    }

    public void setMaxSumOnAccount(long maxSumOnAccount) {
        this.maxSumOnAccount = maxSumOnAccount;
    }

    public void setNumberAccounts(long numberAccounts) {
        this.numberAccounts = numberAccounts;
    }

    public void addAccounts() {

        for (int i = 0; i < numberAccounts; i++) {
            Account account = new Account();
            account.setAccNumber(String.valueOf(i));
            account.setMoney((long) (Math.random() * maxSumOnAccount));
            accounts.put(String.valueOf(i), new Account(account.getAccNumber(), account.getMoney()));
            bankBallanceStart = bankBallanceStart + account.getMoney();
        }
//        System.out.println("accounts.size(): " + accounts.size());
    }


    public void transfer(String fromAccountNum, String toAccountNum, long amount) throws InterruptedException {
        transferCount++;

        if (fraudList.contains(fromAccountNum)) {
            System.out.println(ANSI_RED + "Счет отправителя заблокирован! Транзакция не проведена!" + ANSI_RESET);
            lenth++;
            return;
        }
        if (fraudList.contains(toAccountNum)) {
            System.out.println(ANSI_RED + "Счет получателя заблокирован! Транзакция не проведена!" + ANSI_RESET);
            lenth++;
            return;
        }

        synchronized (Account.class) {
            if (accounts.get(fromAccountNum).getMoney() < amount) {
                System.out.println(ANSI_PURPLE + "счет: " + ANSI_RESET + accounts.get(fromAccountNum).getMoney()
                        + ANSI_PURPLE + " Размер перевода: " + ANSI_RESET + amount);
                System.out.println(ANSI_RED + "Недостаточно средств на счете №:" + ANSI_RESET + accounts.get(fromAccountNum).getAccNumber()
                        + ANSI_RED + " moneyAmmount: " + ANSI_RESET + accounts.get(fromAccountNum).getMoney());
                lenth++;
                return;
            }
            accounts.get(toAccountNum).setMoney(accounts.get(toAccountNum).getMoney() + amount);
            accounts.get(fromAccountNum).setMoney(accounts.get(fromAccountNum).getMoney() - amount);
            transfersCount.incrementAndGet();
            lenth++;
        }
        if (amount > 50000) {
            if (isFraud(fromAccountNum, toAccountNum)) {
                fraudList.add(fromAccountNum);
                fraudList.add(toAccountNum);
            }
        }
    }

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum) {
        try {
            wait(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        fraudTestCounter++;
        return random.nextBoolean();
    }

    public long getBalance(String accountNum) {
        recBalanceCount++;
        return accounts.get(accountNum).getMoney();
    }

    @Override
    public void run() {
        for (int j = 0; j < numIteration; j++) {
            String fromAccount = String.valueOf((int) (Math.random() * numberAccounts));
            String toAccount = String.valueOf((int) (Math.random() * numberAccounts));
            long transferSum = (long) (Math.random() * 52500);
            try {
                transfer(fromAccount, toAccount, transferSum);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int k = 0; k < (int) (Math.random() * 5 + 5); k++) {
                getBalance(String.valueOf((int) (Math.random() * numberAccounts)));
                recBalanceCount++;

            }
        }
    }

}



