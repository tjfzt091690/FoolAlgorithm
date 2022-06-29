package org.fool.alg;

public class MaxDrawDownAlg {

    /*
     * @author foolzt
     * @description 计算最大回撤
     * @createTime  2022/6/29 21:03
     * @param datas 参与计算的数据
     * @return double 最大回撤
     */
    public static double getMaxDrawDown(double[] datas) {
        double res = 0.0;
        if (null == datas || datas.length == 0) {
            return res;
        }
        int len = datas.length;
        double[] leftMaxs = new double[len];
        double leftMax = Double.MIN_VALUE, rightMin = Double.MAX_VALUE;
        //记录每个位置左侧的最大值
        for (int i = 0; i < len; i++) {
            if (leftMax < datas[i]) {
                leftMax = datas[i];
            }
            leftMaxs[i] = leftMax;
        }
        //找到每个位置右侧的最小值，并计算该位置的最大回撤
        for (int i = len - 1; i >= 0; i--) {
            if (rightMin > datas[i]) {
                rightMin = datas[i];
            }
            double thisMaxDD = rightMin / leftMaxs[i] - 1.0;
            if (thisMaxDD < res) {
                res = thisMaxDD;
            }
        }
        return res;
    }
}
