package jvm.week01.z4;

/**
 * 第一课作业1
 * @author deepin
 */
public class FlowControlAndOpTest {
    public static void main(String[] args) {
        int a = 5;
        int b = 2;
        int add = a + b;
        int sub = a - b;
        int mul = a * b;
        int div = a / b;
        int mod = a % b;

        if (add % 2 != 0) {
            add = add * 2;
        }
        int loopSum = 0;
        for (int i = 0; i < add; i++) {
            loopSum += i;
        }
        System.out.println("a:" + a);
        System.out.println("b:" + b);
        System.out.println("sub:" + sub);
        System.out.println("mul:" + mul);
        System.out.println("div:" + div);
        System.out.println("mod:" + mod);
        System.out.println("loopSum:" + loopSum);
    }
}
