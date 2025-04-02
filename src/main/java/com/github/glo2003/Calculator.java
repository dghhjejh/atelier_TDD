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
         else if (split.length == 1) {
            try{
                sum = Integer.parseInt(numbers);
            } catch (NumberFormatException e) {
                throw new InvalidNumberFormatException();
            }
            return sum;
        }
         else if (split.length == 2){
             try {
                 sum = (List.of(split)).stream()
                         .mapToInt(Integer::parseInt)
                         .sum();
             } catch (NumberFormatException e){
                 throw new InvalidNumberFormatException();
             }
             return sum;
        }
        throw new InvalidNumberFormatException();
    }
}
