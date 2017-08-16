package z.stack;

import java.util.Stack;

/**
 * TITLE:
 * Created by ZhongHe.[Z] on 2017/1/16.
 */
public class StackTest {

    public static void main(String[] args) {

        Stack stack = new Stack();
        while (true) {
            for (int i = 0; i < 10; i++
                    ) {
                stack.push(i);
                System.out.println("stack.size() = " + stack.size());
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
        }
    }
}
