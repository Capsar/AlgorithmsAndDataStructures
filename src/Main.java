import java.util.ArrayList;
import java.util.Arrays;

public class Main {


    public static void main(String... args) {

    }



    /**
     * int num1 = -45;
     * int num2 = 100;
     * int multi = multiply(num1, num2);
     * System.out.println(multi);
     **/

    static int multiply(int num1, int num2) {
        if (num1 == 0 || num2 == 0)
            return 0;
        if (num1 > 0) {
            return num2 + multiply(num1 - 1, num2);
        } else if (num1 < 0) {
            return -num2 + multiply(num1 + 1, num2);
        }
        return num1;
    }

    /**
     * int cols = 10;
     * int rows = 20;
     * double[][] a = new double[rows][cols];
     * double d = 0.0;
     * for(int x = 0; x < rows; x++) {
     * for(int y = 0; y < cols; y++) {
     * a[x][y] = d;
     * d += 1;
     * }
     * }
     * <p>
     * for (double[] row : a) {
     * System.out.println(Arrays.toString(row));
     * }
     * <p>
     * double[][] b = clone(a);
     * <p>
     * for(int x = 0; x < rows; x++) {
     * for(int y = 0; y < cols; y++) {
     * a[x][y] = d;
     * d += 1;
     * }
     * }
     * <p>
     * for (double[] row : a) {
     * System.out.println(Arrays.toString(row));
     * }
     * <p>
     * for (double[] row : b) {
     * System.out.println(Arrays.toString(row));
     * }
     **/
    static double[][] clone(double[][] a) {
        double[][] b = new double[a.length][];
        for (int i = 0; i < a.length; i++) {
            double[] aa = a[i];
            double[] bb = new double[aa.length];
            for (int j = 0; j < aa.length; j++) {
                bb[j] = aa[j];
            }
            b[i] = bb;
        }
        return b;
    }


    /**
     * ArrayList<Integer> list = new ArrayList<Integer>();
     * int[] ar = new int[] {5,1,5,9,8};
     * for(int i : ar)
     * list.add(i);
     * <p>
     * removeLastOccurrence(5, list);
     * System.out.println(list);
     * removeAll(list);
     * System.out.println(list);
     * <p>
     * Removes all elements from the ArrayList, using the removeLastOccurrence method.
     *
     * @param list to remove the elements from.
     */
    public static void removeAll(ArrayList<Integer> list) {
        while (!list.isEmpty()) {
            removeLastOccurrence(list.get(list.size() - 1), list);
        }
    }

    /**
     * Takes an ArrayList and removes last occurrence of x,
     * shifting the rest of the elements left.
     * I.e. [5, 1, 5, 9, 8], with x = 5
     * would result in: [5, 1, 9, 8].
     * Note that this method does not return a new list.
     * Instead, the list that is passed as a parameter is changed.
     *
     * @param list to remove an element from.
     * @param x    element value to look for
     */
    public static void removeLastOccurrence(int x, ArrayList<Integer> list) {
        int indexToRemove = -1;
        for (int i = list.size() - 1; i >= 0; i--) {
            int num = list.get(i);
            if (num == x) {
                indexToRemove = i;
                break;
            }
        }
        if (indexToRemove != -1) {
            list.remove(indexToRemove);
        }
    }


    /**
     * Takes the array and the last occurring element x,
     * shifting the rest of the elements left. I.e.
     * [1, 4, 7, 9], with x=7 would result in:
     * [1, 4, 9].
     * <p>
     * int[] arr = {1,2,3,4,7,7,9};
     * int x = 7;
     * System.out.println(Arrays.toString(removeLastOccurrence(x, arr)));
     *
     * @param x   the entry to remove from the array
     * @param arr to remove an entry from
     * @return the updated array, without the last occurrence of x
     */
    public static int[] removeLastOccurrence(int x, int[] arr) {
        int indexToBeRemoved = -1;
        for (int i = 0; i < arr.length; i++) {
            int ar = arr[i];
            if (ar == x) {
                indexToBeRemoved = i;
            }
        }
        if (indexToBeRemoved != -1) {
            int[] newArr = new int[arr.length - 1];
            int newIndex = 0;
            for (int i = 0; i < arr.length; i++) {
                if (i == indexToBeRemoved)
                    continue;
                newArr[newIndex] = arr[i];
                newIndex++;
            }
            arr = newArr;
        }
        return arr;
    }

}
