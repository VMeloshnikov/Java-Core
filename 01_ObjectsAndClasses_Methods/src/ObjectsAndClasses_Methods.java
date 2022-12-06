

public class ObjectsAndClasses_Methods {

    public static void main(String[] args) {
        Basket petyaBasket = new Basket();
        petyaBasket.add("мясо", 400, 2, 4.6);
        petyaBasket.add("кости", 300, 3, 9.2);
        petyaBasket.print("Корзина Пети: ");
        System.out.println("Всего товаров в корзине: " + petyaBasket.getTotalCount());

        Basket genaBasket = new Basket();
        genaBasket.add("Уголь", 100, 2, 350);
        genaBasket.add("Мангал", 400, 1, 1340.5);
        genaBasket.print("Корзина Гены");
        System.out.println("Всего товаров в корзине: " + genaBasket.getTotalCount());

        Basket katyaBasket = new Basket();
        katyaBasket.add("Вино", 1000, 2, 750);
        katyaBasket.add("Сок", 200, 2, 2000);
        katyaBasket.print("Корзина Кати");
        System.out.println("Всего товаров в корзине: " + katyaBasket.getTotalCount());

        System.out.println("\nВ корзины добавлено: " + Basket.getAllBasketCount() + " товара(ов)");
        System.out.println("На сумму: " + Basket.getAllBasketPrice() + " Rub.");
        System.out.println("Средняя стоимость единицы товара: " + Basket.avaregeUnitPrice());
        System.out.println("Средняя стоимость корзины: " + Basket.avaregeBasketPrice());






    }
}
