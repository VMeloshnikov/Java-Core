package practice;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер для поиска: ");
        String number = scanner.nextLine();
        List<String> numberList = new ArrayList<>(CoolNumbers.generateCoolNumbers());
        HashSet<String> hashSet = new HashSet<>(numberList);
        TreeSet<String> treeSet = new TreeSet<>(numberList);
        Collections.shuffle(numberList);
        long brutForce = System.nanoTime();
        long binary = System.nanoTime();
        long hash = System.nanoTime();
        long tree = System.nanoTime();
        while (true) {
            String result = CoolNumbers.bruteForceSearchInList(numberList, number) ? "найден" : "не найден";
            System.out.printf("Поиск перебором: номер %s, поиск занял %dнс" + System.lineSeparator(), result, brutForce);
            Collections.sort(numberList);
            result = CoolNumbers.binarySearchInList(numberList, number) ? "найден" : "не найден";
            System.out.printf("Бинарный поиск: номер %s, поиск занял %dнс" + System.lineSeparator(), result, binary);
            result = CoolNumbers.searchInHashSet(hashSet, number) ? "найден" : "не найден";
            System.out.printf("Поиск в HashSet: номер %s, поиск занял %dнс" + System.lineSeparator(), result, hash);
            result = CoolNumbers.searchInTreeSet(treeSet, number) ? "найден" : "не найден";
            System.out.printf("Поиск в TreeSet: номер %s, поиск занял %dнс" + System.lineSeparator(), result, tree);
        break;
        }
    }
}
