package Stack;

import java.util.Stack;

/**
 * 中缀表达式变后缀表达式的计算过程：
 * ·开始扫描；
 * ·数字时，加入后缀表达式；
 * ·运算符：
 *  a. 若为最高级的运算符，入栈；
 *  b. 若为 '('，入栈；
 *  c. 若为 ')'，则依次把栈中的的运算符加入后缀表达式中，直到出现'('，从栈中删除'(' ；
 *  d. 若为不是最高级的运算符，则将从栈顶到第一个优先级不大于（小于，低于或等于）它的运算符（或 '(',但优先满足前一个条件）之间的运算符加入后缀表达式中，该运算符再入栈；
 */
public class InfixToSuffix {
    private String calculation = null;
    private Stack<Character> stack = null;
    private StringBuilder builder;

    private String operators1= "+=*/";
    private String operators2= "*/";

    public InfixToSuffix(String calculation){
        this.calculation =calculation;
        this.stack = new Stack<>();
        builder = new StringBuilder();
    }

    private void rnfixToSuffix(){
        for (int i = 0; i < calculation.length(); i++) {
            char c = calculation.charAt(i);

            switch (c) {    //四种情况:

                case '+':
                case '-':
                    if (stack.isEmpty() || stack.peek() == '(') { //stack.peek() 查看栈顶的元素，
                        stack.push(c);  //如果为'('左括号,或者栈空了,则'+' '-'号入栈
                    } else {     //栈不为空 且 栈顶不是左括号
                        while (!stack.isEmpty() && operators1.contains(String.valueOf(stack.peek()))) {
                            builder.append(String.valueOf(stack.pop()));
                        }   //栈顶是符号(四种都可以)，此时又要进入符号('+' '-'号),原来的符号先要出栈，直到遇到数字了再进入'+' '-'号
                        stack.push(c);  //栈空了或者遇到数字了，'+'或者'-'两个运算符入栈
                    }
                    break;


                case '*':
                case '/':
                    if (stack.isEmpty() || stack.peek() == '+' || stack.peek() == '-' || stack.peek() == '(') {
                        stack.push(c);  //栈空 或者 遇到低级运算符'+''-' 或者 左括号'(', 高级运算符'*' '/'进栈
                    } else {
                        while (!stack.isEmpty() && operators2.contains(String.valueOf(c))) {
                            builder.append(String.valueOf(stack.pop()));  //此时要进入的是高级运算符'*' '/',如果此时栈顶
                        }                               // 也是高级运算符'*' '/', 则原栈中的高级运算符出栈(注意此时'+''-'不用动)
                        stack.push(c);
                    }
                    break;



                case '(':   //左括号直接进栈
                    stack.push(c);
                    break;


                case ')':   //遇到右括号，需要跟之前的左括号配对，因此需要将栈中左括号上面的元素全部出栈
                    char temp ;
                    while (!stack.isEmpty() && (temp = stack.pop()) != '(') {
                        builder.append(String.valueOf(temp));
                    }
                    break;


                default:    //相当于else,也就是遇到数字就直接添加，不用进栈了
                    builder.append(c);
                    break;
            }

        }

        if(!stack.isEmpty()){   //上面的操作完后还留在栈中的元素直接全部出栈
            while (!stack.isEmpty()){
                builder.append(String.valueOf(stack.pop()));
            }
        }

        System.out.print(builder.toString());

    }

    public static void main(String[] main){
        InfixToSuffix test = new InfixToSuffix("A+B*(C-D)/E+F/H");
        test.rnfixToSuffix();
    }
}
