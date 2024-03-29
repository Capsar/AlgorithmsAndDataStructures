import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Knapsack {

    public static Set<Item> knapsack(Set<Item> items, int budget) {
        Set<Item> ritems = new HashSet<Item>();
        if (items == null || items.isEmpty())
            return ritems;

        int n = items.size();
        int weights[] = new int[n];
        int values[] = new int[n];

        int ix = 0;
        for (Item item : items) {
            weights[ix] = item.getWeight();
            values[ix] = item.getValue();
            ix++;
        }
        int results[][] = new int[n + 1][budget + 1];
        for (int i = 0; i <= budget; i++) results[0][i] = 0;

        int backtracking[][] = new int[n + 1][budget + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= budget; j++) {
                if ((weights[i - 1] <= j) && (values[i - 1] + results[i - 1][j - weights[i - 1]] > results[i - 1][j])) {
                    results[i][j] = values[i - 1] + results[i - 1][j - weights[i - 1]];
                    backtracking[i][j] = 1;
                } else {
                    results[i][j] = results[i - 1][j];
                    backtracking[i][j] = 0;
                }
            }
        }

        int maxWeight = budget;
        for (int i = n; i >= 1; i--) {
            if (backtracking[i][maxWeight] == 1) {
                ritems.add(new Item(weights[i - 1], values[i - 1]));
                maxWeight -= weights[i - 1];
            }
        }
        return ritems;
    }

    private int n, W;  //number of items and maximum capacity
    private int w[], v[];  //weights and values of items
    private int V[][];  //table to store results of sub-problems

    private void initialize() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of items : ");
        n = sc.nextInt();  //number of items
        System.out.print("Enter W of knapsack : ");
        W = sc.nextInt();  //capacity of knapsack
        w = new int[n];
        v = new int[n];
        System.out.println("Enter ws and vs of items : ");
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();  //weight of item
            v[i] = sc.nextInt();  //profit of item
        }
        V = new int[n + 1][W + 1];  //initializing the table to hold results
        for (int i = 0; i <= W; i++) V[0][i] = 0;
    }

    public void knapsack() {
        //table for backtracking to get the items chosen
        int x[][] = new int[n + 1][W + 1];
        //filling tables
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if ((w[i - 1] <= j) && (v[i - 1] + V[i - 1][j - w[i - 1]] > V[i - 1][j])) {
                    V[i][j] = v[i - 1] + V[i - 1][j - w[i - 1]];
                    x[i][j] = 1;
                } else {
                    V[i][j] = V[i - 1][j];
                    x[i][j] = 0;
                }
            }
        }
        //backtracking
        System.out.printf("Items Chosen\n%5s%7s%7s\n", "Item", "Weight", "Profit");
        int K = W;
        for (int i = n; i >= 1; i--)
            if (x[i][K] == 1) {
                System.out.printf("%5d%7d%7d\n", i, w[i - 1], v[i - 1]);
                K -= w[i - 1];
            }
        System.out.println("Maximum profit : " + V[n][W]);
    }

    static class Item {

        private int weight;
        private int value;

        Item(int weight, int value) {

            this.weight = weight;
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public int getWeight() {
            return weight;
        }

        @Override
        public String toString() {
            return "<(w: " + getWeight() + " v:" + getValue() + ")>";
        }
    }
}
