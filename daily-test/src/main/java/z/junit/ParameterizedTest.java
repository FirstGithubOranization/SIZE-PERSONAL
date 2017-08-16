package z.junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

/**
 * TITLE: 参数化单元测试
 * Created by ZhongHe.[Z] on 2017/3/3.
 */

@RunWith(value = Parameterized.class)//必须申明将Parameterized作为运行参数  这一步其实是指定运行器
/**
 * 单元测试的运行器有四种
 * Junit38：3.8和4感觉功能是一样的，为了向下兼容，所以38在未指定运行器的时候是默认的运行器
 *  junit4：
 * Parameterized: 运行使用不同参数运行相同的测试集
 * Suite：是一个不同测试的容器，它也是一个运行器，可以云心一个测试类中所有以@Test注释的方法
 */
public class ParameterizedTest {

    private double expected;
    private double valueOne;
    private double valueTwo;

    /**
     * 必须使用该参数化注解 ＠ Parameters public static ja va.u til . Collect ion ， 无任何参数。 Col lection
     元素必须是相同长度的数组。这个数组的长度必须要和这个唯一的公共构造函数的参数数
     量相匹配。
     * @return
     */
    @Parameterized.Parameters
    public static Collection<Integer[]> getTestParameters() {
        return Arrays.asList(new Integer[][]{
                {2, 1, 1},
                {3, 2, 1},
                {4, 3, 1},
        });
    }

    public ParameterizedTest(double expected, double valueOne, double valueTwo) {
        this.expected = expected;
        this.valueOne = valueOne;
        this.valueTwo = valueTwo;
    }

    @Test
    public void sum() {
        Calculator calculator = new Calculator();
        assertEquals(expected, calculator.add(valueOne, valueTwo), 0);
    }

}
