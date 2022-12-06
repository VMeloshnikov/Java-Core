package practice;

import java.util.*;

public class CoolNumbers {

    public static ArrayList<String> coolRusNumbers = new ArrayList<>();

    public static List<String> generateCoolNumbers() {
        String letter = "А В Е К М Н О Р С Т У Х";
        String[] region = new  String[199];
        int startRegion = 1;
        String[] letterRussian = letter.split(" ");
        String fullString = "";
        for (int i = 0; i < region.length; i++) {
            region[i] = Integer.toString(startRegion++);
            for (int a = 0; a < letterRussian.length; a++) {
                for (int n = 111; n <= 999; n += 111) {
                    String numbers = Integer.toString(n);
                    for (int b = 0; b < letterRussian.length; b++) {
                        for (int c = 0; c < letterRussian.length; c++) {
                            if(i < 10) {
                                fullString = letterRussian[a].concat(numbers).
                                        concat(letterRussian[b]).concat(letterRussian[c]).
                                        concat("0".concat(region[i]));
                                coolRusNumbers.add(fullString);
                            } else {
                                fullString = letterRussian[a].concat(numbers).concat
                                        (letterRussian[b]).concat(letterRussian[c]).concat(region[i]);
                                coolRusNumbers.add(fullString);
                            }
                        }
                    }
                }
            }
        }
        return coolRusNumbers;
    }



    public static boolean bruteForceSearchInList(List<String> list, String number) {
        return list.contains(number);
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {
        Collections.sort(sortedList);
        return Collections.binarySearch(sortedList, number) >= 0;
    }

    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        return hashSet.contains(number);
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        return treeSet.contains(number);
    }
}

