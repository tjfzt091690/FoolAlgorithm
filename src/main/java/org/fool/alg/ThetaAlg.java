package org.fool.alg;

import java.math.BigDecimal;

public class ThetaAlg {

    /*
     * @author foolzt
     * @description 平均数计算
     * @createTime  2022/6/29 21:03
     * @param datas 参与计算的数据
     * @param   needHignPrec    是否需要高精度
     * @return double 平均数
     */
    public static double getTheta(double[] datas, boolean needHignPrec) {
        if (null == datas || datas.length < 2) {
            throw new IllegalArgumentException("参数缺失，至少两个数据");
        }
        if (needHignPrec) {
            double avg = AvgAlg.getAvg(datas, needHignPrec);
            return getThetaBigDecimal(datas, avg);
        }
        double avg = AvgAlg.getAvg(datas, false);
        return getThetaMath(datas, avg);
    }

    /*
     * Title:通过bigdecimal计算平均数
     * @author foolzt
     * @description 通过bigdecimal计算平均数
     * @createTime  2022/8/6 9:55
     * @param datas 参数
     * @param avg 均值
     * @return 平均数double
     */
    private static double getThetaBigDecimal(double[] datas, double avg) {
        BigDecimal sqSums = BigDecimal.ZERO;
        BigDecimal avgBd = BigDecimal.valueOf(avg);
        for (double data : datas) {
            BigDecimal tmpMinus = BigDecimal.valueOf(data).subtract(avgBd);
            sqSums = sqSums.add(tmpMinus.multiply(tmpMinus));
        }
        sqSums.divide(BigDecimal.valueOf(datas.length - 1));
    }

    /*
     * Title:
     * @author foolzt
     * @description 通过数学方法计算平均数，不安全，容易超界
     * @createTime  2022/8/6 9:56
     * @param datas 需要计算的数据
     * @oaram avg 均值
     * @return double平均数
     */
    private static double getThetaMath(double[] datas, double avg) {
        double res = 0.0;
        int l = datas.length - 1;
        for (int i = 0; i < datas.length; i++) {
            double minus = datas[i] - avg;
            res += minus / l * minus;
        }
        return Math.sqrt(res);
    }
}
