package org.fool.alg.java;

import org.fool.alg.MaxDrawDownAlg;
import org.junit.Assert;
import org.junit.Test;

public class MaxDrawDownAlgTest {
    @Test
    public void testAlgCase1() {
        double[] datas1 = {1.0, 2.0, 3.0, 1.5, 13.0, 23.0, 18.0, 16.0};
        double res = MaxDrawDownAlg.getMaxDrawDown(datas1);
        System.out.println(res);
        Assert.assertTrue(res == -0.5);
    }

    @Test
    public void testAlgCase2() {
        double[] datas1 = {1.0, 2.0, 3.0, 4.0};
        double res = MaxDrawDownAlg.getMaxDrawDown(datas1);
        System.out.println(res);
        Assert.assertTrue(res == 0.0);
    }

    @Test
    public void testAlgCase3() {
        double[] datas1 = {1.0, 0.1, 2.0, 0.2, 1.0};
        double res = MaxDrawDownAlg.getMaxDrawDown(datas1);
        System.out.println(res);
        Assert.assertTrue(res == -0.9);
    }

    @Test
    public void testAlgCase4() {
        double[] datas1 = {1.0, 2.0, 5.0, 3.0, 1.0, 5.0, 8.0, 6.0, 10.0, 30.0, 20.0, 15.0};
        double res = MaxDrawDownAlg.getMaxDrawDown(datas1);
        System.out.println(res);
        Assert.assertTrue(res == -0.80);
    }
}