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
 *
 * 后缀表达式(逆波兰表达式)计算过程：建立一个栈S, 从左到右读后缀表达式，如果读到操作数就将它压入栈S中，如果读到n元运算符
 * (即需要参数个数为n的运算符)则取出由栈顶向下的n项按操作符运算，再将运算的结果代替原栈顶的n项，压入栈S中 ;
 * 如果后缀表达式未读完，则重复上面过程，最后输出栈顶的数值则为结束。
 */
public class CalculatSuffix {
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
