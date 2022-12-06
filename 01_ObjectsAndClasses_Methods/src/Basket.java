public class Basket {

    private static int count = 0;
    private int totalCount;
    private String items;
    private static int totalPrice;
    private int limit;
    private double totalWeight;
    private static int allBasketCount;
    private static int allBasketPrice;
    private static double avaregeUnitPrice;
    private static double avaregeBasketPrice;

    public Basket() {
        increaseCount(1);
        items = "Список товаров:";
        this.limit = 1000000;


    }

    public Basket(int limit) {
        this();
        this.limit = limit;
    }

    public Basket(String items, int totalPrice) {
        this();
        this.items = this.items + items;
        this.totalPrice = totalPrice;

    }
        public static int getCount() {
        return count;
    }
    public static int getTotalPrice() {
        return totalPrice;
    }
    public static double avaregeUnitPrice() {
        return avaregeUnitPrice;
    }
    public static double avaregeBasketPrice () {
        return avaregeBasketPrice;
    }

    public static void increaseCount(int count) {
        Basket.count = Basket.count + count;
    }

    public void add(String name, int price) {
        add(name, price, 1);
    }

    public void add(String name, int price, int count) {
        boolean error = false;
        if (contains(name)) {
            error = true;
        }

        if (totalPrice + count * price >= limit) {
            error = true;
        }

        if (error) {
            System.out.println("Error occured :(");
            return;
        }

    }

    public void add(String name, int price, int count, double weight){
        add(name, price,count);
        this.totalWeight = this.totalWeight + weight;
        totalCount = totalCount + (count);
        allBasketCount = allBasketCount + Basket.getCount();
        allBasketPrice = allBasketPrice + (count * price);
        avaregeUnitPrice = allBasketPrice / allBasketCount;
        avaregeBasketPrice = allBasketPrice / Basket.count;

        items = items + "\n" + name + " - " +
                count + " шт. - "
                + price + " руб. - "
                + weight + " гр.";
    }

    public  double getTotalWeight(){
        return this.totalWeight;
    }
    public void clear() {
        this.items = "";
        this.totalPrice = 0;
        this.totalWeight = 0;
    }

    public static int getAllBasketPrice() {
        return allBasketPrice;
    }
    public int getTotalCount() {
        return totalCount;
    }
    public static int getAllBasketCount() {
        return allBasketCount;
    }

    public boolean contains(String name) {
        return items.contains(name);
    }

    public void print(String title) {
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
        }
    }
}
