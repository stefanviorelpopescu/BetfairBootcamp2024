package org.example.unit_testing;

public class Calculator {

    public int sum(String expression) {
        if (expression == null || expression.isBlank()) {
            return 0;
        }
        int sum = 0;
        String[] split = expression.split("\\+");
        for (String number : split) {
            String isolatedNumber = number.replaceAll("\\(", "")
                    .replaceAll("\\)", "")
                    .trim();
            sum += Integer.parseInt(isolatedNumber);
        }
        return sum;
    }

}
