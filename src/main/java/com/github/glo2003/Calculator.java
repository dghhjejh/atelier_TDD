package com.github.glo2003;

import java.util.List;

public class Calculator {
    public int add(String numbers) {
        String separation = ",+";
        String[] split = numbers.split(separation);
        int sum = 0;
        if (numbers.isEmpty()) {
            return sum;
        }
        try{
            sum = (List.of(split)).stream()
                    .mapToInt(Integer::parseInt)
                    .sum();
        } catch (NumberFormatException e) {
            throw new InvalidNumberFormatException();
        }
        return sum;
    }
}
