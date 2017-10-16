/*
 * Copyright  2017 [AllenCoder]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.allen.apputils;

import android.widget.EditText;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Created by Allen on 16-5-26.
 */
public class NumberUtil {
    private NumberUtil() {

    }

    private static final DecimalFormat amountFormat = new DecimalFormat("###,###,###,##0.00");

    /**
     * 四舍五入
     *
     * @param value 数值
     * @param digit 保留小数位
     * @return
     */
    public static String getRoundUp(BigDecimal value, int digit) {
        return value.setScale(digit, BigDecimal.ROUND_HALF_UP).toString();
    }

    /**
     * 四舍五入
     *
     * @param value 数值
     * @param digit 保留小数位
     * @return
     */
    public static String getRoundUp(double value, int digit) {
        BigDecimal result = new BigDecimal(value);
        return result.setScale(digit, BigDecimal.ROUND_HALF_UP).toString();
    }
    /**
     * 四舍五入
     *
     * @param value 数值
     * @param digit 保留小数位
     * @return
     */
    public static String getRoundUp(String value, int digit) {
        BigDecimal result = new BigDecimal(Double.parseDouble(value));
        return result.setScale(digit, BigDecimal.ROUND_HALF_UP).toString();
    }

    /**
     * 获取百分比（乘100）
     *
     * @param value 数值
     * @param digit 保留小数位
     * @return
     */
    public static String getPercentValue(BigDecimal value, int digit) {
        BigDecimal result = value.multiply(new BigDecimal(100));
        return getRoundUp(result, digit);
    }

    /**
     * 获取百分比（乘100）
     *
     * @param value 数值
     * @param digit 保留小数位
     * @return
     */
    public static String getPercentValue(double value, int digit) {
        BigDecimal result = new BigDecimal(value);
        return getPercentValue(result, digit);
    }

    /**
     * 获取百分比（乘100,保留两位小数）
     *
     * @param value 数值
     * @return
     */
    public static String getPercentValue(double value) {
        BigDecimal result = new BigDecimal(value);
        return getPercentValue(result, 2);
    }

    /**
     * 金额格式化
     *
     * @param value 数值
     * @return
     */
    public static String getAmountValue(double value) {
        return amountFormat.format(value);
    }
    /**
     * 金额格式化
     *
     * @param value 数值
     * @return
     */
    public static String getAmountValue(String value) {
        return amountFormat.format(Double.parseDouble(value));
    }
    /**
     * int -tostring
     *
     * @param value 数值
     * @return
     */
    public static String getIntegerValue(int value) {
        return Integer.valueOf(value).toString();
    }
    /**
     * onTextChanged
     * @param sequence  (CharSequenc s
     * @param editText
     */
    public static void formatDot(CharSequence sequence,EditText editText){
        String s = sequence.toString();
        if (s.contains(".")){
            /**
             * 如果小数点位数大于两位 截取后两位
             */
            if (s.length()-1-s.indexOf(".")>2){
                s = s.substring(0, (s.indexOf(".") + 3));
                editText.setText(s);
                editText.setSelection(s.length());
            }
        }
        /**
         * 如果第一个输入为小数点 ，自动补零
         */
        if(s.trim().substring(0).equals(".")){
            s ="0"+s;
            editText.setText(s);
            editText.setSelection(s.length());
        }
        /**
         * 如果第一个第二个均为0
         */
        if(s.startsWith("0")&&s.trim().length()>1){
            if (!s.substring(1,2).equals(".")){
                editText.setText(s.substring(0,1));
                editText.setSelection(1);
                return;
            }
        }
    }

}
