package practice.twoDimensionalArray;

public class TwoDimensionalArray {

    public static final char SYMBOL = 'X';

    public static char[][] getTwoDimensionalArray(int size) {

        //TODO: Написать метод, который создаст двумерный массив char заданного размера.
        // массив должен содержать символ SYMBOL по диагоналям, пример для size = 3
        // [X,  , X]
        // [ , X,  ]
        // [X,  , X]

        char[][] cross = new char[size][size];
        for(int x = 0; x < cross.length; x++){
            for (int y = 0; y < cross[x].length; y++) {
                if (y == x || y == cross.length - 1 - x) {
                    cross[x][y] = 'X';
                } else {
                    cross[x][y] = ' ';
                }
                System.out.print(cross[x][y]);
            }
            System.out.println();
        }
        return cross;
    }
}


