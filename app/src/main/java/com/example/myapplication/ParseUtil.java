package com.example.myapplication;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 *文字转换解析为数字工具
 */
public class ParseUtil {
    /**
     * String 转 Float
     *
     * @param parse
     * @return
     */
    public static float parseFloat(String parse) {
        float m = 0;
        try {
            m = Float.parseFloat(parse);
        } catch (Exception e) {
        }
        return m;
    }
    public static String format(String num) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(parseDouble(num));
    }

    public static double parseDouble(String parse) {
        double m = 0.00;
        try {
            m = Double.parseDouble(parse);
        } catch (Exception e) {
        }
        return m;
    }

    public static double parseMoney(String parse) {
        double m = 0.00;
        try {
            m = new BigDecimal(parse).doubleValue();
        } catch (Exception e) {
        }
        return m;
    }

    public static int parseInt(String parse) {
        int m = 0;
        try {
            m = Integer.parseInt(parse);
        } catch (Exception e) {
        }
        return m;
    }

    public static long parseLong(String parse) {
        long m = 0;
        try {
            m = Long.parseLong(parse);
        } catch (Exception e) {
        }
        return m;
    }

    public static String format_one(String num) {
        DecimalFormat df = new DecimalFormat("0.0");
        return df.format(parseDouble(num));
    }


    /**
     * 中文数字转阿拉伯数字
     *
     * @param chineseNumber
     * @return
     */
    public static int chineseNumber2Int(String chineseNumber) {
        int result = 0;
        int temp = 1;//存放一个单位的数字如：十万
        int count = 0;//判断是否有chArr
        char[] cnArr = new char[]{'一', '二', '三', '四', '五', '六', '七', '八', '九'};
        char[] chArr = new char[]{'十', '百', '千', '万', '亿'};
        for (int i = 0; i < chineseNumber.length(); i++) {
            boolean b = true;//判断是否是chArr
            char c = chineseNumber.charAt(i);
            for (int j = 0; j < cnArr.length; j++) {//非单位，即数字
                if (c == cnArr[j]) {
                    if (0 != count) {//添加下一个单位之前，先把上一个单位值添加到结果中
                        result += temp;
                        temp = 1;
                        count = 0;
                    }
                    if (c == '两') {
                        temp = 2;
                    } else {
                        // 下标+1，就是对应的值
                        temp = j + 1;
                    }
                    b = false;
                    break;
                }
            }
            if (b) {//单位{'十','百','千','万','亿'}
                for (int j = 0; j < chArr.length; j++) {
                    if (c == chArr[j]) {
                        switch (j) {
                            case 0:
                                temp *= 10;
                                break;
                            case 1:
                                temp *= 100;
                                break;
                            case 2:
                                temp *= 1000;
                                break;
                            case 3:
                                temp *= 10000;
                                break;
                            case 4:
                                temp *= 100000000;
                                break;
                            default:
                                break;
                        }
                        count++;
                    }
                }
            }
            if (i == chineseNumber.length() - 1) {//遍历到最后一个字符
                result += temp;
            }
        }
        return result;
    }

}
