package z.栈;

import java.util.Vector;

/**
 * TITLE:
 *
 * @author ZhongHe.Zh
 * @time 2017-09-09 14:24
 **/
public class Stack {

    private int top = -1;

    private Object[] objs;

    public Stack(int capacity) throws Exception {
        if (capacity < 0) throw new Exception("非法长度" + capacity);
        objs = new Object[capacity];
    }

    public void puch(Object o) throws Exception{
        if(top == objs.length-1){
            throw new Exception("stack full");
        }
    }

    public Object pop()throws Exception{
        if(top== -1){
            throw new Exception("stack is empty");
        }
        return objs[top--];
    }

    public void display(){
        System.out.println("| start..");
        for (int i= 0 ; i <= top; i++){

        }

    }

}
