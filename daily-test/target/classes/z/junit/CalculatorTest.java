package z.junit;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * TITLE:
 * Created by ZhongHe.[Z] on 2017/3/3.
 */
public class CalculatorTest {

    @Test
    public void testAdd(){
        Calculator calculator = new Calculator();
        double result = calculator.add(10,50);
        assertEquals(60,result,0);
    }



    class Calculator
    {
        public int add(int a,int b){
            return  a+b;
        }

    }
}
