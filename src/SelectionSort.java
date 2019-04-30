import java.util.Arrays;

public class SelectionSort {

    public static void main(String... args) {
        int[] elements = new int[1000];
        int q = elements.length;
        for(int i = 0; i < elements.length; i++)
            elements[i] = q--;

        System.out.println(Arrays.toString(elements));
        selectionSort(elements);
        System.out.println(Arrays.toString(elements));

    }

    /**
     * @param elements Array of integers to be sorted.
     */
    public static void selectionSort(int[] elements) {
        elements = selectionSort(Integer.MAX_VALUE, 0, elements);
    }

    public static int[] selectionSort(int min, int index, int[] els) {
        if(index == els.length-1)
            return els;

        int tempIndx = -1;
        for(int i = index; i < els.length; i++) {
            int el = els[i];
            if(el < min) {
                min = el;
                tempIndx = i;
            }
        }
        int temp = els[index];
        els[index] = els[tempIndx];
        els[tempIndx] = temp;

        return selectionSort(Integer.MAX_VALUE, index+1, els);
    }


}
