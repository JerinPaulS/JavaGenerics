package generics.erasure;

import java.awt.*;
import java.util.Arrays;
import java.util.function.Function;
import java.util.function.UnaryOperator;

/** Erasure
 *  - Bounded type params replaced by their bounds
 *  - Unbounded type params replaced by Object
 *  - Type casts inserted where needed
 *  - Bridge methods generated to preserve polymorphism
 */

public class ProcessColors {

    private Color color;

    public void setColor(Color color) {
        this.color = color;
    }

    public Color applyFilter(UnaryOperator<Color> filter) {
        return filter.apply(color);
    }

    @SafeVarargs
    public final Color applyFilters(Function<Color,Color>... filters) {
        return Arrays.stream(filters)
                .reduce(Function.identity(), Function::andThen)
                .apply(color);
    }

}
