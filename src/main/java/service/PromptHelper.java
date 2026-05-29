package service;

import java.math.BigDecimal;

public class PromptHelper {
    public static String money(BigDecimal amount) {
        return "$" + amount.setScale(2, java.math.RoundingMode.HALF_UP);
    }

}
