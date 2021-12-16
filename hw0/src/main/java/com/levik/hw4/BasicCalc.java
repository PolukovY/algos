package com.levik.hw4;

import java.util.ArrayList;
import java.util.List;

public class BasicCalc {

    private static final char SPACE = ' ';

    public int calculate(String s) {
        List<Integer> nums = new ArrayList<>();
        List<Operator> operators = new ArrayList<>();

        int n = s.length();
        int i = 0;

        while(i < n) {
            char aChar = s.charAt(i);

            if (aChar == SPACE) {
                i++;
                continue;
            }

            if (Character.isDigit(aChar)) {
                int currentNumber = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    currentNumber = currentNumber * 10 + Integer.parseInt(String.valueOf(s.charAt(i)));
                    i++;
                }
                nums.add(currentNumber);
                i--;
            } else {
                while (!operators.isEmpty() && Operator.getPriority(aChar) <= Operator.getPriority(operators.get(operators.size() - 1).value)) {
                    Integer num2 = nums.remove(nums.size() - 1);
                    Integer num1 = nums.remove(nums.size() - 1);
                    Operator operator = operators.remove(operators.size() - 1);

                    int calcResult = Operator.execute(num1, num2, operator.value);
                    nums.add(calcResult);
                }

                operators.add(new Operator(aChar));

            }
            i++;
        }

        while (!operators.isEmpty()) {
            Integer num2 = nums.remove(nums.size() - 1);
            Integer num1 = nums.remove(nums.size() - 1);
            Operator operator = operators.remove(operators.size() - 1);

            int calcResult = Operator.execute(num1, num2, operator.value);
            nums.add(calcResult);
        }

        return nums.get(nums.size() - 1);
    }

    public static class Operator {
        public static final Character PLUS = '+';
        public static final Character MINUS = '-';
        public static final Character MULTIPLY = '*';
        public static final Character DIV = '/';

        private final char value;

        public Operator(char value) {
            this.value = value;
        }

        public static int getPriority(char current) {
            if (Operator.PLUS.equals(current)  || Operator.MINUS.equals(current)) {
                return 0;
            }

            if (Operator.MULTIPLY.equals(current)  || Operator.DIV.equals(current)) {
                return 1;
            }

            return -1;
        }

        public static int execute(int num1, int num2, char current) {
            if (Operator.PLUS.equals(current)) {
                return num1 + num2;
            }

            if (Operator.MINUS.equals(current)) {
                return num1 - num2;
            }

            if (Operator.MULTIPLY.equals(current)) {
                return num1 * num2;
            }

            if (Operator.DIV.equals(current)) {
                return num1 / num2;
            }

            return -1;
        }
    }
}
