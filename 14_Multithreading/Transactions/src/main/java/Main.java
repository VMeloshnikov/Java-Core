import java.util.concurrent.CyclicBarrier;

public class Main {

    Bank bank = new Bank();

    public static void main(String[] args)  {
        Bank bank = new Bank();
        bank.setNumberAccounts(10000);
        bank.setMaxSumOnAccount(999999);
        bank.addAccounts();
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_PURPLE = "\u001B[35m";
        final String ANSI_CYAN = "\u001B[36m";

        int numCore = Runtime.getRuntime().availableProcessors();
        bank.setNumIteration(10000/numCore);
        for (int i = 0; i < numCore; i++) {
            new Thread(bank).start();
        }
        try {
            Thread.sleep(65000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println(ANSI_CYAN + "счетчик переводов: " + ANSI_RESET + bank.getTransferCount());
        System.out.println(ANSI_CYAN + "баланс банка стартовый: " + ANSI_RESET  + bank.getBankBallanceStart());
        System.out.println(ANSI_CYAN + "количество заблокированных аккаунтов: "  + ANSI_RESET + Bank.getFraudList().size()
                + ANSI_CYAN + "- тестер количества операций проверки на фрод: "  + ANSI_RESET + bank.getFraudTestCounter());
        System.out.println(ANSI_CYAN + "количество запросов баланса: "  + ANSI_RESET + bank.getRecBalanceCount());
    }
}
