import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        System.out.println("start");
        var ref = new Object() {
            int z = 0;
        };
        Executors.newSingleThreadExecutor().submit(() -> {
            for (int i = 0; i < 1000000000; i++) {
                ref.z = (int) (ref.z + Long.parseLong(String.valueOf(i)));
            }
            System.out.println(ref.z);
        });
        System.out.println("finish");

    }
}

