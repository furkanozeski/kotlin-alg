import java.lang.reflect.Array;
import java.util.Arrays;

public class Reverse {

    public void reverseName(String s) {
        char[] str = new char[s.length() - 1];
        s.getChars(0, s.length() - 1, str, 0);
        System.out.println(Arrays.toString(str));
        for (int i = s.length() - 1; i >= 0; i--) {

            System.out.print(s.charAt(i));
        }
    }
}
