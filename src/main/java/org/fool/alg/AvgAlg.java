package org.fool.alg;

import java.math.BigDecimal;

public class AvgAlg {

    /*
     * @author foolzt
     * @description 平均数计算
     * @createTime  2022/6/29 21:03
     * @param datas 参与计算的数据
     * @param   needHignPrec    是否需要高精度
     * @return double 平均数
     */
    public static double getAvg(double[] datas, boolean needHignPrec) {
        if (null == datas || datas.length == 0) {
            throw new IllegalArgumentException("参数缺失");
        }
        if (needHignPrec) {
            return getAvgBigDecimal(datas);
        }
        return getAvgMath(datas);
    }

    /*
     * Title:通过bigdecimal计算平均数
     * @author foolzt
     * @description 通过bigdecimal计算平均数
     * @createTime  2022/8/6 9:55
     * @param datas 参数
     * @return 平均数double
     */
    private static double getAvgBigDecimal(double[] datas) {
        BigDecimal res = BigDecimal.ZERO;
        for (double data : datas) {
            res = res.add(BigDecimal.valueOf(data));
        }
        return res
                .divide(BigDecimal.valueOf(datas.length), 20, BigDecimal.ROUND_HALF_DOWN)
                .doubleValue();
    }

    /*
     * Title:
     * @author foolzt
     * @description 通过数学方法计算平均数
     * @createTime  2022/8/6 9:56
     * @param datas 需要计算的数据
     * @return double平均数
     */
    private static double getAvgMath(double[] datas) {
        double res = 0.0;
        int len = datas.length;
        for (int i = 0; i < datas.length; i++) {
            res += datas[i] / len;
        }
        return res;
    }
}
