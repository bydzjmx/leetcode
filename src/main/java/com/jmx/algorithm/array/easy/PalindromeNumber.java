package com.jmx.algorithm.array.easy;

/**
 * 回文数，判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 示例 1:
 * 输入: 121
 * 输出: true
 * 示例 2:
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 *进阶：不转为字符串解决
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        boolean palindrome = PalindromeSolution.isPalindrome(121);
        boolean palindrome2 = PalindromeSolution.isPalindrome(121);
        System.out.println(palindrome);
        System.out.println(palindrome2);
    }
}

/**
 * 解法1，最简单的字符串反转
 * 涉及字符串大量的api调用，创建字符串相关对象，效率差
 */
class PalindromeSolution {
    public static boolean isPalindrome(int x) {
        //记录原始值
        StringBuilder sb = new StringBuilder();
        sb.append(x);
        return sb.toString().equals(sb.reverse().toString());
    }
}

/**
 * 方法2，取出后半段数字进行翻转，与前半段进行比较
 * 位数为偶数，则翻转过来应相等，位数为奇数，则翻转后应去掉一个长度
 * 1. x为负数，直接返回false
 * 2. x可以整除10，表示反转后首位为0，返回false
 */
class PalindromeSolution2{
    public static boolean isPalindrome(int x){
        if(x < 0 || (x/10==0 && x !=0)) return false;
        int reversedNumber = 0;
        while (x > reversedNumber){
            reversedNumber = reversedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == reversedNumber || x == reversedNumber / 10;
    }
}
