import java.util.*;

public class BucketSort {

        @SuppressWarnings("unchecked")
        public static Queue<Integer>[] fillBuckets(int[] array) {
            if(array.length == 0)
                return new Queue[0];

            int vmin = array[0];
            int vmax = array[0];
            for(int i = 1; i < array.length; i++) {
                int j = array[i];
                    if (j > vmax)
                        vmax = j;
                    else if (j < vmin)
                        vmin = j;
            }
            int bucketCount = vmax - vmin + 1;
            Queue<Integer>[] buckets = new Queue[bucketCount];
            for(int i = 0; i < bucketCount; i++) {
                buckets[i] = new PriorityQueue<Integer>();
            }
            for(int i = 0; i < array.length; i++) {
                buckets[array[i] - vmin].add(array[i]);
            }
            return buckets;
        }

        public static int[] readBuckets(Queue<Integer>[] buckets) {
            int size = 0;
            for(Queue<Integer> queue : buckets) {
                size += queue.size();
            }
            int[] array = new int[size];
            size = 0;
            for(Queue<Integer> queue : buckets) {
                while(!queue.isEmpty()) {
                    array[size] = queue.remove();
                    size++;
                }
            }
            return array;
        }

}