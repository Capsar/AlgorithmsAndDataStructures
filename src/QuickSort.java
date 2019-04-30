import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    private static int numberOfSwaps = 0;

    public static void main(String... args) {
        int[] elements = new int[20000];
        int q = elements.length;
        for (int i = 0; i < elements.length; i++)
            elements[i] = q--;

        System.out.println("Begin: " + Arrays.toString(elements));
        long time = System.nanoTime()/1000;
        quickSort(elements);
        long timeAfter = System.nanoTime()/1000;
        System.out.println(timeAfter-time);
        System.out.println("Number of swaps: " + numberOfSwaps);
        System.out.println("End: " + Arrays.toString(elements));

    }

    public static void quickSort(int[] elements) {
        sort(elements, 0, elements.length - 1);
    }

    private static void sort(int[] elements, int low, int high) {
        if (low < high + 1) {
            int p = partition(elements, low, high);
            sort(elements, low, p - 1);
            sort(elements, p + 1, high);
        }
    }

    private static int partition(int[] elements, int low, int high) {
        swap(elements, low, pivot(low, high));
        int border = low + 1;
        for (int i = border; i <= high; i++) {
            if (elements[i] < elements[low]) {
                swap(elements, i, border++);
            }
        }
        swap(elements, low, border - 1);
        return border - 1;
    }

    private static int pivot(int low, int high) {
        return new Random().nextInt(high-low+1) + low;
    }

    private static void swap(int[] elements, int i1, int i2) {
        numberOfSwaps++;
        int temp = elements[i1];
        elements[i1] = elements[i2];
        elements[i2] = temp;
    }
}
