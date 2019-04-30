import java.util.Arrays;

public class StableSort {

    public static void main(String... args) {
        String[][] data = {{"d", "a"}, {"a", "b"}, {"e", "c"}, {"b", "d"}, {"g", "e"}, {"c", "f"}, {"f", "g"}};
        String[][] data2 = {{"d", "d"}, {"a", "a"}, {"e", "e"}, {"b", "b"}, {"g", "g"}, {"c", "c"}, {"f", "f"}};
        String[][] data3 = {{"aaa", "ddd"}, {"ccc", "bbb"}};
        String[][] data5 = {{"ccc", "bbb"}, {"aaa", "ddd"}};

        StableSort.stableSort(data3, 0);
        for(String[] ss : data3) {
            String s = "";
            for(String sss : ss) {
                s += sss + ", ";
            }
            System.out.println(s);
        }

        StableSort.stableSort(data2, 0);
        for(String[] ss : data2) {
            String s = "";
            for(String sss : ss) {
                s += sss + ", ";
            }
            System.out.println(s);
        }
    }

    public static void stableSort(String[][] table, int column) {
        if(table.length == 0)
            return;

        for (int x = 0; x < table.length; x++) {
            for(int i = 0; i < table.length-1; i++) {
                for (int j = 0; j < table[i].length; j++) {
                    if (j == column) {

                        char c = table[i][j].charAt(0);
                        char cc = table[i + 1][j].charAt(0);
                        if (cc < c) {
                            String[] temp = table[i + 1];
                            table[i + 1] = table[i];
                            table[i] = temp;
                        }
                        break;
                    }
                }
            }
        }
    }

}
