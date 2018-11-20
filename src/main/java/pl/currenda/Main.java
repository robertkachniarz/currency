package pl.currenda;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        System.out.println(new BigDecimal(1.03).subtract(new BigDecimal(0.41)));
        System.out.println(new BigDecimal("1.03").subtract(new BigDecimal("0.41")));
    }
}
