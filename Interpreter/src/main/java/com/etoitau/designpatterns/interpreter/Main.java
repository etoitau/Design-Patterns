package com.etoitau.designpatterns.interpreter;

import java.util.*;

/**
 * Design Patterns exercise - Interpreter
 * You are asked to write an expression processor for simple numeric expressions with the following constraints:
 * Expressions use integral values (e.g. 13), single-letter variables defined in Variables, as well as + and - operators only
 * There is no need to support braces or any other operations
 * If a variable is not found in 'variables' (or if we encounter a variable with > 1 letter, e.g. ab), the evaluator returns 0 (zero)
 * In case of any parsing failure, evaluator returns 0
 */
class ExpressionProcessor
{
    public Map<Character, Integer> variables = new HashMap<>(); // provided

    public int calculate(String expression)
    {
        // turn into series of values to add
        Queue<Op> q = parseExpression(expression);
        // q == null if parsing error
        if (q == null) { return 0; }

        // sum up and return
        int result = 0;
        while (!q.isEmpty()) {
            result = q.poll().on(result);
        }
        return result;
    }

    private Queue<Op> parseExpression(String expression) {
        int i = 0, j;
        Queue<Op> q = new LinkedList<>();
        String s;
        int sign = 1;
        boolean needSign = false;

        while (i < expression.length()) {
            // get next char
            char c = expression.charAt(i);

            if (Character.isDigit(c)) {
                // found integer

                // if last token was int or variable, can't have another
                if (needSign) { return null; }

                // probe ahead to see how many digits this int has
                j = i;
                while (j < expression.length() && Character.isDigit(expression.charAt(j))) { j++; }
                s = expression.substring(i, j);
                i = j;

                // turn into int value
                int val;
                try {
                    val = Integer.parseInt(s);
                } catch (NumberFormatException e) {
                    return null;
                }

                // put in queue
                q.add(new Op(sign, val));

                // next token needs to be +/-
                sign = 1;
                needSign = true;
            } else if (Character.isAlphabetic(c)) {
                // found variable

                // if last token was int or variable, can't have another
                if (needSign) { return null; }

                // if invalid variable
                if (!variables.containsKey(c)) { return null; }

                // move to next
                i++;

                // put in queue
                q.add(new Op(sign, variables.get(c)));

                // next token needs to be +/-
                sign = 1;
                needSign = true;
            } else if (c == '+' || c == '-') {
                // found operator

                // if expecting int or var
                if (!needSign && !q.isEmpty()) {
                    return null;
                }

                // set sign accordingly
                sign = (c == '+')? 1: -1;

                // next token should be int or var
                needSign = false;

                // next char
                i++;
            } else if (c == ' ') {
                // skip over whitespace
                i++;
            } else {
                // some crazy character, no good
                return null;
            }
        }
        return q;
    }


    /**
     * An +/- operation like "add 3" or "subtract 2"
     */
    class Op {
        private int sign, val;

        public Op(int sign, int val) {
            this.sign = sign;
            this.val = val;
        }

        // do the operation on the input and return result
        public int on(int input) {
            return input + sign * val;
        }

        // do the opposite of the operation on the input and return result
        public int undo(int input) {
            return input - sign * val;
        }
    }

}

