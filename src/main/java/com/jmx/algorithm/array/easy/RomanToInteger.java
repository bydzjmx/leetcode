package com.jmx.algorithm.array.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字转整数。 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 *示例 1:
 * 输入: "III"
 * 输出: 3
 * 示例 2:
 * 输入: "IV"
 * 输出: 4
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 */
public class RomanToInteger {
    public static void main(String[] args) {
        RomanSolution romanSolution = new RomanSolution();
        RomanSolution2 romanSolution2 = new RomanSolution2();
        System.out.println(romanSolution.romanToInt("LVIII"));
        System.out.println(romanSolution2.romanToInt("LVIII"));
    }
}

/**
 * 方法1，利用字符串数组
 * 定义两个数组，第一个双字母在前，单字母在后的字符数组。第二个为对应的整数数组
 * 利用逐步减的思路，截取每一个有实际意义的字符串
 */
class RomanSolution {
    public int romanToInt(String s) {
        String[] roman = {"IV","IX", "XL", "XC", "CD", "CM", "I", "V", "X", "L", "C", "D", "M"};
        int[] nums = {4, 9, 40, 90, 400, 900, 1, 5, 10, 50, 100, 500, 1000};
        int num = 0;
        while(s.length()>0){
            for (int i = 0; i < roman.length; i++) {
                if(s.startsWith(roman[i])){
                    num += nums[i];
                    s = s.substring(roman[i].length());
                    break;
                }
            }
        }
        return num;
    }
}

/**
 * 方法2，把基础的罗马数字添加到HashMap中，遍历字符串，同时分别取出后面两位的对应整数，判断如果后面位数的值比前面的值小，
 * 那么就在总数上加上前面的数值，否则就减去前面的数值，
 */
class RomanSolution2 {
    public int romanToInt(String s) {
        Map<Character, Integer> romaNumber = new HashMap<>();
        romaNumber.put('I', 1);
        romaNumber.put('V', 5);
        romaNumber.put('X', 10);
        romaNumber.put('L', 50);
        romaNumber.put('C', 100);
        romaNumber.put('D', 500);
        romaNumber.put('M', 1000);

        int firstValue = 0;
        int nextValue = 0;
        int sum = 0;

        for (int i = 0; i < s.length(); i++){
            firstValue = romaNumber.get(s.charAt(i));
            if (i == s.length()-1){
                sum += firstValue;
            }else {
                nextValue = romaNumber.get(s.charAt(i+1));
                if (firstValue >= nextValue){
                    sum += firstValue;
                }else{
                    sum -= firstValue;
                }
            }
        }
        return sum;
    }
}
