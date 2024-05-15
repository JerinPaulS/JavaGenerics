package generics.wildcards;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** My class or above
 * The term contravariant preserves the ordering of types from more general to more specific
 * Generic Java collections are contravariant when they use super with a wildcard
 * PECS -> Producer Extends, Consumer Super
 * Providing a value from the stream -> super
 * Using the value in the supplied lambda -> extends
 * */

public class LowerBounded {

    public static void main(String[] args) {
        List<String> strings = Stream.of("a", "few", "strings")
                .collect(Collectors.toList());

        strings.forEach((String s) -> System.out.printf("%s in all caps is %s%n", s, s.toUpperCase()));
        strings.forEach((Object o) -> System.out.printf("%s has hashCode %d%n", o, o.hashCode()));

        List<Integer> integers = Stream.of(3, 1, 4, 1, 5, 9)
                .peek(i -> System.out.println(i + " as a binary string is " + Integer.toBinaryString(i)))
                .peek((Number n) -> System.out.println("The double value of " + n + " is " + n.doubleValue()))
                .peek((Object o) -> System.out.println("The default hashcode of " + o + " is " + o.hashCode()))
                .collect(Collectors.toList());
        System.out.println(integers);

    }

}
