package utilities;

import java.math.BigDecimal;

/**
 * Created by artem on 6/15/15.
 */
public class RandomGenerator {
    public static int getRandomFromZeroTo(int to){
        return (int)((to+1) * Math.random());
    }

    public static BigDecimal getRandomFromZeroTo(BigDecimal to) {
        return to.multiply(BigDecimal.valueOf(Math.random()));
    }

}
