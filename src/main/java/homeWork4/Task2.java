package homeWork4;

public class Task2 {
    public static void main(String[] args) {

        int[][] matrix = new int[10][10];
        int number = 0;
        int sum = 0;

//        0 0 0 0 0 0 0 0 0 0
//        0 1 0 0 0 0 0 0 0 0
//        0 0 2 0 0 0 0 0 0 0
//        0 0 0 3 0 0 0 0 0 0
//        0 0 0 0 4 0 0 0 0 0
//        0 0 0 0 0 5 0 0 0 0
//        0 0 0 0 0 0 6 0 0 0
//        0 0 0 0 0 0 0 7 0 0
//        0 0 0 0 0 0 0 0 8 0
//        0 0 0 0 0 0 0 0 0 9

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == j) {
                    matrix[i][j] = number;
                    number++;
                } else {
                    matrix[i][j] = 0;
                }
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // implementation
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }

        System.out.println("The sum of diagonal numbers is: " + sum);

    }
}