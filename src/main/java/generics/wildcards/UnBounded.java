package generics.wildcards;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List

public class UnBounded {

    public static void main(String[] args) {
        List<?> stuff = Arrays.asList("Hello", LocalDate.now(), 3);

        System.out.println(stuff.size());
        stuff.forEach((Object o) -> System.out.println(o));

//        stuff.add("Anything");

        stuff.containsAll(Arrays.asList("Whatever", "else"));
    }

}