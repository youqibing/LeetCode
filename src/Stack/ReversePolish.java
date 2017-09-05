package Stack;

import java.util.Stack;

/**
 * 链接：https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation(逆波兰表达式).
 *
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 *
 * Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class ReversePolish {
    public static void main(String[] args){
        String[] tokens = new String[]{"2","1","+","3","*"};
        reversePolish(tokens);
    }

    private static void reversePolish(String[] tokens){
        int value = 0;
        String operators = "+-*/";

        Stack<String> stack = new Stack<>();

        for(String t : tokens){
            if(!operators.contains(t)){ //说明是数字
                stack.push(t);
            }else {
                int a = Integer.valueOf(stack.pop());   //出栈一个数字
                int b = Integer.valueOf(stack.pop());   //后出栈的作用于前一个出栈的

                switch(t){
                    case "+":
                        stack.push(String.valueOf(b+a));
                        break;

                    case "-":
                        stack.push(String.valueOf(b-a));
                        break;

                    case "*":
                        stack.push(String.valueOf(b*a));
                        break;

                    case "/":
                        if(a!=0){
                            stack.push(String.valueOf(b/a));
                        }else {
                            System.out.print("ERROW");
                            return;
                        }
                        break;
                }
            }
        }

        value = Integer.valueOf(stack.pop());
        System.out.print(value);
    }
}
