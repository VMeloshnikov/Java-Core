

public class ObjectsAndClasses_Methods {

    public static void main(String[] args) {
        Basket petyaBasket = new Basket();
        petyaBasket.add("����", 400, 2, 4.6);
        petyaBasket.add("�����", 300, 3, 9.2);
        petyaBasket.print("������� ����: ");
        System.out.println("����� ������� � �������: " + petyaBasket.getTotalCount());

        Basket genaBasket = new Basket();
        genaBasket.add("�����", 100, 2, 350);
        genaBasket.add("������", 400, 1, 1340.5);
        genaBasket.print("������� ����");
        System.out.println("����� ������� � �������: " + genaBasket.getTotalCount());

        Basket katyaBasket = new Basket();
        katyaBasket.add("����", 1000, 2, 750);
        katyaBasket.add("���", 200, 2, 2000);
        katyaBasket.print("������� ����");
        System.out.println("����� ������� � �������: " + katyaBasket.getTotalCount());

        System.out.println("\n� ������� ���������: " + Basket.getAllBasketCount() + " ������(��)");
        System.out.println("�� �����: " + Basket.getAllBasketPrice() + " Rub.");
        System.out.println("������� ��������� ������� ������: " + Basket.avaregeUnitPrice());
        System.out.println("������� ��������� �������: " + Basket.avaregeBasketPrice());






    }
}
