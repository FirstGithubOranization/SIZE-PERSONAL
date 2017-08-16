package z.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * TITLE:
 * Created by ZhongHe.[Z] on 2017/1/16.
 */
public class QueueTest {

    //不可争一日长短啊
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("first");
        queue.offer("second");
        queue.offer("third");
        System.out.println(queue.peek());
        System.out.println(queue.remove());
        System.out.println(queue.peek());
        System.out.println(queue.size());
        System.out.println(queue.element());
        Stack stack = new Stack();
        System.out.println(stack.size());
        System.out.println(stack.add("1"));
        System.out.println(stack.empty());
    }
}
