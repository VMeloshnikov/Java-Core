public class Main {
    public static void main(String[] args) {

        Container container = new Container();
        container.addCount(5672);
        System.out.println(container.getCount());

        for (int i = 0; i < 65536; i++) {
            char a = (char) i;
            if (a == '¨' || a == '¸') {
                System.out.println(i + " - " + a);
            } else if (a >= 'À' && a <= 'ÿ') {
                System.out.println(i + " - " + a);
            }
        }
    }
}
