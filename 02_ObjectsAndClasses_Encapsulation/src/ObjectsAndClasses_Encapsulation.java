import java.util.Scanner;

public class ObjectsAndClasses_Encapsulation {
    public static void main(String[] args) {
        Elevator elevator = new Elevator(-3, 26);

        while (true) {
            System.out.print("\nВведите номер этажа: ");
            int floor = new Scanner(System.in).nextInt();
            elevator.move(floor);

        Courier firstAddress = new Courier(5.5, "Омск", false,
                "asf123", false, new Dimensions(0.3 , 0.2 , 0.1));


        Courier secondAddress = new Courier(4.4, "Томск", true,
                "fds321", true, new Dimensions(1 , 0.3 , 0.5) );


            System.out.println("Первый адрес: " + firstAddress.getAddress() +
                    "\nВес: " + firstAddress.getWeight() + " кг. " +
                    "\nРегистрационный код: " + firstAddress.getRegistrationNumber() +
                    "\nОбъем груза: " + firstAddress.getDimensions() + " М*3"
            );
            System.out.println();

            System.out.println("Второй адрес: " + secondAddress.getAddress() +
                    "\nВес: " + secondAddress.getWeight() + " кг. " +
                    "\nРегистрационный код: " + secondAddress.getRegistrationNumber() +
                    "\nОбъем груза: " + secondAddress.getDimensions() + " М*3"
            );

        }
    }
}
