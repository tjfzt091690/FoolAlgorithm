package org.fool.alg;

public class VolatilityAlg {

    /*
     * @author foolzt
     * @description 波动率
     * @createTime  2022/6/29 21:03
     * @param datas 参与计算的数据
     * @param n 多日波动率折算
     * @return double 波动率
     */
    public static double getVolitility(double[] datas, int n) {
        double res = 0.0;
        if (null == datas || datas.length < 2) {
            return res;
        }
        double theta = ThetaAlg.getTheta(datas, false);
        return theta * Math.sqrt(n + 0.0);
    }


}
