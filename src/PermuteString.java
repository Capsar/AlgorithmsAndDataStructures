import java.util.Set;
import java.util.TreeSet;

public class PermuteString {

    static Set<String> permuteString(String s) {
        Set<String> result = new TreeSet<>();

        permuteString(s, 0, s.length() - 1, result);

        return result;
    }


    static void permuteString(String s, int p, int q, Set<String> result) {
        if (p == q)
            result.add(s);
        else {
            for (int i = p; i <= q; i++) {
                s = swap(s, p, i);
                permuteString(s, p + 1, q, result);
                s = swap(s, p, i);
            }
        }
    }

    static String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

}
