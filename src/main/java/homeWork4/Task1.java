package homeWork4;

// Find missing numbers in the array, assuming it should start with 1 and end with the last number in the array
public class Task1 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 9, 11};

        int[] missingNumbers = findMissingNumbers(array);

        if (missingNumbers.length > 0) {
            System.out.println("Missing numbers in the array:");
            for (int num : missingNumbers) {
                System.out.println(num);
            }
        } else {
            System.out.println("No missing numbers found!");
        }
    }

    // Method to find missing numbers in the array.
    public static int[] findMissingNumbers(int[] array) {
        int lastNumber = array[array.length - 1];
        int[] missingNumbers = new int[lastNumber];

        // Initialize the missingNumbers array with zeros

        for (int i = 1, j = 0; i <= lastNumber; i++) {
            if (j < array.length && array[j] == i) {
                j++;
            } else {
                missingNumbers[i - 1] = i;
            }
        }

        int count = 0;
        for (int num : missingNumbers) {
            if (num != 0) {
                count++;
            }
        }

        // Create a new array containing only the missing numbers w/o zeros
        int[] result = new int[count];
        count = 0;
        for (int num : missingNumbers) {
            if (num != 0) {
                result[count++] = num;
            }
        }

        return result;
    }
}
