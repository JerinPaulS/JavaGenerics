package generics.raw;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RawTypes {

    public static void main(String[] args) {
        List strings = new ArrayList<>();
        strings.add("This");
        strings.add("is");
        strings.add("a");
        strings.add("RAW");
        strings.add("list");
        strings.add("of");
        strings.add("strings");

        for (Object o : strings) {
            String s = (String) o;
            System.out.printf("%7s has %d characters%n", s, s.length());
        }
    }

}
